package com.qfedu.utils;

import com.sun.org.apache.xpath.internal.objects.XNull;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
    private static JedisPool jedisPool= null;

    static {
        //jedis连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(30);
        config.setMinIdle(5);
        config.setMaxIdle(10);

        jedisPool=new JedisPool(config,"47.104.24.228",6379,1000,"redis12358");

    }

    //获取jedis对象
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    public static void closeJedis(Jedis jedis){
//        jedisPool.returnResource(jedis);//新版本已经废弃
        jedis.close();
    }


}
