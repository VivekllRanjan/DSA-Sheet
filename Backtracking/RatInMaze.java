package Backtracking;

import java.util.ArrayList;

public class RatInMaze {
    static int N; // Size
    static ArrayList<String> ans = new ArrayList<>();
    public static void main(String[] args) {
        RatInMaze rat = new RatInMaze();
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        N = maze.length;
        int[][] sol = new int[N][N];
        if(maze[0][0] == 1) rat.solveMazeUtil(maze, 0,0,sol,ans,"");
        System.out.println(ans);

    }

    public void solveMazeUtil(int[][] maze, int i, int j, int[][] sol, ArrayList<String> ans, String move  ) {
        if(i==N-1 && j==N-1 && maze[i][j]==1){
            sol[i][j] =1;
            ans.add(move);
            return;
        }
        if(i+1<N && sol[i+1][j] !=1 && maze[i+1][j]==1) {
            sol[i][j] = 1;
            solveMazeUtil(maze, i+1, j, sol,ans,move+"D");
            sol[i][j] = 0;
        }

        if(j-1>=0 && sol[i][j-1] !=1 && maze[i][j-1]==1) {
            sol[i][j] = 1;
            solveMazeUtil(maze, i, j-1, sol,ans,move+"L");
            sol[i][j] = 0;
        }

        if(j+1<N && sol[i][j+1] !=1 && maze[i][j+1]==1) {
            sol[i][j] = 1;
            solveMazeUtil(maze, i, j+1, sol,ans,move+"R");
            sol[i][j] = 0;
        }

        if(i-1>=0 && sol[i-1][j] !=1 && maze[i-1][j]==1) {
            sol[i][j] = 1;
            solveMazeUtil(maze, i-1, j, sol,ans,move+"U");
            sol[i][j] = 0;
        }


    }

}
