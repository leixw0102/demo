package com.ehl.demo.examples.pub;

import com.ehl.demo.examples.ExampleCase;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by Lenovo on 2015/9/6.
 */
public class Sub1Example extends ExampleCase {

    protected JedisPubSub common = new JedisPubSub() {
        @Override
        public void onMessage(String channel, String message) {
            logger.info("channel = {},message={}",channel,message);

            if(message.equals("quit")){
                logger.info("+++++++++");
                this.unsubscribe(channel);
            }
        }

        @Override
        public void onPMessage(String pattern, String channel, String message) {
            logger.info("channel = {},message={},pattern={}", channel, message, pattern);
        }

        @Override
        public void onPSubscribe(String pattern, int subscribedChannels) {
            logger.info("channel = {},message={}", pattern, subscribedChannels);
        }

    };
    @Override
    protected void exexute(Jedis jedis) {
        jedis.subscribe(common, "ehl-msg-01");

//        jedis.pubsubChannels()
//        jedis.su
    }
    public static void main(String[]args){
        ExampleCase exampleCase = new Sub1Example();
        exampleCase.executeExample();
    }
}
