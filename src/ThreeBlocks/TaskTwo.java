package ThreeBlocks;

import java.util.Scanner;

public class TaskTwo {
    static class Employee {
        String name;
        String position;
        int age;
        Employee next;
        Employee prev;
        public Employee() {}
        public Employee(String name, String position, int age) {
            this.name = name;
            this.position = position;
            this.age = age;
        }
        public void ReadfromConsol(Scanner scanner) {
            System.out.print("Введите имя: ");
            this.name = scanner.nextLine();
            System.out.print("Введите должность: ");
            this.position = scanner.nextLine();
            System.out.print("Введите возраст: ");
            this.age = scanner.nextInt();
            scanner.nextLine();
        }
        public void PrintfromConsol() {
            System.out.println("Имя: " + name + " | Должность: " + position + " | Возраст: " + age);
        }
    }
    static class CardFile {
        private Employee head;
        private Employee tail;
        public CardFile() {
            this.head = null;
            this.tail = null;
        }
        public boolean isEmpty() {
            return head == null;
        }
        public void addEmployee(Employee newEmp) {
            if (isEmpty()) {
                head = newEmp;
                tail = newEmp;
            } else {
                tail.next = newEmp;
                newEmp.prev = tail;
                tail = newEmp;
            }
            System.out.println("Служащий " + newEmp.name + " добавлен.");
        }
        public void removeEmployee(String name) {
            if (isEmpty()) {
                System.out.println("Список пуст.");
                return;
            }
            Employee current = head;
            while (current != null && !current.name.equalsIgnoreCase(name)) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("Служащий не найден.");
                return;
            }
            if (current == head) {
                head = current.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null;
                }
            } else if (current == tail) {
                tail = current.prev;
                tail.next = null;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            System.out.println("Служащий " + name + " удален.");
        }
        public void printAll() {
            if (isEmpty()) {
                System.out.println("Картотека пуста.");
                return;
            }
            System.out.println("Содержимое картотеки");
            Employee current = head;
            while (current != null) {
                current.PrintfromConsol();
                current = current.next;
            }
        }
        public void printAllReverse() {
            if (isEmpty()) {
                System.out.println("Картотека пуста.");
                return;
            }
            System.out.println("Содержимое картотеки (с конца)");
            Employee current = tail;
            while (current != null) {
                current.PrintfromConsol();
                current = current.prev;
            }
        }
        public void clear() {
            head = null;
            tail = null;
            System.out.println("Картотека очищена.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardFile cardFile = new CardFile();
        while (true) {
            System.out.println("МЕНЮ");
            System.out.println("1. Добавить (ввод с консоли)");
            System.out.println("2. Добавить (быстрый тест)");
            System.out.println("3. Удалить по имени");
            System.out.println("4. Показать всех");
            System.out.println("5. Очистить");
            System.out.println("6. Проверить на пустоту");
            System.out.println("7. Показать всех (с конца)");
            System.out.println("8. Выход");
            System.out.print("Выбор: ");
            String enter = scanner.nextLine();
            switch (enter) {
                case "1":
                    Employee emp = new Employee();
                    emp.ReadfromConsol(scanner);
                    cardFile.addEmployee(emp);
                    break;
                case "2":
                    cardFile.addEmployee(new Employee("Sasha", "Менеджер", 28));
                    cardFile.addEmployee(new Employee("Anna", "Бухгалтер", 34));
                    break;
                case "3":
                    System.out.print("Имя для удаления: ");
                    cardFile.removeEmployee(scanner.nextLine());
                    break;
                case "4":
                    cardFile.printAll();
                    break;
                case "5":
                    cardFile.clear();
                    break;
                case "6":
                    System.out.println(cardFile.isEmpty() ? "Пусто" : "Есть записи");
                    break;
                case "7":
                    cardFile.printAllReverse();
                    break;
                case "8":
                    System.out.println("Выход...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный ввод!");
            }
        }
    }
}