package coffee;
import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    // Constructor
    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    // Add a new menu item with name, price, and index
    public void addMenuItem(String name, double price) {
        Item item = new Item(name, price, menu.size());
        menu.add(item);
    }

    // Display the menu
    public void displayMenu() {
        for (Item item : menu) {
            System.out.printf("%d %s -- $%.2f\n", item.getIndex(), item.getName(), item.getPrice());
        }
    }

    // Create a new order with user input
    public void newOrder() {
        // Prompt for customer name
        System.out.println("Please enter customer name for new order:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        // Create a new order
        Order order = new Order(name);

        // Display the menu
        System.out.println("\nMenu:");
        displayMenu();

        // Prompt for item selection
        System.out.println("Please enter a menu item index or 'q' to quit:");
        String itemNumber = scanner.nextLine();

        // Collect items until user enters 'q'
        while (!itemNumber.equals("q")) {
            try {
                int index = Integer.parseInt(itemNumber);
                if (index >= 0 && index < menu.size()) {
                    Item selectedItem = menu.get(index);
                    order.addItem(selectedItem);
                    System.out.println("Added " + selectedItem.getName() + " to the order.");
                } else {
                    System.out.println("Invalid item index. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid item index or 'q' to quit.");
            }

            System.out.println("Please enter a menu item index or 'q' to quit:");
            itemNumber = scanner.nextLine();
        }

        // Add the order to the orders list
        orders.add(order);

        // Display order details
        System.out.println("\nOrder Details for " + order.getName() + ":");
        System.out.println(order.getOrderDetails());
    }

    // Ninja Bonus: Add menu item via user input
    public void addMenuItemByInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter item name:");
        String name = scanner.nextLine();

        System.out.println("Enter item price:");
        String priceInput = scanner.nextLine();

        try {
            double price = Double.parseDouble(priceInput);
            addMenuItem(name, price);
            System.out.println("Added " + name + " to the menu.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format. Item not added.");
        }
    }
}