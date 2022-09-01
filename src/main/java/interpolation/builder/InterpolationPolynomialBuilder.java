package interpolation.builder;

import function.SimpleFunction;
import interpolation.AitkenScheme;
import interpolation.InterpolationAlgorithm;
import interpolation.InterpolationPolynomial;
import splitter.IntervalSplitter;
import splitter.SplitterFactory;

import java.util.Arrays;
import java.util.Properties;

public class InterpolationPolynomialBuilder {
    private SimpleFunction function;
    private InterpolationAlgorithm interpolationAlgorithm;
    private IntervalSplitter splitter;
    private Double beginOfInterval;
    private Double endOfInterval;
    private Integer degree;

    public InterpolationPolynomialBuilder function(SimpleFunction function) {
        this.function = function;
        return this;
    }

    public InterpolationPolynomialBuilder splitBy(IntervalSplitter splitter) {
        this.splitter = splitter;
        return this;
    }

    public InterpolationPolynomialBuilder degree(int degree) {
        this.degree = degree;
        return this;
    }

    public InterpolationPolynomialBuilder intervalBounds(double beginOfInterval, double endOfInterval) {
        this.beginOfInterval = beginOfInterval;
        this.endOfInterval = endOfInterval;
        return this;
    }

    public InterpolationPolynomialBuilder interpolationAlgorithm(InterpolationAlgorithm interpolationAlgorithm) {
        this.interpolationAlgorithm = interpolationAlgorithm;
        return this;
    }

    public InterpolationPolynomialBuilder allExceptFunction(Properties properties){
        interpolationAlgorithm = (InterpolationAlgorithm) properties.getOrDefault("interpolationAlgorithm", null);
        splitter = SplitterFactory.getSplitter(properties.getProperty("splitter"));
        beginOfInterval = Double.parseDouble(properties.getProperty("beginOfInterval"));
        endOfInterval = Double.parseDouble(properties.getProperty("endOfInterval"));
        degree = Integer.parseInt(properties.getProperty("degree"));
        return this;
    }

    private boolean checkNullFields() {
        return function == null || splitter == null || beginOfInterval == null || endOfInterval == null || degree == null;
    }

    public InterpolationPolynomial build() {
        if(interpolationAlgorithm == null){
            interpolationAlgorithm = new AitkenScheme();
        }
        if (checkNullFields()) {
            throw new NullPointerException("Please set all parameters.");
        }
        double[] nodes = splitter.split(beginOfInterval, endOfInterval, degree + 1);
        double[] functionValueInNodes = Arrays.stream(nodes).map(function::getY).toArray();

        return new InterpolationPolynomial(nodes, functionValueInNodes, interpolationAlgorithm);
    }
}
