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
import org.springframework.stereotype.Service


interface  DeptService{
    BaseResponse<String> createDept(CreateDeptVo vo);
    BaseResponse<List<DeptDTO>> listDept(DeptDTO dto);
}

@CompileStatic
@Service('deptService')
class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao

    BaseResponse<String> createDept(CreateDeptVo vo){
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
        BaseResponse.successReturn(domain.uuid)
    }

    @Override
    BaseResponse<List<DeptDTO>> listDept(DeptDTO dto) {
        DeptDomain domain = new DeptDomain()
        BeanUtils.copyProperties(dto,domain)
        BaseResponse.successReturn(deptDao.listDomain(domain).stream().map({detpDomain2Dto(it)}).collect()) as BaseResponse<List<DeptDTO>>
    }

    static DeptDTO detpDomain2Dto(DeptDomain domain){
        DeptDTO dto = new DeptDTO()
        BeanUtils.copyProperties(domain, dto)
        return  dto
    }}
