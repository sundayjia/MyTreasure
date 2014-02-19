package org.edie.designpattern.prototype;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-2-28
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
abstract class Prototype implements Cloneable
{
    private String _name;
    public void setName(String name)
    {
        _name = name;
    }

    public String getName()
    {
        return _name;
    }

    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}
// Concrete Prototype
class TrainPrototype extends Prototype
{
    public TrainPrototype(String name)
    {
        setName(name);
    }
}
public class PrototypeTest
{
    public static void main(String[] args)
    {
        Prototype prototype = new TrainPrototype("北方火车");
        Prototype p2 = (Prototype)prototype.clone();
        System.out.println("prototype name: " + prototype.getName());
        System.out.println("p2 name: " + p2.getName());
    }
}