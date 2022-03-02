package cn.hjl.easynotes.demo;


import cn.hjl.easynotes.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Autowired
    private Jedis jedis ;

    @Test
    public void testString() {
        strRedisTemplate.opsForValue().set("strKey", "zwqh");
        System.out.println(strRedisTemplate.opsForValue().get("strKey"));
    }

    @Test
    public void testSerializable() {
        UserEntity user=new UserEntity();
        user.setId(1L);
        user.setUserName("朝雾轻寒");
        user.setUserSex("男");
        serializableRedisTemplate.opsForValue().set("user", user);
        UserEntity user2 = (UserEntity) serializableRedisTemplate.opsForValue().get("user");
        System.out.println("user:"+user2.getId()+","+user2.getUserName()+","+user2.getUserSex());
    }





    @Test
    public void testJedis()
    {
        //1、生成一个jedis对象，这个对象负责和指定Redis节点进行通信
        Jedis jedis = new Jedis("localhost", 6379);
        //带密码需要执行认证方法，这里我的Redis没有设密码就不用管
        //jedis.auth("123456");

        //2、jedis存入数据
        jedis.set("hello", "world");
        //3、jedis获取数据
        String value = jedis.get("hello");

        System.out.println(value);

    }


    public boolean tryLock_with_lua(String key, String UniqueId, int seconds) {
        String lua_scripts = "if redis.call('setnx',KEYS[1],ARGV[1]) == 1 then " +
                "redis.call('expire',KEYS[1],ARGV[2]) return 1 else return 0 end";
        List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();
        keys.add(key);
        values.add(UniqueId);
        values.add(String.valueOf(seconds));
        Object result = jedis.eval(lua_scripts, keys, values);
        System.out.println(result);
        //判断是否成功
        return result.equals(1L);
    }


    @Test
    public void testSetnx1(){
        System.out.println(tryLock_with_lua("hujingli","1232456",10));
    }



}
