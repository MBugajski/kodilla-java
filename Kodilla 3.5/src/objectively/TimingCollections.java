package objectively;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

class testingEnviorement {
    int collectionSize;
    int testSize;
    static List<Book> timedLinkedList = new LinkedList<>();
    static Map<Integer, Book> timedHashMap = new HashMap<>();
    long begin;
    long end;


    public testingEnviorement(int collectionSize, int testSize) {
        super();
        this.collectionSize = collectionSize;
        this.testSize = testSize;
    }

    public void testLinkedList() {
        timingLinkedList testLinkedList = new timingLinkedList(collectionSize, testSize);
        testLinkedList.populate();
        testLinkedList.timeLinkList();
    }


    public void populate() {
        Random random = new Random();
        for (int i = 0; i < collectionSize; i++) {
            Integer title = random.nextInt(1000) + 999000;
            Integer author = random.nextInt(1000) + 100000;
            Book book = new Book(title.toString(), author.toString());
            timedLinkedList.add(book);
        }
    }

}

class timingLinkedList extends testingEnviorement {

    public timingLinkedList(int collectionSize, int testSize) {
        super(collectionSize, testSize);
    }

    public void populate() {
        Random random = new Random();
        for (int i = 0; i < collectionSize; i++) {
            Integer title = random.nextInt(1000) + 999000;
            Integer author = random.nextInt(1000) + 100000;
            Book book = new Book(title.toString(), author.toString());
            timedLinkedList.add(book);
        }
    }

    public void timeLinkList() {
        System.out.println("Returning the first element from the list has taken: " + readFirst() + "ns");
        System.out.println("Returning the last element from the list has taken: " + readLast() + "ns");
        System.out.println("Removing the first element from the list has taken: " + removeFirst() + "ns");
        System.out.println("Removing the last element from the list has taken: " + removeLast() + "ns");
        System.out.println("Adding an element at the beginning of the list has taken: " + addFirst() + "ns");
        System.out.println("Adding an element at the end of the list has taken: " + addLast() + "ns");
    }

    public long readFirst() {
        begin = System.nanoTime();
        timedLinkedList.get(0);
        end = System.nanoTime();
        return (end - begin);
    }

    public long readLast() {
        begin = System.nanoTime();
        timedLinkedList.get(timedLinkedList.size() - 1);
        end = System.nanoTime();
        return (end - begin);
    }

    public long removeFirst() {
        begin = System.nanoTime();
        timedLinkedList.remove(0);
        end = System.nanoTime();
        return (end - begin);
    }

    public long removeLast() {
        begin = System.nanoTime();
        timedLinkedList.remove(timedLinkedList.size() - 1);
        ;
        end = System.nanoTime();
        return (end - begin);
    }

    public long addFirst() {
        begin = System.nanoTime();
        timedLinkedList.add(0, new Book("1234567", "7654321"));
        end = System.nanoTime();
        return (end - begin);
    }

    public long addLast() {
        begin = System.nanoTime();
        timedLinkedList.add(timedLinkedList.size() - 1, new Book("1234567", "7654321"));
        end = System.nanoTime();
        return (end - begin);
    }
}

class timingHashMap extends testingEnviorement {

    public timingHashMap(int collectionSize, int testSize) {
        super(collectionSize, testSize);
        // TODO Auto-generated constructor stub
    }

    public void populate() {
        Random random = new Random();
        for (int i = 0; i < collectionSize; i++) {
            Integer title = random.nextInt(1000) + 999000;
            Integer author = random.nextInt(1000) + 100000;
            Book book = new Book(title.toString(), author.toString());
            timedHashMap.put(i, book);
        }
    }
}

class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        super();
        this.author = author;
        this.title = title;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
        return true;
    }

}

public class TimingCollections {


