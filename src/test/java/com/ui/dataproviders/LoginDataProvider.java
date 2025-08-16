package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.Users;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() {
		Gson gson = new Gson();
		FileReader fileReader = null;
		File testDataFile = new File(System.getProperty("user.dir") + File.separator + "testData" + File.separator + "logindata.json");
		try {
			fileReader = new FileReader(testDataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		TestData data = gson.fromJson(fileReader, TestData.class);
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for (Users users : data.getData()) {
			dataToReturn.add(new Object[] { users });
		}
		return dataToReturn.iterator();
	}

	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<Users> loginCSVDatProvider() {
		return CSVReaderUtility.readCSVFile("testData.csv");
	}
	@DataProvider(name = "LoginTestExcelDataProvider")
	public Iterator<Users> loginExcelDatProvider() {
		return ExcelReaderUtility.ReadExcelFile("LoginData.xlsx");
	}
}
