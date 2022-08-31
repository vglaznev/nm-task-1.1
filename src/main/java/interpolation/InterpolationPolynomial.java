package interpolation;

public class InterpolationPolynomial {
    private final double[] nodes;
    private final double[] valuesInNodes;
    private final InterpolationAlgorithm interpolationAlgorithm;

    public InterpolationPolynomial(double[] nodes, double[] valuesInNodes, InterpolationAlgorithm interpolationAlgorithm) {
        this.nodes = nodes;
        this.valuesInNodes = valuesInNodes;
        this.interpolationAlgorithm = interpolationAlgorithm;
    }

    public double getY(double x){
        return interpolationAlgorithm.calculate(nodes, valuesInNodes, x);
    }
}
