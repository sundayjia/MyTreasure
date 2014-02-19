package org.edie.designpattern.Decorator;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-17
 * Time: 上午11:48
 * To change this template use File | Settings | File Templates.
 */
abstract class Component {
    public abstract void draw();
}

class ConcreteComponent extends Component {

    private String name;

    public ConcreteComponent(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println(String.format("ConcreteComponent - %s", name));
    }

}

abstract class Decorator extends Component {
    protected Component internalComponent;

    public void setComponent(Component c) {
        this.internalComponent = c;
    }

    @Override
    public void draw() {
        if (internalComponent != null) {
            internalComponent.draw();
        }
    }
}

class ConcreteDecorator extends Decorator {

    private String customName;

    public ConcreteDecorator(String name) {
        this.customName = name;
    }

    @Override
    public void draw() {
        extraDraw();
        super.draw();
    }

    protected void extraDraw() {
        System.out.println("Draw extra action in ConcreteDecorator...");
    }
}


public class DecoratorTest {

    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent("This is the real component");
        ConcreteDecorator d = new ConcreteDecorator("This is a decorator for the component");
        d.setComponent(c);
        d.draw();
    }
}
