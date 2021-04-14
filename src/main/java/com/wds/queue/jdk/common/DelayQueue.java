package com.wds.queue.jdk.common;

public interface DelayQueue {


    public boolean push(String tmpKey,String message);

    public OrderDelay pop() throws InterruptedException;

    public void clean();

    public int size();

}
