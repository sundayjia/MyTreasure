package org.edie.designpattern.observer;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-31
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */

public class JMSObserver implements Observer{

    public void update(Observable o, Object arg) {
        System.out.println("发送消息给jms服务器的观察者已经被执行");
    }
}