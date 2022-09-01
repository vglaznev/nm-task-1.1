package interpolation;

public class AitkenScheme implements InterpolationAlgorithm{
    @Override
    public double calculate(double[] nodes, double[] valuesInNodes, double x) {
        double[] polynomials = valuesInNodes.clone();
        int degree = polynomials.length - 1;
        for (int i = 0; i < degree; i++) {
            for (int j = 0; j < degree - i; j++) {
                polynomials[j] = (polynomials[j] * (nodes[i + j + 1] - x) - polynomials[j + 1] * (nodes[j] - x)) / (nodes[i + j + 1] - nodes[j]);
            }
        }
        return polynomials[0];
    }
}
