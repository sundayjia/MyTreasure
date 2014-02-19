package org.edie.designpattern.observer;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-31
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */

public class MailObserver implements Observer{

    /**
     * 这个类取名为MailObserver，顾名思义，她是一个用来发送邮件的观察者
     */
    public void update(Observable o, Object arg) {
        System.out.println("发送邮件的观察者已经被执行");
    }
}