package app;


public class App {
    public static void main(String[] args) {
        var board = new boolean[8][];
        for(var i = 0; i < board.length; i++) {
            board[i] = new boolean[8];
        }
        // board[0][0] = true;
        // System.out.println(isValid(board, 1, 0));
        var result = damenproblem(board, 0);
        printBoard(result.getBoard());
    }

    // x . . . . . . .
    // ? . . . . . . .
    //
    //

    private static void printBoard(boolean[][] board) {
        for(var i = 0; i < board.length; i++) {
            for(var j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] ? "Q " : "* ");
            }
            System.out.println();
        }
    }


    private static boolean isValid(boolean[][] board, int x, int y) {
        for(var i = 0; i < board.length; i++) {
            if(i != y && board[i][x]) {
                return false;
            }
            if(x + i < board.length && y + i < board.length && board[y + i][x + i]) {
                return false;
            }
            if(x - i >= 0 && y - i >= 0 && board[y - i][x - i]) {
                return false;
            }
            if(x + i < board.length && y - i >= 0 && board[y - i][x + i]) {
                return false;
            }
            if(x - i >= 0 && y + i < board.length && board[y + i][x - i]) {
                return false;
            }
        }
        return true;
    }

    public static Result damenproblem(boolean[][] board, int current) {
        if(current == board.length) {
            return new Result(board, true);
        }
        for(var i = 0; i < board.length; i++) {
            if(isValid(board, i, current)) {
                var newBoard = clone(board);
                newBoard[current][i] = true;
                var result = damenproblem(newBoard, current + 1);
                if(result.isDone()) {
                    return result;
                }
            }
        }
        return new Result(board, false);
    }

    public static boolean[][] clone(boolean[][] array) {
        var current = new boolean[array.length][];
        for(var i = 0; i < array.length; i++) {
            current[i] = new boolean[array[i].length];
            for(var j = 0; j < array[i].length; j++) {
                current[i][j] = array[i][j];
            }
        }
        return current;
    }
}