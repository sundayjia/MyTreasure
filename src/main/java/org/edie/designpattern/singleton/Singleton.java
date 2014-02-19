package org.edie.designpattern.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-2-28
 * Time: 下午5:08
 * To change this template use File | Settings | File Templates.
 */
class SafeSingleton
{
    public static class Holder
    {
        private static SafeSingleton instance = new SafeSingleton();
    }

    private SafeSingleton()
    {
        System.out.println("SafeSingleton initialized here....");
    }

    public static SafeSingleton getInstance()
    {
        return Holder.instance;
    }

}
public class Singleton
{
    private static Singleton _instance;

    private Singleton()
    {
    }

    public static Singleton getInstance()
    {
        synchronized(Singleton.class)
        {
            if (_instance == null)
            {
                _instance = new Singleton();
            }
            return _instance;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());

        System.out.println(SafeSingleton.getInstance());
        System.out.println(SafeSingleton.getInstance());
    }
}