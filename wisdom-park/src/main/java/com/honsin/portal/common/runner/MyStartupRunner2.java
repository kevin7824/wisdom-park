package com.honsin.portal.common.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动执行
 */
@Component
public class MyStartupRunner2 implements CommandLineRunner,Ordered{

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作222 <<<<<<<<<<<<<");
    }

	@Override
	public int getOrder() {
		return 2;
	}

}