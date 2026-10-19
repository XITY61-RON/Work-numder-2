package SeminarFive;

import java.util.Scanner;

public class NotTwoZero {
    public static long notzero(int n){
        long results = 1;
        for (int i = 2; i <= n; i++) {
            results *= i;
        }
        return results;
    }
    public static long combinations(int n, int k) {
        if (k < 0 || k > n)
            return 0;
        return notzero(n) / (notzero(k) * notzero(n - k));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите a (нулей): ");
        int a = sc.nextInt();
        System.out.print("Введите b (единиц): ");
        int b = sc.nextInt();
        long result = combinations(b + 1, a);
        System.out.println("Количество последовательностей: " + result);
        sc.close();
    }

}
