package ThreeBlocks;

import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
class CardFile {
    private Employee head;  
    public CardFile() {
        this.head = null; 
    }
    public boolean isEmpty() {
        return head == null;
    }
     public Employee getHead() {
        return head;
    }
    public void addEmployee(Employee newEmp) {
        if (isEmpty()) {
            head = newEmp;
        } else {
            Employee current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newEmp;
        }
        System.out.println("Служащий " + newEmp.name + " добавлен.");
    }
    public void removeEmployee(String name) {
        if (isEmpty()) {
            System.out.println("Список пуст, некого удалять.");
            return;
        }
        if (head.name.equalsIgnoreCase(name)) {
            head = head.next;
            System.out.println("Служащий " + name + " удален.");
            return;
        }
        Employee current = head;
        while (current.next != null && !current.next.name.equalsIgnoreCase(name)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Служащий " + name + " удален.");
        } else {
            System.out.println("Служащий с именем " + name + " не найден.");
        }
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
    public void clear() {
        head = null;
        System.out.println("Картотека полностью очищена.");
    }
}
public class DaughtersNodeItem {
    private final Path filePath;
    public DaughtersNodeItem(String filename){
        this.filePath = Paths.get(filename);
    }
     public void initializeFile() throws IOException {
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
            System.out.println("Создан файл: " + filePath.toAbsolutePath());
        } else {
            System.out.println("Файл уже существует: " + filePath.toAbsolutePath());
        }
    }
    public void saveToFile(CardFile cardFile) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(filePath))) {
            Employee current = cardFile.getHead();
            while (current != null) {
                writer.println(current.name + ";" + current.position + ";" + current.age);
                current = current.next;
            }
            System.out.println("Картотека сохранена в файл: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
    public void loadFromFile(CardFile cardFile) {
        if (!Files.exists(filePath)) {
            System.out.println("Файл " + filePath + " не найден, загрузка пропущена.");
            return;
        }
        try {
            int count = 0;
            for (String line : Files.readAllLines(filePath)) {
                if (line.isBlank()) continue;
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    Employee emp = new Employee(parts[0], parts[1], Integer.parseInt(parts[2].trim()));
                    cardFile.addEmployee(emp);
                    count++;
                }
            }
            System.out.println("Загружено записей из файла: " + count);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public static void daughtersNodeItem(Scanner scanner){
        CardFile cardFile = new CardFile();
        DaughtersNodeItem instance = new DaughtersNodeItem("info_node.txt");
        instance.loadFromFile(cardFile);


        while (true) {
            System.out.println("\nМЕНЮ КАРТОТЕКИ");
            System.out.println("1. Добавить служащего");
            System.out.println("2. Удалить служащего по имени");
            System.out.println("3. Показать всех");
            System.out.println("4. Очистить картотеку");
            System.out.println("5. Проверить на пустоту");
            System.out.println("6. Выход");
            System.out.print("Выбор: ");
            
            String enter = scanner.nextLine();
            switch (enter) {
                case "1":
                    Employee emp = new Employee();
                    emp.ReadfromConsol(scanner);
                    cardFile.addEmployee(emp);
                    scanner.nextLine();
                    break;
                case "2":
                    System.out.print("Введите имя для удаления: ");
                    String nameToDelete = scanner.nextLine();
                    cardFile.removeEmployee(nameToDelete);
                    break;
                case "3":
                    cardFile.printAll();
                    scanner.nextLine();
                    break;
                case "4":
                    cardFile.clear();
                    scanner.nextLine();
                    break;
                case "5":
                    if (cardFile.isEmpty()) {
                        System.out.println("Картотека пуста.");
                    } else {
                        System.out.println("В картотеке есть записи.");
                    }
                    scanner.nextLine();
                    break;
                case "6":
                    instance.saveToFile(cardFile);
                    System.out.println("Выход");
                    return;
                default:
                    System.out.println("Неверный ввод!");
                    break;
            }
        }
    }
    
}

