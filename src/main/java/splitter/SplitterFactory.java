package splitter;

import config.Config;

import java.util.Set;

public class SplitterFactory {
    private static Set<String> chebyshevSplitterIdentifiers;
    private static Set<String> uniformSplitterIdentifiers;

    static {
        chebyshevSplitterIdentifiers = Set.of(Config.getProperty("splitter.chebyshev.name").split("#"));
        uniformSplitterIdentifiers = Set.of(Config.getProperty("splitter.uniform.name").split("#"));
    }

    public static IntervalSplitter getSplitter(String splitterType) {
        String splitterTypeLower = splitterType.toLowerCase();
        if (chebyshevSplitterIdentifiers.contains(splitterTypeLower)) {
            return new ChebyshevSplitter();
        } else if (uniformSplitterIdentifiers.contains(splitterTypeLower)) {
            return new UniformSplitter();
        } else {
            throw new IllegalArgumentException("Нет такого разбиения");
        }
    }
}
