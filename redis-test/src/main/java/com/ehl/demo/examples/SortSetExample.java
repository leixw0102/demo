package com.ehl.demo.examples;

import redis.clients.jedis.Jedis;

/**
 * Created by Lenovo on 2015/9/2.
 */
public class SortSetExample extends ExampleCase {
    @Override
    protected void exexute(Jedis jedis) {
        jedis.flushDB();
        jedis.zadd("ehl-sortset-example", 10, "www.baidu.com");
        jedis.zadd("ehl-sortset-example", 12, "www.google.com");
        jedis.zadd("ehl-sortset-example",10,"www.163.com");
        jedis.zadd("ehl-sortset-example", 11, "www.google.com");
        logger.info("size={}", jedis.zcard("ehl-sortset-example"));
        logger.info("min,max={}", jedis.zcount("ehl-sortset-example", 0, 10));
        logger.info("increment value ={}", jedis.zincrby("ehl-sortset-example", 14, "www.163.com"));
        //����
        logger.info(jedis.zrevrange("ehl-sortset-example", 0, 10)+"");
//        jedis.
        logger.info(jedis.zrange("ehl-sortset-example", 0, 10)+"");
//        logger.info(jedis.zrangeByLex("ehl-sortset-example", 0, 10)+"");
        logger.info(jedis.zrangeByScore("ehl-sortset-example","(10","20")+"");

        //����
        logger.info(jedis.zrank("ehl-sortset-example","www.163.com")+"");
        logger.info(jedis.zrevrank("ehl-sortset-example","www.163.com")+"");

        //ɾ��
//        logger.info(jedis.zrem());
//        jedis.zremrangeByRank()�Ƴ����� key �У�ָ������(rank)�����ڵ����г�Ա��

        logger.info(jedis.zscore("ehl-sortset-example","www.163.com")+"");
    }
    public static void main(String[]args){
        ExampleCase exampleCase = new SortSetExample();
        exampleCase.executeExample();
    }
}
