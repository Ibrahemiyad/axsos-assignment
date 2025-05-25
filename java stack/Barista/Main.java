package Barista;

public class Main {
    public static void main(String[] args) {
        // Create two guest orders with unspecified names
        Order guestOrder1 = new Order();
        Order guestOrder2 = new Order();

        // Create some items
        Item item1 = new Item("Coffee", 1.50);
        Item item2 = new Item("Bagel", 2.00);
        Item item3 = new Item("Tea", 1.00);
        Item item4 = new Item("Sandwich", 5.00);
        Item item5 = new Item("Cappuccino", 3.50);
        Item item6 = new Item("Muffin", 2.50);

        // Add items to guest orders
        guestOrder1.addItem(item1);
        guestOrder1.addItem(item2);
        guestOrder2.addItem(item3);
        guestOrder2.addItem(item4);

        // Create three named orders
        Order order1 = new Order("Alice");
        Order order2 = new Order("Bob");
        Order order3 = new Order("Cindhuri");

        // Add items to these orders
        order1.addItem(item5); // Cappuccino
        order1.addItem(item6); // Muffin

        order2.addItem(item1); // Coffee
        order2.addItem(item4); // Sandwich

        order3.addItem(item2); // Bagel
        order3.addItem(item3); // Tea

        // Mark some orders as ready
        order1.setReady(true);
        order3.setReady(true);
        // Test getStatusMessage
        System.out.println(order1.getStatusMessage()); // Should print "Your order is ready."
        System.out.println(order2.getStatusMessage()); // Should print "Thank you for waiting..."
        System.out.println(order3.getStatusMessage()); // Should print "Your order is ready."
    }
}