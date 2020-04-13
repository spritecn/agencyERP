package com.corse.agencyerp.dao

import com.corse.agencyerp.dao.Domain.BaseDomain
import com.corse.agencyerp.dao.Domain.DeptDomain
import com.corse.agencyerp.dao.Domain.EmployeeDomain
import groovy.transform.CompileStatic


@CompileStatic
abstract interface BaseDao<T extends BaseDomain>{
    T  getDomainByUuid(String uuid)
    List<T> listDomain(T domain)
    Integer save(T domain);
    Integer update(T domain)
    Integer removeByUuid(String  uuid)
}


@CompileStatic
interface DeptDao extends BaseDao<DeptDomain>{
}

@CompileStatic
interface EmployeeDao extends BaseDao<EmployeeDomain>{
}

