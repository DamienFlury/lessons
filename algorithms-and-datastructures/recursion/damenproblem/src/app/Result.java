package app;

public class Result {
    private final boolean done;
    private final boolean[][] board;

    public Result(boolean[][] board, boolean done) {
        this.board = board;
        this.done = done;
    }

    public boolean[][] getBoard() {
        return board;
    }

    public boolean isDone() {
        return done;
    }

    
}