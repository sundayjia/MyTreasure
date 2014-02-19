package org.edie.designpattern.observer;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-31
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */
public interface Observer {
    void update(Observable o, Object arg);
}