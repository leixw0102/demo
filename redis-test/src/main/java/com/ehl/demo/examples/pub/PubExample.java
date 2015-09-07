package com.ehl.demo.examples.pub;

import com.ehl.demo.examples.ExampleCase;
import redis.clients.jedis.Jedis;

/**
 * Created by Lenovo on 2015/9/6.
 */
public class PubExample extends ExampleCase{
    @Override
    protected void exexute(Jedis jedis) {

        logger.info("pub channel msg "+jedis.publish("ehl-msg-01","hello word!"));

        logger.info("pub channel msg "+jedis.publish("ehl-msg-01","quit"));
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//
//        }
        logger.info("pub channel msg "+jedis.publish("ehl-msg-01","quit"));
    }



    public static void main(String[]args){
        ExampleCase exampleCase = new PubExample();
        exampleCase.executeExample();
    }
}
