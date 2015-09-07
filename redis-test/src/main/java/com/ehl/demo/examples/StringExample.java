package com.ehl.demo.examples;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * Created by Lenovo on 2015/9/1.
 */
public class StringExample extends ExampleCase{
    @Override
    protected void exexute(Jedis jedis) {
//        commonCommand(jedis);
        bitMapCommand(jedis);
//        logger.info("{},{}",random.nextInt(1000000000),random.nextInt(1000000000));
    }
    private Random random = new Random();
    private void bitMapCommand(Jedis jedis) {
        jedis.flushDB();
//        for (int i = 0; i < 3; i++){
//            int x=random.nextInt(1000000000);
//            logger.info("d="+x);
//            jedis.setbit("ehl-bitmap-test",x,true);
//        }
        jedis.setbit("ehl-bitmap-test",1*8,true);
        jedis.setbit("ehl-bitmap-test", 2 * 8, true);
       logger.info("" + jedis.bitcount("ehl-bitmap-test"));
        logger.info(""+jedis.bitcount("ehl-bitmap-test", 2, -1));
        logger.info("" + jedis.getbit("ehl-bitmap-test",2*8));
        //BITOP operation destkey key [key ...]

        //对一个或多个保存二进制位的字符串 key 进行位元操作，并将结果保存到 destkey 上。

        //operation 可以是 AND 、 OR 、 NOT 、 XOR 这四种操作中的任意一种：

        //BITOP AND destkey key [key ...] ，对一个或多个 key 求逻辑并，并将结果保存到 destkey 。
        //BITOP OR destkey key [key ...] ，对一个或多个 key 求逻辑或，并将结果保存到 destkey 。
        //BITOP XOR destkey key [key ...] ，对一个或多个 key 求逻辑异或，并将结果保存到 destkey 。
        //BITOP NOT destkey key ，对给定 key 求逻辑非，并将结果保存到 destkey 。
    }

    /**
     * 常用命令
     * @param jedis
     */
    private void commonCommand(Jedis jedis){
        // SET key value [EX seconds] [PX milliseconds] [NX|XX]
        // 将字符串值 value 关联到 key ,如果 key 已经持有其他值， SET 就覆写旧值，无视类型。
        //EX second ：设置键的过期时间为 second 秒。 SET key value EX second 效果等同于 SETEX key second value 。
        //PX millisecond ：设置键的过期时间为 millisecond 毫秒。 SET key value PX millisecond 效果等同于 PSETEX key millisecond value 。
        //NX ：只在键不存在时，才对键进行设置操作。 SET key value NX 效果等同于 SETNX key value 。
        //XX ：只在键已经存在时，才对键进行设置操作。
        jedis.flushDB();
        logger.info("string init:set command .");
        jedis.set("ehl-string-test","ehl--------");

        // APPEND key value
        jedis.append("ehl-string-test","abc");
        //如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。

        //如果 key 不存在， APPEND 就简单地将给定 key 设为 value ，就像执行 SET key value 一样

        logger.info("get command value={}",jedis.get("ehl-string-test"));

        logger.info("getrange command value={}",jedis.getrange("ehl-string-test",0,2));

        //MSET key value [key value ...]
    }
    public static void main(String[]args){
        ExampleCase exampleCase = new StringExample();
        exampleCase.executeExample();
    }
}
