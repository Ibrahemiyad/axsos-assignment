package Abstract;

import java.util.ArrayList;
import java.util.Collections;

public class Museum {
    public static void main(String[] args) {
        // Create Paintings
        Painting p1 = new Painting("Starry Night", "Van Gogh", "A swirling night sky over a quiet town", "Oil");
        Painting p2 = new Painting("Water Lilies", "Monet", "Impressionist series of water lilies", "Watercolor");
        Painting p3 = new Painting("The Persistence of Memory", "Dali", "Melting clocks in a surreal landscape", "Acrylic");

        // Create Sculptures
        Sculpture s1 = new Sculpture("David", "Michelangelo", "Renaissance marble sculpture", "Marble");
        Sculpture s2 = new Sculpture("The Thinker", "Rodin", "Bronze figure of a thinking man", "Bronze");

        //  Bonus 1: Store all in ArrayList
        ArrayList<Art> museum = new ArrayList<>();
        museum.add(p1);
        museum.add(p2);
        museum.add(p3);
        museum.add(s1);
        museum.add(s2);

        //  Bonus 2: Shuffle and display
        Collections.shuffle(museum);
        for (Art art : museum) {
            art.viewArt();
        }
    }
}
