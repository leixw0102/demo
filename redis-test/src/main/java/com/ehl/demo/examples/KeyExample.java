package com.ehl.demo.examples;
import redis.clients.jedis.Jedis;

/**
 * Created by Lenovo on 2015/9/1.
 */
public class KeyExample extends ExampleCase{
    private void operate(Jedis jedis){
        logger.info("init exit key ={},result={}","abc",jedis.exists("abc"));
        //operate
        //EXPIRE key seconds  为给定 key 设置生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除
        //EXPIREAT


//        logger.info("init data by set ,result={}",jedis.set("abc", "example"));
        logger.info(" exit key ={},result={}","abc",jedis.exists("abc"));
        logger.info(jedis.keys("*").size()+"");
        //keys 匹配模式
        //KEYS * 匹配数据库中所有 key 。
        //KEYS h?llo 匹配 hello ， hallo 和 hxllo 等。
        //KEYS h*llo 匹配 hllo 和 heeeeello 等。
        //KEYS h[ae]llo 匹配 hello 和 hallo ，但不匹配 hillo 。


        //move key db

        //randomkey
        logger.info("random key ={}",jedis.randomKey());


        //RENAME key newkey  当 newkey 已经存在时， RENAME 命令将覆盖旧值
       // RENAMENX key newkey //当且仅当 newkey 不存在时，将 key 改名为 newkey 。


        //TYPE key  返回 key 所储存的值的类型。none (key不存在)
        //string (字符串)
        //list (列表)
        //set (集合)
        //zset (有序集)
        //hash (哈希表)
    }


    public static void main(String[]args){
        //key
        ExampleCase example = new KeyExample();
        example.executeExample();
    }

    @Override
    protected void exexute(Jedis jedis) {
        operate(jedis);
    }


}
