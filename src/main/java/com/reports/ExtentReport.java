package com.reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.constants.Constants;




public class ExtentReport {

	public static ExtentHtmlReporter report=null;
	public static String extentreportpath="";
	public static ExtentReports extent;
	

	//To avoid external initialization
	private ExtentReport() {
		 report = new ExtentHtmlReporter(Constants.EXTENTREPORTPATH);
		extentreportpath=Constants.EXTENTREPORTPATH;
		extent= new ExtentReports();
		extent.attachReporter(report);
		report.loadXMLConfig(new File(Constants.EXTENTCONFIGFILEPATH));
		
	}

	public static void initialize()
	{
		new ExtentReport();
	}
	
	public static void closeReports() {
		extent.flush();
	}

}
