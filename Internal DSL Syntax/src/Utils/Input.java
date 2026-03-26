package Utils;

import java.util.Scanner;
import java.io.InputStream;

public class Input extends Scanner {
    
    private static Input instance;

    private Input() {
        super(System.in);
    }

    private Input(InputStream in) {
        super(in);
    }

    public static String readLine() {
        if (instance == null) {
            instance = new Input();
        }
        return instance.nextLine().trim();
    }
}
