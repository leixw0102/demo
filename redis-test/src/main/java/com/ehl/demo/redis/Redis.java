/* Copyright 2013 Future TV, Inc.
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package com.ehl.demo.redis;

import com.ehl.demo.commons.PropertiesLoaderUtils;
import com.ehl.demo.redis.exception.CacheExecption;
import com.google.common.base.Strings;
import com.google.common.primitives.Ints;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: xiaowu lei
 * Date: 13-11-15
 * Time: 下午1:32
 */
public class Redis extends RedisConfig{


    private Redis(){
    }
    private static Properties propertiesUtils=null;

    private static JedisPool jedisPool;
    private static synchronized void init(){
        try {
            propertiesUtils = PropertiesLoaderUtils.loadAllProperties("redis.properties");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if(null == jedisPool){
            JedisPoolConfig config=new JedisPoolConfig();
            config.setMaxTotal(Ints.tryParse(propertiesUtils.getProperty(REDIS_MAXACTIVE)));
            config.setMaxWaitMillis(Long.parseLong(propertiesUtils.getProperty(REDIS_MAXWAIT)));
            config.setTestOnBorrow(true);

            String pwd =propertiesUtils.getProperty(REDIS_PWD);
            String ip=propertiesUtils.getProperty(REDIS_IP);
            int port=Ints.tryParse(propertiesUtils.getProperty(REDIS_PORT));
            if(Strings.isNullOrEmpty(pwd)){
                jedisPool = new JedisPool(config,ip,port,2000*5);
            }else {
                jedisPool = new JedisPool(config, ip, port, 2000 * 5, pwd);
            }
        }
    }

    public static Jedis getJedis(){
        init();
        Jedis jedis= jedisPool.getResource();
        jedis.select(Ints.tryParse(propertiesUtils.getProperty(REDIS_DB,"0")));
        return jedis;
    }

    public static void returnResource(Jedis jedis){
        if(null != jedis){
            jedis.close();
        }
    }

    public static  <T> T execute(IRedisCache<T> cache){
        Jedis jedis=null;
        try{
            jedis= getJedis();
            return cache.callBack(jedis);
        }catch (Exception e){
           throw new CacheExecption(e);
        }finally {
           returnResource(jedis);
        }
    }

}
