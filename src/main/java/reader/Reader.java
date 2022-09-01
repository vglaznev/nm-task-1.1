package reader;

import java.io.IOException;
import java.util.Properties;

public interface Reader {
    Properties read() throws IOException;
}
