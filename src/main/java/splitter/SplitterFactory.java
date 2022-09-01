package splitter;

import java.util.Set;

public class SplitterFactory {
    private static Set<String> chebyshevSplitterIdentifiers = Set.of("chebyshev", "чебышев", "чебышёв");
    private static Set<String> uniformSplitterIdentifiers = Set.of("uniform", "равномерное");

    public static IntervalSplitter getSplitter(String splitterType) {
        String splitterTypeLower = splitterType.toLowerCase();
        if (chebyshevSplitterIdentifiers.contains(splitterTypeLower)) {
            return new ChebyshevSplitter();
        } else if (uniformSplitterIdentifiers.contains(splitterTypeLower)) {
            return new UniformSplitter();
        } else {
            throw new IllegalArgumentException("There is no such splitter!");
        }
    }
}
