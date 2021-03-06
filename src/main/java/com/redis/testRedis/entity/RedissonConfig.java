package com.redis.testRedis.entity;
import org.redisson.Redisson;  
import org.redisson.api.RedissonClient;  
import org.redisson.config.Config;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.core.io.ClassPathResource;  
  
import java.io.IOException;  
  
@Configuration  
public class RedissonConfig {  
  
    @Value("${redisCluster}")  
    private boolean redisCluster;  
  
    @Bean  
    public RedissonClient redissonClient() throws IOException {  
        return Redisson.create(  
                Config.fromYAML(new ClassPathResource("redisson-" + (redisCluster ? "cluster" : "single") + ".yml").getInputStream())  
        );  
    }  
}  