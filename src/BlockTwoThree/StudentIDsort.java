package BlockTwoThree;
import java.util.Random;
import java.util.Scanner;
import java.util.Comparator;
class Student {
    String name;
    String id;
    int mark;
    Student(String name, String id,int mark){
        this.name = name;
        this.id = id;
        this.mark = mark;
    }
    @Override 
    public String toString(){
        return name + "[" + id+"] Оценка: " + mark;
    }
}
class SortingStudentsByGPA implements Comparator<Student>{
    @Override
    public int compare(Student s1,Student s2){
        return Integer.compare(s2.mark, s1.mark); 
    }   
}
public class StudentIDsort {
    static Student generateStudent(Scanner scanner, Random random) {
    System.out.print("Имя нового студента: ");
    String name = scanner.nextLine().trim();

    char[] letters = name.toCharArray();
    for (int i = letters.length - 1; i > 0; i--) {
        int j = random.nextInt(i + 1);
        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
    }
    String two = new String(letters).substring(0, 2);
    int randInt = random.nextInt(200000) + 1000;
    int markInt = random.nextInt(4)+2;
    String id = "#ID " + randInt + two;
    return new Student(name, id, markInt);
}
static void insertionSort(Student[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Student key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].id.compareTo(key.id) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    static void printAll(Student[] arr){
        for(Student s: arr){
            System.out.println(s);
        }
    }
static void quicksort(Student[] arr, int low, int high, Comparator<Student>comparator){
    if(low<high){
        int pi = partition(arr,low,high,comparator);
        quicksort(arr, low, pi - 1, comparator);
        quicksort(arr, pi+1, high, comparator);
    }
}
static int partition(Student[] arr,int low, int high, Comparator<Student>comparator){
    Student pivot = arr[high];
    int i = (low-1);
    for(int j = low; j < high; j++ ){
        if(comparator.compare(arr[j], pivot) < 0){
            i++;
            Student temp = arr[i];
            arr[i]=arr[j];
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
        if (left[i].id.compareTo(right[j].id) <= 0) {
            result[k++] = left[i++];
        } else {
            result[k++] = right[j++];
        }
    }
    while (i < left.length) {
        result[k++] = left[i++];
    }
    while (j < right.length) {
        result[k++] = right[j++];
    }
    return result;
}
static Student[] mergeSort(Student[] arr) {
    if (arr.length <= 1) {
        return arr; 
    }
    int mid = arr.length / 2;
    Student[] left = new Student[mid];
    Student[] right = new Student[arr.length - mid];
    System.arraycopy(arr, 0, left, 0, mid);
    System.arraycopy(arr, mid, right, 0, arr.length - mid);
    left = mergeSort(left);
    right = mergeSort(right);
    return merge(left, right);
}
public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    System.out.println("Сколько студентов в системе №1?");
    int num = scanner.nextInt();
    scanner.nextLine();
    Student[] students = new Student[num];
    for(int i =0; i <num; i++){
        System.out.println("Студент №" + (i+1) +"Список 1" +"\n");
        students[i] = generateStudent(scanner, random);
    }
    System.out.println("Сколько студентов в системе №2?");
    int num1 = scanner.nextInt();
    scanner.nextLine();
    Student[] students2 = new Student[num1];
    for(int i =0; i <num1; i++){
        System.out.println("Студент №" + (i+1) + "Список 2" +"\n");
        students2[i] = generateStudent(scanner, random);
    }
        while (true) {
            System.out.println("Как вы хотите провести сортировку?");
            System.out.println("По ID - сортировка вставкой - Введите 1");
            System.out.println("ПО оценке - быстрая сортировка - Введите 2");
            System.out.println("ПО оценке - сортировка слиянием - Введите 3");
            System.out.println("Выход - Введите 4");
            String enter = scanner.nextLine();
            switch (enter) {
                case "1":
                    System.out.println("До сортировки: ");
                    printAll(students);
                    printAll(students2);
                    System.out.println("После сортировки по первой цифре ID: ");
                    insertionSort(students);
                    insertionSort(students2);
                    System.out.println("Список 1");
                    printAll(students);
                    System.out.println("Список 2");
                    printAll(students2);
                    System.out.println("Нажмите Enter для завершения просмотра");
                    scanner.nextLine();
                    break;
                case "2":
                    System.out.println("После сортировки по GPA");
                    SortingStudentsByGPA gpaComporator = new SortingStudentsByGPA();
                    System.out.println("Список 1");
                    quicksort(students, 0, students.length-1, gpaComporator);
                    printAll(students);
                    System.out.println("Список 2");
                    quicksort(students2, 0, students2.length-1, gpaComporator);
                    printAll(students2);
                    System.out.println("Нажмите Enter для завершения просмотра");
                    scanner.nextLine();
                break;
                case "3":
                   Student[] sorted1 = mergeSort(students);
                   Student[] sorted2 = mergeSort(students2);
                   Student[] merged = merge(sorted1, sorted2);
                   System.out.println("\nПЕРВЫЙ СПИСОК (отсортирован)");
                   printAll(sorted1);
                   System.out.println("\nВТОРОЙ СПИСОК (отсортирован)");
                   printAll(sorted2);
                   System.out.println("\nОБЪЕДИНЕННЫЙ ОТСОРТИРОВАННЫЙ СПИСОК");
                   printAll(merged);

                break;
                 case "4":
                    scanner.close();
                break;
                default:
                    System.out.println("Команда не распознана");
                    break;
            }
        }
    }
}