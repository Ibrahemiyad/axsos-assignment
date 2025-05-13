package alfredBot;

public class AlfredTest {
    public static void main(String[] args) {
        AlfredQuotes alfredBot = new AlfredQuotes();

        System.out.println(alfredBot.guestGreeting("Beth Kane"));

        System.out.println(alfredBot.getCurrentDate());

        System.out.println(alfredBot.respondBeforeAlexis("Alexis! Play some music."));
        System.out.println(alfredBot.respondBeforeAlexis("Alfred, can you assist me?"));
        System.out.println(alfredBot.respondBeforeAlexis("Just thinking about Batman."));
    }
}
