package com.wds.queue.jdk.common;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @PACKAGE_NAME: com.wds.queue.jdk.common
 * @NAME: OrderDelay
 * @USER: wds
 * @DATE: 2021/4/14 13:34
 */
public class OrderDelay extends Order implements Delayed {

    public OrderDelay(String tmpKey, String message, long delay) {
        super(tmpKey, message, delay);
    }

    /**
     * 设置的到期时间减去当前时间。  unit.convert用于转换时间，大致用法请看 TestTimeUnit.class  测试类
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.getExpire()-System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    /**
     * 对队列中的元素进行排序
     */
    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.NANOSECONDS)-o.getDelay(TimeUnit.NANOSECONDS));
    }
}
