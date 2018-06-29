import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

class Forum {
    static Map<String, ArrayList<String>> forum = new LinkedHashMap<String, ArrayList<String>>();

    public static void startThread(String threadName, String title, String body) {
        forum.put(threadName, new ArrayList<String>());
        forum.get(threadName).add(title);
        forum.get(threadName).add(body);
    }

    public static void comment(String threadName, String commentBody) {
        forum.get(threadName).add(commentBody);
    }

    public static void showForum() {
        System.out.println("------------------------");
        System.out.println("Forum constists of following threads:");
        System.out.println("------------------------");
        for (Map.Entry<String, ArrayList<String>> entry : forum.entrySet()) {
            String name = entry.getKey();
            String title = entry.getValue().get(0);
            System.out.println(title + "  (" + name + ")");
        }
        System.out.println("------------------------");
    }

    public static void showThread(String threadName) {
        ArrayList<String> aThread = forum.get(threadName);
        if (aThread.size() >= 2) {
            System.out.println("Title: ");
            System.out.println(aThread.get(0));
            System.out.println("***");
        }
        for (int i = 1; i < aThread.size(); i++) {
            System.out.println(i + ": " + aThread.get(i));
        }
        System.out.println("------------------------");
    }

}

class User {
    private String firstName;
    private String secondName;
    private char sex;
    private int age;
    private String mail;
    private boolean logged;
    private boolean deleted;

    public User(String firstName, String secondName, char sex, int age, String mail) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.sex = sex;
        this.age = age;
        this.mail = mail;
        logged = !logged;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    public void logIn() {
        if (!logged & !deleted) {
            logged = !logged;
            System.out.println("User " + firstName + " " + secondName + " logged in.");
        } else if (logged) {
            System.out.println(
                    "User already logged in. If you are not " + firstName + " " + secondName + " please log out.");
        } else {
            System.out.println("Invalid account.");
        }
    }

    public void logOut() {
        if (logged) {
            logged = !logged;
            System.out.println("User has been logged out.");
        } else {
            System.out.println("You need to log in first.");
        }
    }

    public void deleteUser() {
        deleted = true;
        System.out.println("User has been deleted.");
    }

}

class ForumUser extends User {
    private int numberOfPosts;
    private boolean visible;

    public ForumUser(String firstName, String secondName, char sex, int age, String mail) {
        super(firstName, secondName, sex, age, mail);
        visible = true;
    }

    public void startThread(String threadName, String threadTitle, String threadBody) {
        Forum.startThread(threadName, threadTitle, threadBody);
        this.numberOfPosts++;
    }

    public void showThread(String postName) {
        Forum.showThread(postName);
    }

    public void comment(String threadName, String commentBody) {
        Forum.comment(threadName, commentBody);
        this.numberOfPosts++;
    }

    public void showInfo() {
        System.out.println(this.getFirstName() + " " + this.getSecondName() + ", " + this.getSex() + ", " + this.getAge() + ". Posts: " + this.getNumberOfPosts());
    }

    public void changeVisibility() {
        visible = !visible;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

}

public class App {
    public static void main(String[] args) {
        ForumUser michal = new ForumUser("Micha�", "Bugajski", 'M', 30, "mb@gmail.com");
        ForumUser marta = new ForumUser("Marta", "Tylman", 'F', 27, "mt@gmail.com");
        ForumUser adam = new ForumUser("Adam", "Kwiecie�", 'M', 29, "ak@gmail.com");

        michal.startThread("introduction", "I'd like to introduce myself", "Hi, my name is Michal");
        michal.startThread("exploration", "So, what is everyone up to?",
                "I've been looking around here for a while and it all seems rather dead.");
        Forum.showForum();
        marta.comment("introduction", "Hi Michal, nice to meet you!");
        marta.comment("exploration",
                "Oh, it's been pretty quiet lately, but we, as well as the forum itself are indeed quite alive. THings should get back to normal soon enough, don't you worry.");
        adam.comment("introduction", "Hey there! Enjoy your stay!");
        michal.showThread("exploration");
        adam.showThread("introduction");

        michal.logOut();
        michal.logIn();
        michal.logIn();
        michal.logOut();
        michal.logOut();
        michal.deleteUser();
        michal.logIn();
        michal.showInfo();
        marta.showInfo();
        adam.showInfo();

    }
}
