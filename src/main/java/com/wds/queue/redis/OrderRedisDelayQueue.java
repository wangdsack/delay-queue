package com.wds.queue.redis;

import com.wds.queue.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 王
 * @PACKAGE_NAME: com.wds.queue.redis
 * @NAME: OrderRedisDelayQueue
 * @USER: wds
 * @DATE: 2021/4/14 15:20
 */

public class OrderRedisDelayQueue implements RedisDelayQueue, Serializable {

    private static final long serialVersionUID = 5622992690838772054L;

    public ZSetOperations<String, Order> zSet;
    public long delay;
    public OrderRedisDelayQueue(RedisTemplate<String, Order> redisTemplate, long delay) {
        this.zSet = redisTemplate.opsForZSet();
        this.delay = delay * 1000000;
    }

    /**
     * 将指定的元素放到集合中
     * key  队列名称
     * ID   商品唯一ID
     * message  描述信息
     */
    @Override
    public boolean push(String Key,String ID, String message) {
        Order order = new Order(ID, message, delay);
        return zSet.add(Key,order,order.getExpire());
    }

    /**
     * 删除过期元素.
     * return: data 删除的数据
     *         removeNum 删除的数量
     */
    @Override
    public Map<String,Object> pop(String Key) {
        long l = System.nanoTime();
        Set<Order> orders = zSet.reverseRangeByScore(Key, 0, l);
        Long aLong = zSet.removeRangeByScore(Key, 0, l);
        return new HashMap<String,Object>(){
            private static final long serialVersionUID = -340795443880730670L;
            {
                put("data",orders);
                put("removeNum",aLong);
            }
        };
    }

    @Override
    public void clean() {

    }

    @Override
    public int size() {
        return 0;
    }
}
