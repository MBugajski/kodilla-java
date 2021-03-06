package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Book {
    private int year;
    private String title;

    public Book(int year, String title) {
        super();
        this.year = year;
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }
}

public class Lists8 {
    public static void main(String[] args) {
        Integer[] grades8 = {5, 2, 3, 4, 2, 6, 2, 4, 5, 3, 3, 4};
        List<Integer> grades = new ArrayList<Integer>(Arrays.asList(grades8));
        Collections.sort(grades);
        double sum = 0;
        for (int i = 1; i + 1 < grades.size(); i++) {
            sum += grades.get(i);
        }
        System.out.println("Grade average: " + sum / (grades.size() - 2));

        Book[] library8 = {new Book(1999, "Mezopotamia"), new Book(2010, "Narrenturm"),
                new Book(1978, "Fryderyk II"), new Book(2012, "The Hydrogen Sonata"), new Book(2002, "Altered Carbon"),
                new Book(2013, "Capital"), new Book(1867, "Das Kapital")};
        List<Book> library = new LinkedList<Book>(Arrays.asList(library8));
        for (Book book : library) {
            if (book.getYear() >= 2000) {
                System.out.println(book.getTitle());
            }
        }
    }
}
