package Map;
import java.util.HashMap;
import java.util.Set;

public class Map {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<>();
        trackList.put("Wonderwall", "Today is gonna be the day that they're gonna throw it back to you...");
        trackList.put("Yellow", "Look at the stars, look how they shine for you...");
        trackList.put("Fix You", "When you try your best but you don't succeed...");
        trackList.put("Viva La Vida", "I hear Jerusalem bells ringing, Roman Cavalry choirs are singing...");


        String song = "Yellow";
        String lyrics = trackList.get(song);
        if (lyrics != null) {
            System.out.println("Lyrics for " + song + ": " + lyrics);
        } else {
            System.out.println("Song not found in the track list.");
        }
        System.out.println("All songs in the track list:");
        for (String title : trackList.keySet()) {
            System.out.println(title + ": " + trackList.get(title));
        }
    }
    
}
