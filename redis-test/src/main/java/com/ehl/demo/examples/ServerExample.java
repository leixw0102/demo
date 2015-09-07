package com.ehl.demo.examples;

import redis.clients.jedis.Jedis;

/**
 * Created by Lenovo on 2015/9/2.
 */
public class ServerExample extends ExampleCase {
    @Override
    protected void exexute(Jedis jedis) {
//        jedis.slaveof()
//        jedis.shutdown();
        jedis.info();
    }
}
