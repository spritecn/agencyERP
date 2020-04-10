package com.corse.agencyerp.dao

import org.springframework.stereotype.Repository
import tk.mybatis.mapper.common.BaseMapper


@Repository
public interface DeptMapper extends BaseMapper<DeptDomain> {

}


@Repository
public interface EmployeeMapper extends BaseMapper<EmployeeDomain> {

}

