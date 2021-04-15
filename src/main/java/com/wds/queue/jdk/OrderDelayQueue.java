package com.wds.queue.jdk;

import com.wds.queue.jdk.OrderDelay;
import com.wds.queue.vo.Order;

import java.util.concurrent.DelayQueue;
/**
 * @PACKAGE_NAME: com.wds.queue.jdk.common
 * @NAME: OrderDelayQueue
 * @USER: wds
 * @DATE: 2021/4/14 13:31
 */
public class OrderDelayQueue implements com.wds.queue.jdk.DelayQueue {

    /**
     * 过期时长，单位(纳秒)
     */
    public   long delay;
    public DelayQueue<OrderDelay> delayQueue= new DelayQueue<OrderDelay>();

    /**
     * 参数传入毫秒转成纳秒
     */
    public OrderDelayQueue(long delay) {
        this.delay = delay * 1000000;
    }


    /**
     * String tmpKey 订单唯一编号
     * String messahe 商品信息
     */
    @Override
    public boolean push(String tmpKey, String message) {
        OrderDelay orderDelay = new OrderDelay(tmpKey,message,delay);
        //将指定的元素插入队列
        return delayQueue.offer(orderDelay);
    }

    /**
     * 删除队列中的元素,阻塞,存在过期元素才会删除
     * @return
     */
    @Override
    public Order pop() throws InterruptedException {
        return delayQueue.take();
    }

    /**
     * 清除队列中所有元素
     */
    @Override
    public void clean() {
        delayQueue.clear();
    }

    /**
     * 队列中元素的数量
     */
    @Override
    public int size() {
        return delayQueue.size();
    }
}
