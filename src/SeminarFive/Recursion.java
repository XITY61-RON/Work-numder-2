package SeminarFive;
import java.util.Scanner;

public class Recursion {
    public static int recursions(){
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int preiv = -1;
        while (true) {
            int currect = scanner.nextInt();
             if(currect==0 && preiv ==0){
            break;
        }
        if (currect ==1) {
            count++;
        }
        preiv = currect;
        }
        scanner.close();
        return count;
    }
    public static void main(String[] args){
        System.out.println("Введите числа (0 0 = конец):");
        System.out.println("Количество единиц: " + recursions());
    }
}
    
