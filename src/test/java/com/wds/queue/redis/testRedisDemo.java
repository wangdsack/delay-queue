package com.wds.queue.redis;

import com.wds.queue.vo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * @PACKAGE_NAME: com.wds.queue.redis
 * @NAME: testRedisDemo
 * @USER: wds
 * @DATE: 2021/4/14 15:42
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class testRedisDemo {
    @Autowired
    RedisTemplate<String, Order> redisTemplate;

    @Test
    public void  test_redisDelay(){
        OrderRedisDelayQueue orderRedisDelayQueue = new OrderRedisDelayQueue(redisTemplate,10000);
//        orderRedisDelayQueue.push("order","4","第四个商品");

        Set<Order> order = orderRedisDelayQueue.pop("order");
        for (Order order1 : order) {
            System.out.println(System.nanoTime());
            System.out.println(order1);
        }

    }

}
