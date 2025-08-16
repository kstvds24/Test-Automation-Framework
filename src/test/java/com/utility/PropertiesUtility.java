package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.ENV;

public class PropertiesUtility {

	public static String readProperty(ENV env, String propertyName) {
		File propFile = new File(System.getProperty("user.dir") + "\\config\\" + env + ".properties");
		FileReader fileReader;
		Properties properties = new Properties();
		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

		String data = properties.getProperty(propertyName.toUpperCase());
		return data;

	}

}
