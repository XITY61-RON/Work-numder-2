package FourBlocks;

import java.util.Arrays;
import java.util.Scanner;

class InvalidInnException extends Exception {
    public InvalidInnException(String message) { super(message); }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) { super(message); }
}

interface Student {
    String getFullName();
    double getAverage();
}

class StudentImpl implements Student {
    private String fullName;
    private double average;
    public StudentImpl(String fullName, double average) {
        this.fullName = fullName;
        this.average = average;
    }
    @Override public String getFullName() { return fullName; }
    @Override public double getAverage() { return average; }
    @Override public String toString() { return fullName + " (" + average + ")"; }
}

class Client {
    private String fullName;
    private String inn;
    public Client(String fullName, String inn) throws InvalidInnException {
        if (inn == null || inn.length() != 12) {
            throw new InvalidInnException("Invalid INN for client " + fullName + ": " + inn);
        }
        for (char c : inn.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidInnException("Invalid INN for client " + fullName + ": " + inn);
            }
        }
        this.fullName = fullName;
        this.inn = inn;
    }
    public String getFullName() { return fullName; }
    public String getInn() { return inn; }
}

public class INN {

    public static void sortByAverage(Student[] students) {
        Arrays.sort(students, (a, b) -> Double.compare(b.getAverage(), a.getAverage()));
    }

    public static Student findByName(Student[] students, String name) throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getFullName().equalsIgnoreCase(name)) return s;
        }
        throw new StudentNotFoundException("Student not found: " + name);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full name: ");
        String name = sc.nextLine();
        System.out.print("Enter INN (12 digits): ");
        String inn = sc.nextLine();

        try {
            Client client = new Client(name, inn);
            System.out.println("Order placed for " + client.getFullName() + ", INN = " + client.getInn());
        } catch (InvalidInnException e) {
            System.out.println("Order failed: " + e.getMessage());
        }

        Student[] students = {
            new StudentImpl("Ivanov Ivan", 4.5),
            new StudentImpl("Petrov Petr", 3.8),
            new StudentImpl("Sidorov Sidr", 4.9),
            new StudentImpl("Smirnova Anna", 4.1)
        };

        sortByAverage(students);
        System.out.println("Sorted by average:");
        for (Student s : students) System.out.println("  " + s);

        System.out.print("Enter name to search: ");
        String search = sc.nextLine();

        try {
            System.out.println("Found: " + findByName(students, search));
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
