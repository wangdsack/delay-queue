package com.wds.queue.jdk;

import com.wds.queue.jdk.OrderDelayQueue;
import com.wds.queue.vo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @PACKAGE_NAME: com.wds.queue.jdk
 * @NAME: testDemo
 * @USER: wds
 * @DATE: 2021/4/14 14:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class testDemo {

    @Test
    public  void  test_jdkDelayQueue() throws InterruptedException {
        OrderDelayQueue orderDelayQueue = new OrderDelayQueue(10000);
        for (int i = 0; i < 10; i++) {
            orderDelayQueue.push(i+"","第"+i+"个商品");
        }

        while (orderDelayQueue.size() != 0) {
            Order pop = orderDelayQueue.pop();
            System.out.println(pop);
        }
    }

}
