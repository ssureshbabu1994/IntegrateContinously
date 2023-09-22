package mobileWrap;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;


import dataProvider.ConfigFileReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.connection.HasNetworkConnection;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.Scenario;
import utils.Reporter;


public class MobileWrapper {

	public static IOSDriver<WebElement> iOSdriver;
	public static AndroidDriver<WebElement> Androiddriver;
	public static String platform;
	Assertion assertion = new Assertion();
	ConfigFileReader propertyFile = new ConfigFileReader();

	public void initiateDriver(String OSVersion) {
		if (OSVersion.equalsIgnoreCase("iOS")) {
			platform = OSVersion;
			try {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("browserstack.user", propertyFile.getBrowserstackUser());
				caps.setCapability("browserstack.key", propertyFile.getBrowserstackKey());

				caps.setCapability("app", propertyFile.getIOSAppURL());

				caps.setCapability("device", propertyFile.getIOSDeviceName());
				caps.setCapability("os_version", propertyFile.getIOSVersion());

				caps.setCapability("project", propertyFile.getProjectName());
				caps.setCapability("build", "IOS Execution App Version " + propertyFile.getIOSAppBuild());

				iOSdriver = new IOSDriver<WebElement>(new URL(propertyFile.getBrowserstackURL()), caps);

				iOSdriver.manage().timeouts().implicitlyWait(propertyFile.getImplicitWait(), TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (OSVersion.equalsIgnoreCase("android")) {
			platform = OSVersion;
			try {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("browserstack.user", propertyFile.getBrowserstackUser());
				caps.setCapability("browserstack.key", propertyFile.getBrowserstackKey());

				caps.setCapability("app", propertyFile.getAndroidAppURL());

				caps.setCapability("device", propertyFile.getAndroidDeviceName());
				caps.setCapability("os_version", propertyFile.getAndroidVersion());

				caps.setCapability("project", propertyFile.getProjectName());
				caps.setCapability("build", "Android Execution App Version " + propertyFile.getAndroidAppBuild());

				Androiddriver = new AndroidDriver<WebElement>(new URL(propertyFile.getBrowserstackURL()), caps);

				Androiddriver.manage().timeouts().implicitlyWait(propertyFile.getImplicitWait(), TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void reinitiateDriver(String OSVersion) {
		if (OSVersion.equalsIgnoreCase("iOS")) {
			platform = OSVersion;
			try {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("browserstack.user", propertyFile.getBrowserstackUser());
				caps.setCapability("browserstack.key", propertyFile.getBrowserstackKey());

				caps.setCapability("app", propertyFile.getIOSAppURL());

				caps.setCapability("device", propertyFile.getIOSDeviceName());
				caps.setCapability("os_version", propertyFile.getIOSVersion());

				caps.setCapability("project", propertyFile.getProjectName());
				caps.setCapability("build", propertyFile.getIOSBuild());

//				String packageName = ((IOSDriver) iOSdriver).getCurrentPackage();
//				iOSdriver.terminateApp(packageName);
//				iOSdriver.activateApp(packageName);

				iOSdriver.manage().timeouts().implicitlyWait(propertyFile.getImplicitWait(), TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (OSVersion.equalsIgnoreCase("android")) {
			platform = OSVersion;
			try {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("browserstack.user", propertyFile.getBrowserstackUser());
				caps.setCapability("browserstack.key", propertyFile.getBrowserstackKey());

				caps.setCapability("app", propertyFile.getAndroidAppURL());

				caps.setCapability("device", propertyFile.getAndroidDeviceName());
				caps.setCapability("os_version", propertyFile.getAndroidVersion());

				caps.setCapability("project", propertyFile.getProjectName());
				caps.setCapability("build", propertyFile.getAndroidBuild());

				String packageName = ((AndroidDriver) Androiddriver).getCurrentPackage();
				Androiddriver.terminateApp(packageName);
				Androiddriver.activateApp(packageName);

				Androiddriver.manage().timeouts().implicitlyWait(propertyFile.getImplicitWait(), TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void launchAppInRealDevice(String appPackage, String appActivity, String deviceName, String udid,
			String version) {
		if (version.equalsIgnoreCase("iOS")) {
			try {
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability("appPackage", appPackage);
				dc.setCapability("appActivity", appActivity);
				dc.setCapability("deviceName", deviceName);
				dc.setCapability("automationName", "UiAutomator2");
				dc.setCapability("noReset", true);
				dc.setCapability("udid", udid);
				dc.setCapability("autoGrantPermissions", true);
				dc.setCapability("unicodeKeyboard", "true");
				dc.setCapability("resetKeyboard", "true");

				iOSdriver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
				iOSdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (version.equalsIgnoreCase("android")) {
			try {
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability("appPackage", appPackage);
				dc.setCapability("appActivity", appActivity);
				dc.setCapability("deviceName", deviceName);
				dc.setCapability("automationName", "UiAutomator2");
				dc.setCapability("noReset", true);
				dc.setCapability("udid", udid);
				dc.setCapability("autoGrantPermissions", true);
				dc.setCapability("unicodeKeyboard", "true");
				dc.setCapability("resetKeyboard", "true");

				Androiddriver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
				Androiddriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean loadURL(String URL) {
		if (platform.equalsIgnoreCase("iOS")) {
			iOSdriver.get(URL);

		} else if (platform.equalsIgnoreCase("android")) {
			Androiddriver.get(URL);
		}
		return true;
	}

	public boolean verifyAndInstallApp(String appPackage, String appPath) {
		boolean bInstallSuccess = false;
		if (platform.equalsIgnoreCase("iOS")) {
			if (iOSdriver.isAppInstalled(appPackage))
				iOSdriver.removeApp(appPackage);

			iOSdriver.installApp(appPath);
			bInstallSuccess = true;
		} else if (platform.equalsIgnoreCase("android")) {
			if (Androiddriver.isAppInstalled(appPackage))
				Androiddriver.removeApp(appPackage);

			Androiddriver.installApp(appPath);
			bInstallSuccess = true;
		}

		return bInstallSuccess;
	}

	// Only for Android
	public boolean switchBetweenAppsInAndroid(String appPackage, String appActivity) {
		if (platform.equalsIgnoreCase("android")) {
			try {
				Activity activity = new Activity(appPackage, appActivity);
				((StartsActivity) Androiddriver).startActivity(activity);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public void printContext() {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				Set<String> contexts = iOSdriver.getContextHandles();
				for (String string : contexts) {
					System.out.println(string);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				Set<String> contexts = Androiddriver.getContextHandles();
				for (String string : contexts) {
					System.out.println(string);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public boolean switchContext(String Context) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				iOSdriver.context(Context);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				Androiddriver.context(Context);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	public boolean switchWebview() {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				Set<String> contextNames = iOSdriver.getContextHandles();
				for (String contextName : contextNames) {
					if (contextName.contains("WEBVIEW"))
						iOSdriver.context(contextName);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				Set<String> contextNames = Androiddriver.getContextHandles();
				for (String contextName : contextNames) {
					if (contextName.contains("WEBVIEW"))
						Androiddriver.context(contextName);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean switchNativeview() {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				Set<String> contextNames = iOSdriver.getContextHandles();
				for (String contextName : contextNames) {
					if (contextName.contains("NATIVE"))
						iOSdriver.context(contextName);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				Set<String> contextNames = Androiddriver.getContextHandles();
				for (String contextName : contextNames) {
					if (contextName.contains("NATIVE"))
						Androiddriver.context(contextName);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public void verifyText(String Expected, String locator, String locValue) {
		String name = "";
		if (platform.equalsIgnoreCase("iOS")) {

			try {
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				WebElement ele = getWebElement(locator, locValue);
				wait.until(ExpectedConditions.visibilityOf(ele));
				name = ele.getText();
				if (name.equalsIgnoreCase(Expected)) {
					System.out.println(Expected + " element is displayed successfully");
				}

			} catch (Exception e) {
				System.out.println(Expected + " element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				Assert.fail(Expected + " Element is not displayed");

				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {

			try {
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				WebElement ele = getWebElement(locator, locValue);
				wait.until(ExpectedConditions.visibilityOf(ele));
				name = ele.getText();
				if (name.equalsIgnoreCase(Expected)) {
					System.out.println(Expected + " element is displayed successfully");
				}

			} catch (Exception e) {
				System.out.println(Expected + " element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				Assert.fail(Expected + " element is not displayed");

				e.printStackTrace();
			}
		}
	}

	public void verifyTextNotPresent(String Expected, String locator, String locValue) {
		String name = "";
		if (platform.equalsIgnoreCase("iOS")) {

			try {
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				WebElement ele = getWebElement(locator, locValue);
				wait.until(ExpectedConditions.visibilityOf(ele));
				if (!ele.isDisplayed()) {
					System.out.println(Expected + " element is not displayed as expected");
				}

				name = ele.getText();
			} catch (Exception e) {
				System.out.println(Expected + " element is displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				Assert.fail(Expected + " element is displayed");

				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {

			try {
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				WebElement ele = getWebElement(locator, locValue);
				wait.until(ExpectedConditions.visibilityOf(ele));
				if (!ele.isDisplayed()) {
					System.out.println(Expected + " element is not displayed as expected");
				}
				name = ele.getText();
			} catch (Exception e) {
				System.out.println(Expected + " element is displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				Assert.fail(Expected + " element is displayed");

				e.printStackTrace();
			}
		}
	}

	public void showNotificationMenu() {
		((AndroidDriver<WebElement>) Androiddriver).openNotifications();
	}

	public void getBatteryInfoInAndroid() {
		if (platform.equalsIgnoreCase("iOS")) {
			Map<String, Object> args = new HashMap<>();
			args.put("command", "dumpsys");
			args.put("args", "battery");
			Object executeScript = iOSdriver.executeScript("mobile:shell", args);
			System.out.println(executeScript.toString());
		} else if (platform.equalsIgnoreCase("android")) {
			Map<String, Object> args = new HashMap<>();
			args.put("command", "dumpsys");
			args.put("args", "battery");
			Object executeScript = Androiddriver.executeScript("mobile:shell", args);
			System.out.println(executeScript.toString());
		}
	}

	public void sleep(int mSec) {
		try {
			Thread.sleep(mSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean pressEnter() {
		if (platform.equalsIgnoreCase("iOS")) {
			((PressesKey) iOSdriver).pressKey(new KeyEvent(AndroidKey.ENTER));
		} else if (platform.equalsIgnoreCase("android")) {
			((PressesKey) Androiddriver).pressKey(new KeyEvent(AndroidKey.ENTER));
		}
		return true;
	}

	public boolean pressBack() {
		if (platform.equalsIgnoreCase("iOS")) {
			((PressesKey) iOSdriver).pressKey(new KeyEvent(AndroidKey.BACK));
		} else if (platform.equalsIgnoreCase("android")) {
			((PressesKey) Androiddriver).pressKey(new KeyEvent(AndroidKey.BACK));
		}
		return true;
	}

	public long takeScreenShot() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		if (platform.equalsIgnoreCase("iOS")) {

			try {
				File srcFiler = iOSdriver.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFiler, new File("./reports/images/" + number + ".png"));
			} catch (WebDriverException e) {
				e.printStackTrace();
				System.out.println("The browser has been closed.");
			} catch (IOException e) {
				System.out.println("The snapshot could not be taken");
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				File srcFiler = Androiddriver.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFiler, new File("./reports/images/" + number + ".png"));
			} catch (WebDriverException e) {
				e.printStackTrace();
				System.out.println("The browser has been closed.");
			} catch (IOException e) {
				System.out.println("The snapshot could not be taken");
			}
		}
		return number;
	}

	protected WebElement getWebElement(String locator, String locValue) {
		if (platform.equalsIgnoreCase("iOS")) {
			switch (locator) {
			case "id":
				return iOSdriver.findElementById(locValue);
			case "name":
				return iOSdriver.findElementByName(locValue);
			case "className":
				return iOSdriver.findElementByClassName(locValue);
			case "link":
				return iOSdriver.findElementByLinkText(locValue);
			case "partialLink":
				return iOSdriver.findElementByPartialLinkText(locValue);
			case "tag":
				return iOSdriver.findElementByTagName(locValue);
			case "css":
				return iOSdriver.findElementByCssSelector(locValue);
			case "xpath":
				return iOSdriver.findElementByXPath(locValue);
			case "accessibilityId":
				return iOSdriver.findElementByAccessibilityId(locValue);
			case "image":
				return iOSdriver.findElementByImage(locValue);
			case "classchain":
				return iOSdriver.findElementByIosClassChain(locValue);
			case "predicateString":
				return iOSdriver.findElementByIosNsPredicate(locValue);
			}
		} else if (platform.equalsIgnoreCase("android")) {
			switch (locator) {
			case "id":
				return Androiddriver.findElementById(locValue);
			case "name":
				return Androiddriver.findElementByName(locValue);
			case "className":
				return Androiddriver.findElementByClassName(locValue);
			case "link":
				return Androiddriver.findElementByLinkText(locValue);
			case "partialLink":
				return Androiddriver.findElementByPartialLinkText(locValue);
			case "tag":
				return Androiddriver.findElementByTagName(locValue);
			case "css":
				return Androiddriver.findElementByCssSelector(locValue);
			case "xpath":
				return Androiddriver.findElementByXPath(locValue);
			case "accessibilityId":
				return Androiddriver.findElementByAccessibilityId(locValue);
			case "image":
				return Androiddriver.findElementByImage(locValue);
			}
		}
		return null;
	}

	public boolean verifyTextString(String Expected, String locator, String locValue) {
		boolean val = false;
		String name = "";
		if (platform.equalsIgnoreCase("iOS")) {

			try {
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.visibilityOf(getWebElement(locator, locValue)));
				if (getWebElement(locator, locValue).isDisplayed()) {
					System.out.println(Expected + " element is displayed as expected");
				}

				name = getWebElement(locator, locValue).getText();
				if (name.contains(Expected)) {
					val = true;
				} else
					val = false;
			} catch (Exception e) {
				System.out.println(Expected + " element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail(Expected + " element is not displayed");

				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.visibilityOf(getWebElement(locator, locValue)));
				if (getWebElement(locator, locValue).isDisplayed()) {
					System.out.println(Expected + " element is displayed as expected");
				}
				name = getWebElement(locator, locValue).getText();
				if (name.contains(Expected)) {
					val = true;
				} else
					val = false;
			} catch (Exception e) {
				System.out.println(Expected + " element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail(Expected + " element is not displayed");

				e.printStackTrace();
			}
		}
		return val;
	}

	// Applicable only for Mobile Web/Browser
	public boolean scrollDownInBrowser(int val) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				JavascriptExecutor jse = (JavascriptExecutor) iOSdriver;
				jse.executeScript("window.scrollBy(0," + val + "\")", "");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				JavascriptExecutor jse = (JavascriptExecutor) Androiddriver;
				jse.executeScript("window.scrollBy(0," + val + "\")", "");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public void scrollDownInBrowser() {
		if (platform.equalsIgnoreCase("iOS")) {
			JavascriptExecutor js = (JavascriptExecutor) iOSdriver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
		} else if (platform.equalsIgnoreCase("android")) {
			JavascriptExecutor js = (JavascriptExecutor) Androiddriver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
		}
	}

	// Applicable only for Mobile Web/Browser
	public boolean navigateBackInBrowser() {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				iOSdriver.navigate().back();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				Androiddriver.navigate().back();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean scrollFromDownToUpinAppUsingTouchActions() {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				Dimension size = iOSdriver.manage().window().getSize();
				int x1 = (int) (size.getWidth() * 0.5);
				int y1 = (int) (size.getHeight() * 0.8);
				int x0 = (int) (size.getWidth() * 0.5);
				int y0 = (int) (size.getHeight() * 0.2);
				MultiTouchAction touch = new MultiTouchAction(iOSdriver);
				touch.add(new TouchAction<>(iOSdriver).press(point(x1, y1))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(point(x0, y0)).release())
						.perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				Dimension size = Androiddriver.manage().window().getSize();
				int x1 = (int) (size.getWidth() * 0.5);
				int y1 = (int) (size.getHeight() * 0.8);
				int x0 = (int) (size.getWidth() * 0.5);
				int y0 = (int) (size.getHeight() * 0.2);
				MultiTouchAction touch = new MultiTouchAction(Androiddriver);
				touch.add(new TouchAction<>(Androiddriver).press(point(x1, y1))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(point(x0, y0)).release())
						.perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public void scrollFromDownToUpinAppUsingPointerInput() {
		if (platform.equalsIgnoreCase("iOS")) {
			Dimension size = iOSdriver.manage().window().getSize();
			int x1 = (int) (size.getWidth() * 0.5);
			int y1 = (int) (size.getHeight() * 0.8);
			int x0 = (int) (size.getWidth() * 0.5);
			int y0 = (int) (size.getHeight() * 0.2);
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x1, y1));
			sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
			sequence.addAction(
					finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x0, y0));
			sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
			iOSdriver.perform(Arrays.asList(sequence));
		} else if (platform.equalsIgnoreCase("android")) {
			Dimension size = Androiddriver.manage().window().getSize();
			int x1 = (int) (size.getWidth() * 0.5);
			int y1 = (int) (size.getHeight() * 0.8);
			int x0 = (int) (size.getWidth() * 0.5);
			int y0 = (int) (size.getHeight() * 0.2);
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x1, y1));
			sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
			sequence.addAction(
					finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x0, y0));
			sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
			Androiddriver.perform(Arrays.asList(sequence));
		}
	}

	public boolean scrollFromUpToDowninAppUsingTouchActions() {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				Dimension size = iOSdriver.manage().window().getSize();
				int x1 = (int) (size.getWidth() * 0.5);
				int y1 = (int) (size.getHeight() * 0.2);
				int x0 = (int) (size.getWidth() * 0.5);
				int y0 = (int) (size.getHeight() * 0.8);
				MultiTouchAction touch = new MultiTouchAction(iOSdriver);
				touch.add(new TouchAction<>(iOSdriver).press(point(x1, y1))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(point(x0, y0)).release())
						.perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				Dimension size = Androiddriver.manage().window().getSize();
				int x1 = (int) (size.getWidth() * 0.5);
				int y1 = (int) (size.getHeight() * 0.2);
				int x0 = (int) (size.getWidth() * 0.5);
				int y0 = (int) (size.getHeight() * 0.8);
				MultiTouchAction touch = new MultiTouchAction(Androiddriver);
				touch.add(new TouchAction<>(Androiddriver).press(point(x1, y1))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(point(x0, y0)).release())
						.perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	public void scrollFromUpToDowninAppUsingPointerInput() {
		if (platform.equalsIgnoreCase("iOS")) {
			Dimension size = iOSdriver.manage().window().getSize();
			int x1 = (int) (size.getWidth() * 0.5);
			int y1 = (int) (size.getHeight() * 0.8);
			int x0 = (int) (size.getWidth() * 0.5);
			int y0 = (int) (size.getHeight() * 0.2);
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x0, y0));
			sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
			sequence.addAction(
					finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x1, y1));
			sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
			iOSdriver.perform(Arrays.asList(sequence));
		} else if (platform.equalsIgnoreCase("android")) {
			Dimension size = Androiddriver.manage().window().getSize();
			int x1 = (int) (size.getWidth() * 0.5);
			int y1 = (int) (size.getHeight() * 0.8);
			int x0 = (int) (size.getWidth() * 0.5);
			int y0 = (int) (size.getHeight() * 0.2);
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x0, y0));
			sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
			sequence.addAction(
					finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x1, y1));
			sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
			Androiddriver.perform(Arrays.asList(sequence));
		}

	}

	public boolean scrollFromRightToLeftInAppUsingTouchActions() {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				Dimension size = iOSdriver.manage().window().getSize();
				int x1 = (int) (size.getWidth() * 0.8);
				int y1 = (int) (size.getHeight() * 0.5);
				int x0 = (int) (size.getWidth() * 0.2);
				int y0 = (int) (size.getHeight() * 0.5);
				MultiTouchAction touch = new MultiTouchAction(iOSdriver);
				touch.add(new TouchAction<>(iOSdriver).press(point(x1, y1))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(point(x0, y0)).release())
						.perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				Dimension size = Androiddriver.manage().window().getSize();
				int x1 = (int) (size.getWidth() * 0.8);
				int y1 = (int) (size.getHeight() * 0.5);
				int x0 = (int) (size.getWidth() * 0.2);
				int y0 = (int) (size.getHeight() * 0.5);
				MultiTouchAction touch = new MultiTouchAction(Androiddriver);
				touch.add(new TouchAction<>(Androiddriver).press(point(x1, y1))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(point(x0, y0)).release())
						.perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public void scrollFromRightToLeftInAppUsingPointerInput() {
		if (platform.equalsIgnoreCase("iOS")) {
			Dimension size = iOSdriver.manage().window().getSize();
			int x1 = (int) (size.getWidth() * 0.8);
			int y1 = (int) (size.getHeight() * 0.5);
			int x0 = (int) (size.getWidth() * 0.2);
			int y0 = (int) (size.getHeight() * 0.5);
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x1, y1));
			sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
			sequence.addAction(
					finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x0, y0));
			sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
			iOSdriver.perform(Arrays.asList(sequence));
		} else if (platform.equalsIgnoreCase("android")) {
			Dimension size = Androiddriver.manage().window().getSize();
			int x1 = (int) (size.getWidth() * 0.8);
			int y1 = (int) (size.getHeight() * 0.5);
			int x0 = (int) (size.getWidth() * 0.2);
			int y0 = (int) (size.getHeight() * 0.5);
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x1, y1));
			sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
			sequence.addAction(
					finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x0, y0));
			sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
			Androiddriver.perform(Arrays.asList(sequence));
		}

	}

	public boolean scrollFromLeftToRightInAppUsingTouchActions() {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				Dimension size = iOSdriver.manage().window().getSize();
				int x1 = (int) (size.getWidth() * 0.8);
				int y1 = (int) (size.getHeight() * 0.5);
				int x0 = (int) (size.getWidth() * 0.2);
				int y0 = (int) (size.getHeight() * 0.5);
				MultiTouchAction touch = new MultiTouchAction(iOSdriver);
				touch.add(new TouchAction<>(iOSdriver).press(point(x0, y0))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(point(x1, y1)).release())
						.perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				Dimension size = Androiddriver.manage().window().getSize();
				int x1 = (int) (size.getWidth() * 0.8);
				int y1 = (int) (size.getHeight() * 0.5);
				int x0 = (int) (size.getWidth() * 0.2);
				int y0 = (int) (size.getHeight() * 0.5);
				MultiTouchAction touch = new MultiTouchAction(Androiddriver);
				touch.add(new TouchAction<>(Androiddriver).press(point(x0, y0))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(point(x1, y1)).release())
						.perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public void scrollFromLeftToRightInAppUsingPointerInput() {
		if (platform.equalsIgnoreCase("iOS")) {
			Dimension size = iOSdriver.manage().window().getSize();
			int x1 = (int) (size.getWidth() * 0.8);
			int y1 = (int) (size.getHeight() * 0.5);
			int x0 = (int) (size.getWidth() * 0.2);
			int y0 = (int) (size.getHeight() * 0.5);
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x0, y0));
			sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
			sequence.addAction(
					finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x1, y1));
			sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
			iOSdriver.perform(Arrays.asList(sequence));
		} else if (platform.equalsIgnoreCase("android")) {
			Dimension size = Androiddriver.manage().window().getSize();
			int x1 = (int) (size.getWidth() * 0.8);
			int y1 = (int) (size.getHeight() * 0.5);
			int x0 = (int) (size.getWidth() * 0.2);
			int y0 = (int) (size.getHeight() * 0.5);
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence sequence = new Sequence(finger, 1);
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x0, y0));
			sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
			sequence.addAction(
					finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x1, y1));
			sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
			Androiddriver.perform(Arrays.asList(sequence));
		}
	}

	public void pinchUsingPointerInput() {
		if (platform.equalsIgnoreCase("iOS")) {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

			Dimension size = iOSdriver.manage().window().getSize();
			Point source = new Point(size.getWidth(), size.getHeight());

			Sequence pinchAndZoom1 = new Sequence(finger, 0);
			pinchAndZoom1.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
					source.x / 3, source.y / 3));
			pinchAndZoom1.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			pinchAndZoom1.addAction(new Pause(finger, Duration.ofMillis(100)));
			pinchAndZoom1.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
					source.x / 2, source.y / 2));
			pinchAndZoom1.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			Sequence pinchAndZoom2 = new Sequence(finger2, 1);
			pinchAndZoom2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
					source.x * 3 / 4, source.y * 3 / 4));
			pinchAndZoom2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			pinchAndZoom2.addAction(new Pause(finger, Duration.ofMillis(100)));
			pinchAndZoom2.addAction(finger2.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
					source.x / 2, source.y / 2));
			pinchAndZoom2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			iOSdriver.perform(Arrays.asList(pinchAndZoom1, pinchAndZoom2));
		} else if (platform.equalsIgnoreCase("android")) {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

			Dimension size = Androiddriver.manage().window().getSize();
			Point source = new Point(size.getWidth(), size.getHeight());

			Sequence pinchAndZoom1 = new Sequence(finger, 0);
			pinchAndZoom1.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
					source.x / 3, source.y / 3));
			pinchAndZoom1.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			pinchAndZoom1.addAction(new Pause(finger, Duration.ofMillis(100)));
			pinchAndZoom1.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
					source.x / 2, source.y / 2));
			pinchAndZoom1.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			Sequence pinchAndZoom2 = new Sequence(finger2, 1);
			pinchAndZoom2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
					source.x * 3 / 4, source.y * 3 / 4));
			pinchAndZoom2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			pinchAndZoom2.addAction(new Pause(finger, Duration.ofMillis(100)));
			pinchAndZoom2.addAction(finger2.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
					source.x / 2, source.y / 2));
			pinchAndZoom2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			Androiddriver.perform(Arrays.asList(pinchAndZoom1, pinchAndZoom2));
		}

	}

	// Pinch using Touch Action will not work. Known Bug.
	public void pinchUsingTouchActions() {
		if (platform.equalsIgnoreCase("iOS")) {
			Dimension size = iOSdriver.manage().window().getSize();
			Point source = new Point(size.getWidth(), size.getHeight());
			MultiTouchAction multiTouch = new MultiTouchAction(iOSdriver);
			TouchAction<?> tAction0 = new TouchAction<>(iOSdriver);
			TouchAction<?> tAction1 = new TouchAction<>(iOSdriver);
			tAction0.press(point(source.x / 3, source.y / 3)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(point(source.x / 2, source.y / 2)).release();
			tAction1.press(point(source.x * 3 / 4, source.y * 3 / 4))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(point(source.x / 2, source.y / 2)).release();

			multiTouch.add(tAction0).add(tAction1);
			multiTouch.perform();
		} else if (platform.equalsIgnoreCase("android")) {
			Dimension size = Androiddriver.manage().window().getSize();
			Point source = new Point(size.getWidth(), size.getHeight());
			MultiTouchAction multiTouch = new MultiTouchAction(Androiddriver);
			TouchAction<?> tAction0 = new TouchAction<>(Androiddriver);
			TouchAction<?> tAction1 = new TouchAction<>(Androiddriver);
			tAction0.press(point(source.x / 3, source.y / 3)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(point(source.x / 2, source.y / 2)).release();
			tAction1.press(point(source.x * 3 / 4, source.y * 3 / 4))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(point(source.x / 2, source.y / 2)).release();

			multiTouch.add(tAction0).add(tAction1);
			multiTouch.perform();
		}
	}

	public void ZoomUsingPointerInput() {
		if (platform.equalsIgnoreCase("iOS")) {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

			Dimension size = iOSdriver.manage().window().getSize();
			Point source = new Point(size.getWidth(), size.getHeight());

			Sequence pinchAndZoom1 = new Sequence(finger, 0);
			pinchAndZoom1.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
					source.x / 2, source.y / 2));
			pinchAndZoom1.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			pinchAndZoom1.addAction(new Pause(finger, Duration.ofMillis(100)));
			pinchAndZoom1.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
					source.x / 3, source.y / 3));
			pinchAndZoom1.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			Sequence pinchAndZoom2 = new Sequence(finger2, 0);
			pinchAndZoom2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
					source.x / 2, source.y / 2));
			pinchAndZoom2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			pinchAndZoom2.addAction(new Pause(finger, Duration.ofMillis(100)));
			pinchAndZoom2.addAction(finger2.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
					source.x * 3 / 4, source.y * 3 / 4));
			pinchAndZoom2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			iOSdriver.perform(Arrays.asList(pinchAndZoom1, pinchAndZoom2));
		} else if (platform.equalsIgnoreCase("android")) {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

			Dimension size = Androiddriver.manage().window().getSize();
			Point source = new Point(size.getWidth(), size.getHeight());

			Sequence pinchAndZoom1 = new Sequence(finger, 0);
			pinchAndZoom1.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
					source.x / 2, source.y / 2));
			pinchAndZoom1.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			pinchAndZoom1.addAction(new Pause(finger, Duration.ofMillis(100)));
			pinchAndZoom1.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
					source.x / 3, source.y / 3));
			pinchAndZoom1.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			Sequence pinchAndZoom2 = new Sequence(finger2, 0);
			pinchAndZoom2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
					source.x / 2, source.y / 2));
			pinchAndZoom2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			pinchAndZoom2.addAction(new Pause(finger, Duration.ofMillis(100)));
			pinchAndZoom2.addAction(finger2.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
					source.x * 3 / 4, source.y * 3 / 4));
			pinchAndZoom2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			Androiddriver.perform(Arrays.asList(pinchAndZoom1, pinchAndZoom2));
		}
	}

	public void zoomUsingTouchActions() {
		if (platform.equalsIgnoreCase("iOS")) {
			Dimension size = iOSdriver.manage().window().getSize();
			Point source = new Point(size.getWidth(), size.getHeight());
			MultiTouchAction multiTouch = new MultiTouchAction(iOSdriver);
			TouchAction<?> tAction0 = new TouchAction<>(iOSdriver);
			TouchAction<?> tAction1 = new TouchAction<>(iOSdriver);
			tAction0.press(point(source.x / 2, source.y / 2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(point(source.x / 3, source.y / 3)).release();
			tAction1.press(point(source.x * 2, source.y * 2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(point(source.x * 3 / 4, source.y * 3 / 4)).release();

			multiTouch.add(tAction0).add(tAction1);
			multiTouch.perform();
		} else if (platform.equalsIgnoreCase("android")) {
			Dimension size = Androiddriver.manage().window().getSize();
			Point source = new Point(size.getWidth(), size.getHeight());
			MultiTouchAction multiTouch = new MultiTouchAction(Androiddriver);
			TouchAction<?> tAction0 = new TouchAction<>(Androiddriver);
			TouchAction<?> tAction1 = new TouchAction<>(Androiddriver);
			tAction0.press(point(source.x / 2, source.y / 2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(point(source.x / 3, source.y / 3)).release();
			tAction1.press(point(source.x * 2, source.y * 2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(point(source.x * 3 / 4, source.y * 3 / 4)).release();

			multiTouch.add(tAction0).add(tAction1);
			multiTouch.perform();
		}
	}

	public void eleIsDisplayed(String locator, String locValue) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");

			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

			}
		}

	}
	
	public boolean eleIsDisplayedReturnBoolean(String locator, String locValue) {
		boolean val=false;
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				if (ele.isDisplayed()) {
					val=true;
					System.out.println("Element is displayed as expected");
				}
			} catch (Exception e) {
				val=false;
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");

			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				if (ele.isDisplayed()) {
					val=true;
					System.out.println("Element is displayed as expected");
				}
			} catch (Exception e) {
				val=false;
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

			}
		}
		return val;

	}

	public void eleIsDisplayedAccessibilityID(String accessibilityID) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");

			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

			}
		}

	}

	public void eleIsNotDisplayed(String opXpath) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
