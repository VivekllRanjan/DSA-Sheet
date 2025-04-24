package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensI {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0; i<n;i++) Arrays.fill(board[i], '.');

        nQueens(0, board, ans, n);
        return ans;
    }

    public static void nQueens(int row, char[][] board, List<List<String>> ans, int n) {
        if(row == n){
            ans.add(construct(board));
            return;
        }

        for(int col =0; col < n; col++){
            if(isSafe(row,col,board,n)){
                board[row][col] = 'Q'; //place Q
                nQueens(row+1,board,ans,n); //go to next row recursively to build the ans
                board[row][col] = '.'; //backtrack
            }
        }
    }
    public static boolean isSafe(int row, int col, char[][] board, int n){
        for(int i =0; i < row; i++) {
            if(board[i][col] == 'Q') return false;
        }

        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] =='Q') return false;
        }

        for(int i = row-1, j=col+1; i >=0 && j<n; i--, j++) {
            if(board[i][j] =='Q') return false;
        }
        return true;
    }

    public static List<String> construct(char[][] board){
        List<String> config = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            config.add(new String(board[i]));
        }
        return config;
    }

    public static void main(String[] args) {
        List<List<String>> results = solveNQueens(4);
        for (List<String> board : results) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println(); // separator between solutions
        }
    }
}
