package Recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    public static boolean solveMaze(int[][] maze, int n){
        int[][] path = new int[n][n];

        // Start solving the maze from the top-left corner
        if (solveMazeUtil(maze, 0, 0, n, path)) {
            // Print the solution path
            printSolution(path, n);
            return true;
        }

        // If no solution is found, print "No path found"
        System.out.println("No path found!");
        return false;
    }
    public static boolean solveMazeUtil(int[][] maze, int x, int y, int n, int[][] path) {
        // Base case: If we've reached the destination
        if (x == n - 1 && y == n - 1) {
            path[x][y] = 1;
            return true;
        }

        if(isSafe(maze,x,y,n)){
            path[x][y] = 1;

            //Move right
            if (solveMazeUtil(maze, x + 1, y, n, path)) {
                return true;
            }

            // Move down
            if (solveMazeUtil(maze, x, y + 1, n, path)) {
                return true;
            }

            // Move left
            if (solveMazeUtil(maze, x - 1, y, n, path)) {
                return true;
            }

            // Move up
            if (solveMazeUtil(maze, x, y - 1, n, path)) {
                return true;
            }

            // If no move works, unmark the current cell and backtrack
            path[x][y] = 0;
            return false;
        }

        return false;
    }

    public static boolean isSafe(int[][] mat, int x, int y, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n && mat[x][y] == 1);
    }

    public static void printSolution(int[][] path, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int n = maze.length;

        // Solve the maze
        solveMaze(maze, n);
    }
}
