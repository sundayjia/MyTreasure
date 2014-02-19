package org.edie.designpattern.flyweight;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-17
 * Time: 下午12:29
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.List;

abstract class Flyweight
{
    abstract public void doOperation(int extrinsicState);
}

class UnsharedConcreteFlyweight extends Flyweight
{
    @Override
    public void doOperation(int extrinsicState)
    {
    }
}

class ConcreteEvenFlyweight extends Flyweight
{
    @Override
    public void doOperation(int extrinsicState)
    {
        System.out.println("In ConcreteEvenFlyweight.DoOperation: " + extrinsicState);
    }
}

class ConcreteUnevenFlyweight extends Flyweight
{
    @Override
    public void doOperation(int extrinsicState)
    {
        System.out.println("In ConcreteUnevenFlyweight.DoOperation: " + extrinsicState);
    }
}

class FlyweightFactory
{
    private List<Flyweight> pool = new ArrayList<Flyweight>();

    // the flyweightfactory can crete all entries in the pool at startup
    // (if the pool is small, and it is likely all will be used), or as
    // needed, if the pool si large and it is likely some will never be used
    public FlyweightFactory()
    {
        pool.add(new ConcreteEvenFlyweight());
        pool.add(new ConcreteUnevenFlyweight());
    }

    public Flyweight getFlyweight(int key)
    {
        // here we would determine if the flyweight identified by key
        // exists, and if so return it. If not, we would create it.
        // As in this demo we have implementation all the possible
        // flyweights we wish to use, we retrun the suitable one.
        int i = key % 2;
        return((Flyweight)pool.get(i));
    }
}

public class FlyweightTest {

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8};

        FlyweightFactory f = new FlyweightFactory();

        int extrinsicState = 3;
        for (int i : data)
        {
            Flyweight flyweight = f.getFlyweight(i);
            flyweight.doOperation(extrinsicState);
        }
    }
}