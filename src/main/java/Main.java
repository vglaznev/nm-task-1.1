import function.Function;
import function.FunctionUtil;
import function.SimpleFunction;
import interpolation.InterpolationPolynomial;
import interpolation.builder.InterpolationPolynomialBuilder;
import reader.InterpolationConfigurationConsoleReader;
import reader.Reader;

import java.awt.*;
import java.util.Properties;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        Reader reader = new InterpolationConfigurationConsoleReader();
        Properties interpolationConfig = reader.read();

        Function interpolatedFunction = new SimpleFunction(x -> pow(x,2));

        InterpolationPolynomialBuilder builder = new InterpolationPolynomialBuilder();
        InterpolationPolynomial poly = builder
                .function(interpolatedFunction)
                .allExceptFunction(interpolationConfig)
                .build();

        Plotter plotter = new Plotter();
        plotter.addGraphic(FunctionUtil.getDotFunction(poly, -10, 10, 1000),
                "poly", Color.black);
        plotter.addGraphic(FunctionUtil.getDotFunction(interpolatedFunction, -10, 10, 1000),
                "function", Color.green);

        plotter.display();

        /*
        1. Построить полином
        2. Нарисовать исходный полином и функцию
        3. Вычислить ошибку
        4. Нарисовать ошибку
        */
    }

}
