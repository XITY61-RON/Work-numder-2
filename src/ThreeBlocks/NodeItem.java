package ThreeBlocks;

import java.io.IOException;
import java.util.Scanner;

    class Employee{
        String name;
        String position;
        int age;
        Employee next;
        public Employee(){
            //Конструктор для чтения
        }
        public Employee(String name, String position, int age){
            this.name = name;
            this.position = position;
            this.age = age;
        } // Конструктор для быстрого создания
        public void ReadfromConsol(Scanner scanner){
            System.out.println("Введите имя: ");
            this.name = scanner.nextLine();
            System.out.println("Введите должность: ");
            this.position = scanner.nextLine();
            System.out.println("Введите возраст: ");
            this.age = scanner.nextInt();
            scanner.nextLine();
        }
        public void PrintfromConsol(){
            System.out.println("Имя "+name+"|"+"Должность "+position+"|"+"Возраст "+ age);
        }
    }
    class Cardfiles{
        private Employee head;
        public Cardfiles(){
            this.head = null;
        }
        public boolean isEmpty(){
            return head == null;
        }
        public void addCards(Employee newEmployee){
            if(isEmpty()){
                head = newEmployee;
            }

        }
    }
    
    public class NodeItem { //Класс тестер выполняет класс NodeItem
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DaughtersNodeItem nodeitem = new DaughtersNodeItem("info_node.txt");
        try{
            nodeitem.initializeFile();
        } catch(IOException e){
            System.out.println("Error:" + e.getMessage());
        }
        while (true) {
            System.out.println("Что нужно выполнить?");
            System.out.println("Задание 1.1");
            System.out.println("Быстрый конструктор - 1");
            System.out.println("Создать пустой - 2 ");
            System.out.println("Задание 1.2");
            System.out.println("Переход к спискам - 3");
            System.out.println("Выйти - 4");
            String enter = scanner.nextLine();
            switch (enter) {
                case "1":
                    System.out.println("Добавление через конструктор");
                    Employee emp1 = new Employee("Sasha", "Менеджер", 28);
                    emp1.PrintfromConsol();
                    scanner.nextLine();
                    break;
                case "2":
                    System.out.println("Добавление через консоль");
                    Employee emp2 = new Employee();
                    emp2.ReadfromConsol(scanner);
                    emp2.PrintfromConsol();
                    scanner.nextLine();
                    break;
                case "3":
                    DaughtersNodeItem.daughtersNodeItem(scanner);
                    break;
                case "4":
                    scanner.close();
                    break;
                default:
                    System.out.println("Нужно ввести цифру 1 или 2 или 3 или 4");
                    break;
            }
        }
    }
}
