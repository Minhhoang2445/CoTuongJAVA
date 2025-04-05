package com.example.cotuong.chesslogic;

import com.example.cotuong.chesslogic.pieces.*;
import com.example.cotuong.chesslogic.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private static Player bottomPlayer = Player.Red;
    private final Piece[][] pieces = new Piece[10][9];

    public Piece get(int row, int col) {
        return pieces[row][col];
    }

    public void set(int row, int col, Piece piece) {
        pieces[row][col] = piece;
    }

    public Piece get(Position pos) {
        return pieces[pos.getRow()][pos.getColumn()];
    }

    public void set(Position pos, Piece piece) {
        pieces[pos.getRow()][pos.getColumn()] = piece;
    }

    public static Board initial() {
        Board board = new Board();
        board.addStartPieces();
        return board;
    }

    private void addStartPieces() {
        set(0, 0, new Chariot(Player.Black));
        set(0, 1, new Horse(Player.Black));
        set(0, 2, new Elephant(Player.Black));
        set(0, 3, new Advisor(Player.Black));
        set(0, 4, new General(Player.Black));
        set(0, 5, new Advisor(Player.Black));
        set(0, 6, new Elephant(Player.Black));
        set(0, 7, new Horse(Player.Black));
        set(0, 8, new Chariot(Player.Black));
        set(2, 1, new Cannon(Player.Black));
        set(2, 7, new Cannon(Player.Black));
        set(3, 0, new Soldier(Player.Black));
        set(3, 2, new Soldier(Player.Black));
        set(3, 4, new Soldier(Player.Black));
        set(3, 6, new Soldier(Player.Black));
        set(3, 8, new Soldier(Player.Black));

        set(9, 0, new Chariot(Player.Red));
        set(9, 1, new Horse(Player.Red));
        set(9, 2, new Elephant(Player.Red));
        set(9, 3, new Advisor(Player.Red));
        set(9, 4, new General(Player.Red));
        set(9, 5, new Advisor(Player.Red));
        set(9, 6, new Elephant(Player.Red));
        set(9, 7, new Horse(Player.Red));
        set(9, 8, new Chariot(Player.Red));
        set(7, 1, new Cannon(Player.Red));
        set(7, 7, new Cannon(Player.Red));
        set(6, 0, new Soldier(Player.Red));
        set(6, 2, new Soldier(Player.Red));
        set(6, 4, new Soldier(Player.Red));
        set(6, 6, new Soldier(Player.Red));
        set(6, 8, new Soldier(Player.Red));
    }

    public static Board initialForOnline(Player color) {
        bottomPlayer = color;
        Board board = new Board();
        if (color == Player.Red) {
            board.addStartPieces();
        } else {
            board.addStartPiecesForBlackPlayer();
        }
        return board;
    }

    private void addStartPiecesForBlackPlayer() {
        set(0, 0, new Chariot(Player.Red, Player.Black));
        set(0, 1, new Horse(Player.Red, Player.Black));
        set(0, 2, new Elephant(Player.Red, Player.Black));
        set(0, 3, new Advisor(Player.Red, Player.Black));
        set(0, 4, new General(Player.Red, Player.Black));
        set(0, 5, new Advisor(Player.Red, Player.Black));
        set(0, 6, new Elephant(Player.Red, Player.Black));
        set(0, 7, new Horse(Player.Red, Player.Black));
        set(0, 8, new Chariot(Player.Red, Player.Black));
        set(2, 1, new Cannon(Player.Red, Player.Black));
        set(2, 7, new Cannon(Player.Red, Player.Black));
        set(3, 0, new Soldier(Player.Red, Player.Black));
        set(3, 2, new Soldier(Player.Red, Player.Black));
        set(3, 4, new Soldier(Player.Red, Player.Black));
        set(3, 6, new Soldier(Player.Red, Player.Black));
        set(3, 8, new Soldier(Player.Red, Player.Black));

        set(9, 0, new Chariot(Player.Black, Player.Black));
        set(9, 1, new Horse(Player.Black, Player.Black));
        set(9, 2, new Elephant(Player.Black, Player.Black));
        set(9, 3, new Advisor(Player.Black, Player.Black));
        set(9, 4, new General(Player.Black, Player.Black));
        set(9, 5, new Advisor(Player.Black, Player.Black));
        set(9, 6, new Elephant(Player.Black, Player.Black));
        set(9, 7, new Horse(Player.Black, Player.Black));
        set(9, 8, new Chariot(Player.Black, Player.Black));
        set(7, 1, new Cannon(Player.Black, Player.Black));
        set(7, 7, new Cannon(Player.Black, Player.Black));
        set(6, 0, new Soldier(Player.Black, Player.Black));
        set(6, 2, new Soldier(Player.Black, Player.Black));
        set(6, 4, new Soldier(Player.Black, Player.Black));
        set(6, 6, new Soldier(Player.Black, Player.Black));
        set(6, 8, new Soldier(Player.Black, Player.Black));
    }

    public static boolean isInside(Position pos) {
        return pos.getRow() >= 0 && pos.getColumn() >= 0 && pos.getRow() < 10 && pos.getColumn() < 9;
    }

    public boolean isEmpty(Position pos) {
        return get(pos) == null;
    }

    public static boolean isInPalace(Position pos, Player color) {
        if (bottomPlayer == Player.Red) {
            if (color == Player.Red) {
                return pos.getRow() >= 7 && pos.getRow() <= 9 && pos.getColumn() >= 3 && pos.getColumn() <= 5;
            } else if (color == Player.Black) {
                return pos.getRow() >= 0 && pos.getRow() <= 2 && pos.getColumn() >= 3 && pos.getColumn() <= 5;
            }
        } else {
            if (color == Player.Red) {
                return pos.getRow() >= 0 && pos.getRow() <= 2 && pos.getColumn() >= 3 && pos.getColumn() <= 5;
            } else if (color == Player.Black) {
                return pos.getRow() >= 7 && pos.getRow() <= 9 && pos.getColumn() >= 3 && pos.getColumn() <= 5;
            }
        }
        return false;
    }

    public List<Position> piecePositions() {
        List<Position> result = new ArrayList<>();
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 9; col++) {
                Position pos = new Position(row, col);
                if (!isEmpty(pos)) {
                    result.add(pos);
                }
            }
        }
        return result;
    }

    public List<Position> piecePositionFor(Player player) {
        return piecePositions().stream()
                .filter(pos -> get(pos).getColor() == player)
                .collect(Collectors.toList());
    }

    public boolean isInCheck(Player player) {
        return piecePositionFor(player.opponent()).stream().anyMatch(pos -> {
            Piece piece = get(pos);
            return piece.canCaptureOpponentGeneral(pos, this);
        });
    }

    public Board copy() {
        Board copy = new Board();
        for (Position pos : piecePositions()) {
            copy.set(pos, get(pos).copy());
        }
        return copy;
    }
}
