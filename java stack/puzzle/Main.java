package puzzle;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PuzzleJava puzzle = new PuzzleJava();

        // Generate and display 10 random dice rolls
        ArrayList<Integer> rolls = puzzle.getTenRolls();
        System.out.println("Ten dice rolls: " + rolls);

        // Generate and display a random letter
        char randomLetter = puzzle.getRandomLetter();
        System.out.println("Random letter: " + randomLetter);

        // Generate and display an 8-character password
        String password = puzzle.generatePassword();
        System.out.println("Generated password: " + password);

        // Generate and display a set of 5 passwords
        ArrayList<String> passwordSet = puzzle.getNewPasswordSet(5);
        System.out.println("Password set: " + passwordSet);
    }
}
