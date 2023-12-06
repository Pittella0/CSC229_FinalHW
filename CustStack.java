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
public class CustStack {
    private int[] myArray;
    private int top;
    public CustStack(int capacity){
        myArray = new int[capacity];
        top = 0;
    }
    
    public boolean empty(){
        return top ==0;
    }
    
   public void push(int pushValue){
       if(top == myArray.length+1){
           System.out.println("Stack Overflow");
           
       
       }
       else{
          
           myArray[top] = pushValue;
            top =top+1;
       }
   }
   int returnValue;
   public int pop(){
       if (empty()){
           System.out.println("Stack is empty");
       }
       else{
            returnValue = myArray[top];
           top=top-1;
           
       }
       return returnValue;
   }
   
   public int peek(){
       if (empty()){
           System.out.println("Stack is empty");
       }
       else{
          returnValue = myArray[top];
           
       }
       return returnValue;
   }
   public int size(){
       return myArray.length;
   }
    public void listAll(){
        for (int i=0; i<= myArray.length-2;i++){
            System.out.print(myArray[i]+ " ,");
        }
        int i = myArray.length -1;
        System.out.println(myArray[i]+"");
    }

    public static void main(String[] args) {
        CustStack myStack  =new CustStack(10);
        for(int i=0; i<=myStack.size()-1;i++){
            Random rand = new Random();
            int randnum = rand.nextInt(100);
            myStack.push(randnum);
        }
        myStack.listAll();
    }

}
