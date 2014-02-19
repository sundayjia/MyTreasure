package org.edie.designpattern.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-17
 * Time: 上午11:01
 * To change this template use File | Settings | File Templates.
 */
public abstract class Person {
    private String type;
    private Clothing clothing;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public abstract void dress();
}
