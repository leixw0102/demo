package com.ehl.demo.examples;

import redis.clients.jedis.Jedis;

/**
 * Created by Lenovo on 2015/9/1.
 */
public class ListExample extends ExampleCase{
    @Override
    protected void exexute(Jedis jedis) {
        jedis.flushDB();
//        commonComand(jedis);

        //��������
        blistCommand(jedis);
    }

    private void blistCommand(Jedis jedis) {
        //ͬʱ����
        while (true) {
            logger.info("values = {}", jedis.blpop(0, "ehl-list-example", "test"));
        }
    }

    private void commonComand(Jedis jedis){
        //jedis.ltrim(key,start,stop) ��������
//        jedis.lrem(key,count,value) �Ƴ�key��valueֵ������count
        //jedis.lrange(key, start,stop);
        //LINSERT key BEFORE|AFTER pivot value
         jedis.lpush("ehl-list-example", "2", "3");
        logger.info("pop={}", jedis.lpop("ehl-list-example"));
        jedis.lset("ehl-list-example",0,"10");
        logger.info("list element value={}",jedis.lindex("ehl-list-example",0));
    }
    public static void main(String[]args){
        ExampleCase exampleCase = new ListExample();
        exampleCase.executeExample();
    }
}
