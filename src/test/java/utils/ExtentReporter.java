package utils;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public abstract class ExtentReporter{

	public static ExtentReports report;
	public static ExtentTest logger;
	public static String path;

//	report = new ExtentReports(path);       
//	report.loadConfig(new File("//home//.....//extent-config.xml"));
	
	

}