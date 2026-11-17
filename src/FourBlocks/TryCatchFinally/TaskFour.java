package FourBlocks.TryCatchFinally;

import java.util.Scanner;

public class TaskFour {
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
        } finally {
            System.out.println("Finally block executed");
            myScanner.close();
        }
    }

    public static void main(String[] args) {
        new TaskFour().exceptionDemo();
    }
}
/*
ОБЪЯСНЕНИЕ:
finally выполняется ВСЕГДА — и при успехе, и при перехваченном исключении,
и даже при неперехваченном (перед аварийным завершением).
Ввод "1"      -> "2" + "Finally block executed"
Ввод "0"      -> "Attempted division by zero" + "Finally block executed"
Ввод "Qwerty" -> "Could not parse..." + "Finally block executed"
myScanner.close() перенесён в finally — ресурс закрывается гарантированно
при любом сценарии, а не только при штатном выходе.
*/