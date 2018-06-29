import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

class Student {
    private String firstName;
    private String lastName;
    private int id;

    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String toString() {
        return firstName + " " + lastName + " (" + id + ")";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + id;
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
        Student other = (Student) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (id != other.id)
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }
}

public class Maps {
    public static void main(String[] args) {
        Student student1 = new Student("Mike", "Brown", 12345678);
        Student student2 = new Student("Molly", "Brown", 87654321);
        Student student3 = new Student("Jane", "Smith", 12348765);
        Student student4 = new Student("Edmund", "Clark", 43215678);

        Map<Student, int[]> classRegister = new HashMap<>();

        classRegister.put(student1, new int[]{2, 4, 6, 3, 5, 3, 1});
        classRegister.put(student2, new int[]{3, 4, 5, 5, 6, 5});
        classRegister.put(student3, new int[]{4, 3, 4, 5, 4, 2, 1, 4});
        classRegister.put(student4, new int[]{4, 4, 5, 5, 6, 5});
        DecimalFormat twoDecimals = new DecimalFormat("#.00");

        for (Student student : classRegister.keySet()) {
            int sum = 0;
            for (int i : classRegister.get(student)) {
                sum += i;
            }
            double average = (double) sum / classRegister.get(student).length;
            System.out.println(student.toString() + " has an average grade of: " + twoDecimals.format(average));
        }
    }
}
