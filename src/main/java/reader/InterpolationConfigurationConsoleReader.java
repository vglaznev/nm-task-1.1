package reader;

import java.util.Properties;
import java.util.Scanner;

public class InterpolationConfigurationConsoleReader implements Reader {
    @Override
    public Properties read() {
        Scanner scanner = new Scanner(System.in);
        Properties properties = new Properties();
        System.out.println("Введите левую границу интервала: ");
        properties.setProperty("beginOfInterval", scanner.next());
        System.out.println("Введите правую границу интервала: ");
        properties.setProperty("endOfInterval", scanner.next());
        System.out.println("Введите степень интерполяционного полинома: ");
        properties.setProperty("degree", scanner.next());
        System.out.println("Введите метод разбиения отрезка: ");
        properties.setProperty("splitter", scanner.next());
        return properties;
    }
}
