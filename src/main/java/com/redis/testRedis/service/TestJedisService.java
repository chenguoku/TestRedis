package com.redis.testRedis.service;

import java.io.File;

import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.asm.Advice.This;
import redis.clients.jedis.Jedis;

@Service
public class TestJedisService {

	private final Logger logger = LoggerFactory.getLogger(This.class);
	
//	@Autowired
	private Jedis jedis;
	
	
	public boolean testJedis() {
		
		String name = jedis.get("name");
		logger.info(name);
		return true;
	}
	
}
