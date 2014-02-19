package org.edie.designpattern.component;

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


