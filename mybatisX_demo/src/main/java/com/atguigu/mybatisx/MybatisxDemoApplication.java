package com.atguigu.mybatisx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author zhuchifeng
 * @Date 2022/10/22 7:18
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.atguigu.mybatisx.mapper")
public class MybatisxDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisxDemoApplication.class, args);
    }
}
