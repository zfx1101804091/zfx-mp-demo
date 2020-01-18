package com.zfx.mp.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 分页查询
 * @author: zheng-fx
 * @time: 2020/1/18 0018 20:22
 */
@Configuration
@MapperScan("com.zfx.mp.mapper") //设置mapper接口的扫描包
public class MybatisPlusConfig {

    /*** 分页插件 */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
