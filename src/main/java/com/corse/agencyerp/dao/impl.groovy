package com.corse.agencyerp.dao

import org.springframework.beans.factory.annotation.Autowired

class DeptDaoImpl implements DeptDao{
    @Autowired
    DeptMapper deptMapper

    @Override
    List<DeptDomain> listDeptByDeptDomain(DeptDomain domain) {
        deptMapper.select(domain)
    }

    @Override
    DeptDomain getDeptByUuid(String uuid) {
        DeptDomain deptDomain = new DeptDomain()
        deptDomain.uuid = uuid
        deptMapper.selectOne(deptDomain)
    }

    @Override
    Integer saveDept(DeptDomain domain) {
        deptMapper.insert(domain)
    }
}
