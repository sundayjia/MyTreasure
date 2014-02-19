package org.edie.designpattern.AbstractFactory;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-2-26
 * Time: 下午5:38
 * To change this template use File | Settings | File Templates.
 */
interface ITrainStair
{
    void make();
}
interface ITrainBody
{
    void make();
}
// concrete product
class NorthTrainStair implements ITrainStair
{
    public void make()
    {
        System.out.println("生产椅子(北方样式)完成......");
    }
}
class NorthTrainBody implements ITrainBody
{
    public void make()
    {
        System.out.println("生产车身(北方样式)完成......");
    }
}
class SouthTrainStair implements ITrainStair
{
    public void make()
    {
        System.out.println("生产椅子(南方样式)完成......");
    }
}
class SouthTrainBody implements ITrainBody
{
    public void make()
    {
        System.out.println("生产车身(南方样式)完成......");
    }
}
// abstract factory
interface ITrainFactory
{
    ITrainStair createTrainChair();
    ITrainBody  createTrainBody();
}
//Concrete Factory
class NorthFactory implements ITrainFactory
{
    public ITrainStair createTrainChair()
    {
        System.out.println("北车公司, 生产火车椅子零件(from North)...");
        ITrainStair its = new NorthTrainStair();
        return its;
    }

    public ITrainBody  createTrainBody()
    {
        System.out.println("北车公司, 生产火车车身零件(from North)...");
        ITrainBody itb = new NorthTrainBody();
        return itb;
    }
}
class SouthFactory implements ITrainFactory
{
    public ITrainStair createTrainChair()
    {
        System.out.println("南车公司, 生产火车椅子零件(from South)...");
        ITrainStair its = new SouthTrainStair();
        return its;
    }

    public ITrainBody createTrainBody()
    {
        System.out.println("南车公司, 生产火车车身零件(from South)...");
        ITrainBody itb = new SouthTrainBody();
        return itb;
    }
}
public class AbstractFactoryTest
{
    public static void main(String[] args)
    {
        ITrainFactory itf = new NorthFactory();
        itf.createTrainChair().make();
        itf.createTrainBody().make();

        itf = new SouthFactory();
        itf.createTrainChair().make();
        itf.createTrainBody().make();
    }
}