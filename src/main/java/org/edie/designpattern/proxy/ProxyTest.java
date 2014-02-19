package org.edie.designpattern.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-17
 * Time: 下午12:49
 * To change this template use File | Settings | File Templates.
 */
abstract class Subject {
    public abstract void request();
}

class RealSubject  extends Subject {
    public RealSubject () {
        System.out.println("Starting to construct ActualSubject");
        try {
            // simulate doing some other work on the constructor
            Thread.sleep(1000);
            System.out.println("Sleeping 1 second finished....");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Finished constructing ActualSubject");

    }

    @Override
    public void request() {
        System.out.println("Executing request in ActualSubject");
    }
}

class ProxySubject extends Subject {
    Subject subject;

    @Override
    public void request() {
//        preRequest();
        if (subject == null) {
            subject = new RealSubject ();
        }
        subject.request();
//        postRequest();
    }
}

public class ProxyTest {

    public static void main(String[] args) {
        Subject subject = new ProxySubject();
        subject.request();
    }

}