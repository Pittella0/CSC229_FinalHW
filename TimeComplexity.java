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
public class TimeComplexity {
    public static String[] createTest(int size){
   
    // Create test size (1,000,000) using push, pop, peek

    Random rnd = new Random();
    String[] operators = {"push", "pop", "peek"};
    String[] testData = new String[size];
    /*Here the for loop pushes a random operator to testData 
      size() amount of times. Here we're doing 1,000,000 */
        for (int i = 0; i < size; i++) {
            testData[i] = operators[rnd.nextInt(operators.length)];
        }
        return testData;
    }
    
    public static long testStackSpeed(Stack<String> stack, String[] operators){
    // This is the method to actually test and time the two Stacks
    
    long start = System.currentTimeMillis();
        for (String ops : operators) {
            switch (ops){
                case "push":
                    stack.push("test");
                    break;
                case "pop":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "peek":
                    if (!stack.isEmpty()) {
                        stack.peek();
                    }
                    break;
            }
        }
        long end = System.currentTimeMillis();        
        return end - start;
    }    
    
    
    
    public static void main(String[] args) {
        
        String[] testSize = createTest(1000000);
        Stack<String> arrayStack = new Stack<>();
        Stack<String> linkListStack = new Stack<>();
        
        // Test Array Stack
        long arrayStackTime = testStackSpeed(arrayStack, testSize);
        System.out.println("ArrayStack results: " + arrayStackTime + " milliseconds.");
        
        // Test Linked List Stack
        long LListStackTime = testStackSpeed(linkListStack, testSize);
        System.out.println("LListStack results: " + LListStackTime + " milliseconds.");
    }
   
}
