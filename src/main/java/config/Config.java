package config;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Properties defaultProps = new Properties();
    static {
        try {
            InputStream in = Config.class
                    .getClassLoader()
                    .getResourceAsStream("configuration.properties");
            defaultProps.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return defaultProps.getProperty(key);
    }
}
