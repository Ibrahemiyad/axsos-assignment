package Barista;

import java.util.ArrayList;

public class Order {
    private boolean ready;
    private String name;
    private ArrayList<Item> items;

    public Order(){
        this.name = "Guest";
        this.ready = false;
        this.items = new ArrayList<Item>();
    }

    public Order(String name){
        this.name = name;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItem(){
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public String getName() {
        return name;
    }
    public void addItem(Item item) {
        this.items.add(item);
    }
    public double getOrderTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public void display() {
        System.out.printf("Name: %s\n", name);
        System.out.printf("Total: %.2f\n", getOrderTotal());
        System.out.printf("Ready: %s\n", ready);
        System.out.println("Items:");
        for (Item item : items) {
            System.out.printf("- %s: %.2f\n", item.getName(), item.getPrice());
        }
    }
    public String getStatusMessage() {
        if (this.ready) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
    public boolean isReady() {
        return ready;
    }
}


