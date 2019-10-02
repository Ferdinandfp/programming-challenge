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
    //The @Getter feature is a Project Lombok feature and I have not made any changes to this project to include it.
    //Created a getter function to be able to continue and get something working.
    public static File getImportFile(){
        return importFile;
    }
    
    public static void load() {
        //Changed classLoader to use the Thread method as classLoader was not able 
        //to find the resource using maven - the dev environemnt on my PC, win7.
        URL propertyFileUrl = Thread.currentThread().getContextClassLoader().getResource(CONFIG_FILE);      
        if (propertyFileUrl == null) {
            throw new IllegalArgumentException("Could not find the file.");
        }
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = propertyFileUrl.openStream();
            // load a properties file
            properties.load(input);
            //Again used Thread as classLoader would not work with my maven setup
            importFile = new File(Thread.currentThread().getContextClassLoader().getResource(properties.getProperty("csv.file.path")).getFile());
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
