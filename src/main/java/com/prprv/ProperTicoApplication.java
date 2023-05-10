package com.prprv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//注意：@MapperScan注解要导入TK包下的
@MapperScan(basePackages = "com.prprv.mapper")
public class ProperTicoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProperTicoApplication.class, args);
    }

}
