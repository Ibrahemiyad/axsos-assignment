package coffee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private String name;
    private List<Item> items;

    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
    }


    public void addItem(Item item) {
        items.add(item);
    }

    public String getName() {
        return name;
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Customer: ").append(name).append("\n");
        details.append("Items:\n");
        double total = 0.0;
        for (Item item : items) {
            details.append(item.getName()).append(" -- $").append(String.format("%.2f", item.getPrice())).append("\n");
            total += item.getPrice();
        }
        details.append("Total: $").append(String.format("%.2f", total));
        return details.toString();
    }

}
