package com.example.cotuong.chesslogic;

public class Move {
    private Position fromPos;
    private Position toPos;

    public Move(Position fromPos, Position toPos) {
        this.fromPos = fromPos;
        this.toPos = toPos;
    }

    public Position getFromPos() {
        return fromPos;
    }

    public Position getToPos() {
        return toPos;
    }

    public void setFromPos(Position fromPos) {
        this.fromPos = fromPos;
    }

    public void setToPos(Position toPos) {
        this.toPos = toPos;
    }

    public boolean isLegal() {


    }
}
