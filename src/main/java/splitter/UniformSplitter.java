package splitter;

import java.util.stream.IntStream;

public class UniformSplitter implements IntervalSplitter {
    @Override
    public double[] split(double beginOfInterval, double endOfInterval, int numberOfNodes) {
        double step = (endOfInterval - beginOfInterval) / numberOfNodes;
        return IntStream.range(0, numberOfNodes + 1)
                .mapToDouble(i -> beginOfInterval + i * step)
                .toArray();
    }
}