//				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);

				if (iOSdriver.findElements(By.xpath(opXpath)).size() == 0) {
					System.out.println("Element is not displayed as expected");
				} else {
					throw new RuntimeException("Element is displayed");
				}

			} catch (Exception e) {
				System.out.println("Element is displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is displayed");

			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
//				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				if (Androiddriver.findElements(By.xpath(opXpath)).size() == 0) {
					System.out.println("Element is not displayed as expected");
				} else {
					throw new RuntimeException("Element is displayed");
				}
			} catch (Exception e) {
				System.out.println("Element is displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is displayed");

			}
		}

	}

	public boolean scrollFromUpToDowninAppWithWebElementUsingPointerInput(String locator, String locValue) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {

				WebElement ele = getWebElement(locator, locValue);
				// int startX = ele.getLocation().getX();
				int startY = ele.getLocation().getY();

				int centerX = ((MobileElement) ele).getCenter().getX();
				int centerY = ((MobileElement) ele).getCenter().getY();
				// int endX = (centerX*2)-startX;
				int endY = (centerY * 2) - startY;

				int x0 = (int) centerX;
				int y0 = (int) ((endY - startY) * 0.2) + startY;
				int x1 = (int) centerX;
				int y1 = (int) ((endY - startY) * 0.8) + startY;

				PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
				Sequence sequence = new Sequence(finger, 1);
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x0, y0));
				sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x1, y1));
				sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
				iOSdriver.perform(Arrays.asList(sequence));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {

				WebElement ele = getWebElement(locator, locValue);
				// int startX = ele.getLocation().getX();
				int startY = ele.getLocation().getY();

				int centerX = ((MobileElement) ele).getCenter().getX();
				int centerY = ((MobileElement) ele).getCenter().getY();
				// int endX = (centerX*2)-startX;
				int endY = (centerY * 2) - startY;

				int x0 = (int) centerX;
				int y0 = (int) ((endY - startY) * 0.2) + startY;
				int x1 = (int) centerX;
				int y1 = (int) ((endY - startY) * 0.8) + startY;

				PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
				Sequence sequence = new Sequence(finger, 1);
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x0, y0));
				sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x1, y1));
				sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
				Androiddriver.perform(Arrays.asList(sequence));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean scrollFromDownToUpinAppWithWebElementUsingPointerInput(String locator, String locValue) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				// int startX = ele.getLocation().getX();
				int startY = ele.getLocation().getY();

				int centerX = ((MobileElement) ele).getCenter().getX();
				int centerY = ((MobileElement) ele).getCenter().getY();
				// int endX = (centerX*2)-startX;
				int endY = (centerY * 2) - startY;

				int x0 = (int) centerX;
				int y0 = (int) ((endY - startY) * 0.8) + startY;
				int x1 = (int) centerX;
				int y1 = (int) ((endY - startY) * 0.2) + startY;

				PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
				Sequence sequence = new Sequence(finger, 1);
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x0, y0));
				sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x1, y1));
				sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
				iOSdriver.perform(Arrays.asList(sequence));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				// int startX = ele.getLocation().getX();
				int startY = ele.getLocation().getY();

				int centerX = ((MobileElement) ele).getCenter().getX();
				int centerY = ((MobileElement) ele).getCenter().getY();
				// int endX = (centerX*2)-startX;
				int endY = (centerY * 2) - startY;

				int x0 = (int) centerX;
				int y0 = (int) ((endY - startY) * 0.8) + startY;
				int x1 = (int) centerX;
				int y1 = (int) ((endY - startY) * 0.2) + startY;

				PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
				Sequence sequence = new Sequence(finger, 1);
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x0, y0));
				sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x1, y1));
				sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
				Androiddriver.perform(Arrays.asList(sequence));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;

	}

	public boolean scrollFromLeftToRightinAppWithWebElementUsingPointerInput(String locator, String locValue) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				int startX = ele.getLocation().getX();
				// int startY = ele.getLocation().getY();

				int centerX = ((MobileElement) ele).getCenter().getX();
				int centerY = ((MobileElement) ele).getCenter().getY();
				int endX = (centerX * 2) - startX;
				// int endY = (centerY*2)-startY;

				int x0 = (int) ((endX - startX) * 0.2) + startX;
				int y0 = (int) centerY;
				int x1 = (int) ((endX - startX) * 0.8) + startX;
				int y1 = (int) centerY;

				PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
				Sequence sequence = new Sequence(finger, 1);
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x0, y0));
				sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x1, y1));
				sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
				iOSdriver.perform(Arrays.asList(sequence));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				int startX = ele.getLocation().getX();
				// int startY = ele.getLocation().getY();

				int centerX = ((MobileElement) ele).getCenter().getX();
				int centerY = ((MobileElement) ele).getCenter().getY();
				int endX = (centerX * 2) - startX;
				// int endY = (centerY*2)-startY;

				int x0 = (int) ((endX - startX) * 0.2) + startX;
				int y0 = (int) centerY;
				int x1 = (int) ((endX - startX) * 0.8) + startX;
				int y1 = (int) centerY;

				PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
				Sequence sequence = new Sequence(finger, 1);
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x0, y0));
				sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x1, y1));
				sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
				Androiddriver.perform(Arrays.asList(sequence));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean scrollFromRightToLeftinAppWithWebElementUsingPointerInput(String locator, String locValue) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				int startX = ele.getLocation().getX();
				// int startY = ele.getLocation().getY();

				int centerX = ((MobileElement) ele).getCenter().getX();
				int centerY = ((MobileElement) ele).getCenter().getY();
				int endX = (centerX * 2) - startX;
				// int endY = (centerY*2)-startY;

				int x0 = (int) ((endX - startX) * 0.8) + startX;
				int y0 = (int) centerY;
				int x1 = (int) ((endX - startX) * 0.2) + startX;
				int y1 = (int) centerY;

				PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
				Sequence sequence = new Sequence(finger, 1);
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x0, y0));
				sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x1, y1));
				sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
				iOSdriver.perform(Arrays.asList(sequence));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				int startX = ele.getLocation().getX();
				// int startY = ele.getLocation().getY();

				int centerX = ((MobileElement) ele).getCenter().getX();
				int centerY = ((MobileElement) ele).getCenter().getY();
				int endX = (centerX * 2) - startX;
				// int endY = (centerY*2)-startY;

				int x0 = (int) ((endX - startX) * 0.8) + startX;
				int y0 = (int) centerY;
				int x1 = (int) ((endX - startX) * 0.2) + startX;
				int y1 = (int) centerY;

				PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
				Sequence sequence = new Sequence(finger, 1);
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x0, y0));
				sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
				sequence.addAction(
						finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x1, y1));
				sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
				Androiddriver.perform(Arrays.asList(sequence));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

