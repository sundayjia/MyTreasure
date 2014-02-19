package org.edie.designpattern.builder;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-2-26
 * Time: 下午5:58
 * To change this template use File | Settings | File Templates.
 */
abstract class Train
{
    private String _body;
    private String _head;
    private String _tail;

    public String getBody()
    {
        return _body;
    }

    public String getHead()
    {
        return _head;
    }

    public String getTail()
    {
        return _tail;
    }

    public void setBody(String body)
    {
        _body = body;
    }

    public void setHead(String head)
    {
        _head = head;
    }

    public void setTail(String tail)
    {
        _tail = tail;
    }
}
class NorthTrain extends Train
{
    public NorthTrain()
    {
        System.out.println("北方火车");
    }
}

// Builder
interface ITrainBuilder
{
    void buildBody();
    void buildHead();
    void buildTail();
    Train buildTrain();
}
//Concrete Builder
class TrainBuilder implements ITrainBuilder
{
    Train train;
    public TrainBuilder()
    {
        train = new NorthTrain();
    }
    public void buildBody()
    {
        train.setBody("制造车身...");
    }

    public void buildHead()
    {
        train.setHead("制造车头...");
    }

    public void buildTail()
    {
        train.setTail("制造车尾...");
    }

    public Train buildTrain()
    {
        return train;
    }
}
// Director
class TrainDirector
{
    public Train constructTrain(ITrainBuilder itb)
    {
        itb.buildBody();
        itb.buildHead();
        itb.buildTail();
        return itb.buildTrain();
    }
}
public class BuilderTest
{
    public static void main(String[] args)
    {
        TrainDirector td = new TrainDirector();
        Train train = td.constructTrain(new TrainBuilder());
        System.out.println(train.getBody());
        System.out.println(train.getHead());
        System.out.println(train.getTail());
    }
}