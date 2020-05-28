package com.wac.du.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.wac.du.base.TestBase;

public class GetCurrentDate extends TestBase {
	
	public static String getDateMMMddYYYYFormat() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
		String currentDate = sdf.format(date);
		return currentDate;
	}
	
	public static String getDateMMddYYYYFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = sdf.format(date);
		return currentDate;
	}
	
	public static String getDateyyyyMMddhhmmssFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date = new Date();
		String currentDate = sdf.format(date);
		return currentDate;
	}
	
	public static String getDateDayMonthDateYearFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("E MMMM");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("d");
		Date date = new Date();
		String currentDate1 = sdf.format(date);
		String currentDate2 = sdf1.format(date);
		String currentDate3 = sdf2.format(date);
		if((currentDate3.equalsIgnoreCase("1")) || (currentDate3.equalsIgnoreCase("21")) || (currentDate3.equalsIgnoreCase("31"))) {
			
			currentDate3 = currentDate3 + "st";
			
		} else if ((currentDate3.equalsIgnoreCase("2")) || (currentDate3.equalsIgnoreCase("22"))) {
			
			currentDate3 = currentDate3 + "nd";
			
		} else if ((currentDate3.equalsIgnoreCase("3")) || (currentDate3.equalsIgnoreCase("23"))) {
			
			currentDate3 = currentDate3 + "rd";
			
		} else {
			
			currentDate3 = currentDate3 + "th";
			
		}
		
		String currentDate = currentDate1 + " " + currentDate3 + ", " + currentDate2;
		
		return currentDate;
	}
	
	public static String getDateMMddYYFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		Date date = new Date();
		String currentDate = sdf.format(date);
		return currentDate;
	}

}
