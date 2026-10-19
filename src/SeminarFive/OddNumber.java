package SeminarFive;

import java.util.Scanner;

public class OddNumber {
    static Scanner num = new Scanner(System.in);
    public static void printNumodd() {
        int numbers = num.nextInt();
        if (numbers == 0) {
            return;
        }
        printNumodd();
        if (numbers % 2 != 0) {
            System.out.println("Полученое значение: " + numbers);
        }
    }
    public static void main(String[] args) {
        printNumodd();
    }
}