    public static void main(String[] args) {

//		testingEnviorement timingEnviorement = new testingEnviorement(2000000, 500000);
//		timingEnviorement.testLinkedList();

        LinkedList<Book> timedList = new LinkedList<>();
        Map<Integer, Book> timedMap = new HashMap<>();
        Random random = new Random();
        int size = 2000000;
        for (int i = 0; i < size; i++) {
            Integer title = random.nextInt(1000) + 999000;
            Integer author = random.nextInt(1000) + 100000;
            Book book = new Book(title.toString(), author.toString());
            timedList.add(book);
            timedMap.put(i, book);
        }

        long begin = System.nanoTime();
        timedList.get(0);
        long end = System.nanoTime();
        System.out.println("Returning the first element from the list has taken: " + (end - begin) + "ns");

        begin = System.nanoTime();
        timedList.get(timedList.size() - 1);
        end = System.nanoTime();
        System.out.println("Returning the last element from the list has taken: " + (end - begin) + "ns");

        System.out.println();

        begin = System.nanoTime();
        timedList.remove(0);
        end = System.nanoTime();
        System.out.println("Removing the first element from the list has taken: " + (end - begin) + "ns");

        begin = System.nanoTime();
        timedList.remove(timedList.size() - 1);
        end = System.nanoTime();
        System.out.println("Removing the last element from the list has taken: " + (end - begin) + "ns");

        System.out.println();

        begin = System.nanoTime();
        timedList.add(0, new Book("1234567", "7654321"));
        end = System.nanoTime();
        System.out.println("Adding an element at the beginning of the list has taken: " + (end - begin) + "ns");

        begin = System.nanoTime();
        timedList.add(timedList.size(), new Book("7654321", "1234567"));
        end = System.nanoTime();
        System.out.println("Adding an element at the end of the list has taken: " + (end - begin) + "ns");

        System.out.println();

        int testSize = 5000000;
        long averageMapTiming = 0;
        long longestMapTiming = 0;
        for (int i = 0; i < testSize; i++) {
            int randomLongTestKey = random.nextInt(timedMap.size() + 1);
            begin = System.nanoTime();
            timedMap.get(randomLongTestKey);
            end = System.nanoTime();
            averageMapTiming += (end - begin);
            if ((end - begin) > longestMapTiming) {
                longestMapTiming = (end - begin);
            }
        }
        System.out.println("Retrieving an random element from the map has taken on average: "
                + (averageMapTiming / testSize) + "ns");
        System.out.println("Retrieving an random element from the map has taken at most: " + longestMapTiming + "ns");

        System.out.println();

        averageMapTiming = 0;
        longestMapTiming = 0;
        for (int i = 0; i < testSize; i++) {
            Map<Integer, Book> tempTimedMap = new HashMap<>();
            tempTimedMap = timedMap;
            int randomLongTestKey = random.nextInt(timedMap.size() + 1);
            begin = System.nanoTime();
            tempTimedMap.remove(randomLongTestKey);
            end = System.nanoTime();
            averageMapTiming += (end - begin);
            if ((end - begin) > longestMapTiming) {
                longestMapTiming = (end - begin);
            }
        }
        System.out.println(
                "Removing a random element from the map has taken on average: " + (averageMapTiming / testSize) + "ns");
        System.out.println("Removing a random element from the map has taken at most: " + longestMapTiming + "ns");

        System.out.println();
        /**
         * While both retrieving and removing items from the map produces fairly
         * consistent averages (both circa 200ns for my system), ones for adding are all
         * over the place and vary wildly both depending on the way of providing a key
         * but also with testSize. With high testSize seemingly increasing the averages
         * by a large margin. Is it a nature of the beast, so to speak, or am I doing
         * something wrong here?
         **/

        averageMapTiming = 0;
        longestMapTiming = 0;
        for (int i = 0; i < testSize; i++) {
            Map<Integer, Book> tempTimedMap = new HashMap<>();
            tempTimedMap = timedMap;
            // int randomLongTestKey = timedMap.size()/2;
            // int randomLongTestKey = timedMap.size()+1;
            int randomLongTestKey = random.nextInt(timedMap.size() + 1);
            // int randomLongTestKey = random.nextInt(timedMap.size()+1) +
            // timedMap.size()+1;

            begin = System.nanoTime();
            tempTimedMap.put(randomLongTestKey, new Book("1234567", "7654321"));
            end = System.nanoTime();
            averageMapTiming += (end - begin);
            if ((end - begin) > longestMapTiming) {
                longestMapTiming = (end - begin);
            }
        }
        System.out.println(
                "Adding a random element to the map has taken on average: " + (averageMapTiming / testSize) + "ns");
        System.out.println("Adding a random element to the map has taken at most: " + longestMapTiming + "ns");

    }

}
