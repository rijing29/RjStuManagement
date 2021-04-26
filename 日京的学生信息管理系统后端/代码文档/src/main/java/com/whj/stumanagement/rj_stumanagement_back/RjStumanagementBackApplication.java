package com.whj.stumanagement.rj_stumanagement_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.whj.stumanagement.rj_stumanagement_back.*"})
public class RjStumanagementBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(RjStumanagementBackApplication.class, args);
    }
}
