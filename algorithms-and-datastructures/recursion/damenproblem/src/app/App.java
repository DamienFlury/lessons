package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        var board = new boolean[8][];
        for(var i = 0; i < board.length; i++) {
            board[i] = new boolean[8];
        }
        // board[0][0] = true;
        // System.out.println(isValid(board, 1, 0));
        damenproblem(board, 0);
        printBoard(board);
    }

    // x . . . . . . .
    // ? . . . . . . .
    //
    //

    private static void printBoard(boolean[][] board) {
        for(var i = 0; i < 8; i++) {
            for(var j = 0; j < 8; j++){
                System.out.print(board[i][j] ? "Q" : "*");
            }
            System.out.println();
        }
    }


    private static boolean isValid(boolean[][] board, int x, int y) {
        for(var i = 0; i < 8; i++) {
            // if(i != x && board[y][i]) {
            //     return false;
            // }
            if(i != y && board[i][x]) {
                return false;
            }
            // printBoard(board);
            // System.out.println("[" + x + ", " + y + "]");
            if(x + i < 8 && y + i < 8 && board[y + i][x + i]) {
                return false;
            }
            if(x - i >= 0 && y - i >= 0 && board[y - i][x - i]) {
                return false;
            }
            if(x + i < 8 && y - i >= 0 && board[y - i][x + i]) {
                return false;
            }
            if(x - i >= 0 && y + i < 8 && board[y + i][x - i]) {
                return false;
            }
        }
        return true;

        // for(var i = x; i >= 0; i--) {
        //     for(var j 0)
        // }
    }

    public static boolean[][] damenproblem(boolean[][] board, int current) {
        if(current == 8) {
            return board;
        }
        for(var i = 0; i < 8; i++) {
            if(isValid(board, i, current)) {
                var newBoard = clone(board);
                newBoard[current][i] = true;
                return damenproblem(newBoard, current + 1);
            }
        }
        return board;
    }

    public static boolean[][] clone(boolean[][] array) {
        var current = new boolean[8][];
        for(var i = 0; i < 8; i++) {
            current[i] = new boolean[8];
            for(var j = 0; j < 8; j++) {
                current[i][j] = array[i][j];
            }
        }
        return current;
    }
}