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
public class StringReverse {
 // Push the words from the read line onto the stack
    public static void Sentence(String[] words){
        Stack <String> words_stack = new Stack <>();
        for (int i = 0; i < words.length; i++) {
            words_stack.push(words[i]);
        }
    }
    // Push the individual letters from the words on the Stack
    private static String reverseWord(String letters){
        Stack<Character> letters_stack = new Stack<>();
        for (char i = 0; i < letters.length(); i++) {
            letters_stack.push(letters.charAt(i));   
        }
        
    // While Stack of letters is not empty keep popping letters off the Stack
        StringBuilder reverseWord = new StringBuilder();
        while(!letters_stack.empty()) {
            reverseWord.append(letters_stack.pop());
        }
        
    // Returns the letters in Last in First out order to a string to create a word/String
        return reverseWord.toString();
    }
    
    public static void main(String[] args) {
        System.out.print("Please enter your joke: ");
        
    // Scanner to read the words entered Line
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
    
    // This is where the line is split, "\\s+" is the delimiter meaning white space.
    // So it will break down the complete String into subStrings (words)
        String [] words = input.split("\\s+");
    
    // Calls the reverseWord method
        for (int i = 0; i < words.length; i++) {
        words[i] = reverseWord(words[i]);
        }

        
    // Reconstruct the reversed words in sentence
        String reversedSentence = String.join(" ", words);

    // Display the original and reversed sentences
        System.out.println("Original sentence: " + input);
        System.out.println("Reversed sentence: " + reversedSentence);        
    }
    

    

}
