package SeminarFive;

import java.util.Scanner;

public class ReversNum {
    public static int revers(int n, int lenght){
     if (n<10) {
        return n;
     }
     int last = n%10;
     int rest = revers(n/10, lenght-1);
     return last * result(lenght-1)+rest;

    }
    public static int result(int k){
        if(k ==0 ) 
            return 1;
        return 10 * result(k-1);
    }
    public static int lenghts(int n){
        if (n<10) return 1;
        return 1 + lenghts(n/10);
    }
    public static void main(String[] args){
        Scanner num = new Scanner(System.in);
        System.out.println("Введите число n");
        int nums = num.nextInt();
        int result = revers(nums, lenghts(nums));
        System.out.println("Отзеркаленное число:" + result);
        num.close();
    }

}
