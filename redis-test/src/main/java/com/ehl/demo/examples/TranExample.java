package com.ehl.demo.examples;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Created by Lenovo on 2015/9/2.
 * redis事务在执行的中途遇到错误，不会回滚，而是继续执行后续命令；（违反原子性）
 *
 * 为了保持简单，redis事务保证了其中的一致性和隔离性；
 不满足原子性和持久性；
 */
public class TranExample extends ExampleCase {
    /**
     * 原子性

     redis事务在执行的中途遇到错误，不会回滚，而是继续执行后续命令；（违反原子性）
     * @param jedis
     */
    @Override
    protected void exexute(Jedis jedis) {

        //1.MULTI  命令用于开启一个事务，它总是返回 OK 。MULTI 执行之后，客户端可以继续向服务器发送任意多条命令，这些命令不会立即被执行，而是被放到一个队列中
        //2.EXEC 命令被调用时，所有队列中的命令才会被执行
        //3.DISCARD  命令时，事务会被放弃，事务队列会被清空，并且客户端会从事务状态中退出
        //4.WATCH  命令可以为 Redis 事务提供 check-and-set （CAS）行为 被WATCH 的键会被监视，并会发觉这些键是否被改动过了。如果有至少一个被监视的键在EXEC 执行之前被修改了，那么整个事务都会被取消

        /**
         * 使用事务时可能会遇上以下两种错误：
         1.事务在执行EXEC 之前，入队的命令可能会出错。比如说，命令可能会产生语法错误（参数数量错误，参数名错误，等等），或者其他更严重的错误，比如内存不足
         （如果服务器使用 maxmemory 设置了最大内存限制的话）。
         在 Redis 2.6.5 以前，Redis 只执行事务中那些入队成功的命令，而忽略那些入队失败的命令
         不过，从 Redis 2.6.5 开始，服务器会对命令入队失败的情况进行记录，并在客户端调用EXEC 命令时，拒绝执行并自动放弃这个事务。
         2.命令可能在EXEC 调用之后失败。举个例子，事务中的命令可能处理了错误类型的键，比如将列表命令用在了字符串键上面，诸如此类。
         第二种错误的情况:
         至于那些在EXEC 命令执行之后所产生的错误，并没有对它们进行特别处理：即使事务中有某个/某些命令在执行时产生了错误，事务中的其他命令仍然会继续执行
         */
//        jedis.watch("")监听
        Transaction tr=jedis.multi();
        //command
        List result = tr.exec();
        //
//        tr.discard();
    }
}
