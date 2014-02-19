package org.edie.designpattern.Composite;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-17
 * Time: 上午11:37
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.List;

//字符片段
abstract class Piece {
    // 统计字数
    public abstract int count();

    public abstract void add(Piece p);
    public abstract void remove(Piece p);

    protected List<Piece> pieces;

    public List<Piece> getPieces() {
        return pieces;
    }

}

class Sentence extends Piece {
    String word;
    public Sentence(String word) {
        this.word = word;
        pieces = null;
    }

    public int count() {
        return word == null ? 0 : word.length();
    }

    public void add(Piece p) {

    }

    public void remove(Piece p) {

    }
}

class Paragraph extends Piece {
    public Paragraph() {
        pieces = new ArrayList<Piece>();
    }
    public int count() {
        int count = 0;
        for (Piece p: pieces) {
            count += p.count();
        }
        return count;
    }

    public void add(Piece p) {
        pieces.add(p);
    }

    public void remove(Piece p) {
        pieces.remove(p);
    }
}

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