package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";
	private static String androidBuildApp;
	private static String IOSBuildApp;

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getIOSDeviceName() {
		String iOSDeviceName = properties.getProperty("iOSDeviceName");
		if (iOSDeviceName != null)
			return iOSDeviceName;
		else
			throw new RuntimeException("iOS Device Name not specified in the Configuration.properties file.");
	}

	public String getAndroidDeviceName() {
		String androidDeviceName = properties.getProperty("androidDeviceName");
		if (androidDeviceName != null)
			return androidDeviceName;
		else
			throw new RuntimeException("Android Device Name not specified in the Configuration.properties file.");
	}

	public String getBrowserstackUser() {
		String browserstackUser = properties.getProperty("browserstackUser");
		if (browserstackUser != null)
			return browserstackUser;
		else
			throw new RuntimeException("Browserstack User is not specified in the Configuration.properties file.");
	}

	public String getBrowserstackKey() {
		String browserstackKey = properties.getProperty("browserstackKey");
		if (browserstackKey != null)
			return browserstackKey;
		else
			throw new RuntimeException("Browserstack Key is not specified in the Configuration.properties file.");
	}

	public String getIOSAppURL() {
		String iOSAppURL = properties.getProperty("iOSAppURL");
		if (iOSAppURL != null)
			return iOSAppURL;
		else
			throw new RuntimeException("IOS App URL is not specified in the Configuration.properties file.");
	}

	public String getAndroidAppURL() {
		String androidAppURL = properties.getProperty("androidAppURL");
		if (androidAppURL != null)
			return androidAppURL;
		else
			throw new RuntimeException("Android App URL is not specified in the Configuration.properties file.");
	}

	public String getIOSVersion() {
		String iOSVersion = properties.getProperty("iOSVersion");
		if (iOSVersion != null)
			return iOSVersion;
		else
			throw new RuntimeException("iOS Version is not specified in the Configuration.properties file.");
	}

	public String getAndroidVersion() {
		String androidOSVersion = properties.getProperty("androidOSVersion");
		if (androidOSVersion != null)
			return androidOSVersion;
		else
			throw new RuntimeException("Android Version is not specified in the Configuration.properties file.");
	}

	public String getProjectName() {
		String project = properties.getProperty("project");
		if (project != null)
			return project;
		else
			throw new RuntimeException("Project not specified in the Configuration.properties file.");
	}

	public String getIOSBuild() {
		String iOSBuild = properties.getProperty("iOSBuild");
		if (iOSBuild != null)
			return iOSBuild;
		else
			throw new RuntimeException("iOS Build is not specified in the Configuration.properties file.");
	}

	public String getAndroidBuild() {
		String androidBuild = properties.getProperty("androidBuild");
		if (androidBuild != null)
			return androidBuild;
		else
			throw new RuntimeException("Android Build is not specified in the Configuration.properties file.");
	}

	public int getImplicitWait() {
		int implicitWait = Integer.valueOf(properties.getProperty("implicitWait"));
		if (implicitWait != 0)
			return implicitWait;
		else
			throw new RuntimeException("Implicit wait is not specified in the Configuration.properties file.");
	}

	public String getBrowserstackURL() {
		String browserstackURL = properties.getProperty("browserstackURL");
		if (browserstackURL != null)
			return browserstackURL;
		else
			throw new RuntimeException("Broswerstack URL not specified in the Configuration.properties file.");
	}

	public String getAndroidAppBuild() {

		String androidAppURL = properties.getProperty("androidAppURL");
		if (androidAppURL.equalsIgnoreCase("bs://d55cde6bac44cf50e86c6752170af74c8b520261")) {
			androidBuildApp = "0.0.3";
			return androidBuildApp;
		}
		else if(androidAppURL.equalsIgnoreCase("bs://681686fcad0a6a0c8d5114863e97f0b24030137a")) {
			androidBuildApp = "0.0.10";
			return androidBuildApp;
		}
		else if(androidAppURL.equalsIgnoreCase("bs://7c86a7a933276473183e3c84182196c519747b8d")) {
			androidBuildApp = "0.0.14";
			return androidBuildApp;
		}
		else if(androidAppURL.equalsIgnoreCase("bs://4fdd8e2f1f5b11aefae970ce64b775e54c3eb6bd")) {
			androidBuildApp = "0.0.16";
			return androidBuildApp;
		}
		else if(androidAppURL.equalsIgnoreCase("bs://9db2357dcda078564f59b743e0b6800e9bc3aae7")) {
			androidBuildApp = "0.0.17";
			return androidBuildApp;
		}
		else if(androidAppURL.equalsIgnoreCase("bs://e16f5bde19775f43ac3ad85c2a014a893d591816")) {
			androidBuildApp = "0.0.18";
			return androidBuildApp;
		}
		else if(androidAppURL.equalsIgnoreCase("bs://4c47fe1a5884b01af78da09b7e946bbb6d7d1a51")) {
			androidBuildApp = "0.0.18";
			return androidBuildApp;
		}
		else if(androidAppURL.equalsIgnoreCase("bs://23657a0558e681a54efa87601023a872ea465471")) {
			androidBuildApp = "0.0.20";
			return androidBuildApp;
		}
		else if(androidAppURL.equalsIgnoreCase("bs://8b72222c171a97f21e40df1d1867b351a5781854")) {
			androidBuildApp = "0.0.21";
			return androidBuildApp;
		}
		
		
		

		else
			throw new RuntimeException("Android App URL is not specified in the Configuration.properties file.");
	}

	public String getIOSAppBuild() {

		String iOSAppURL = properties.getProperty("iOSAppURL");
		if (iOSAppURL.equalsIgnoreCase("")) {
			IOSBuildApp = "0.0.3";
			return IOSBuildApp;
		}

		else
			throw new RuntimeException("Android App URL is not specified in the Configuration.properties file.");
	}

}