package PracticeElevenToFourteen;

import java.util.*;
import java.text.*;

class Worker implements Comparable<Worker>{
    String firstName;
    String lastName;
    String specialty;
    int course;
    String group;
    int mark;
    Date birthDate;

    public Worker(String firstName, String lastName, String specialty, int course, String group, int mark, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.mark = mark;
        this.birthDate = birthDate;
    }

    public String getFormattedBirthDate(int style) {
        return DateFormat.getDateInstance(style).format(birthDate);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " | " + specialty + " | Курс: " + course + " | Группа: " + group + " | GPA: " + mark + " | ДР: " + birthDate;
    }

    @Override
    public int compareTo(Worker other) {
        return this.lastName.compareTo(other.lastName);
    }
}

public class Practicell {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Задание 1");
        System.out.print("Фамилия: ");
        String name = sc.nextLine();
        Date d1 = new Date();
        Thread.sleep(1000);
        Date d2 = new Date();
        System.out.println(name + " получил: " + d1 + " сдал: " + d2);

        System.out.println("\nЗадание 2");
        System.out.print("Введите дату (dd.MM.yyyy): ");
        String dateStr = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date userDate = sdf.parse(dateStr);
        Date now = new Date();
        if (userDate.after(now)) {
            System.out.println("Введенная дата в будущем");
        } else if (userDate.before(now)) {
            System.out.println("Введенная дата в прошлом");
        } else {
            System.out.println("Даты равны");
        }

        System.out.println("\nЗадание 3");
        Calendar calBday = Calendar.getInstance();
        calBday.set(2000, 0, 15); // 15 января 2000
        Worker s = new Worker("Иван", "Иванов", "IT", 3, "A1", 5, calBday.getTime());
        System.out.println("SHORT:  " + s.getFormattedBirthDate(DateFormat.SHORT));
        System.out.println("MEDIUM: " + s.getFormattedBirthDate(DateFormat.MEDIUM));
        System.out.println("FULL:   " + s.getFormattedBirthDate(DateFormat.FULL));

        System.out.println("\nЗадание 4");
        System.out.print("Год Месяц Число: ");
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        System.out.print("Часы Минуты: ");
        int h = sc.nextInt();
        int min = sc.nextInt();
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, d, h, min);
        Date dateFromCal = cal.getTime();
        System.out.println("Date: " + dateFromCal);

        System.out.println("\nЗадание 5");
        int N = 100000;
        List<Integer> al = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) al.add(i);
        System.out.println("ArrayList add: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) al.get(i);
        System.out.println("ArrayList get: " + (System.currentTimeMillis() - start) + " ms");
        List<Integer> ll = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) ll.add(i);
        System.out.println("LinkedList add: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) ll.get(i);
        System.out.println("LinkedList get: " + (System.currentTimeMillis() - start) + " ms");
        sc.close();
    }
}