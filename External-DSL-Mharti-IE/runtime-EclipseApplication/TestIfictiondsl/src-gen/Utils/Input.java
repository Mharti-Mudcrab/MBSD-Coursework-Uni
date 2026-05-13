package Utils;

import java.util.Scanner;
import java.io.InputStream;

public class Input {
    
    private static Input instance;
    
    private Scanner scanner;

    private Input() {
        this.scanner = new Scanner(System.in);
    }

    private Input(InputStream in) {
        this.scanner = new Scanner(in);
    }

    public static String readLine() {
        if (instance == null) {
            instance = new Input();
        }
        return instance.scanner.nextLine().trim();
    }
}
