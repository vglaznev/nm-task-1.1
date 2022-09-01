package function;

import splitter.IntervalSplitter;
import splitter.UniformSplitter;

import java.util.Arrays;

public class FunctionUtil {
    public static DotFunction getDotFunction(Function function, double beginOfInterval, double endOfInterval, int numberOfDots){
        IntervalSplitter splitter = new UniformSplitter();
        double[] x = splitter.split(beginOfInterval, endOfInterval, numberOfDots);
        double[] y = Arrays.stream(x).map(function::getY).toArray();
        return new DotFunction(x, y);
    }

    public static double maxValue(Function function, double beginOfInterval, double endOfInterval, double step){
        double max = function.getY(beginOfInterval);
        double value;
        for (double x = beginOfInterval; x <= endOfInterval; x += step) {
            value = function.getY(x);
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
