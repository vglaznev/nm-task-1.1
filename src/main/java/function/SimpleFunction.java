package function;

import java.util.function.UnaryOperator;

public class SimpleFunction implements Function{
    private UnaryOperator<Double> function;

    public SimpleFunction(UnaryOperator<Double> function) {
        this.function = function;
    }

    @Override
    public double getY(double x) {
        return function.apply(x);
    }
}
