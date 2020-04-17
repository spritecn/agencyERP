package com.corse.agencyerp.controller

import com.corse.agencyerp.base.BaseResponse
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
@RequestMapping("/employee/")
@Api(value = "employee",tags = "employee")
class EmployeeController {
    @Autowired
    private DeptService deptService;


    @RequestMapping(value = "/createdE", method = RequestMethod.POST)
    @ApiOperation(value = "创建部门", notes = "创建部门")
    BaseResponse<String> createDept(@RequestBody CreateDeptVo  request){
        BaseResponse.successReturn(deptService.createDept(request))
    }

    @RequestMapping(value = "/listDept", method = RequestMethod.POST)
    @ApiOperation(value = "查询部门", notes = "查询部门")
    BaseResponse<List<DeptDTO>> listDept(@RequestBody DeptDTO  request){
        BaseResponse.successReturn(deptService.listDept(request))
    }

    @RequestMapping(value = "/listAllDept", method = RequestMethod.POST)
    @ApiOperation(value = "列出所有部门", notes = "查询部门")
    BaseResponse<List<DeptDTO>> listDept(){
        BaseResponse.successReturn(deptService.listAllDept())
    }

}
