package org.edie.designpattern.memento;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-31
 * Time: 下午2:50
 * To change this template use File | Settings | File Templates.
 */
//memento:此为备忘录，用来对原发器对象的状态state进行保存
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}

//originator:此为原发器，它里面有一个关键状态，用1.中的类可以进行备份，需要的话，可以用这个备份来进行还原。同时此类里面有一个关键的生成备份的creatememento()方法，同时还有一个用于还原的useMemento(Memento m)方法：
class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void useMemento(Memento m) {
        this.state = m.getState();
    }

    public void showState() {
        System.out.println(state);
    }
}
 //此类用来对进行备份的Memento进行存储，然后在需要的时候，调用此类里面的那个memento对象引用：
class CareTaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento m) {
        this.memento = m;
    }
}
public class Test {
    public static void main(String[] args) {
        Originator o = new Originator();
        o.setState("正在睡觉中。。。。。。");

        CareTaker ca = new CareTaker();
        ca.setMemento(o.createMemento());

        o.setState("正在学习中。。。。。。");
        o.showState();

        o.useMemento(ca.getMemento());
        o.showState();
    }
}