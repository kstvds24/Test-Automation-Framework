package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.ENV;
import com.google.gson.Gson;
import com.ui.pojos.Config;
import com.ui.pojos.Environment;
import com.ui.pojos.TestData;

public class JSONUtility {

	public static Environment readjson(ENV env) {
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir") + File.separator + "config" + File.separator + "config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		return config.getEnvironments().get(env.name());

	}
	public static TestData getUserData() {
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir") + File.separator + "testData" + File.separator + "logindata.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		TestData data = gson.fromJson(fileReader, TestData.class);
		return data;

	}

}
