package function;

import splitter.IntervalSplitter;
import splitter.UniformSplitter;

import java.util.Arrays;
import java.util.stream.Stream;

public class FunctionUtil {
    public static TableFunction getTableFunction(Function function, double beginOfInterval, double endOfInterval, int numberOfDots) {
        IntervalSplitter splitter = new UniformSplitter();
        double[] x = splitter.split(beginOfInterval, endOfInterval, numberOfDots);
        double[] y = Arrays.stream(x).map(function::getY).toArray();
        return new TableFunction(x, y);
    }

    public static double max(Function function, double beginOfInterval, double endOfInterval, double step) {
        return Stream.iterate(beginOfInterval, n -> n <= endOfInterval, n -> n + step)
                .map(function::getY)
                .max(Double::compare).get();
    }
}
