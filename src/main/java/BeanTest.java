import java.util.ArrayList;
import java.util.List;

public class BeanTest {
    public static void main(String[] args) {

        Album album1 = new Album(1, "Sublime", "Santeria", 1996, 40.5, "rock");
        Album album2 = new Album(2,"Random Band", "Goated Album", 2022, 69.69, "experimental");

        Author author1 = new Author(1, "Mark Twain");
        Author author2 = new Author(2, "Neal Shusterman");

        Quotes quote1 = new Quotes(1, "May you always keep your youth.", author1);
        Quotes quote2 = new Quotes(2, "Truth is stranger than fiction, but it is because fiction is obliged to stick to possibilities; the truth isn't.", author1);
        Quotes quote3 = new Quotes(3, "Stupid dreams. Even the good ones are bad, because they remind you how poorly reality measures up.", author2);
        Quotes quote4 = new Quotes(4, "No true hero ever believes that they are one.", author2);

        List<Quotes> quotesList = new ArrayList<>();
        quotesList.add(quote1);
        quotesList.add(quote2);
        quotesList.add(quote3);
        quotesList.add(quote4);

        for (Quotes quote : quotesList){
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("Author: " + quote.getAuthor().getAuthor_name());
            System.out.println("Quote #" + quote.getId() + " " + quote.getContent());
        }

    }
}
