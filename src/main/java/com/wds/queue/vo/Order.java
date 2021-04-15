package com.wds.queue.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author 王
 * @PACKAGE_NAME: com.wds.queue.jdk.common
 * @NAME: Order
 * @USER: wds
 * @DATE: 2021/4/14 13:21
 */
public class Order implements Serializable{

    private static final long serialVersionUID = -4312093020423278052L;
    /**
     * 订单唯一编号
     */
    private String tmpKey;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 延迟时间 纳秒
     */
    private long delay;

    /**
     * 到期时间 纳秒
     */
    private long expire;

    /**
     * 创建时间 纳秒
     */
    private long registerTime;

    public Order(String tmpKey, String message, long delay) {
        this.tmpKey = tmpKey;
        this.message = message;
        this.delay = delay;
        this.registerTime = System.nanoTime();
        this.expire = this.delay + this.registerTime;
    }
    public Order() {
    }

    public String getTmpKey() {
        return tmpKey;
    }

    public void setTmpKey(String tmpKey) {
        this.tmpKey = tmpKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(long registerTime) {
        this.registerTime = registerTime;
    }


    @Override
    public String toString() {
        return "Order{" +
                "tmpKey='" + tmpKey + '\'' +
                ", message='" + message + '\'' +
                ", delay=" + delay +
                ", expire=" + expire +
                ", registerTime=" + registerTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return delay == order.delay &&
                expire == order.expire &&
                registerTime == order.registerTime &&
                Objects.equals(tmpKey, order.tmpKey) &&
                Objects.equals(message, order.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tmpKey, message, delay, expire, registerTime);
    }
}
