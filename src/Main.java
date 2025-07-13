import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    int row, column;
    Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Minesweeper!");
        System.out.println("Please enter the dimensions you want to play!");
        System.out.println("Enter the number of rows you want to play! :");
        row = input.nextInt();
        System.out.println("Enter the number of columns you want to play! :");
        column = input.nextInt();

        Minesweeper mayın = new Minesweeper(row, column);
        mayın.run();
    }
}