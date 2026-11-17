package FourBlocks.TryCatchFinally;

import java.util.Scanner;

public class TaskSeven {
public void getKey() {
    Scanner myScanner = new Scanner(System.in);
    String key = myScanner.next();
    try {
        printDetails(key);
    } catch (Exception e) {
        System.out.println("Caught in getKey: " + e.getMessage());
    }
    myScanner.close();
}

public void printDetails(String key) throws Exception {   
    try {
        String message = getDetails(key);
        System.out.println(message);
    } catch (Exception e) {
        throw e;                                          
    }
}

private String getDetails(String key) throws Exception {  
    if (key.isEmpty()) {
        throw new Exception("Key set to empty string");
    }
    return "data for " + key;
}
}
