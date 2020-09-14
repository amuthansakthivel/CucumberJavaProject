package com.reports;

import com.aventstack.extentreports.Status;

public class LogStatus {

	private LogStatus() {
		//private to avoid initialization
	}
	public static void pass(String message)
	{
		ExtentManager.getExtTest().log(Status.PASS, message);
		
	}

	public static void fail(String message)
	{
		ExtentManager.getExtTest().log(Status.FAIL, message);
	}

	public static void fail(Exception message)
	{
		ExtentManager.getExtTest().log(Status.FAIL, message);
	}

	public static void fail(AssertionError a)
	{
		ExtentManager.getExtTest().log(Status.FAIL, a);
	}

	public static void info(String message)
	{
		ExtentManager.getExtTest().log(Status.INFO, message);
	}

	public static void error(String message)
	{
		ExtentManager.getExtTest().log(Status.ERROR, message);
	}

	public static void fatal(String message)
	{
		ExtentManager.getExtTest().log(Status.FATAL, message);
	}

	public static void skip(String message)
	{
		ExtentManager.getExtTest().log(Status.SKIP, message);
	}

	
	public static void warning(String message)
	{
		ExtentManager.getExtTest().log(Status.WARNING, message);
	}
	
}
