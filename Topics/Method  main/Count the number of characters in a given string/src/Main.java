import java.util.Scanner;

public class Main {
    // Declare the method 'countCharacters'
    public static void countCharacters(String inputString) {
        // Your code here
        System.out.println(inputString.length());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        // Call 'countCharacters' method with the input string
        countCharacters(inputString);

        scanner.close();
    }
}