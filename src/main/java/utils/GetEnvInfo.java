package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GetEnvInfo {

	public static Map<String, String> getenv = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> envAndFile() {

		String environment = System.getProperty("env");

		try {
			if (environment.equalsIgnoreCase("dev")) {

				FileInputStream fisDev = new FileInputStream(System.getProperty("user.dir") + "/resources/dev.properties");
				propMain.load(fisDev);
				getenv.put("ServerUrl", propMain.getProperty("ServerUrl"));
				getenv.put("portNo", propMain.getProperty("portNo"));
				getenv.put("username", propMain.getProperty("username"));
				getenv.put("password", propMain.getProperty("password"));

			} else if (environment.equalsIgnoreCase("prod")) {
				FileInputStream fisQA = new FileInputStream(System.getProperty("user.dir") + "/resources/prod.properties");
				propMain.load(fisQA);
				getenv.put("ServerUrl", propMain.getProperty("ServerUrl"));
				getenv.put("portNo", propMain.getProperty("portNo"));
				getenv.put("username", propMain.getProperty("username"));
				getenv.put("password", propMain.getProperty("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return getenv;

	}
	
	
	public static Map<String, String> getConfigReader(){
		if(getenv == null) {
			getenv = envAndFile();
		}
		
		
		return getenv;
		
	}

}
