package cinema;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    private static int rows;
    private static int seats;
    private static char[][] seat;
    private static final Scanner scanner = new Scanner(System.in);
    static boolean isBigCinema = false;
    static boolean isOn = true;
    static int purchasedTickets = 0;
    static double percentageSeatsTaken = 0;
    static int currentIncome = 0;
    static int maxIncome = 0;
    static int newestTicketPrice = 0;

    public Cinema() {

    }

    public static void main(String[] args) {
        // Write your code here
        getSize();
        intitializeCinema(rows, seats);
        calculateIncome();
        do {
            System.out.println("""
                    1. Show the seats
                    2. Buy a ticket
                    3. Statistics
                    0. Exit
                    """);
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    printSeats();
                    break;
                case 2:
                    getTicketNumber();
                    purchasedTickets++;
                    updateStats();
                    break;
                case 3:
                    printStatistics();
                    break;
                case 0:
                    isOn = false;
                    break;
                default:
                    System.out.println("Wrong input, try again");
                    break;

            }
        } while (isOn);

        printSeats();
    }

    private static void updateStats() {
        percentageSeatsTaken = ((double) purchasedTickets / (rows * seats)) * 100;
        currentIncome += newestTicketPrice;
    }


    private static void printStatistics() {
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%%%n", percentageSeatsTaken);
        System.out.println("Current Income: $" + currentIncome);
        System.out.println("Total income: $" + maxIncome);
        System.out.println();
    }

    private static void getTicketPrice(int row, int seatNumber) {
        if (isBigCinema) {
            if (row >= rows / 2) {
                System.out.println("Ticket price: $8");
                newestTicketPrice = 8;
            } else {
                System.out.println("Ticket price: $10");
                newestTicketPrice = 10;
            }
        } else {
            System.out.println("Ticket price: $10");
            newestTicketPrice = 10;
        }
    }

    private static void intitializeCinema(int rows, int seats) {
        seat = new char[rows][seats];
        for (char[] chars : seat) {
            Arrays.fill(chars, 'S');
        }
    }

    private static void getTicketNumber() {
        while (true) {
            System.out.println("Enter a row number:");
            int row = scanner.nextInt() - 1;
            System.out.println("Enter a seat number in that row:");
            int seatNumber = scanner.nextInt() - 1;

            if (row < 0 || row >= rows || seatNumber < 0 || seatNumber >= seats) {
                System.out.println("Wrong input!");
                continue;
            }

            if (seat[row][seatNumber] == 'S') {
                seat[row][seatNumber] = 'B';
                getTicketPrice(row, seatNumber);
                break;
            } else if (seat[row][seatNumber] == 'B') {
                System.out.println("That ticket has already been purchased!");
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    private static void calculateIncome() {
        if (rows * seats < 60) {
            maxIncome = rows * seats * 10;
        } else {
            int frontRow = rows / 2 * seats;
            int backRow = rows * seats - frontRow;
            maxIncome = frontRow * 10 + backRow * 8;
        }
    }

    private static void printSeats() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int k = 1; k <= seats; k++) {  // Geändert von rows+1 zu seats
            System.out.print(k + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats; j++) {  // Geändert von seats-1 zu seats
                System.out.print(seat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void getSize() {
        System.out.println("Enter the number of rows: ");
        rows = Cinema.scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        seats = Cinema.scanner.nextInt();
        isBigCinema();

    }

    private static void isBigCinema() {
        if (rows * seats > 60) {
            isBigCinema = true;
        }
    }

}