import java.util.HashMap;
public class CustomHashMap {
    public static void main(String[] args) {
        // Create a HashMap to store book titles and their authors
        HashMap<String, String> bookAuthors = new HashMap<>();

        // Add some books to the HashMap
        bookAuthors.put("To Kill a Mockingbird", "Harper Lee");
        bookAuthors.put("1984", "George Orwell");
        bookAuthors.put("The Great Gatsby", "F. Scott Fitzgerald");

        // Retrieve and print the author of a specific book
        String bookTitle = "1984";
        String author = bookAuthors.get(bookTitle);
        System.out.println("The author of '" + bookTitle + "' is " + author + ".");
    }

}
