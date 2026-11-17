package FourBlocks.TryCatchFinally;

public class TaskFive {

    public void getDetails(String key) {
        try {
            if (key == null) {
                throw new NullPointerException("null key in getDetails");
            }
            System.out.println("data for " + key);
        } catch (NullPointerException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }

    public void printMessage(String key) {
        try {
            String message = getDetails2(key);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println("Error in printMessage: " + e.getMessage());
        }
    }

    public String getDetails2(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        TaskFive demo = new TaskFive();

        System.out.println("Step 1: throw without catch");
        try {
            demo.getDetails2(null);
        } catch (NullPointerException e) {
            System.out.println("Uncaught would be: " + e);
        }

        System.out.println("Step 2: catch inside method");
        demo.getDetails(null);

        System.out.println("Listing 18.6: throw propagates to caller");
        demo.printMessage(null);
        demo.printMessage("abc");
    }
}

/*
ОБЪЯСНЕНИЕ:
Шаг 1: getDetails2(null) бросает NullPointerException("null key in getDetails").
       Без перехвата программа падает со стек-трейсом.

Шаг 2: getDetails(null) ловит исключение ВНУТРИ метода через try-catch.
       Программа не падает, выводит "Caught: null key in getDetails".
       НО это плохая практика: метод сам бросает и сам ловит, вызывающий
       не узнаёт об ошибке. Исключение теряет смысл — оно должно передавать
       ошибку вверх по стеку тому, кто знает, что с ней делать.

Листинг 18.6: getDetails2() бросает, printMessage() ловит и обрабатывает.
       Это правильнее: решение об обработке принимает вызывающий код.
*/