import java.util.Random;

public class randomNumbers {
    public static void main(String[] args) {
        Random randomInt = new Random();
        int sumaA = 1000;
        int sumaB = 0;
        int count = 1;

        while (sumaA > sumaB) {
            System.out.println("Iteration " + count++ + ":");
            System.out.println("A:" + (sumaA += randomInt.nextInt(10)) + "; B: " + (sumaB += randomInt.nextInt(50)));
        }
    }
}
