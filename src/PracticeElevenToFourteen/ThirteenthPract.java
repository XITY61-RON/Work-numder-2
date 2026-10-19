package PracticeElevenToFourteen;



import java.util.*; //Сокращенный импорт всего нужного 

class Person {
    String lastName, firstName, middleName;
    Person(String l, String f, String m) { lastName = l; firstName = f; middleName = m; }
    String getFIO() {
        StringBuilder sb = new StringBuilder(lastName);
        if (firstName != null && !firstName.isEmpty()) sb.append(" ").append(firstName.charAt(0)).append(".");
        if (middleName != null && !middleName.isEmpty()) sb.append(middleName.charAt(0)).append(".");
        return sb.toString();
    }
}

class Address {
    String country, region, city, street, house, building, apartment;
    void parseSplit(String a) {
        String[] p = a.split(",");
        if (p.length >= 7) {
            country = p[0].trim(); region = p[1].trim(); city = p[2].trim();
            street = p[3].trim(); house = p[4].trim(); building = p[5].trim(); apartment = p[6].trim();
        }
    }
    void parseTokenizer(String a) {
        StringTokenizer st = new StringTokenizer(a, ",.;");
        if (st.countTokens() >= 7) {
            country = st.nextToken().trim(); region = st.nextToken().trim(); city = st.nextToken().trim();
            street = st.nextToken().trim(); house = st.nextToken().trim(); building = st.nextToken().trim(); apartment = st.nextToken().trim();
        }
    }
    public String toString() { return country + " " + region + " " + city + " " + street + " " + house + " " + building + " " + apartment; }
}

class Shirt {
    String id, description, color, size;
    Shirt(String s) {
        String[] p = s.split(",");
        id = p[0]; description = p[1]; color = p[2]; size = p[3];
    }
    public String toString() { return id + " " + description + " " + color + " " + size; }
}

public class ThirteenthPract {
    static void t1(String s) {
        System.out.println(s.charAt(s.length() - 1));
        System.out.println(s.endsWith("!!!"));
        System.out.println(s.startsWith("I like"));
        System.out.println(s.contains("Java"));
        System.out.println(s.indexOf("Java"));
        System.out.println(s.replace('а', 'о'));
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s.substring(s.indexOf("Java"), s.indexOf("Java") + 4));
    }

    static String t5(String p) {
        if (p.startsWith("8")) p = "+7" + p.substring(1);
        String code = p.startsWith("+10") ? p.substring(0, 4) : p.substring(0, 2);
        String r = p.substring(code.length());
        return code + r.substring(0, 3) + "-" + r.substring(3, 6) + "-" + r.substring(6, 10);
    }

    static String t6(String s) {
        List<String> list = new ArrayList<>(Arrays.asList(s.split(" ")));
        if (list.isEmpty()) return "";
        StringBuilder sb = new StringBuilder(list.remove(0));
        while (!list.isEmpty()) {
            char last = Character.toLowerCase(sb.charAt(sb.length() - 1));
            boolean found = false;
            for (int i = 0; i < list.size(); i++) {
                if (Character.toLowerCase(list.get(i).charAt(0)) == last) {
                    sb.append(" ").append(list.remove(i));
                    found = true;
                    break;
                }
            }
            if (!found) break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    t1("I like Java!!!");
    
    System.out.println(new Person("Иванов", "Иван", "Иванович").getFIO());
    System.out.println(new Person("Петров", null, "").getFIO());
    System.out.println();
    
    Address ad = new Address();
    ad.parseSplit("Р, МО, М, Т, 1, 2, 3");
    System.out.println(ad);
    ad.parseTokenizer("С; К. Л, Г; 5. 6, 7");
    System.out.println(ad);
    System.out.println();
    
    String[] arr = {"S001,Black,Black,XL", "S002,Blue,Blue,L"};
    for (String s : arr) System.out.println(new Shirt(s));
    System.out.println();
    
    System.out.println(t5("89175655655"));
    System.out.println(t5("+104289652211"));
    System.out.println();
    
    System.out.println(t6("apple elephant tree cat"));
    System.out.println("Нажмите на Enter для выхода из режима просмотра: ");
}
}
