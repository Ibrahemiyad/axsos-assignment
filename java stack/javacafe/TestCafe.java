package javacafe;
import javacafe.CafeUtil; // Ensure CafeUtil is in 'javacafe' package
import java.util.ArrayList;
import java.util.Scanner;

public class TestCafe {
    public static void main(String[] args) {

        // Instantiate the CafeUtil class
        CafeUtil appTest = new CafeUtil();

        /* ============ App Test Cases ============= */

        // Test 1: Default streak goal (10 weeks)
        System.out.println("\n----- Streak Goal Test -----");
        int defaultGoal = appTest.getStreakGoal();
        System.out.printf("Purchases needed by week 10: %d \n\n", defaultGoal);

        // Test 2: Custom streak goal (e.g., 15 weeks)
        // System.out.println("----- Streak Goal with Parameter Test -----");
        // int customGoal = appTest.getStreakGoal(15);
        // System.out.printf("Purchases needed by week 15: %d \n\n", customGoal);

        // Test 3: Order total from an array of line items
        System.out.println("----- Order Total Test -----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        double total = appTest.getOrderTotal(lineItems);
        System.out.printf("Order total: $%.2f \n\n", total);

        // Test 4: Display a sample coffee menu
        System.out.println("----- Display Menu Test -----");
        ArrayList<String> menu = new ArrayList<>();
        menu.add("Drip Coffee");
        menu.add("Cappuccino");
        menu.add("Latte");
        menu.add("Mocha");
        appTest.displayMenu(menu);

        // Test 5: Add customers (prompt user input)
        System.out.println("\n----- Add Customer Test -----");
        ArrayList<String> customers = new ArrayList<>();
        for (int i = 0; i < 2; i++) { // Run twice to simulate multiple customers
            appTest.addCustomer(customers);
            System.out.println();
        }

        // Optional: Display final list of customers
        System.out.println("Final customer list: " + customers);
    }
}
