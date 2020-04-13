package com.corse.agencyerp;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages  = {"com.corse.agencyerp.dao.mapper"})
public class AgencyerpApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgencyerpApplication.class, args);
    }

}
