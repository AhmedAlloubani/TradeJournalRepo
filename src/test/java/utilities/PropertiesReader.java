package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    private static Properties config;


    static {

        try {

            File file = new File("src/main/resources/test_data/env.properties");

            FileInputStream input = new FileInputStream(file);

            config = new Properties();

            config.load(input);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(String key) {
        return config.getProperty(key);
    }
}
