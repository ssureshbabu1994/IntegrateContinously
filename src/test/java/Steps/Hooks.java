package Steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import mobileWrap.MobileWrapper;

public class Hooks extends MobileWrapper {

	public static WebDriver driver;
	JavascriptExecutor jse;

	@AfterStep
	public void as(Scenario scenario) throws IOException {
		if (iOSdriver != null) {
			getByteScreenshot("iOS");
		} else if (Androiddriver != null) {
			getByteScreenshot("android");

		}
	}

	@After(order = 0)
	public void quitDriver() {
		if (iOSdriver != null) {
			try {
				iOSdriver.closeApp();
				iOSdriver.quit();

			} catch (Exception e) {
			}
		}
		if (Androiddriver != null) {
			try {
				Androiddriver.closeApp();
				Androiddriver.quit();

			} catch (Exception e) {
			}
		}
	}

	public static byte[] getByteScreenshot(String osVersion) throws IOException {
		byte[] FileContent = null;
		if (platform.equalsIgnoreCase("iOS")) {
			File src = ((TakesScreenshot) iOSdriver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/test-output/StepScreenshots/" + src.getName();
			org.apache.commons.io.FileUtils.copyFile(src, new File(path));
			FileContent = FileUtils.readFileToByteArray(new File(path));

		} else if (platform.equalsIgnoreCase("android")) {
			File src = ((TakesScreenshot) Androiddriver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/test-output/StepScreenshots/" + src.getName();
			org.apache.commons.io.FileUtils.copyFile(src, new File(path));
			FileContent = FileUtils.readFileToByteArray(new File(path));
		}

		return FileContent;
	}

}
