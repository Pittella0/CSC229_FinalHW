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
public class CompanyX {
    // Creating 4 Priority Lists
    static Queue<String> P1 = new LinkedList<>();
    static Queue<String> P2 = new LinkedList<>();
    static Queue<String> P3 = new LinkedList<>();
    static Queue<String> P4 = new LinkedList<>();
    // Using static for all of these because they are going to be used throughout program
    static Random rndTime = new Random(15);
    static int count = 0;
    static int orderNum = 1;
    static String customerName;
    static int priority = 0;
    static int processingTime = 0;

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int choice = 0;
    // Creating menu
    while (true) {
            System.out.println("\n\nChoose an option: 1-4 \t" + "[Total count: " + count + "]");
            System.out.println("1. Create A New Order");
            System.out.println("2. Process Next Order");
            System.out.println("3. Process Random Order");
            System.out.println("4. View Order Queue\n");
            System.out.print("Selection: ");

            try{ // Accepting selection into temp location for sterilization
            choice = sc.nextInt();

            if (choice < 1 || choice > 4) {
                    System.out.println("Invalid input. Please enter a valid number between 1 and 4.");
            } else {
                    switch (choice) {   
                    case 1: newOrder();
                            break;
                    case 2: nextOrder();
                            break;
                    case 3: randomOrder();
                            break;
                    case 4: viewOrderQueue();  	 
                            break;
                    default:System.out.println("Invalid input. Please enter a valid number between 1 and 4.");
                            break;
                    }
            }
            // This is to catch everything else that's not a number
            } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number between 1 and 4.");
            sc.next();  // Clears invalid input
            }
    }    
    }

    private static void newOrder() {

    Scanner sc = new Scanner(System.in);
    int pChoice = 0;

    System.out.print("\nEnter Customer Name: ");
    customerName = sc.nextLine();

    while (true) { // Establishes the order Priority
            System.out.print("Enter Priority 1-4: ");
            pChoice = sc.nextInt();
            if (pChoice < 1 || pChoice > 4) {
            System.out.println("Invalid input. Please enter a valid number between 1 and 4.");
            } else {
            priority = pChoice;          	 
            break; // Break out of the loop if the priority is valid           	 
            }
    }
    orderNum++;
    count++;
    // Creating random processing times
    processingTime = new Random().nextInt(15) + 1;
    // Passing everything along to queueOrder
    queueOrder(customerName, orderNum, priority, processingTime);
    System.out.println("\n\n"+ customerName +" your order number is " + orderNum + " and you are in group " + priority + ".");


    }

    private static void nextOrder() {
    // Processes the next order in queue
    String order = null;
    if (!P1.isEmpty()) {
            order = P1.poll();

    } else if (!P2.isEmpty()) {
            order = P2.poll();

    } else if (!P3.isEmpty()) {
            order = P3.poll();

    } else if (!P4.isEmpty()) {
            order = P4.poll();

    } else {
            System.out.println("\nNo orders to process.\n");
    return; // Return early if there are no orders to process
    }
    System.out.println("\n**PROCESSING ORDER**\n" + order);
    // Process the order using orderProcessing
    orderProcessing(order);
    count--;
}

    private static String orderProcessing(String order) {
    // Pull information from the order string
    order = order.trim(); // Put this in because I was getting errors, so just wanted to clean up the order
    String[] orderDetails = order.split("[\\s\\n]+"); // Delimiters can be spaces, tabs, and newlines
                    // I was getting a Parsing integers from order error because of my formatting with new lines
    if (orderDetails.length < 4) {
            return "Invalid order format: " + order;

    }    

    String customerName = orderDetails[0];
    try{ // Converting the String versions into Ints and storing in position[i]
            int orderNum = Integer.parseInt(orderDetails[1]);
            int priority = Integer.parseInt(orderDetails[2]);
            int processingTime = Integer.parseInt(orderDetails[3]);

            // Perform order processing actions
            System.out.println("\nNow Processing:");
            System.out.println("Customer Name:   " + customerName);
            System.out.println("Order No:    	" + orderNum);
            System.out.println("Priority:    	" + priority);
            System.out.println("Processing Time: " + processingTime + " minutes");
            count--;
            return null;      	 

    } catch (NumberFormatException e) {
            return "Error parsing integers from order:\n" + order;

    }
    }

    private static void randomOrder() {
    Random rndOrder = new Random();

    // Select a random selection from P1, P2, P3, or P4
    int priority = rndOrder.nextInt(4) + 1;
    Queue<String> selectedQueue;

    switch (priority) {
            case 1:
            selectedQueue = P1;
            break;
            case 2:
            selectedQueue = P2;
            break;
            case 3:
            selectedQueue = P3;
            break;
            case 4:
            selectedQueue = P4;
            break;
            default:
            System.out.println("Error: Invalid priority.");
            count--;
            return;
    }

    if (!selectedQueue.isEmpty()) {
            // Polling the random order and passing it along to orderProcessing
            String randomOrder = selectedQueue.poll();
            System.out.println("\n**PROCESSING RANDOM ORDER**\n" + randomOrder);
            orderProcessing(randomOrder);
    } else {
            System.out.println("\nNo orders in priority " + priority + " to process.\n");
    }
    }  

    private static void queueOrder(String customerName, int orderNum, int priority, int processingTime) {
    // This is the method to (.add) the new orders to their proper LL
    switch (priority) {
            case 1: P1.add("\nName: "+ customerName +
                    "\nOrder number: " + orderNum +
                    "\nGroup: " + priority +
                    "\nProcessing Time: " + processingTime + " minutes.\n");
            break;
            case 2: P2.add("\nName: "+ customerName +
                    "\nOrder number: " + orderNum +
                    "\nGroup: " + priority +
                    "\nProcessing Time: " + processingTime + " minutes.\n");
            break;
            case 3: P3.add("\nName: "+ customerName +
                    "\nOrder number: " + orderNum +
                    "\nGroup: " + priority +
                    "\nProcessing Time: " + processingTime + " minutes.\n");
            break;
            case 4: P4.add("\nName: "+ customerName +
                    "\nOrder number: " + orderNum +
                    "\nGroup: " + priority +
                    "\nProcessing Time: " + processingTime + " minutes.\n");
            break;

    }
    }

    private static void viewOrderQueue() {
    // This is option 4 from the table, and just shows what is the queue and the positions
    System.out.println("Order Queue:\n\n");
    int position = 1;

    for (String order : P1) {
            System.out.println("Position: " + position + order);
            position++;
    }
    for (String order : P2) {
            System.out.println("Position: " + position + order);
            position++;
    }
    for (String order : P3) {
            System.out.println("Position: " + position + order);
            position++;
    }
    for (String order : P4) {
            System.out.println("Position: " + position + order);
            position++;
    }
    }

}
