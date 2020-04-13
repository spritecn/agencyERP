package com.corse.agencyerp.utils

import groovy.transform.CompileStatic

@CompileStatic
class UuidUtil {
    //返回一个12位数字UUID
    static  String genSortUuid(){
        Integer hashCode = UUID.randomUUID().hashCode()
        String perifx = ((Math.random()*9+1)*10).toInteger().toString()
        if(hashCode < 0){
            hashCode = -hashCode
        }
        perifx + String.format("%010d", hashCode)
    }
}
