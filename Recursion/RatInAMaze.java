package Recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    public static List<String> solveMaze(int[][] maze, int n){
        String path = "";
        List<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        if(maze[0][0] == 1){
            solveMazeUtil(maze,0,0,n,path,visited,ans);
        }

        return ans;
    }

    public static void solveMazeUtil(int[][] maze, int x, int y, int n, String path, boolean[][] visited , List<String> ans) {
        if(x == n-1 && y == n-1) {
            ans.add(path);
            return;
        }

        visited[x][y] = true;

        //Down
        if(isSafe(maze,visited,x+1,y,n)) solveMazeUtil(maze,x+1,y,n,path+'D',visited,ans);

        //Left
        if(isSafe(maze,visited,x,y-1,n)) solveMazeUtil(maze,x,y-1,n,path+'L',visited,ans);

        //Right
        if(isSafe(maze,visited,x,y+1,n)) solveMazeUtil(maze,x,y+1,n,path+'R',visited,ans);

        //Up
        if(isSafe(maze,visited,x-1,y,n)) solveMazeUtil(maze,x-1,y,n,path+'U',visited,ans);

        visited[x][y] = false;

    }

    public static boolean isSafe(int[][] maze, boolean[][] visited, int x, int y, int n) {
        return (x >=0 && x<n && y>=0 && y<n && maze[x][y] == 1 && !visited[x][y]);
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 1, 0},
                {1, 1, 1, 1}
        };
        int n = maze.length;

        // Solve the maze
        System.out.println(solveMaze(maze, n));
    }
}
