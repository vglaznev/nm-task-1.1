import function.FunctionUtil;
import function.SimpleFunction;
import interpolation.AitkenScheme;
import interpolation.InterpolationPolynomial;
import interpolation.builder.InterpolationPolynomialBuilder;
import splitter.SplitterFactory;

import java.awt.*;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        InterpolationPolynomialBuilder builder = new InterpolationPolynomialBuilder();
        InterpolationPolynomial poly = builder.function(new SimpleFunction(x -> pow(x,2)))
                .interpolationAlgorithm(new AitkenScheme())
                .intervalBounds(-3, 3)
                .degree(2)
                .splitBy(SplitterFactory.getSplitter("Chebyshev"))
                .build();
        System.out.println(poly.getY(5));

        Plotter plotter = new Plotter();
        plotter.addGraphic(FunctionUtil.getDotFunction(poly, -10, 10, 1000),
                "poly", Color.black);
        plotter.display();
        /*
        1. Построить полином
        2. Нарисовать исходный полином и функцию
        3. Вычислить ошибку
        4. Нарисовать ошибку
        */
    }

}
