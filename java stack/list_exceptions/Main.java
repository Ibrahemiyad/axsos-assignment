package list_exceptions;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add(1);
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer value = (Integer) myList.get(i);
                System.out.println("Element at index " + i + " casted to Integer: " + value);
            } catch (ClassCastException e) {
                System.out.println("ClassCastException at index " + i + ":");
                System.out.println("Value: " + myList.get(i));
                System.out.println("Error message: " + e.getMessage());
                // Continue with next item
            }
        }
    }
}