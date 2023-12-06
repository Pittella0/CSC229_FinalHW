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
public class LongestIncreasingSubsequence {
    public static int longestIncreasingSubsequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;

        // lisLengths array stores the length of LIS ending at each index
        int[] lisLengths = new int[n];

        // Array-based stack to store indices of elements
        Stack<Integer> stack = new Stack<>();

        // Initialize the stack with the first index
        stack.push(0);

        for (int i = 1; i < n; i++) {
            // Remove elements from the stack if they are greater than or equal to the current element
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            // If the stack is not empty, update the LIS length using the top element of the stack
            if (!stack.isEmpty()) {
                lisLengths[i] = lisLengths[stack.peek()] + 1;
            } else {
                // If the stack is empty, the current element is the start of a new LIS
                lisLengths[i] = 1;
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        // Find the maximum value in lisLengths array
        int maxLength = 0;
        for (int length : lisLengths) {
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int result = longestIncreasingSubsequence(arr);
        System.out.println("Length of Longest Increasing Subsequence: " + result);
    }

}
