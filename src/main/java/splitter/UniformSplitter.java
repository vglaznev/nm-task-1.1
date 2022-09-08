package splitter;

import java.util.stream.IntStream;

public class UniformSplitter implements IntervalSplitter {
    @Override
    public double[] split(double beginOfInterval, double endOfInterval, int numberOfNodes) {
        double step = (endOfInterval - beginOfInterval) / (numberOfNodes - 1);
        return IntStream.range(0, numberOfNodes)
                .mapToDouble(i -> beginOfInterval + i * step)
                .toArray();
    }
}
