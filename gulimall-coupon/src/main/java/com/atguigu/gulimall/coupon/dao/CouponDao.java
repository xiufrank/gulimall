package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author sxf
 * @email sxfahau@163.com
 * @date 2024-08-07 23:35:46
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
