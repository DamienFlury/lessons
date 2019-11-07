package app;

public class App {
    public static void main(String[] args) throws Exception {
        var board = new boolean[8][];
        for(var i = 0; i < board.length; i++) {
            board[i] = new boolean[8];
        }
        // board[0][0] = true;
        System.out.println(isValid(board, 1, 0));
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
            if(i == x && i == y) {
                continue;
            }
            if(board[i][y]) {
                return false;
            }
            if(board[x][i]) {
                return false;
            }
            printBoard(board);
            System.out.println("[" + x + ", " + y + "]");
            if(x + i < 8 && y + i < 8 && board[x + i][y + i]) {
                return false;
            }
            if(x - i >= 0 && y - i >= 0 && board[x - i][y - i]) {
                return false;
            }
            if(x + i < 8 && y - i >= 0 && board[x + i][y - i]) {
                return false;
            }
            if(x - i >= 0 && y + i < 8 && board[x - i][y + i]) {
                return false;
            }
        }
        return true;

        // for(var i = x; i >= 0; i--) {
        //     for(var j 0)
        // }
    }

    public static void damenproblem(boolean[][] board, int current) {
        if(current == 5) {
            return;
        }
        for(var i = 0; i < 8; i++) {
            if(isValid(board, current, i)) {
                System.out.println(current + ", " + i);
                board[current][i] = true;
                damenproblem(board, current + 1);
            }
            // board[current][i] = false;
        }
    }
}