package PracticeTen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

class Student implements Comparable<Student> {
    String firstName;
    String lastName;
    String specialty;
    int course;
    String group;
    int mark;
    public Student(String firstName, String lastName, String specialty, int course, String group, int mark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.mark = mark;
    }
    public String getFirstName() { 
        return firstName; 
    }
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }
    public String getLastName() {
         return lastName; 
        }
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }
    public String getSpecialty() {
         return specialty; 
        }
    public void setSpecialty(String specialty) { 
        this.specialty = specialty; 
    }
    public int getCourse() { 
        return course; 
    }
    public void setCourse(int course) {
         this.course = course; 
        }
    public String getGroup() { 
        return group; 
    }
    public void setGroup(String group) { 
        this.group = group; 
    }
    public int getMark() {
         return mark; 
        }
    public void setMark(int mark) {
         this.mark = mark; 
        }
    @Override
    public String toString() {
        return lastName + " " + firstName + " | " + specialty + " | Курс: " + course + " | Группа: " + group + " | GPA: " + mark;
    }

    @Override
    public int compareTo(Student other) {
        return this.lastName.compareTo(other.lastName);
    }
}
class SortingStudentsByGPA implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s2.getMark(), s1.getMark());
    }
}
public class SortStudentsByGPA {
    static Student[] iDNumber;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Сколько студентов в первом списке? ");
        int size1 = scanner.nextInt();
        setArray(size1, random);
        System.out.println("\nИсходный массив:");
        outArray(iDNumber);
        System.out.println("\nБыстрая сортировка по GPA (убывание):");
        quicksort(iDNumber, 0, iDNumber.length - 1, new SortingStudentsByGPA());
        outArray(iDNumber);
        System.out.println("\nСортировка по курсу (возрастание):");
        Arrays.sort(iDNumber, Comparator.comparingInt(Student::getCourse));
        outArray(iDNumber);
        System.out.print("\nСколько студентов во втором списке? ");
        int size2 = scanner.nextInt();
        Student[] secondArray = new Student[size2];
        for (int i = 0; i < size2; i++) {
            secondArray[i] = createRandomStudent(random);
        }
        Student[] sorted1 = mergeSort(iDNumber);
        Student[] sorted2 = mergeSort(secondArray);
        Student[] merged = merge(sorted1, sorted2);        
        System.out.println("\nОбъединенный отсортированный список (по фамилии):");
        outArray(merged);
        scanner.close();
    }
    static void setArray(int size, Random random) {
        iDNumber = new Student[size];
        for (int i = 0; i < size; i++) {
            iDNumber[i] = createRandomStudent(random);
        }
    }
    static void outArray(Student[] arr) {
        for (Student s : arr) {
            System.out.println(s);
        }
    }
    static void quicksort(Student[] arr, int low, int high, Comparator<Student> comparator) {
        if (low < high) {
            int pi = partition(arr, low, high, comparator);
            quicksort(arr, low, pi - 1, comparator);
            quicksort(arr, pi + 1, high, comparator);
        }
    }
    static int partition(Student[] arr, int low, int high, Comparator<Student> comparator) {
        Student pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(arr[j], pivot) < 0) {
                i++;
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Student temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    static Student[] merge(Student[] left, Student[] right) {
        Student[] result = new Student[left.length + right.length];
        int i = 0, j = 0, k = 0;   
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
        return result;
    }
    static Student[] mergeSort(Student[] arr) {
        if (arr.length <= 1) return arr;
        int mid = arr.length / 2;
        Student[] left = Arrays.copyOfRange(arr, 0, mid);
        Student[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }
    static Student createRandomStudent(Random random) {
        String[] names = {"Иван", "Петр", "Анна", "Мария", "Олег"};
        String[] surnames = {"Иванов", "Петров", "Сидорова", "Смирнов", "Кузнецов"};
        String[] specs = {"IT", "Math", "Physics", "Economy"};
        String[] groups = {"A1", "B2", "C3"};
        return new Student(
            names[random.nextInt(names.length)],
            surnames[random.nextInt(surnames.length)],
            specs[random.nextInt(specs.length)],
            random.nextInt(4) + 1,
            groups[random.nextInt(groups.length)],
            random.nextInt(4) + 2
        );
    }
}

