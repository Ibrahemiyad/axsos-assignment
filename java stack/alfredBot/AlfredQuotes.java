package alfredBot;
import java.util.Date;

public class AlfredQuotes {
    public String guestGreeting(String name) {
        return String.format("Hello, %s", name);
    }
    public String getCurrentDate() {
        Date date = new Date();
        return "Current date is: " + date;
    }

    public String respondBeforeAlexis(String conversation) {
        if (conversation.toLowerCase().contains("alexis")) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (conversation.toLowerCase().contains("alfred")) {
            return "At your service. As you wish, naturally.";
        } else {
            return "Right. And with that, I shall retire.";
        }
    }
    

}
