import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] companies = new int[size];

        initializeCompanies(companies, scanner);
        System.out.println(getHighestOutputIndex(companies, scanner));
    }

    private static int getHighestOutputIndex(int[] companies, Scanner scanner) {
        double highestOutputIncome = 0;
        double currentIncome;
        int highestOutputIndex = 0;
        double currentTax;
        for (int i = 0; i < companies.length; i++) {
            currentTax = (double) scanner.nextInt() /100;
            currentIncome = companies[i] * currentTax;
            if (currentIncome > highestOutputIncome) {
                highestOutputIndex = i+1;
                highestOutputIncome = currentIncome;
            }
        }
        return highestOutputIndex;
    }

    private static void initializeCompanies(int[] companies, Scanner scanner) {
        for (int i = 0; i < companies.length; i++) {
            companies[i] = scanner.nextInt();
        }
    }


}