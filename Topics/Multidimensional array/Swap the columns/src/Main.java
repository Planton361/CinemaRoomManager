import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int[][] array = new int[i][j];
        for(int a = 0;a<i;a++){
            for(int b = 0;b<j;b++){
                array[a][b] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        for(int m = 0;m<i;m++){
            int cache = array[m][k];
            array[m][k] = array[m][l];
            array[m][l] = cache;
        }
        for(int a = 0;a<i;a++){
            for(int b = 0;b<j;b++){
                System.out.print(array[a][b] +" ");
            }
            System.out.println();

        }


    }
}