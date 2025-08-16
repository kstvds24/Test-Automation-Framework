package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojos.Users;

public class ExcelReaderUtility {

	public static Iterator<Users> ReadExcelFile(String fileName) {
		// XLSX File
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		Users users;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		List<Users> userList = new ArrayList<Users>();
		File xlsxFile = new File(System.getProperty("user.dir") + "//testData//" + fileName);
		XSSFWorkbook xssfWorkbook = null;
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();// Skip First Row

			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				users = new Users(emailAddressCell.toString(), passwordCell.toString());
				userList.add(users);

			}

			xssfWorkbook.close();
		} catch (InvalidFormatException | IOException e) {

			e.printStackTrace();
		}
		return userList.iterator();
	}

}
