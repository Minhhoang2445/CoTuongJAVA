package com.example.cotuong.chesslogic.pieces;

import com.example.cotuong.chesslogic.*;

import java.util.List;

public abstract class Piece {
    public Player bottomPlayer;
    public abstract PieceType getType();
    public abstract Player getColor();
    public boolean hasMoved = false;
    public abstract Piece copy();

    public abstract List<Move> getMoves(Position from, Board board);

    public boolean canCaptureOpponentGeneral(Position from, Board board) {
        return getMoves(from, board).stream().anyMatch(move -> {
            Piece piece = board.get(move.getToPos());
            return piece != null && piece.getType() == PieceType.General;
        });
    }

    @Override
    public String toString() {
        switch (getType()) {
            case General: return (getColor() == Player.Black) ? "bG" : "rG";
            case Advisor: return (getColor() == Player.Black) ? "bA" : "rA";
            case Chariot: return (getColor() == Player.Black) ? "bCh" : "rCh";
            case Cannon: return (getColor() == Player.Black) ? "bC" : "rC";
            case Elephant: return (getColor() == Player.Black) ? "bE" : "rE";
            case Horse: return (getColor() == Player.Black) ? "bH" : "rH";
            default: return (getColor() == Player.Black) ? "bS" : "rS";
        }
    }
}
