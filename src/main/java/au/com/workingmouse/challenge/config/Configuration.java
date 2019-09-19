package au.com.workingmouse.challenge.config;

import lombok.Getter;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class Configuration {

    private static final Logger LOGGER = Logger.getLogger(Configuration.class);

    private static final String CONFIG_FILE = "config.properties";

    @Getter
    private static File importFile;

    public static void load() {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL propertyFileUrl = classLoader.getResource(CONFIG_FILE);

        Properties properties = new Properties();
        InputStream input = null;

        try {
            input = propertyFileUrl.openStream();

            // load a properties file
            properties.load(input);

            importFile = new File(classLoader.getResource(properties.getProperty("csv.file.path")).getFile());

        } catch (IOException e) {
            LOGGER.error("Failed to load properties", e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                   LOGGER.error("Failed to close properties file", e);
                }
            }
        }
    }
}
