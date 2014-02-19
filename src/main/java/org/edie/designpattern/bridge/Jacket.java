package org.edie.designpattern.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-17
 * Time: 上午11:08
 * To change this template use File | Settings | File Templates.
 */
public class Jacket extends Clothing{

    @Override
    public void personDressClothing(Person person) {
        //To change body of implemented methods use File | Settings | File Templates.
        System.out.println(person.getType()+"穿衣服");
    }
}
