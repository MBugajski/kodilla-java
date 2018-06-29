class User {
    private String name;
    private double age;
    private double height;

    public User(String name, double age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public void checkValidations() {
        if (validateAge() & validateHeight()) {
            System.out.println("User is older than 30 and higher then 160cm");
        } else {
            System.out.println("User is younger than 30 or lower than 160cm");
        }
    }

    private boolean validateAge() {
        return age > 30;
    }

    private boolean validateHeight() {
        return height > 160;
    }
}

class Application {
    public static void main(String[] args) {
        User adam = new User("Adam", 40.5, 178);
        adam.checkValidations();
    }
}