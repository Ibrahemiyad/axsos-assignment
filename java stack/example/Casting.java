package example;

public class Casting {

    public static void main(String[]args){
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
        long end = System.currentTimeMillis();
        double total = (double) (end - start) / 1000;
        System.out.println("Time of execution: " + total + " seconds");
        Integer a = 10;
        Integer b = 10;
        a = null;
        b = null;
        System.out.println(a);
        System.out.println(b);
        String[] fruits = {"banana","apple","papaya","kiwi"};
        String temp = fruits[0];
        fruits[0] = fruits[3];
        fruits[3] = temp;
        System.out.println(fruits.length);
        int[] myarray;
        myarray = new int[5];
        myarray[0] = 4;
        myarray[1] = 3;
        myarray[2] = 5;
        myarray[3] = 6;
        myarray[4] = 7;
        System.out.println(myarray.length);
        System.out.println(myarray[4]);





    }
}
