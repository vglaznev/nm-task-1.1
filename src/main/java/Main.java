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
    private static final int PLOTTER_RESOLUTION = 1000;
    private static final String INTERPOLATION_CONFIG_FILE_NAME = "interpolation.properties";

    public static void main(String[] args) throws IOException {
        Reader reader = new PropertiesFileReader(INTERPOLATION_CONFIG_FILE_NAME);
        Properties interpolationConfig = reader.read();

        Function interpolatedFunction = new SimpleFunction(x -> abs(x));

        InterpolationPolynomialBuilder builder = new InterpolationPolynomialBuilder();
        InterpolationPolynomial poly = builder
                .function(interpolatedFunction)
                .allExceptFunction(interpolationConfig)
                .build();

        double beginOfInterval = Double.parseDouble(interpolationConfig.getProperty("beginOfInterval"));
        double endOfInterval = Double.parseDouble(interpolationConfig.getProperty("endOfInterval"));

        Function errorFunction = new SimpleFunction(x -> abs(interpolatedFunction.getY(x) - poly.getY(x)));
        System.out.println("Максимальное значение ошибки по модулю: " + FunctionUtil.max(errorFunction, beginOfInterval, endOfInterval, 0.01));

        Plotter functionsPlotter = new Plotter();
        functionsPlotter.addGraphic(FunctionUtil.getTableFunction(interpolatedFunction, beginOfInterval, endOfInterval, PLOTTER_RESOLUTION),
                "Исходная функция", Color.green);
        functionsPlotter.addGraphic(FunctionUtil.getTableFunction(poly, beginOfInterval, endOfInterval, PLOTTER_RESOLUTION),
                "Интерполяционный полином", Color.black);
        functionsPlotter.addGraphic(FunctionUtil.getTableFunction(errorFunction, beginOfInterval, endOfInterval, PLOTTER_RESOLUTION),
                "График погрешности", Color.orange);

        functionsPlotter.addDots(poly.getInterpolationGrid(), "Узлы интерполяции", Color.red);
        functionsPlotter.display();
    }

}
