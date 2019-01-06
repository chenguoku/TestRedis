package com.redis.testRedis.service;

import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestRedissonService {

    @Autowired  
    private RedissonClient redissonClient;  
    
    public boolean testRedisson() {
    	
    	RMap<Object, Object> map = redissonClient.getMap("user");
//    	RBucket<Object> bucket = redissonClient.getBucket("name");
//    	System.out.println(bucket.toString());
    	
    	return true;
    }
	
}
