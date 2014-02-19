package org.edie.designpattern.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-17
 * Time: 上午11:03
 * To change this template use File | Settings | File Templates.
 */
public class Man extends Person{
    public Man(){
        setType("男人");
    }
    @Override
    public void dress() {
        Clothing clothing = getClothing();
        clothing.personDressClothing(this);
    }
}
