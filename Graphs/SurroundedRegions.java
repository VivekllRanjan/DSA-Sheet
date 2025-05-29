package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    private int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                capture(board, r, 0);
            }
            if (board[r][COLS - 1] == 'O') {
                capture(board, r, COLS - 1);
            }
        }
        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                capture(board, 0, c);
            }
            if (board[ROWS - 1][c] == 'O') {
                capture(board, ROWS - 1, c);
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= ROWS ||
                c >= COLS || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        capture(board, r + 1, c);
        capture(board, r - 1, c);
        capture(board, r, c + 1);
        capture(board, r, c - 1);
    }

    private int[][] directions = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public void solve2(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        capture(board);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (r == 0 || r == ROWS - 1 ||
                        c == 0 || c == COLS - 1 &&
                        board[r][c] == 'O') {
                    q.offer(new int[]{r, c});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            if (board[r][c] == 'O') {
                board[r][c] = 'T';
                for (int[] direction : directions) {
                    int nr = r + direction[0], nc = c + direction[1];
                    if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS) {
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
