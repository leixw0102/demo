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

        //��һ���������������λ���ַ��� key ����λԪ����������������浽 destkey �ϡ�

        //operation ������ AND �� OR �� NOT �� XOR �����ֲ����е�����һ�֣�

        //BITOP AND destkey key [key ...] ����һ������ key ���߼���������������浽 destkey ��
        //BITOP OR destkey key [key ...] ����һ������ key ���߼��򣬲���������浽 destkey ��
        //BITOP XOR destkey key [key ...] ����һ������ key ���߼���򣬲���������浽 destkey ��
        //BITOP NOT destkey key ���Ը��� key ���߼��ǣ�����������浽 destkey ��
    }

    /**
     * ��������
     * @param jedis
     */
    private void commonCommand(Jedis jedis){
        // SET key value [EX seconds] [PX milliseconds] [NX|XX]
        // ���ַ���ֵ value ������ key ,��� key �Ѿ���������ֵ�� SET �͸�д��ֵ���������͡�
        //EX second �����ü��Ĺ���ʱ��Ϊ second �롣 SET key value EX second Ч����ͬ�� SETEX key second value ��
        //PX millisecond �����ü��Ĺ���ʱ��Ϊ millisecond ���롣 SET key value PX millisecond Ч����ͬ�� PSETEX key millisecond value ��
        //NX ��ֻ�ڼ�������ʱ���ŶԼ��������ò����� SET key value NX Ч����ͬ�� SETNX key value ��
        //XX ��ֻ�ڼ��Ѿ�����ʱ���ŶԼ��������ò�����
        jedis.flushDB();
        logger.info("string init:set command .");
        jedis.set("ehl-string-test","ehl--------");

        // APPEND key value
        jedis.append("ehl-string-test","abc");
        //��� key �Ѿ����ڲ�����һ���ַ����� APPEND ��� value ׷�ӵ� key ԭ����ֵ��ĩβ��

        //��� key �����ڣ� APPEND �ͼ򵥵ؽ����� key ��Ϊ value ������ִ�� SET key value һ��

        logger.info("get command value={}",jedis.get("ehl-string-test"));

        logger.info("getrange command value={}",jedis.getrange("ehl-string-test",0,2));

        //MSET key value [key value ...]
    }
    public static void main(String[]args){
        ExampleCase exampleCase = new StringExample();
        exampleCase.executeExample();
    }
}
