package com.ehl.demo.examples;

import redis.clients.jedis.Jedis;

/**
 * Created by Lenovo on 2015/9/1.
 */
public class HashExample extends ExampleCase{

    @Override
    protected void exexute(Jedis jedis) {
        jedis.flushDB();
        jedis.hset("ehl-hset-example-1", "name", "lexw");
        jedis.hset("ehl-hset-example-1", "age", "30");
        logger.info("key exist={}", jedis.exists("ehl-hset-example-1"));
        logger.info("hexist={}",jedis.hexists("ehl-hset-example-1","age"));
//        logger.info(jedis.hgetAll());
        logger.info("fields ={},size={}",jedis.hkeys("ehl-hset-example-1"),jedis.hlen("ehl-hset-example-1"));
        logger.info("hset -->hget={},{}", jedis.hget("ehl-hset-example-1", "name"), jedis.hget("ehl-hset-example-1","age"));

        jedis.hdel("ehl-hset-example-1","name");
        logger.info("hset -->hget={},{}",jedis.hget("ehl-hset-example-1","name"),jedis.hget("ehl-hset-example-1","age"));
//        jedis.hm

    }
    public static void main(String[]args){
        ExampleCase exampleCase = new HashExample();
        exampleCase.executeExample();
    }
}
