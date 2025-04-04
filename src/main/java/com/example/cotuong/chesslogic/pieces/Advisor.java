package com.example.cotuong.chesslogic.pieces;

import com.example.cotuong.chesslogic.*;

import java.util.ArrayList;
import java.util.List;

public class Advisor extends Piece {
    private final Player color;
    private final Player bottomPlayer;

    public Advisor(Player color) {
        this(color, Player.Red);
    }

    public Advisor(Player color, Player bottomPlayer) {
        this.color = color;
        this.bottomPlayer = bottomPlayer;
    }

    @Override
    public PieceType getType() {
        return PieceType.Advisor;
    }

    @Override
    public Player getColor() {
        return color;
    }

    @Override
    public Piece copy() {
        Advisor copy = new Advisor(color, bottomPlayer);
        copy.hasMoved = false;
        return copy;
    }

    private static final Direction[] dirs = {
            Direction.SouthEast, Direction.SouthWest, Direction.NorthEast, Direction.NorthWest
    };

    private Iterable<Position> movePositions(Position from, Board board) {
        List<Position> positions = new ArrayList<>();
        for (Direction dir : dirs) {
            Position to = from.add(dir);
            if (!Board.isInside(to)) {
                continue;
            }

            if (Board.isInPalace(to, color) && (board.isEmpty(to) || board.getPiece(to).getColor() != color)) {
                positions.add(to);
            }
        }
        return positions;
    }

    @Override
    public Iterable<Move> getMoves(Position from, Board board) {
        List<Move> moves = new ArrayList<>();
        for (Position to : movePositions(from, board)) {
            moves.add(new NormalMove(from, to));
        }
        return moves;
    }
}
