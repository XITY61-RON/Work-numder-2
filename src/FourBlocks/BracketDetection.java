package FourBlocks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BracketDetection {
    public static boolean isValid(String s){
        Deque<Character> stack =new ArrayDeque<>(); //Deque - двухстор очередь(добавить и удалить с начала и конца)
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}'){
                if(stack.isEmpty()) return false;
                char open = stack.pop();
                if (c==')'&& open !='(' ||c==']'&& open !='[' ||c=='}'&& open !='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    while (true) {
        System.out.print("Введите (),[],{}: ");
        String ent = scan.nextLine();
        boolean hasBrackets = false;
        for (char c : "()[]{}".toCharArray()) {
    if (ent.indexOf(c) >= 0) {
        hasBrackets = true;
        break;
    }
}
        if (ent.isEmpty()) {
            System.out.println("В данной строке нет скобок!");
        }else if(!hasBrackets){
            System.out.println("В данной строке нет скобок!");
        } else{
            System.out.println(isValid(ent) ? "Correct" : "Error");
        }
        System.out.println("Продолжить? (+ да, - выход)");
        String enter = scan.nextLine();   
        switch (enter) {
            case "+":
                break;                    
            case "-":
                scan.close();
                return;                    
            default:
                System.out.println("Неизвестная команда, продолжаем.");
                break;
        }
    }
}
}
