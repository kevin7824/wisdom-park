package com.honsin.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.honsin.portal.common.datasource.DynamicDataSourceRegister;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@Import({DynamicDataSourceRegister.class})
public class MyBootApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(MyBootApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}