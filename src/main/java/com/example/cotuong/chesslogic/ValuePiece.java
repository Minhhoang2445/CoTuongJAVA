package com.example.cotuong.chesslogic;

public class ValuePiece {
    // quân xanh
    private final int[][] bSoldier= new int[][]
    {
        {0,  0,  0,  0,  0,  0,  0,  0,  0 },
        {0,  0,  0,  0,  0,  0,  0,  0,  0 },
        {0,  0,  0,  0,  0,  0,  0,  0,  0},
        {0,  0, -2,  0,  4,  0, -2,  0,  0},
        {2,  0,  8,  0,  8,  0,  8,  0,  2 },
        {6,  12, 18, 18, 20, 18, 18, 12, 6 },
        {10, 20, 30, 34, 40, 34, 30, 20, 10 },
        {14, 26, 42, 60, 80, 60, 42, 26, 14 },
        {18, 36, 56, 80, 120, 80, 56, 36, 18 },
        {0,  3,  6,  9,  12,  9,  6,  3,  0}
    };
    private final int[][] bHorse = new int[][]
    {
        {0, -4, 0, 0, 0, 0, 0, -4, 0 },
        {0, 2, 4, 4, -2, 4, 4, 2, 0 },
        {4, 2, 8, 8, 4, 8, 8, 2, 4 },
        {2, 6, 8, 6, 10, 6, 8, 6, 2 },
        {4, 12, 16, 14, 12, 14, 16, 12, 4 },
        {6, 16, 14, 18, 16, 18, 14, 16, 6 },
        {8, 24, 18, 24, 20, 24, 18, 24, 8 },
        {12, 14, 16, 20, 18, 20, 16, 14, 12 },
        {4, 10, 28, 16, 8, 16, 28, 10, 4 },
        {4, 8, 16, 12, 4, 12, 16, 8, 4 }
    };
    private final int[][] bChariot = new int[][]
    {
        {-2, 10, 6, 14, 12, 14, 6, 10, -2 },
        {8, 4, 8, 16, 8, 16, 8, 4, 8 },
        {4, 8, 6, 14, 12, 14, 6, 8, 4 },
        {6, 10, 8, 14, 14, 14, 8, 10, 6 },
        {12, 16, 14, 20, 20, 20, 14, 16, 12 },
        {12, 14, 12, 18, 18, 18, 12, 14, 12 },
        {12, 18, 16, 22, 22, 22, 16, 18, 12 },
        {12, 12, 12, 18, 18, 18, 12, 12, 12 },
        {16, 20, 18, 24, 26, 24, 18, 20, 16 },
        {14, 14, 12, 18, 16, 18, 12, 14, 14 }
    };
    private final int[][] bCannon = new int[][]
    {
        {0, 0, 2, 6, 6, 6, 2, 0, 0 },
        { 0, 2, 4, 6, 6, 6, 4, 2, 0 },
        {4, 0, 8, 6, 10, 6, 8, 0, 4 },
        {0, 0, 0, 2, 4, 2, 0, 0, 0 },
        {-2, 0, 4, 2, 6, 2, 4, 0, -2 },
        {0, 0, 0, 2, 8, 2, 0, 0, 0 },
        {0, 0, -2, 4, 10, 4, -2, 0, 0 },
        {2, 2, 0, -10, -8, -10, 0, 2, 2 },
        {2, 2, 0, -4, -14, -4, 0, 2, 2 },
        {6, 4, 0, -10, -12, -10, 0, 4, 6 }
    };
    private final int[][] bElephant = new int[][]
    {
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 2, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };
    private final int[][] bAdvisor = new int[][]
    {
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 2, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };
    private final int[][] bGeneral = new int[][]
    {
        {0, 0, 0, 0, 2, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };

    // quân đỏ
    private final int[][] rSoldier = new int[][]
    {
        {0,  3,  6,  9,  12,  9,  6,  3,  0},
        {18, 36, 56, 80, 120, 80, 56, 36, 18 },
        {14, 26, 42, 60, 80, 60, 42, 26, 14 },
        {10, 20, 30, 34, 40, 34, 30, 20, 10 },
        {6,  12, 18, 18, 20, 18, 18, 12, 6 },
        {2,  0,  8,  0,  8,  0,  8,  0,  2 },
        {0,  0, -2,  0,  4,  0, -2,  0,  0},
        {0,  0,  0,  0,  0,  0,  0,  0,  0 },
        {0,  0,  0,  0,  0,  0,  0,  0,  0 },
        {0,  0,  0,  0,  0,  0,  0,  0,  0}
    };
    private final int[][] rChariot = new int[][]
    {
        {14, 14, 12, 18, 16, 18, 12, 14, 14 },
        {16, 20, 18, 24, 26, 24, 18, 20, 16 },
        {12, 12, 12, 18, 18, 18, 12, 12, 12 },
        {12, 18, 16, 22, 22, 22, 16, 18, 12 },
        {12, 14, 12, 18, 18, 18, 12, 14, 12 },
        {12, 16, 14, 20, 20, 20, 14, 16, 12 },
        {6, 10, 8, 14, 14, 14, 8, 10, 6 },
        {4, 8, 6, 14, 12, 14, 6, 8, 4 },
        {8, 4, 8, 16, 8, 16, 8, 4, 8 },
        {-2, 10, 6, 14, 12, 14, 6, 10, -2 }
    };
    private final int[][] rCannon = new int[][]
    {
        {6, 4, 0, -10, -12, -10, 0, 4, 6 },
        {2, 2, 0, -4, -14, -4, 0, 2, 2 },
        {2, 2, 0, -10, -8, -10, 0, 2, 2 },
        {0, 0, -2, 4, 10, 4, -2, 0, 0 },
        {0, 0, 0, 2, 8, 2, 0, 0, 0 },
        {-2, 0, 4, 2, 6, 2, 4, 0, -2 },
        {0, 0, 0, 2, 4, 2, 0, 0, 0 },
        {4, 0, 8, 6, 10, 6, 8, 0, 4 },
        {0, 2, 4, 6, 6, 6, 4, 2, 0 },
        {0, 0, 2, 6, 6, 6, 2, 0, 0 }
    };
    private final int[][] rHorse = new int[][]
    {
        {4, 8, 16, 12, 4, 12, 16, 8, 4 },
        {4, 10, 28, 16, 8, 16, 28, 10, 4 },
        {12, 14, 16, 20, 18, 20, 16, 14, 12 },
        {8, 24, 18, 24, 20, 24, 18, 24, 8 },
        {6, 16, 14, 18, 16, 18, 14, 16, 6 },
        {4, 12, 16, 14, 12, 14, 16, 12, 4 },
        {2, 6, 8, 6, 10, 6, 8, 6, 2 },
        {4, 2, 8, 8, 4, 8, 8, 2, 4 },
        {0, 2, 4, 4, -2, 4, 4, 2, 0 },
        {0, -4, 0, 0, 0, 0, 0, -4, 0 }
    };
    private final int[][] rElephant = new int[][]
    {
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 2, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };
    private final int[][] rAdvisor = new int[][]
    {
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 2, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };
    private final int[][] rGeneral = new int[][]
    {
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 0, 0, 0, 0 },
        {0, 0, 0, 0, 2, 0, 0, 0, 0 }
    };

