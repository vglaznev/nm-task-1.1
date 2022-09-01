package splitter;

import java.util.stream.IntStream;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class ChebyshevSplitter implements IntervalSplitter{
    @Override
    public double[] split(double beginOfInterval, double endOfInterval, int numberOfNodes) {
        double centerOfInterval = (beginOfInterval + endOfInterval) / 2;
        double radiusOfInterval = (endOfInterval - beginOfInterval) / 2;
        double coefficientInChebyshevRoot = PI / (2 * numberOfNodes + 2);

        return IntStream
                .range(0, numberOfNodes + 1)
                .mapToDouble(i -> centerOfInterval - radiusOfInterval * cos((2 * i + 1) * coefficientInChebyshevRoot))
                .toArray();
    }
}
