import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

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

    public boolean before2010() {

        return year < 2010;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (year != other.year)
            return false;
        return true;
    }

}

public class HashSetK {

    public static void main(String[] args) {
        Book[] baseLibrary = {new Book(1999, "Roux", "Mezopotamia"), new Book(2010, "Sapkowski", "Narrenturm"),
                new Book(1978, "Salmonowicz", "Fryderyk II"), new Book(2012, "Banks", "The Hydrogen Sonata"),
                new Book(2002, "Morgan", "Altered Carbon"), new Book(2013, "Piketty", "Capital"),
                new Book(1867, "Marx", "Das Kapital")};
        Predicate<Book> rules = (b) -> b.before2010();

        Set<Book> library = new HashSet<Book>(Arrays.asList(baseLibrary));
        library.forEach((book) -> {
            if (rules.test(book)) {
                System.out.println(book.getTitle());
            }
        });
    }

}
