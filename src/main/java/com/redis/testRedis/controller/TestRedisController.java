package com.redis.testRedis.controller;

import java.util.HashSet;
import java.util.Set;

import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.testRedis.service.TestJedisService;
import com.redis.testRedis.service.TestRedissonService;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@RestController
public class TestRedisController {

	@Autowired
	private TestJedisService testJedisService;
	
	@Autowired
	private TestRedissonService testRedisController;
	

	//单个redis 使用jedis 测试
//	@Test
//	public void testSingle() {
//		Jedis jedis ;
//		jedis = new Jedis("192.168.11.130",6379);
//		try {
//			jedis.set("name", "111222");
//			String string = jedis.get("name");
//			logger.info(string);
//			
//		} finally {
//			jedis.close();
//		}
//	}
//	
	//集群redis 使用jedis 测试
//	@Test
//	public void testCluster() {
//		Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
//		jedisClusterNode.add(new HostAndPort("192.168.138.128", 7001));
//		jedisClusterNode.add(new HostAndPort("192.168.138.128", 7002));
//		jedisClusterNode.add(new HostAndPort("192.168.138.128", 7003));
//		jedisClusterNode.add(new HostAndPort("192.168.138.128", 7004));
//		jedisClusterNode.add(new HostAndPort("192.168.138.128", 7005));
//		jedisClusterNode.add(new HostAndPort("192.168.138.128", 7006));
//		
//		JedisPoolConfig cfg = new JedisPoolConfig();
//		cfg.setMaxTotal(100);
//		cfg.setMaxIdle(20);
//		cfg.setMaxWaitMillis(-1);
//		cfg.setTestOnBorrow(true);
//		JedisCluster jc = new JedisCluster(jedisClusterNode,6000,100,cfg);
//		
//		System.out.println(jc.set("age", "20"));
//		System.out.println(jc.set("sex", "man"));
//		System.out.println(jc.get("age"));
//		System.out.println(jc.get("sex"));
//		
//	}
	
	
	@GetMapping("/test")
	public int testController() {
		
//		testJedisService.testJedis();
		testRedisController.testRedisson();
		return 1;
	}
	
}
