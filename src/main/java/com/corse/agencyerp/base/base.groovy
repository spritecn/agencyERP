package com.corse.agencyerp.base

import groovy.transform.CompileStatic

@CompileStatic
class BaseResponse<T> {
    String code
    String msg
    T data

    BaseResponse(){
        this.code = "1"
        this.msg = "error"
    }

    static <T> BaseResponse successReturn(T data){
        BaseResponse<T> response  = new BaseResponse<>()
        //成功的都是一样的，不成功的各有各的不同
        response.code = "0"
        response.msg = "ok"
        response.data = data
        response
    }

}
