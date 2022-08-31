import splitter.ChebyshevSplitter;
import splitter.SplitterFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(SplitterFactory.getSplitter(scanner.next()));
    }

}
