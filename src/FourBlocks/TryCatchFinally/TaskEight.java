package FourBlocks.TryCatchFinally;

import java.util.Scanner;

public class TaskEight {

    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        boolean success = false;

        while (!success) {
            System.out.print("Enter key: ");
            String key = myScanner.next();
            try {
                printDetails(key);
                success = true;              // вышли из цикла только при успехе
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Try again...");
            }
        }

        myScanner.close();
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {
        if (key.isEmpty()) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        new TaskEight().getKey();
    }
}

/*
ОБЪЯСНЕНИЕ:
1. getKey() больше не объявляет throws — вместо этого сам ловит исключение.
2. try-catch в getKey() перехватывает Exception из printDetails/getDetails.
3. Цикл while (!success): при пустом ключе getDetails бросает Exception,
   catch его ловит, выводит сообщение и просит ввести снова.
   success = true ставится только после успешного printDetails —
   тогда цикл завершается.

Цепочка: getDetails() бросает -> printDetails() пробрасывает (throws) ->
getKey() ловит в try-catch. Программа НЕ падает, пользователь получает
повторный шанс ввода.

Пример:
  Enter key:        (пустой ввод -> next() не примет пустую строку, см. ниже)
  Enter key: abc
  data for abc
*/