    //Lấy giá trị bàn cờ
    public int getValueBoard(Board board){
        int totalvalue = 0;
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board.get(i,j) != null)
                {
                    switch (board.get(i,j).getType())
                    {
                        case PieceType.CANNON:
                            totalvalue += (board.get(i,j).getColor() == Player.RED) ? -(45 + rCannon[i][j]) : (45 + bCannon[i][j]);
                            break;
                        case PieceType.ADVISOR:
                            totalvalue += (board.get(i,j).getColor() == Player.RED) ? -(20 + rAdvisor[i][j]) : (20 + bAdvisor[i][j]);
                            break;
                        case PieceType.HORSE:
                            totalvalue += (board.get(i,j).getColor() == Player.RED) ? -(40 + rHorse[i][j]) : (40 + bHorse[i][j]);
                            break;
                        case PieceType.ELEPHANT:
                            totalvalue += (board.get(i,j).getColor() == Player.RED) ? -(20 + rElephant[i][j]) : (20 + bElephant[i][j]);
                            break;
                        case PieceType.CHARIOT:
                            totalvalue += (board.get(i,j).getColor() == Player.RED) ? -(90 + rChariot[i][j]) : (90 + bChariot[i][j]);
                            break;
                        case PieceType.SOLDIER:
                            totalvalue += (board.get(i,j).getColor() == Player.RED) ? -(15 + rSoldier[i][j]) : (15 + bSoldier[i][j]);
                            break;
                        case PieceType.GENERAL:
                            totalvalue += (board.get(i,j).getColor() == Player.RED) ? -(900 + rGeneral[i][j]) : (900 + bGeneral[i][j]);
                            break;
                    }
                }
            }
        }
        return totalvalue;
    }
}
