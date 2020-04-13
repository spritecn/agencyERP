package com.corse.agencyerp.config;


import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.SqlServerMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;


public interface TkBaseMapper<T> extends ExampleMapper<T>, Marker, SqlServerMapper<T>, BaseSelectMapper<T>, BaseUpdateMapper<T>, InsertListMapper<T> {
}
