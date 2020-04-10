package com.corse.agencyerp.dao


import groovy.transform.CompileStatic
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


abstract class BaseDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String uuid;

    Date createTm;

    Date updateTm;

    Boolean del;
}


@CompileStatic
@Table(name = 'dept')
class DeptDomain extends BaseDomain{

    String name;

    String superUuid;

    Integer closed;

    String json;
}

@CompileStatic
@Table(name = 'employee')
class EmployeeDomain extends BaseDomain{

    String name;

    //等级
    Integer level;

    //在职状态,0正式,1:试用,2:请假 3:离职
    Integer status;

    String deptUuid;

    String json;
}



