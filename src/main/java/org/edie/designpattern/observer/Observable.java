package org.edie.designpattern.observer;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-31
 * Time: 下午3:04
 * To change this template use File | Settings | File Templates.
 */
public class Observable {
    private boolean changed = false;
    private Vector obs;

    //创建被观察者时就创建一个它持有的观察者列表，注意，这个列表是需要同步的。
    public Observable() {
        obs = new Vector();
    }

    /**
     * 添加观察者到观察者列表中去
     */
    public synchronized void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    /**
     * 删除一个观察者
     */
    public synchronized void deleteObserver(Observer o) {
        obs.removeElement(o);
    }

    /**
     * 通知操作，即被观察者发生变化，通知对应的观察者进行事先设定的操作，不传参数的通知方法
     */
    public void notifyObservers() {
        notifyObservers(null);
    }

    /**
     * 与上面的那个通知方法不同的是，这个方法接受一个参数，这个参数一直传到观察者里，以供观察者使用
     */
    public void notifyObservers(Object arg) {

        Object[] arrLocal;

        synchronized (this) {
            if (!changed)
                return;
            arrLocal = obs.toArray();
            clearChanged();
        }

        for (int i = arrLocal.length - 1; i >= 0; i--)
            ((Observer) arrLocal[i]).update(this, arg);
    }
    private void clearChanged(){

    }
    protected  void setChanged(){

    }
}