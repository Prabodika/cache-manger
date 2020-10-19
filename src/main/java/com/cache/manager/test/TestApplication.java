package com.cache.manager.test;

import com.cache.manager.test.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Autowired
	private CacheService cacheService;

	@Override
	public void run(String... args) throws Exception {

		cacheService.getCache("abc");

	}
}
