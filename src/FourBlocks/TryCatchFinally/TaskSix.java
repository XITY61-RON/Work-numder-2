package FourBlocks.TryCatchFinally;

class ThrowsDemo {
    public void printMessage(String key) {
        String message = getDetails(key);
        System.out.println(message);
    }

    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        demo.printMessage("abc");   // правильный ключ
        demo.printMessage(null);    // нулевой ключ
    }
}
public class TaskSix {

    public void printMessage(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        TaskSix demo = new TaskSix();
        demo.printMessage("abc");
        demo.printMessage(null);
        demo.printMessage("xyz");
        System.out.println("Program finished normally");
    }
}

/*
ОБЪЯСНЕНИЕ:
printMessage() оборачивает вызов getDetails() в try-catch.
- Правильный ключ "abc" -> getDetails возвращает "data for abc" -> выводится.
- null -> getDetails бросает NullPointerException -> catch перехватывает ->
  выводится "Error: null key in getDetails". Программа НЕ падает.
- После catch выполнение продолжается: следующий вызов "xyz" работает,
  затем "Program finished normally".

Почему это правильно: getDetails() только СИГНАЛИЗИРУЕТ об ошибке (throw),
а решение, что с ней делать, принимает вызывающий (printMessage).
Исключение передаётся вверх по стеку до того, кто знает, как реагировать.
*/