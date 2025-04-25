package Recursion;

public class Sudokusolver {

    public static void solveSudoku(char[][] board) {
        solve(board);
    }
    public static boolean solve(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                if(board[i][j] != '.') continue; //Skip filled cells

                //Try 1st valid digit from 1-9 in the empty cell
                for(char num = '1'; num <= '9'; num++) {
                    if(isValid(board, i, j, num)) {
                        board[i][j] = num; //Chose to enter number
                        if(solve(board)) return true; //Recursively build sudoku
                        board[i][j] = '.'; //Backtrack
                    }
                }
                return false; //No valid number backtrack needed
            }
        }
        return true; //All cells filled
    }

    private static boolean isValid(char[][] board, int row, int col, char num) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
        }

        // Check 3x3 subgrid
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRowStart + i][boxColStart + j] == num) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(board);

        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
