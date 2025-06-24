import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String form = scanner.nextLine();
        double a;
        double b;
        double c;
        double r;
        double result;
        // start coding here
        switch (form) {
            case "triangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                c = scanner.nextDouble();
                double s = (a+b+c) /2.0;
                System.out.println(Math.sqrt(s * (s - a) * (s - b) * (s - c)));
                break;
            case "circle":
                r = scanner.nextDouble();
                System.out.println(3.14 *r *r);
                break;
            case "rectangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                System.out.println(a*b);
                break;
        }
    }
}