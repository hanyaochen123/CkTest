package com.kuang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@MapperScan(basePackages ="com.kuang.mapper")
@EnableTransactionManagement
public class DemoplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoplusApplication.class, args);
    }

}
