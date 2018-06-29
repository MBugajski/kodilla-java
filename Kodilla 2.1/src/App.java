public class App {
    public static void main(String[] args) {

        int[] numbers = new int[20];
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * numbers.length) + 1;
            System.out.println(numbers[i]);
            sum += numbers[i];
        }
        for (int i : numbers) {
            System.out.println(i);
        }
        System.out.println("The average is: " + sum / numbers.length);
    }
}
