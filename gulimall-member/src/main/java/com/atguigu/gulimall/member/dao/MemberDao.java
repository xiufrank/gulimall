package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author sxf
 * @email sxfahau@163.com
 * @date 2024-08-07 23:21:00
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
