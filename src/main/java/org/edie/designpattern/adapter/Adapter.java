package org.edie.designpattern.adapter;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-2-28
 * Time: 下午5:34
 * 适配器角色:扩展源角色，实现目标角色，从而使得目标角色改动时候，不用改动源角色，只要改动适配器
 */
public class Adapter extends Adaptee implements Target{
    public int get110v(){
        return 110;
    }
}
