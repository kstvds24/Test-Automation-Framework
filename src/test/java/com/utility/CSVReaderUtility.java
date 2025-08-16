package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.Users;

public class CSVReaderUtility {

	public static Iterator<Users> readCSVFile(String fileName) {
		File csvFile = new File(System.getProperty("user.dir") + File.separator + "testData" + File.separator + fileName);
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<Users> userList = new ArrayList<Users>();
		Users users;
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();//Reads Immediate line
			while ((line = csvReader.readNext()) != null) {
				users = new Users(line[0], line[1]);
				userList.add(users);
			}
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();

	}

}
