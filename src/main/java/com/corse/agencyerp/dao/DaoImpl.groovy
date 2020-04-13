package com.corse.agencyerp.dao


import com.corse.agencyerp.dao.Domain.DeptDomain
import com.corse.agencyerp.dao.Domain.EmployeeDomain
import com.corse.agencyerp.dao.mapper.DeptMapperTk
import com.corse.agencyerp.dao.mapper.EmployeeMapperTk
import org.springframework.stereotype.Service


@Service("deptDao")
class DeptDaoImpl extends BaseDaoImpl<DeptMapperTk, DeptDomain> implements DeptDao {
}

@Service("employeeDao")
class EmployeeDaoImpl extends BaseDaoImpl<EmployeeMapperTk, EmployeeDomain> implements EmployeeDao {
}

