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

import com.ui.pojo.User;

public class ExcelReaderUtility {
	
	public static Iterator<User> readExcelFile(String fileName) {
		
	File xlsxFile = new File(System.getProperty("user.dir")+ "/testData/"+fileName );
	
	XSSFWorkbook xssfWorkbook = null;
	List<User> userList = null;
	Row row;
	Cell emailAddressCell, passwordCell;
	User user;
	
	Iterator<Row> rowIterator;
	XSSFSheet xssfsheet;
	
	try {
		xssfWorkbook = new XSSFWorkbook(xlsxFile);
		userList = new ArrayList<User>();
		xssfsheet= xssfWorkbook.getSheet("LoginTestData");
		rowIterator = xssfsheet.iterator();
		rowIterator.next();
		
		while(rowIterator.hasNext()) {
			row = rowIterator.next();
			
			if (row == null || row.getCell(0) == null || row.getCell(1) == null || row.getCell(0).toString().trim().isEmpty() || row.getCell(1).toString().trim().isEmpty()) 
			{ continue; //Skipping blank rows
			}
			
			emailAddressCell =row.getCell(0);
			passwordCell =row.getCell(1);
			user = new User(emailAddressCell.toString(),passwordCell.toString());
			userList.add(user);
		
			
		}
		xssfWorkbook.close();
	} catch (InvalidFormatException e) {

		e.printStackTrace();
	} catch (IOException e) {

		e.printStackTrace();
	}
	
	return userList.iterator();
	
	}

}
