package interpolation;

public interface InterpolationAlgorithm {
    double calculate(double[] nodes, double[] valuesInNodes, double x);
}
