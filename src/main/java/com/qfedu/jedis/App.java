package com.qfedu.jedis;

import com.qfedu.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        //常见jedis对象
        Jedis jedis = new Jedis("47.104.24.228", 6379, 1000);
        //设置redis服务器密码
        jedis.auth("redis12358");
        //get根据key值获取字符串数据
        String name = jedis.get("name");
        System.out.println("name:"+name);

        jedis.set("weight","100");
        String weight = jedis.get("weight");
        System.out.println("weight:"+weight);

        jedis.hset("person","name","张三");
        //map集合
        HashMap<String, String> map = new HashMap<>();
        map.put("high","180");
        map.put("qq","123456");
        jedis.hmset("hasmap",map);
        System.out.println("hasmap:"+jedis.hgetAll("hasmap"));

        jedis.hset("person","age","20");
        String hget = jedis.hget("person", "name");
        String hget1 = jedis.hget("person", "age");
        System.out.println("姓名:"+hget+"年龄"+hget1);

        jedis.close();






        Jedis jedis1 = JedisUtils.getJedis();
        System.out.println(jedis1.get("name"));
        JedisUtils.closeJedis(jedis1);

    }
}
