package reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader implements Reader {
    private String fileName;

    public PropertiesFileReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Properties read() throws IOException {
        Properties properties = new Properties();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(fileName)) {
            properties.load(in);
        }
        return properties;
    }
}
