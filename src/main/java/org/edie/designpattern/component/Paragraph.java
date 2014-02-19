package org.edie.designpattern.component;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-9
 * Time: 上午11:36
 * To change this template use File | Settings | File Templates.
 */
public class Paragraph extends Piece {
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


