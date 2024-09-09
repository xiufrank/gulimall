package com.atguigu.gulimall.member.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.nacos.shaded.io.grpc.netty.shaded.io.netty.handler.codec.http2.Http2Settings;
import com.atguigu.gulimall.member.fegin.CouponFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.atguigu.gulimall.member.service.MemberService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 会员
 *
 * @author sxf
 * @email sxfahau@163.com
 * @date 2024-08-07 23:21:00
 */
@RestController
@RequestMapping("member/member")
public class MemberController {

    @Value("${persion.name}")
    private String name;
    @Value("${persion.age}")
    private int age;

    @Autowired
    private MemberService memberService;
    @Autowired
    private CouponFeignClient couponFeignClient;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
//		MemberEntity member = memberService.getById(id);
        MemberEntity member = new MemberEntity();
        member.setNickname(name);
        member.setGrowth(age);
        return R.ok().put("member", member);
    }

    @RequestMapping("/coupon/info/{id}")
    //@RequiresPermissions("member:member:info")
    public R couponInfo(@PathVariable("id") Long id){
//		MemberEntity member = memberService.getById(id);
        MemberEntity member = new MemberEntity();
        member.setNickname(name);
        member.setGrowth(age);
        member.setId(id);

        R memberList = couponFeignClient.memberList();

        Map<String, Object> result = new HashMap<>();
        result.put("member", member);
        result.put("coupon", memberList.get("data"));
        return R.ok().put("data", result);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
