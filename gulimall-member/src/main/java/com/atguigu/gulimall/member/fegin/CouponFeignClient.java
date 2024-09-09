package com.atguigu.gulimall.member.fegin;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gulimall-coupon", url = "")
public interface CouponFeignClient {

    @GetMapping("/coupon/coupon/member/list")
    R memberList();
}
