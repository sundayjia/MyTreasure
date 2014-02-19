package org.edie.designpattern.component;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-9
 * Time: 上午11:35
 * To change this template use File | Settings | File Templates.
 */
public class Sentence extends Piece {
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

