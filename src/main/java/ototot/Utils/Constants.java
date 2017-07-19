/*
package ototot.Utils;

import java.util.Properties;
import java.util.logging.Logger;

public enum Constants {

    private static final String PATH            = "/27ua.properties";

    private static final Logger logger          = LoggerFactory.getLogger(Constants.class);

    private static Properties properties;

    private String          value;

    private void init() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(Constants.class.getResourceAsStream(PATH));
            }
            catch (Exception e) {
                logger.error("Unable to load " + PATH + " file from classpath.", e);
                System.exit(1);
            }
        }
        value = (String) properties.get(this.toString());
    }

    public String getValue() {
        if (value == null) {
            init();
        }
        return value;
    }

}
*/
