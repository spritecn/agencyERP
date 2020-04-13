package com.corse.agencyerp.servie.bean

import com.corse.agencyerp.dao.BaseDao

import javax.validation.constraints.NotBlank

class dto {
}

abstract class BaseDTO{
    String uuid
    Date createTm
    Date updateTm
}

class DeptDTO extends BaseDTO {
    String name
    String superUuid
    Integer closed
    String json
}

class CreateDeptVo{
    @NotBlank
    String name
    String superUuid
    Integer closed
    String json
}