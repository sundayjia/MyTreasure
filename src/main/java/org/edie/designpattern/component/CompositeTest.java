package org.edie.designpattern.component;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-9
 * Time: 上午11:33
 * To change this template use File | Settings | File Templates.
 */
public class CompositeTest {

    public static void main(String[] args) {

        Piece child = new Sentence("abcde");
        Piece child2 = new Sentence("123");
        Piece child3 = new Sentence("456789");
        Piece para = new Paragraph();
        Piece para2 = new Paragraph();
        para.add(child);
        para.add(child2);
        para2.add(child3);
        para2.add(para);

        int count = para2.count();
        System.out.println("count of para2 = " + count);
    }

}