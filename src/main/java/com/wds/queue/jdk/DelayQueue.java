package com.wds.queue.jdk;

import com.wds.queue.vo.Order;

public interface DelayQueue {


    public boolean push(String tmpKey,String message);

    public Order pop() throws InterruptedException;

    public void clean();

    public int size();

}
