import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = fillArray(scanner, size);
        int n = scanner.nextInt();
        System.out.println(sumArray(array,n));
    }

    private static int sumArray(int[] array, int n) {
        int sum = 0;
        for(int i: array){
            if(i>n){
                sum+=i;
            }
        }
        return sum;
    }

    private static int[] fillArray(Scanner scanner, int size) {
        int[] array = new int[size];
        for(int i = 0; i<array.length;i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }
}