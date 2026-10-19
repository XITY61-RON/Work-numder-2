package PracticeElevenToFourteen;

import java.util.*;
import java.util.regex.*;

interface Filter {
    boolean apply(Object o);
}

public class FourteenthPract {

    static void task2(String s) {
        System.out.println(s.matches("abcdefghijklmnopqrstuv18340"));
    }

    static void task3(String text) {
        Pattern p = Pattern.compile("\\b\\d+(\\.\\d+)?\\s?(USD|RUB|EU)\\b");
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    static void task4(String text) {
        Pattern p = Pattern.compile("\\d+(?!\\s*\\+)");
        Matcher m = p.matcher(text);
        System.out.println(m.find());
    }

    static void task5(String date) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19\\d{2}|[2-9]\\d{3})$";
        if (date.matches(regex)) {
            String[] parts = date.split("/");
            int d = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            Calendar cal = Calendar.getInstance();
            cal.setLenient(false);
            cal.set(y, m - 1, d);
            try {
                cal.getTime();
                System.out.println(true);
            } catch (Exception e) {
                System.out.println(false);
            }
        } else {
            System.out.println(false);
        }
    }

    static void task6(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        System.out.println(email.matches(regex) || email.matches("^[a-zA-Z0-9._%+-]+@localhost$"));
    }

    static void task7(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z0-9_]{8,}$";
        System.out.println(password.matches(regex));
    }

    static Object[] filter(Object[] arr, Filter f) {
        List<Object> res = new ArrayList<>();
        for (Object o : arr) {
            if (f.apply(o)) {
                res.add(o);
            }
        }
        return res.toArray();
    }

    static void task9(String text) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c) && c >= 'а' && c <= 'я') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("2:");
        task2("abcdefghijklmnopqrstuv18340");
        task2("abcdefghijklmnoasdfasdpqrstuv18340");

        System.out.println("3:");
        task3("Цены: 25.98 USD, 100 RUB, 44 ERR, 0.004 EU.");
        
        System.out.println("4:");
        task4("(1 + 8) – 9 / 4");
        task4("6 / 5 – 2 * 9");

        System.out.println("5:");
        task5("29/02/2000");
        task5("29/02/2001");
        task5("1/1/1899");

        System.out.println("6:");
        task6("user@example.com");
        task6("myhost@@@com.ru");
        task6("root@localhost");

        System.out.println("7:");
        task7("F032_Password");
        task7("smart_pass");

        System.out.println("8:");
        Object[] nums = {1, "строка", 2.5, "Java", 10, true};
        Object[] filtered = filter(nums, o -> o instanceof String);
        System.out.println(Arrays.toString(filtered));

        System.out.println("9:");
        task9("Привет мир, это тестовый текст для словаря");
        
        sc.close();
    }
}

