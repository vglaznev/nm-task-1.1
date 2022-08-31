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
}
