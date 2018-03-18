package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoadPropertiesFile {
	private static Logger log = LogManager.getLogger(LoadPropertiesFile.class.getName());

	public static Properties loadProperties(String path) {
		log.info("Started loading the Properties file and file path is \"" + path + "\"");
		File file = new File(path);
		FileInputStream inStream = null;
		Properties properties = null;
		try {
			log.info("Started reading the file " + file.getName() + " in path " + file.getPath());
			inStream = new FileInputStream(path);
			properties = new Properties();
			properties.load(inStream);
		} catch (FileNotFoundException e) {
			log.fatal("File " + file.getAbsolutePath() + " not not there in that location, please check manualy.");
			log.fatal(e.toString());
		} catch (IOException e) {
			log.fatal("File is not a property file.");
			log.fatal(e.toString());
		}
		return properties;
	}
}