//	public boolean scrollFromDownToUpinAppUsingPointerInputUntilElementIsVisible(String locator, String locValue) {
//		while (!eleIsDisplayed(getWebElement(locator, locValue))) {
//			scrollFromDownToUpinAppUsingPointerInput();
//		}
//		return true;
//	}
//
//	public boolean scrollFromUpToDowninAppUsingPointerInputUntilElementIsVisible(String locator, String locValue) {
//		while (!eleIsDisplayed(getWebElement(locator, locValue))) {
//			scrollFromUpToDowninAppUsingPointerInput();
//		}
//		return true;
//	}

	public boolean clickInCoOrdinatesOfApp(int x0, int y0) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				TouchAction<?> touch = new TouchAction<>(iOSdriver);
				touch.press(point(x0, y0)).release().perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				TouchAction<?> touch = new TouchAction<>(Androiddriver);
				touch.press(point(x0, y0)).release().perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public void resetApp() {
		if (platform.equalsIgnoreCase("iOS")) {
			iOSdriver.resetApp();
		} else if (platform.equalsIgnoreCase("android")) {
			Androiddriver.resetApp();
		}
	}

	public void closeApp(String OSVersion) {
		if (OSVersion.equalsIgnoreCase("iOS")) {
			if (iOSdriver != null) {
				try {
					iOSdriver.closeApp();
					iOSdriver.quit();

				} catch (Exception e) {
				}
			}
		} else if (OSVersion.equalsIgnoreCase("android")) {
			if (Androiddriver != null) {
				try {
					Androiddriver.closeApp();
					Androiddriver.quit();

				} catch (Exception e) {
				}
			}
		}

	}

	public void closeAppAlone(String OSVersion) {
		if (OSVersion.equalsIgnoreCase("iOS")) {
			if (iOSdriver != null) {
				try {
					iOSdriver.closeApp();

				} catch (Exception e) {
				}
			}
		} else if (OSVersion.equalsIgnoreCase("android")) {
			if (Androiddriver != null) {
				try {
					Androiddriver.closeApp();

				} catch (Exception e) {
				}
			}
		}

	}

	// Only for Android
	public boolean WiFiOffInAndorid() {
		if (platform.equalsIgnoreCase("iOS")) {
			// ((HasNetworkConnection) driver).setConnection(new
			// ConnectionStateBuilder().withAirplaneModeEnabled().build());
			// ((HasNetworkConnection) driver).setConnection(new
			// ConnectionStateBuilder().withDataDisabled().build());
			((HasNetworkConnection) iOSdriver).setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());

		} else if (platform.equalsIgnoreCase("android")) {
			((HasNetworkConnection) Androiddriver)
					.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
		}
		return true;
	}

	// Only for Android
	public boolean WiFiOnInAndroid() {
		if (platform.equalsIgnoreCase("iOS")) {
			// ((HasNetworkConnection) driver).setConnection(new
			// ConnectionStateBuilder().withAirplaneModeDisabled().build());
			// ((HasNetworkConnection) driver).setConnection(new
			// ConnectionStateBuilder().withDataEnabled().build());
			((HasNetworkConnection) iOSdriver).setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());

		} else if (platform.equalsIgnoreCase("android")) {
			((HasNetworkConnection) Androiddriver)
					.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
		}
		return true;
	}

	public boolean setPortraitOrientation() {
		if (platform.equalsIgnoreCase("iOS")) {
			iOSdriver.rotate(ScreenOrientation.PORTRAIT);
		} else if (platform.equalsIgnoreCase("android")) {
			Androiddriver.rotate(ScreenOrientation.PORTRAIT);
		}
		return true;
	}

	public boolean setLanscapeOrientation() {
		if (platform.equalsIgnoreCase("iOS")) {
			iOSdriver.rotate(ScreenOrientation.LANDSCAPE);
		} else if (platform.equalsIgnoreCase("android")) {
			Androiddriver.rotate(ScreenOrientation.LANDSCAPE);
		}
		return true;
	}

	public void hideKeyboard() {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				iOSdriver.hideKeyboard();
			} catch (Exception e) {
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				Androiddriver.hideKeyboard();
			} catch (Exception e) {
			}
		}
	}

	private String getOrientation() {
		String orientation = "";
		if (platform.equalsIgnoreCase("iOS")) {
			orientation = iOSdriver.getOrientation().toString();
		} else if (platform.equalsIgnoreCase("android")) {
			orientation = Androiddriver.getOrientation().toString();
		}
		return orientation;
	}

	public void enterValue(String data, String locator, String locValue) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				ele.clear();
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}

				ele.sendKeys(data);

			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();

			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				ele.clear();
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				ele.sendKeys(data);

			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
			}
		}
	}

	public void enterValueAccessibilityID(String accessibilityID, String data) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				ele.clear();
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}

				ele.sendKeys(data);

			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();

			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				ele.clear();
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				ele.sendKeys(data);

			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
			}
		}
	}

	public void clear(String locator, String locValue) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}

				ele.clear();

			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				ele.clear();

			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
			}
		}
	}

	public void clearAccessibilityID(String accessibilityID) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}

				ele.clear();

			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				ele.clear();

			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
			}
		}
	}

	public void click(String locator, String locValue) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				ele.click();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				ele.click();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");
				e.printStackTrace();
			}
		}
	}
	
	public void clickByWebEle(WebElement element) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				if (element.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				element.click();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				if (element.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				element.click();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");
				e.printStackTrace();
			}
		}
	}

	public void clickById(String id) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = findElementByID(id);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				ele.click();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = findElementByID(id);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				ele.click();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");
				e.printStackTrace();
			}
		}
	}

	public String getText(String locator, String locValue) {
		String text = "";
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getText();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				// TODO Auto-generated catch block
				assertion.fail("Element is not displayed");
				e.printStackTrace();
				return null;
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getText();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
				return null;
			}
		}
		return text;

	}

	public String getResourceID(String locator, String locValue) {
		String text = "";
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getAttribute("resource-id");
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				// TODO Auto-generated catch block
				assertion.fail("Element is not displayed");
				e.printStackTrace();
				return null;
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getAttribute("resource-id");
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
				return null;
			}
		}
		return text;

	}

	public String getResourceIDUsingAccessibilityID(String val) {
		String text = "";
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = findElementByAccessibilityID(val);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getAttribute("resource-id");
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				// TODO Auto-generated catch block
				assertion.fail("Element is not displayed");
				e.printStackTrace();
				return null;
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = findElementByAccessibilityID(val);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getAttribute("resource-id");
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
				return null;
			}
		}
		return text;

	}

	public String getTextAccessibilityID(String accessibilityID) {
		String text = "";
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getText();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				// TODO Auto-generated catch block
				assertion.fail("Element is not displayed");
				e.printStackTrace();
				return null;
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getText();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
				return null;
			}
		}
		return text;

	}

	public String getAttributeAccessibilityID(String accessibilityID, String attributeName) {
		String text = "";
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getAttribute(attributeName);
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				// TODO Auto-generated catch block
				assertion.fail("Element is not displayed");
				e.printStackTrace();
				return null;
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getAttribute(attributeName);
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
				return null;
			}
		}
		return text;

	}

	public String getAttribute(String locator, String locValue, String attributeName) {
		String text = "";
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getAttribute(attributeName);
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				// TODO Auto-generated catch block
				assertion.fail("Element is not displayed");
				e.printStackTrace();
				return null;
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = getWebElement(locator, locValue);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getAttribute(attributeName);
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
				return null;
			}
		}
		return text;

	}

	public boolean launchApp(String appPackage, String appActivity, String deviceName, String udid) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability("appPackage", appPackage);
				dc.setCapability("appActivity", appActivity);
				dc.setCapability("deviceName", deviceName);
				dc.setCapability("automationName", "UiAutomator2");
				dc.setCapability("noReset", true);
				dc.setCapability("udid", udid);
				dc.setCapability("autoGrantPermissions", true);
				// dc.setCapability("unicodeKeyboard", "true");
				// dc.setCapability("resetKeyboard", "true");

				iOSdriver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
				iOSdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} catch (Exception e) {

			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability("appPackage", appPackage);
				dc.setCapability("appActivity", appActivity);
				dc.setCapability("deviceName", deviceName);
				dc.setCapability("automationName", "UiAutomator2");
				dc.setCapability("noReset", true);
				dc.setCapability("udid", udid);
				dc.setCapability("autoGrantPermissions", true);
				// dc.setCapability("unicodeKeyboard", "true");
				// dc.setCapability("resetKeyboard", "true");

				Androiddriver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
				Androiddriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} catch (Exception e) {

			}
		}
		return true;
	}

	public boolean launchBrowser(String browserName, String deviceName, String URL) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability("browserName", browserName);
				dc.setCapability("deviceName", deviceName);
				iOSdriver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
				iOSdriver.get(URL);
				iOSdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability("browserName", browserName);
				dc.setCapability("deviceName", deviceName);
				Androiddriver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
				Androiddriver.get(URL);
				Androiddriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static void swipe(int fromX, int fromY, int toX, int toY) {
		if (platform.equalsIgnoreCase("iOS")) {
			TouchAction action = new TouchAction(iOSdriver);
			action.press(PointOption.point(fromX, fromY))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000)))
					.moveTo(PointOption.point(toX, toY)).release().perform();
		} else if (platform.equalsIgnoreCase("android")) {
			TouchAction action = new TouchAction(Androiddriver);
			action.press(PointOption.point(fromX, fromY))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000)))
					.moveTo(PointOption.point(toX, toY)).release().perform();
		}
	}

	public void swipeUp(int pixelsToSwipe, String xpath) {
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				Point value = null;

				value = iOSdriver.findElement(By.xpath(xpath)).getLocation();

				int x = value.x;
				int y = value.y;
				int y1 = value.y + pixelsToSwipe;

				swipe(x, y, x, y1);
			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

		} else if (platform.equalsIgnoreCase("android")) {
			try {
				Point value = null;

				value = Androiddriver.findElement(By.xpath(xpath)).getLocation();

				int x = value.x;
				int y = value.y;
				int y1 = value.y + pixelsToSwipe;

				swipe(x, y, x, y1);
			} catch (Exception e) {

				System.out.println(e.getMessage());
			}
		}
	}

	public static byte[] getByteScreenshot(String osVersion) throws IOException {
		byte[] FileContent = null;
		if (platform.equalsIgnoreCase("iOS")) {
			File src = ((TakesScreenshot) iOSdriver).getScreenshotAs(OutputType.FILE);
			FileContent = FileUtils.readFileToByteArray(src);

		} else if (platform.equalsIgnoreCase("android")) {
			File src = ((TakesScreenshot) Androiddriver).getScreenshotAs(OutputType.FILE);
			FileContent = FileUtils.readFileToByteArray(src);
		}

		return FileContent;
	}

	public void attachScreenshot(Scenario scenario, String osVersion) throws IOException {
		scenario.attach(getByteScreenshot(osVersion), "img/png", "test execution");
	}

	public void closeDriver(String OSVersion) {
		closeApp(OSVersion);
	}

	public void launchDriver(String OSVersion) {
		initiateDriver(OSVersion);
		switchNativeview();

	}

	public void reLaunchDriver(String OSVersion) {
		reinitiateDriver(OSVersion);
		switchNativeview();

	}

	public void launchDriverRealDevice(String OSVersion) {
		if (OSVersion.equalsIgnoreCase("iOS")) {
			launchAppInRealDevice("com.driver_app", "com.driver_app_MaiActivity", "Aishwarya",
					"D:\\Downloads\\driver_app.ipa", OSVersion);
			switchNativeview();
		} else if (OSVersion.equalsIgnoreCase("android")) {
			launchAppInRealDevice("com.driver_app", "com.driver_app_MaiActivity", "Aishwarya",
					"D:\\Downloads\\app-armeabi-v7a-release.apk", OSVersion);
			switchNativeview();
		}

	}

	public void clickAccessibilityID(String accessibilityID) {

		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed");
				}
				ele.click();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed");
				}
				ele.click();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");
			}
		}
	}

	public WebElement findElementByAccessibilityID(String val) {
		WebElement ele = null;
		if (platform.equalsIgnoreCase("iOS")) {
			ele = iOSdriver.findElementByAccessibilityId(val);
		} else if (platform.equalsIgnoreCase("android")) {
			ele = Androiddriver.findElementByAccessibilityId(val);
		}
		return ele;
	}

	public WebElement findElementByID(String val) {
		WebElement ele = null;
		if (platform.equalsIgnoreCase("iOS")) {
			ele = iOSdriver.findElementById(val);
		} else if (platform.equalsIgnoreCase("android")) {
			ele = Androiddriver.findElementById(val);
		}
		return ele;
	}

	public String getContentDescUsingAccessibilityID(String accessibilityID) {
		String text = "";
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getAttribute("content-desc");
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");

			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getAttribute("content-desc");
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

			}
		}
		return text;

	}

	public int sizeOfList(String val) {
		int opSize = 0;
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				List<WebElement> ele = iOSdriver.findElementsByAccessibilityId(val);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				opSize = ele.size();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				assertion.fail("Element is not displayed");

			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				List<WebElement> ele = Androiddriver.findElementsByAccessibilityId(val);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				opSize = ele.size();
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

			}
		}
		return opSize;
	}

	public List<String> getTexts(String locator, String locValue) {
		List<String> texts = new ArrayList<String>();
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				List<WebElement> ele = iOSdriver.findElements(By.xpath(locValue));
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				if (ele.size() > 0) {
					System.out.println("Elements are displayed as expected");
				}
				for (WebElement webElement : ele) {
					texts.add(webElement.getText());
				}
			} catch (Exception e) {
				System.out.println("Elements are not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				// TODO Auto-generated catch block
				assertion.fail("Elements are not displayed");
				e.printStackTrace();
				return null;
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				List<WebElement> ele = Androiddriver.findElements(By.xpath(locValue));
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				if (ele.size() > 0) {
					System.out.println("Elements are displayed as expected");
				}
				for (WebElement webElement : ele) {
					texts.add(webElement.getText());
				}
			} catch (Exception e) {
				System.out.println("Elements are not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Elements are not displayed");

				e.printStackTrace();
				return null;
			}
		}
		return texts;

	}

	public List<WebElement> getElements(String locator, String locValue) {
		List<WebElement> el = new ArrayList<>();
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				List<WebElement> ele = iOSdriver.findElements(By.xpath(locValue));
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				if (ele.size() > 0) {
					System.out.println("Elements are displayed as expected");
				}
				el = ele;
			} catch (Exception e) {
				System.out.println("Elements are not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				// TODO Auto-generated catch block
				assertion.fail("Elements are not displayed");
				e.printStackTrace();
				return null;
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				List<WebElement> ele = Androiddriver.findElements(By.xpath(locValue));
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				if (ele.size() > 0) {
					System.out.println("Elements are displayed as expected");
				}
				el = ele;
			} catch (Exception e) {
				System.out.println("Elements are not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Elements are not displayed");

				e.printStackTrace();
				return null;
			}
		}

		return el;
	}
	
	

	public String getAttributeUsingAccessibilityID(String accessibilityID, String attributeName) {
		String text = "";
		if (platform.equalsIgnoreCase("iOS")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(iOSdriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getAttribute(attributeName);
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				iOSdriver.closeApp();
				iOSdriver.quit();
				// TODO Auto-generated catch block
				assertion.fail("Element is not displayed");
				e.printStackTrace();
				return null;
			}
		} else if (platform.equalsIgnoreCase("android")) {
			try {
				WebElement ele = findElementByAccessibilityID(accessibilityID);
				WebDriverWait wait = new WebDriverWait(Androiddriver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				if (ele.isDisplayed()) {
					System.out.println("Element is displayed as expected");
				}
				text = ele.getAttribute(attributeName);
			} catch (Exception e) {
				System.out.println("Element is not displayed");
				Androiddriver.closeApp();
				Androiddriver.quit();
				assertion.fail("Element is not displayed");

				e.printStackTrace();
				return null;
			}
		}
		return text;

	}
	
//	public void turnOffAllData() {
//		if (platform.equalsIgnoreCase("iOS")) {
//	   
//		}else if (platform.equalsIgnoreCase("android")) {
////			Androiddriver.setConnection(Connection.NONE);
//
//
////			Androiddriver.setNetworkConnection(ncs);
//		}
//		
//
//	}

}
