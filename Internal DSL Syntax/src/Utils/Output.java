package Utils;

import java.io.PrintStream;

public class Output extends PrintStream {

    private static Output instance;

    private Output() {
        super(System.out);
    }

    private Output(PrintStream out) {
        super(out);
    }

    public static void printLine(String x) {
        if (instance == null) {
            instance = new Output();
        }
        instance.println(x);
    }
}
