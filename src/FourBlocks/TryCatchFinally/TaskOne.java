package FourBlocks.TryCatchFinally;

public class TaskOne {
    
    public void exceptionDemoCrash() {
        System.out.println(2 / 0); 
    }
    public void exceptionDemoDouble() {
        System.out.println(2.0 / 0.0); 
    }

    public void exceptionDemoCatch() {
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        TaskOne demo = new TaskOne();
        
        demo.exceptionDemoCrash(); // Вызовет ошибку и остановит программу
        // demo.exceptionDemoDouble(); // Выведет Infinity
        // demo.exceptionDemoCatch(); // Выведет Attempted division by zero
    }
}


