package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author sxf
 * @email sxfahau@163.com
 * @date 2024-08-07 23:52:38
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
