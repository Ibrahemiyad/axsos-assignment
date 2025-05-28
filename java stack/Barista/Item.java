package Barista;

public class Item {
    private String name;
    private double price;

    // constructor
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Item() {
        this.name = "";
        this.price = 0.0;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
