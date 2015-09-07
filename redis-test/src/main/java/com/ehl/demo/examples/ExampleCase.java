package com.ehl.demo.examples;

import com.ehl.demo.redis.Redis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * Created by Lenovo on 2015/9/1.
 */
public abstract class ExampleCase {
    protected  final Logger logger = LoggerFactory.getLogger(ExampleCase.class);
    protected Jedis get(){
        return Redis.getJedis();
    }

    protected void close(Jedis jeds){
        Redis.returnResource(jeds);
    }

    public void executeExample(){
        Jedis jedis = null;
        try{
            jedis = get();
            logger.info("........");
            exexute(jedis);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(jedis);
        }
    }

    protected abstract void exexute(Jedis jedis);

}
