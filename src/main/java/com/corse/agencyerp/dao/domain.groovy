package com.corse.agencyerp.dao


import groovy.transform.CompileStatic
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


abstract class baseDomain{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String uuid;

        private Date createTm;

        private Date updateTm;

        private Boolean del;
}


@CompileStatic
@Table(name = 'dept')
class deptDomain extends baseDomain{

    private String name;

    private String superUuid;

    private int closed;

    private String json;
}



