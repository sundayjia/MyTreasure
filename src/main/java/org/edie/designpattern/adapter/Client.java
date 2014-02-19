package org.edie.designpattern.adapter;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-2-28
 * Time: 下午5:34
 * 客户端
 */
public class Client {
    public static void main(String rags[]) {
        new Client().test();
    }

    public void test() {
        Target target = new Adapter();
        int v1 = target.get110v();
        int v2 = target.get220v();
    }
}