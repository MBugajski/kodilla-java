import java.util.ArrayDeque;
import java.util.Queue;

class Book {
    private int year;
    private String author;
    private String title;

    public Book(int year, String author, String title) {
        super();
        this.year = year;
        this.author = author;
        this.title = title;

    }

    public String getClassLowercaseName() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    public String getClassLowercaseNamePlural() {
        return this.getClass().getSimpleName().toLowerCase() + "s";
    }

    public String toString() {
        return "Title: \"" + title + "\", author: " + author + ", (" + year + ")";
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

}

public class ArrayDequeK {
    public static void main(String[] args) {

        ArrayDeque<Book> library = new ArrayDeque<Book>();
        library.push(new Book(2012, "Banks", "The Hydrogen Sonata"));
        library.push(new Book(1999, "Roux", "Mezopotamia"));
        library.push(new Book(2010, "Sapkowski", "Narrenturm"));
        library.push(new Book(1978, "Salmonowicz", "Fryderyk II"));
        library.push(new Book(2002, "Morgan", "Altered Carbon"));

        for (int i = 3; i != library.size(); ) {
            library.poll();
        }
        System.out.println("Last book: " + library.pop());
        System.out.println(isStackEmpty(library));
    }

    public static String isStackEmpty(Queue<Book> collection) {
        if (collection.isEmpty()) {
            return "The stack is empty.";
        } else if (collection.size() == 1) {
            return ("The stack has " + collection.size() + " " + collection.peek().getClassLowercaseName() + " remaining.");
        } else {
            return ("The stack has " + collection.size() + " " + collection.peek().getClassLowercaseNamePlural() + " remaining.");
        }
    }
}
