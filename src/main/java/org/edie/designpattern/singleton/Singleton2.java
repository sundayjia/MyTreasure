package org.edie.designpattern.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-2-28
 * Time: 下午5:20
 * To change this template use File | Settings | File Templates.
 */
//懒汉式单例类.在第一次调用的时候实例化
public class Singleton2 {
    //私有的默认构造子
    private Singleton2() {
    }

    //注意，这里没有final
    private static Singleton2 single = null;

    //静态工厂方法
    public synchronized static Singleton2 getInstance() {
        if (single == null) {
            single = new Singleton2();
        }
        return single;
    }
}