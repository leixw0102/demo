package com.ehl.demo.examples;
import redis.clients.jedis.Jedis;

/**
 * Created by Lenovo on 2015/9/1.
 */
public class KeyExample extends ExampleCase{
    private void operate(Jedis jedis){
        logger.info("init exit key ={},result={}","abc",jedis.exists("abc"));
        //operate
        //EXPIRE key seconds  Ϊ���� key ��������ʱ�䣬�� key ����ʱ(����ʱ��Ϊ 0 )�����ᱻ�Զ�ɾ��
        //EXPIREAT


//        logger.info("init data by set ,result={}",jedis.set("abc", "example"));
        logger.info(" exit key ={},result={}","abc",jedis.exists("abc"));
        logger.info(jedis.keys("*").size()+"");
        //keys ƥ��ģʽ
        //KEYS * ƥ�����ݿ������� key ��
        //KEYS h?llo ƥ�� hello �� hallo �� hxllo �ȡ�
        //KEYS h*llo ƥ�� hllo �� heeeeello �ȡ�
        //KEYS h[ae]llo ƥ�� hello �� hallo ������ƥ�� hillo ��


        //move key db

        //randomkey
        logger.info("random key ={}",jedis.randomKey());


        //RENAME key newkey  �� newkey �Ѿ�����ʱ�� RENAME ������Ǿ�ֵ
       // RENAMENX key newkey //���ҽ��� newkey ������ʱ���� key ����Ϊ newkey ��


        //TYPE key  ���� key �������ֵ�����͡�none (key������)
        //string (�ַ���)
        //list (�б�)
        //set (����)
        //zset (����)
        //hash (��ϣ��)
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
