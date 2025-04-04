package com.example.cotuong.chesslogic;

public enum Player {
    None,
    Red,
    Black;

    public Player opponent() {
        switch (this) {
            case Red:
                return Black;
            case Black:
                return Red;
            default:
                return None;
        }
    }
}


