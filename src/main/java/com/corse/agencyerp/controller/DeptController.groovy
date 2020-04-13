package com.corse.agencyerp.controller

import com.corse.agencyerp.base.BaseResponse
import com.corse.agencyerp.dao.Domain.DeptDomain
import com.corse.agencyerp.servie.DeptService
import com.corse.agencyerp.servie.bean.CreateDeptVo
import com.corse.agencyerp.servie.bean.DeptDTO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dept/")
@Api(value = "dept",tags = "dept")
class DeptController {
    @Autowired
    private DeptService deptService;


    @RequestMapping(value = "/createDept", method = RequestMethod.POST)
    @ApiOperation(value = "创建部门", notes = "创建部门")
    BaseResponse<String> createDept(@RequestBody CreateDeptVo  request){
        deptService.createDept(request)
    }

    @RequestMapping(value = "/listDept", method = RequestMethod.POST)
    @ApiOperation(value = "查询部门", notes = "查询部门")
    BaseResponse<List<DeptDTO>> listDept(@RequestBody DeptDTO  request){
        deptService.listDept(request)
    }

}
