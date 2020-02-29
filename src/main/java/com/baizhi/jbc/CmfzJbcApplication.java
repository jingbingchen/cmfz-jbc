package com.baizhi.jbc;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.jbc.Dao")
public class CmfzJbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmfzJbcApplication.class, args);
    }

}
