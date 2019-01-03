package com.redis.testRedis.controller;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class TestRedisController {

	@Autowired
	private RedissonClient redisson;
	
	@Autowired
	private Jedis jedis;
	
	@Test
	public void testSingle() {
//		Jedis jedis = new Jedis();
		Jedis jedis = new Jedis("192.168.138.128",6379);
		jedis.set("name", "111222");
		String string = jedis.get("name");
		System.out.println(string);
	}
	
	@Test
	public void testCluster() {
		Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
		jedisClusterNode.add(new HostAndPort("192.168.138.128", 7001));
		jedisClusterNode.add(new HostAndPort("192.168.138.128", 7002));
		jedisClusterNode.add(new HostAndPort("192.168.138.128", 7003));
		jedisClusterNode.add(new HostAndPort("192.168.138.128", 7004));
		jedisClusterNode.add(new HostAndPort("192.168.138.128", 7005));
		jedisClusterNode.add(new HostAndPort("192.168.138.128", 7006));
		
		JedisPoolConfig cfg = new JedisPoolConfig();
		cfg.setMaxTotal(100);
		cfg.setMaxIdle(20);
		cfg.setMaxWaitMillis(-1);
		cfg.setTestOnBorrow(true);
		JedisCluster jc = new JedisCluster(jedisClusterNode,6000,100,cfg);
		
		System.out.println(jc.set("age", "20"));
		System.out.println(jc.set("sex", "man"));
		System.out.println(jc.get("age"));
		System.out.println(jc.get("sex"));
		
	}
	
	
	@GetMapping("/test")
	public int testController() {
//		redisson.
		return 1;
	}
	
}
