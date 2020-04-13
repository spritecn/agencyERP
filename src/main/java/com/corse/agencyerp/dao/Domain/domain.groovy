package com.corse.agencyerp.dao.Domain


import groovy.transform.CompileStatic
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@CompileStatic
abstract class BaseDomain implements Serializable{
    private static final long serialVersionUID = 485265899L

    @Id
    @GeneratedValue(generator="JDBC")
    Long id

    String uuid

    Date createTm

    Date updateTm

    Boolean del
}


@Table(name = 'dept')
class DeptDomain extends BaseDomain{

    String name

    String superUuid

    Integer closed

    String json
}


@Table(name = 'employee')
class EmployeeDomain extends BaseDomain{

    String name

    //等级
    Integer level

    //在职状态,0正式,1:试用,2:请假 3:离职
    Integer status

    String deptUuid

    String json
}



