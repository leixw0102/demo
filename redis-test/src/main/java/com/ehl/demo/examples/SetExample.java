package com.ehl.demo.examples;

import redis.clients.jedis.Jedis;

/**
 * Created by Lenovo on 2015/9/2.
 */
public class SetExample extends ExampleCase {
    @Override
    protected void exexute(Jedis jedis) {
        jedis.flushDB();
        jedis.sadd("ehl-set-example", "1", "2", "1");
        logger.info("size = {}",jedis.scard("ehl-set-example"));
        //集合只差 A-B
        //jedis.sdiff("key","key1");
//        jedis.sdiffstore()
        //交集A  B
//        jedis.sinter()
//        jedis.sinterstore()

        // 并集 a b
//        jedis.sunion()
//        jedis.sunionstore()
        //
        logger.info("exist ={}",jedis.sismember("ehl-set-example","1"));
        logger.info("not exist ={}",jedis.sismember("ehl-set-example","3"));
        logger.info("members ={}",jedis.smembers("ehl-set-example"));

//        logger.info("random value={},but remove from queue",jedis.spop());
        logger.info("random value ={}",jedis.srandmember("ehl-set-example",2));

//        logger.info("移除一个或多个,{}",jedis.srem(""));
    }
    public static void main(String[]args){
        ExampleCase exampleCase = new SetExample();
        exampleCase.executeExample();
    }
}
