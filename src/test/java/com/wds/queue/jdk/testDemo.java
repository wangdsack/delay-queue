package com.wds.queue.jdk;

import com.wds.queue.jdk.common.OrderDelay;
import com.wds.queue.jdk.common.OrderDelayQueue;
import org.junit.Test;

/**
 * @PACKAGE_NAME: com.wds.queue.jdk
 * @NAME: testDemo
 * @USER: wds
 * @DATE: 2021/4/14 14:03
 */
public class testDemo {

    @Test
    public  void  test_jdkDelayQueue() throws InterruptedException {
        OrderDelayQueue orderDelayQueue = new OrderDelayQueue(20000);
        for (int i = 0; i < 10; i++) {
            orderDelayQueue.push(i+"","第"+i+"个商品");
        }

        while (orderDelayQueue.size() != 0) {
            OrderDelay pop = orderDelayQueue.pop();
            System.out.println(pop);
        }
    }

}
