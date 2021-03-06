package com.github.covidalert.newsprovider.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.TestConfiguration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@TestConfiguration
public class RedisTestConfig
{

    private final RedisServer redisServer;

    public RedisTestConfig(RedisProperties redisProperties)
    {
        this.redisServer = new RedisServer(redisProperties.getPort());
    }

    @PostConstruct
    public void postConstruct()
    {
        redisServer.start();
    }

    @PreDestroy
    public void preDestroy()
    {
        redisServer.stop();
    }

}
