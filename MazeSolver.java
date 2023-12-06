/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc229.csc229_final_hw;
import java.util.*;
/**
 *
 * @author tonypittella
 */
public class MazeSolver {
    // Define constants for maze symbols
    private static final char START = 'S';
    private static final char GOAL = 'G';
    private static final char WALL = 'W';
    private static final char VISITED = 'V';

    public static void main(String[] args) {
        // Define the maze
        char[][] maze = {
                {'S', ' ', ' ', ' ', 'W'},
                {'W', 'W', ' ', 'W', 'W'},
                {' ', ' ', ' ', ' ', ' '},
                {'W', 'W', 'W', 'W', 'W'},
                {'G', ' ', ' ', ' ', ' '}
        };

        // Create a stack to store the path
        Stack<int[]> stack = new Stack<>();
        
        // Find the starting point and push it onto the stack
        int[] start = findStart(maze);
        if (start != null) {
            stack.push(start);

            // Perform depth-first search until the stack is empty
            while (!stack.isEmpty()) {
                int[] current = stack.peek();
                int row = current[0];
                int col = current[1];

                // Check if the goal is reached
                if (maze[row][col] == GOAL) {
                    System.out.println("Maze solved!");
                    printSolution(stack);
                    return;
                }

                // Check if the current cell is not visited
                if (maze[row][col] != VISITED) {
                    maze[row][col] = VISITED;

                    // Explore neighbors (up, down, left, right)
                    int[][] neighbors = {
                            {row - 1, col},  // Up
                            {row + 1, col},  // Down
                            {row, col - 1},  // Left
                            {row, col + 1}   // Right
                    };

                    // Try to push a valid neighbor onto the stack
                    for (int[] neighbor : neighbors) {
                        int newRow = neighbor[0];
                        int newCol = neighbor[1];

                        if (isValid(newRow, newCol, maze.length, maze[0].length) &&
                                maze[newRow][newCol] != WALL && maze[newRow][newCol] != VISITED) {
                            stack.push(new int[]{newRow, newCol});
                            break;
                        }
                    }
                } else {
                    // Backtrack if the cell is already visited
                    stack.pop();
                }
            }

            // If the stack is empty and the goal is not reached, no solution is found
            System.out.println("No solution found.");
        } else {
            System.out.println("Starting point not found.");
        }
    }

    // Helper method to find the starting point in the maze
    private static int[] findStart(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == START) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Helper method to check if a cell is within the maze boundaries
    private static boolean isValid(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

    // Helper method to print the solution path
    private static void printSolution(Stack<int[]> solution) {
        System.out.println("Solution path:");
        for (int[] point : solution) {
            System.out.println("(" + point[0] + ", " + point[1] + ")");
        }
    }

}
