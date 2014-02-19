package org.edie.designpattern.proxy;

import java.lang.reflect.Method;
import  java.lang.reflect.Proxy;
import  java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-4-17
 * Time: 下午5:12
 * To change this template use File | Settings | File Templates.
 */

interface ISubject {
    abstract public void request();
}

class RealSubject1 implements ISubject {

    public RealSubject1() {
    }

    public void request() {
        System.out.println(" From real subject. ");
    }
}

class DynamicSubject implements InvocationHandler {
    private Object sub;

    public DynamicSubject() {
    }

    public DynamicSubject(Object obj) {
        sub = obj;
    }
    public  Object invoke(Object proxy, Method method, Object[] args)  throws  Throwable  {
        System.out.println( " before calling  "   +  method);
        method.invoke(sub,args);
        System.out.println( " after calling  "   +  method);
        return   null ;
    }
}

public   class  DynamicProxyTest  {

    static   public   void  main(String[] args)  throws  Throwable  {

        RealSubject1 rs  =   new  RealSubject1();  // 在这里指定被代理类
        InvocationHandler ds  =   new  DynamicSubject(rs);
        Class cls  =  rs.getClass();
        // 以下是一次性生成代理
        ISubject subject  =  (ISubject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(),ds );
        subject.request();

    }
}

