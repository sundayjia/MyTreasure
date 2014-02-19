package org.edie.designpattern.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-17
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
public class Trouser extends Clothing {
    @Override
    public void personDressClothing(Person person) {
        System.out.println(person.getType()+"穿裤子");
    }
}
