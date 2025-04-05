package com.example.cotuong.chesslogic;

public enum Player {
    NONE,
    RED,
    BLACK;

    public Player opponent() {
        switch (this) {
            case RED:
                return BLACK;
            case BLACK:
                return RED;
            default:
                return NONE;
        }
    }
}


