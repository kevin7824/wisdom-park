package com.honsin.portal.common.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.honsin.portal.MyBootApplication;
import com.honsin.portal.common.controller.HelloController;


/**
 * 服务启动执行
 */
@Component
@Order(1)
public class MyStartupRunner1 implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(MyBootApplication.class);
	
	@Autowired
	private HelloController hello;
	
    @Override
    public void run(String... args) throws Exception {
    	
    	log.debug("log1");
    	log.info("log2");
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作111<<<<<<<<<<<<<");
        log.error("log3");
    }

}