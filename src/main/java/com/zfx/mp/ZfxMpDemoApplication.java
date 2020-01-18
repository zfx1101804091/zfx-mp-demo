package com.zfx.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zfx.mp.mapper")
public class ZfxMpDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZfxMpDemoApplication.class, args);
    }

}
