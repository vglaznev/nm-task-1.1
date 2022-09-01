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
import static java.lang.Math.sin;

public class Main {
    public static void main(String[] args) {
        Reader reader = new InterpolationConfigurationConsoleReader();
        Properties interpolationConfig = reader.read();

        Function interpolatedFunction = new SimpleFunction(x -> sin(x));

        InterpolationPolynomialBuilder builder = new InterpolationPolynomialBuilder();
        InterpolationPolynomial poly = builder
                .function(interpolatedFunction)
                .allExceptFunction(interpolationConfig)
                .build();

        double beginOfRendering = Double.parseDouble(interpolationConfig.getProperty("beginOfInterval"));
        double endOfRendering = Double.parseDouble(interpolationConfig.getProperty("endOfInterval"));
        int resolution = 1000;

        Plotter plotter = new Plotter();
        plotter.addGraphic(FunctionUtil.getDotFunction(poly, beginOfRendering, endOfRendering, resolution),
                "poly", Color.black);
        plotter.addGraphic(FunctionUtil.getDotFunction(interpolatedFunction, beginOfRendering, endOfRendering, resolution),
                "function", Color.green);
        plotter.addDots(poly.geInterpolationGrid(), "nodes");
        plotter.display();

        /*
        1. Построить полином +
        2. Нарисовать исходный полином и функцию +
        3. Вычислить ошибку
        4. Нарисовать ошибку
        */
    }

}
