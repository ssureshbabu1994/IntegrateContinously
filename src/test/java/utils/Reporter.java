package utils;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;





public abstract class Reporter{

	public ExtentHtmlReporter html;
	public ExtentReports extent;
	public static ExtentTest test, suiteTest;
	public String testCaseName, testNodes, testDescription, category, authors;
	public static String folderName = "";

	public abstract long takeScreenShot();

	public void reportStep(String desc, String status, boolean bSnap)  {

		MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
			snapNumber = takeScreenShot();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../reports/images/"+snapNumber+".png").build();
			} catch (IOException e) {
				
			}
		}
//		if(status.equalsIgnoreCase("PASS")) {
//			test.pass(desc);			
//		}else if (status.equalsIgnoreCase("FAIL")) {
//			test.fail(desc);
//			throw new RuntimeException();
//		}else if (status.equalsIgnoreCase("WARNING")) {
//			test.warning(desc);
//		}else if (status.equalsIgnoreCase("INFO")) {
//			test.info(desc);
//		}							
	}


	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}


}