package interpolation;

import function.DotFunction;
import function.Function;

public class InterpolationPolynomial implements Function {
    private final double[] nodes;
    private final double[] valuesInNodes;
    private final InterpolationAlgorithm interpolationAlgorithm;

    public InterpolationPolynomial(double[] nodes, double[] valuesInNodes, InterpolationAlgorithm interpolationAlgorithm) {
        this.nodes = nodes;
        this.valuesInNodes = valuesInNodes;
        this.interpolationAlgorithm = interpolationAlgorithm;
    }

    @Override
    public double getY(double x){
        return interpolationAlgorithm.calculate(nodes, valuesInNodes, x);
    }

    public DotFunction geInterpolationGrid(){
        return new DotFunction(nodes, valuesInNodes);
    }
}
