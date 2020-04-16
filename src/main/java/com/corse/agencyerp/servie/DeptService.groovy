package com.corse.agencyerp.servie

import com.corse.agencyerp.base.BaseResponse
import com.corse.agencyerp.dao.DeptDao
import com.corse.agencyerp.dao.Domain.DeptDomain
import com.corse.agencyerp.servie.bean.CreateDeptVo
import com.corse.agencyerp.servie.bean.DeptDTO
import com.corse.agencyerp.utils.UuidUtil
import groovy.transform.CompileStatic
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service


interface  DeptService{
    String createDept(CreateDeptVo vo)
    List<DeptDTO> listDept(DeptDTO dto)
    List<DeptDTO> listAllDept()
}

@CompileStatic
@Service('deptService')
class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao
    @CacheEvict(value = "dept",allEntries = true)
    String createDept(CreateDeptVo vo){
        //判断重名
        DeptDomain dept = new DeptDomain()
        dept.name = vo.name
        if(deptDao.listDomain(dept)){
            BaseResponse response = new BaseResponse<>()
            response.msg = "已存在同名部门:[${vo.name}]"
            return response

        }
        DeptDomain domain = new DeptDomain()
        domain.uuid = UuidUtil.genSortUuid()
        domain.name = vo.name
        domain.json = vo.json
        domain.superUuid = vo.superUuid
        deptDao.save(domain)
        domain.uuid
    }

    @Override
    List<DeptDTO> listDept(DeptDTO dto) {
        dto = dto?:new DeptDTO()
        DeptDomain domain = new DeptDomain()
        BeanUtils.copyProperties(dto,domain)
        deptDao.listDomain(domain).stream().map({detpDomain2Dto(it)}).collect() as List<DeptDTO>
    }

    @Override
    @CacheEvict(value = "dept",key = "{'AllDept'}")
    List<DeptDTO> listAllDept() {
        DeptDomain domain = new DeptDomain()
        deptDao.listDomain(domain).stream().map({detpDomain2Dto(it)}).collect() as List<DeptDTO>
    }

    static DeptDTO detpDomain2Dto(DeptDomain domain){
        DeptDTO dto = new DeptDTO()
        BeanUtils.copyProperties(domain, dto)
        return  dto
    }
}
