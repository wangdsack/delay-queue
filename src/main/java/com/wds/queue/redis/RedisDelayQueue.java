package com.wds.queue.redis;

import com.wds.queue.vo.Order;

import java.util.Map;
import java.util.Set;

public interface RedisDelayQueue {


    public boolean push(String key,String ID,String message);

    public Map<String,Object> pop(String key);

    public void clean();

    public int size();

}
