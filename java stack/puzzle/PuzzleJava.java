package puzzle;
import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> rolls = new ArrayList<>();
        for (int i=0; i < 10; i++){
            rolls.add(randMachine.nextInt(20)+1);
        }
        return rolls;

    }

    public char getRandomLetter() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        return alphabet[randMachine.nextInt(26)];
    }

    public String generatePassword(){
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            password.append(getRandomLetter());
        }
        return password.toString();
    }
    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwordSet = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            passwordSet.add(generatePassword());
        }
        return passwordSet;


    }
    
}
