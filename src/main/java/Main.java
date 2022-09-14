import function.Function;
import function.FunctionUtil;
import function.SimpleFunction;
import interpolation.InterpolationPolynomial;
import interpolation.builder.InterpolationPolynomialBuilder;
import reader.PropertiesFileReader;
import reader.Reader;

import java.awt.*;
import java.io.IOException;
import java.util.Properties;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new PropertiesFileReader("interpolation.properties");
        Properties interpolationConfig = reader.read();

        Function interpolatedFunction = new SimpleFunction(x -> abs(x));

        InterpolationPolynomialBuilder builder = new InterpolationPolynomialBuilder();
        InterpolationPolynomial poly = builder
                .function(interpolatedFunction)
                .allExceptFunction(interpolationConfig)
                .build();

        double beginOfInterval = Double.parseDouble(interpolationConfig.getProperty("beginOfInterval"));
        double endOfInterval = Double.parseDouble(interpolationConfig.getProperty("endOfInterval"));
        int resolution = 1000;

        Function errorFunction = new SimpleFunction(x -> abs(interpolatedFunction.getY(x) - poly.getY(x)));
        System.out.println("Максимальное значение ошибки по модулю: " + FunctionUtil.max(errorFunction, beginOfInterval, endOfInterval, 0.01));

        Plotter functionsPlotter = new Plotter();
        functionsPlotter.addGraphic(FunctionUtil.getTableFunction(poly, beginOfInterval, endOfInterval, resolution),
                "poly", Color.black);
        functionsPlotter.addGraphic(FunctionUtil.getTableFunction(interpolatedFunction, beginOfInterval, endOfInterval, resolution),
                "function", Color.green);
        functionsPlotter.addGraphic(FunctionUtil.getTableFunction(errorFunction, beginOfInterval, endOfInterval, resolution),
                "error", Color.orange);
        functionsPlotter.addDots(poly.getInterpolationGrid(), "nodes", Color.red);
        functionsPlotter.display();
    }

}
