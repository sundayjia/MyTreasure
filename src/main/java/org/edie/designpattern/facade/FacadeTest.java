package org.edie.designpattern.facade;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-17
 * Time: 下午12:15
 * To change this template use File | Settings | File Templates.
 */
class SubSysClassX {
    public void doX() {
        System.out.println("SubSysClassX doX called");
    }
}

class SubSysClassY {
    public void doY() {
        System.out.println("SubSysClassY doY called");
    }
}

class SubSysClassZ {
    public void doZ() {
        System.out.println("SubSysClassZ doZ called");
    }
}

class Facade {
    private SubSysClassX x = new SubSysClassX();
    private SubSysClassY y = new SubSysClassY();
    private SubSysClassZ z = new SubSysClassZ();

    public void doWrapper(boolean includeY) {
        System.out.println("The Facade OperationWrapper carries out complex decision-making");
        System.out.println("which in turn results in calls to the subsystem classes");
        x.doX();
        if (includeY) {
            y.doY();
        }
        z.doZ();
    }
}

public class FacadeTest {

    public static void main(String[] args) {
        Facade f1 = new Facade();
        f1.doWrapper(false);

        Facade f2 = new Facade();
        f2.doWrapper(true);
    }

}