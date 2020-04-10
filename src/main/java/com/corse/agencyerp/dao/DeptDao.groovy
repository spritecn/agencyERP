package com.corse.agencyerp.dao

import org.springframework.stereotype.Service


@Service
interface DeptDao {
    public DeptDomain  getDeptByUuid(String uuid)
    public List<DeptDomain> listDeptByDeptDomain(DeptDomain domain)
    public Integer saveDept(DeptDomain domain);
}