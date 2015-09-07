package com.ehl.demo.redis;

import com.ehl.demo.commons.PropertiesLoaderUtils;
import com.google.common.primitives.Ints;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Lenovo on 2015/9/1.
 */
public class RedisConfig {
    static final String REDIS_IP="redis.ip";
    protected static final String REDIS_PORT="redis.port";
    protected static final String REDIS_PWD="redis.pwd";
    protected static final String REDIS_MAXACTIVE="redis.maxactive";
    protected static final String REDIS_MAXWAIT="redis.maxwait";
    protected static final String REDIS_DB="redis.db";



}
