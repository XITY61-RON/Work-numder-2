package FourBlocks.TryCatchFinally;

import java.util.Scanner;

public class TaskThree {

    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer ");
        String intString = myScanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (Exception e) {                          //  НОВЫЙ пункт, добавлен ПЕРВЫМ
            System.out.println("Caught an exception: " + e);
        // } catch (NumberFormatException e) {              //  стал недостижимым
            System.out.println("Could not parse the input as an integer: " + intString);
        // } catch (ArithmeticException e) {                //  стал недостижимым
            System.out.println("Attempted division by zero");
        }
        myScanner.close();
    }

    public static void main(String[] args) {
        new TaskThree().exceptionDemo();
    }
}

/*
ОБЪЯСНЕНИЕ:
Код НЕ компилируется. Ошибка: "NumberFormatException has already been caught",
"ArithmeticException has already been caught".
Причина: NumberFormatException и ArithmeticException — наследники Exception.
catch (Exception e) первым перехватывает всё, последующие блоки недостижимы.
Java требует порядок catch от частного к общему: Exception — в КОНЕЦ.
Если оставить только catch (Exception e) — код работает, но все исключения
ловятся одним блоком, специфичные сообщения теряются.
*/
