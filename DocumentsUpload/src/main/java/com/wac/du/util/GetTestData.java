package com.wac.du.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.wac.du.base.TestBase;

public class GetTestData extends TestBase {
	
	public static String TESTDATA_SHEET_PATH = workingDir+"\\src\\test\\java\\com\\"
			+ "wac\\du\\testdata\\DocumentsUploadData.xlsx";
	
	static Workbook book;
	static Sheet sheet;	
	
	public static List<HashMap<String, String>> getTestData2(String sheetName,String testMethod) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		List<HashMap<String, String>> ls = new LinkedList<HashMap<String, String>>();
		List<String> headerRowStrings = new LinkedList<String>();
		//log.info("TOTAL ROWS  "+sheet.getLastRowNum());

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			String inclusionOfRow = "";
			String testCaseMethod="";
			HashMap<String, String> dataRow = new HashMap<String, String>();
				if(i == 0) {
					for (int k = 0; k < sheet.getRow(i).getLastCellNum(); k++) {
						headerRowStrings.add(sheet.getRow(i).getCell(k).toString());
					}
				} else {
					inclusionOfRow = sheet.getRow(i).getCell(0).toString();
					//log.info(inclusionOfRow);
					testCaseMethod = sheet.getRow(i).getCell(1).toString();		
					//log.info(testCaseMethod);
						if(inclusionOfRow.equals("YES") && testMethod.equals(testCaseMethod) ) {
							//System.out.println("xxxxxx ->  "+sheet.getRow(i).getLastCellNum());
							for (int k = 0; k < sheet.getRow(i).getLastCellNum(); k++) {
								//System.out.println(headerRowStrings.get(k)+"  -----  "+sheet.getRow(i).getCell(k).toString());
								String cellValue = sheet.getRow(i).getCell(k).toString();
								if(cellValue != "") {
								dataRow.put(headerRowStrings.get(k),sheet.getRow(i).getCell(k).toString());
								}
								
							}				
					
				}
			if( inclusionOfRow.equals("YES") && testMethod.equals(testCaseMethod) &&  i != 0 ) {				
						ls.add(dataRow);
			}
		}
		}
		return ls;
	}

}
