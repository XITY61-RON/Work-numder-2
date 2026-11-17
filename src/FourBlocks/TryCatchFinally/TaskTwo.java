package FourBlocks.TryCatchFinally;

import java.util.Scanner;

public class TaskTwo {

    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer ");
        String intString = myScanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Could not parse the input as an integer: " + intString);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
        myScanner.close();
    }

    public static void main(String[] args) {
        new TaskTwo().exceptionDemo();
    }
}