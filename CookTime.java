import java.util.Scanner;

/**
 * This program calculates the time needed to reheat a certain food.
 * 
 * @author Amin Zeina
 * @version 1.0
 * @since 2020-02-21
 */

public class CookTime {
  
  /**
  * This class calculates the time needed to reheat a certain food depnding
  * on # of items.
  */
  
  public static void main(String[] args) throws Exception {
    // Create variables 
    String foodEntered;
    int numberOfItems;
    double time;
    
    // Create scanner object
    Scanner userInput = new Scanner(System.in);
    // Ask user for type of food
    System.out.print("Do you need to reheat a pizza, sub, or soup? ");
    
    tryCatch: try {
      // Get type of food
      foodEntered = userInput.nextLine();
      // Determine what type of food it is
      if (foodEntered.equals("pizza")) {
        // Base time 0.75 mins (45 sec)
        time = 0.75;
      } else if (foodEntered.equals("sub")) {
        // Base time 1 mins (60 sec)
        time = 1;
      } else if (foodEntered.equals("soup")) {
        // Base time 1.75 mins (105 sec)
        time = 1.75;
      } else {
        System.err.println("Invalid input. Please enter: pizza, sub, or soup.");
        /* break try catch block to avoid # of Items prompt 
          https://stackoverflow.com/questions/6534072/how-can-i-break-from-a-try
          -catch-block-without-throwing-an-exception-in-java */
        break tryCatch;
      }
      
      // Ask user for number of items
      System.out.print("How many " + foodEntered + "s are you reheating (max 3)? ");
      // Get # of items
      numberOfItems = userInput.nextInt();
      // determine total time 
      if (numberOfItems == 1) {
        // 1 item = no change to time (x1)
        time = time * 1.0;
      } else if (numberOfItems == 2) {
        // 2 items = 50% increase in time (x1.5)
        time = time * 1.5;
      } else if (numberOfItems == 3) {
        // 3 items = 100% increase in time (x2)
        time = time * 2;
      } else {
        System.err.println("Invalid Input. Only 1-3 items at a time.");
        // break try catch block to avoid final print 
        break tryCatch;
      }
      
      System.out.println("Your total cook time is " + Math.round(time * 100.0) / 100.0  
          + " minute(s).");
    } catch (Exception e) {
      System.err.println("Invalid Input. Only 1-3 items at a time.");
    }
  }
}