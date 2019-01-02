package com.redis.testRedis.controller;

import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import redis.clients.jedis.Jedis;

public class TestRedisController {

	@Autowired
	private RedissonClient redisson;
	
	@Autowired
	private Jedis jedis;
	
	@Test
	public void test() {
//		Jedis jedis = new Jedis();
		Jedis jedis = new Jedis("192.168.138.128",6379);
		jedis.set("name", "111222");
		String string = jedis.get("name");
		System.out.println(string);
	}
	
	@GetMapping("/test")
	public int testController() {
//		redisson.
		return 1;
	}
	
}
