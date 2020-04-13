package com.corse.agencyerp


import groovy.json.JsonParserType
import groovy.json.JsonSlurper
import groovy.transform.TypeChecked


class test {

    static void main(String[] args) {
        def slurper = new JsonSlurper(type:JsonParserType.LAX)
        def jsonStr = '{a:1}'
        Map result = slurper.parseText(jsonStr)
        println(result.get('a')+'1')
    }

}
