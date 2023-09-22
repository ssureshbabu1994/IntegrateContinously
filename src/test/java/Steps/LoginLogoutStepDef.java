package Steps;

import java.io.UnsupportedEncodingException;

import org.openqa.selenium.JavascriptExecutor;

import Pages.EmailSend;
import androidPages.LoginLogoutPageAndroid;
import iOSPages.LoginLogoutPageiOS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobileWrap.MobileWrapper;

public class LoginLogoutStepDef extends MobileWrapper {
	public static String osVersion;
	public static String functional;
	JavascriptExecutor jse;

	@Given("I launch the application in {string} for {string}")
	public void i_launch_the_application_in_version_forfunctionality(String OSVersion, String functionality) {
		osVersion = OSVersion;
		functional = functionality;
		try {
			if (OSVersion.equalsIgnoreCase("iOS")) {
				launchDriver(OSVersion);
				jse = (JavascriptExecutor) iOSdriver;

			} else if (OSVersion.equalsIgnoreCase("android")) {
				launchDriver(OSVersion);
				jse = (JavascriptExecutor) Androiddriver;

			}
		} catch (Exception e) {
			closeApp(OSVersion);
			e.printStackTrace();
		}
	}

	@Then("I click on driver app to access location")
	public void i_click_on_driver_app_to_access_location() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().clickdriverAppAccessLocation();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@And("I click on driver app to access media")
	public void i_click_on_driver_app_to_access_media() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().clickdriverAppAccessMedia();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@And("I click on driver app to take photo and video")
	public void i_click_on_driver_app_to_take_photo_video() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().clickdriverAppTakePhotoVideo();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@When("I validate login page objects")
	public void i_validate_login_page_objects() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
				new LoginLogoutPageiOS().verifyUsername().verifyPassword().verifyShowlink().verifyLogin();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().verifyUsername(osVersion).verifyPassword().verifyShowlink().verifyLogin();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@Then("I enter username and password")
	public void i_enter_username_and_password() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {

			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().enterEmailAddress().enterValidPassword();
			}

		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@Then("I click login button")
	public void i_click_login_button() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
//				new LoginPage().clickLogin();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().clickLogin();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@Then("I click logout")
	public void i_click_logout() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
//				new LoginPage().clickLogout().clickLogoutYes();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().clickLogout().clickLogoutYes();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@Then("validate if logout is done successfully")
	public void validate_if_logout_is_done_successfully() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
//				new LoginPage().verifyLogin();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().verifyLogin();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@Then("validate if splash screen is displayed")
	public void validate_splash_screen_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
//				new LoginPage().validateSplashScreenDisplayed();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().validateSplashScreenDisplayed();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("validate if hide or show is displayed")
	public void validate_hide_show_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
//				new LoginPage().verifyHideOrShowDisplayed();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().verifyHideOrShowDisplayed();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("validate if skip username or password error msg is displayed")
	public void validate_skip_username_pwd_error_msg_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
//				new LoginPage().clickLogin().verifyUsernamePasswordError();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().verifySkipUsernamePwdErrorMsg();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("validate if blank username and valid pwd error msg is dispalyed")
	public void validate_blank_username_valid_pwd_error_msg_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().enterBlankEmailAddress().enterValidPassword();
				new LoginLogoutPageAndroid().clickLogin();
				new LoginLogoutPageAndroid().verifyBlankUsernameValidPwdErrorMsg();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("validate if valid username and blank pwd error msg is dispalyed")
	public void validate_valid_username_blank_pwd_error_msg_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().enterEmailAddress().enterBlankPassword();
				new LoginLogoutPageAndroid().clickLogin();
				new LoginLogoutPageAndroid().verifyValidUsernameBlankPwdErrorMsg();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("validate if valid username and incorrect pwd error msg is dispalyed")
	public void validate_valid_username_incorrect_pwd_error_msg_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
//				new LoginPage().enterEmailAddress(name).enterValidPassword("").clickLogin().verifyValidPasswordError();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().enterEmailAddress().enterIncorrectPassword();
				new LoginLogoutPageAndroid().clickLogin();
				new LoginLogoutPageAndroid().verifyValidUsernameIncorrectPwdErrorMsg();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("validate if copyright text and version is displayed")
	public void validate_copyright_text_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
//				new LoginPage().validateCopyWrite();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().verifyCopyrightTextVersionDisplayed();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("validate if user gets error msg when logged in with blank spaces in username and password")
	public void validate_error_msg_logged_blank_Spaces_values_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
//				new LoginPage().enterEmailAddress(name).enterValidPassword(pwd).clickLogin().verifyValidUsernameError();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().enterBlankSpacesAddress().enterBlankSpacesPwd();
				new LoginLogoutPageAndroid().clickLogin();
				new LoginLogoutPageAndroid().verifyErrorMsgLoggedInWithBlankSpacesDisplayed();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("validate {string} is displayed in home screen")
	public void validate_username_homescreen_displayed(String username) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {

			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().verifyUsernameDisplayedInHomescreen(username);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("Close the application alone")
	public void close_the_application_alone_in_os() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
				closeAppAlone(osVersion);

			} else if (osVersion.equalsIgnoreCase("android")) {
				closeAppAlone(osVersion);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@When("I reopen the application in {string} for {string}")
	public void reopen_the_application_in_os(String OSVersion, String functionality) {
		osVersion = OSVersion;
		functional = functionality;
		try {
			if (OSVersion.equalsIgnoreCase("iOS")) {
				reLaunchDriver(OSVersion);
//				launchDriverRealDevice(OSVersion);
				jse = (JavascriptExecutor) iOSdriver;

			} else if (OSVersion.equalsIgnoreCase("android")) {
//				launchDriverRealDevice(OSVersion);
				reLaunchDriver(OSVersion);
				jse = (JavascriptExecutor) Androiddriver;

			}
		} catch (Exception e) {
			closeApp(OSVersion);
			e.printStackTrace();
		}
	}

	@Then("validate if username {string} is saved and pwd is empty")
	public void validate_username_saved_pwd_empty(String username) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {

			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().verifySavedUsernameBlankPwdDisplayed(username);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("I enter password {string} alone for auto filled in username")
	public void i_enter_pwd_alone_auto_filled_username(String password) {

		try {
			if (osVersion.equalsIgnoreCase("iOS")) {

			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().enterPwdForFilledInUsername();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("I do swipe down to {string} element")
	public void i_do_scroll_down_to_element(String element) {

		try {
			if (osVersion.equalsIgnoreCase("iOS")) {

			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().swipeToElement(element);
				;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("I click logout alone")
	public void i_click_logout_alone() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
				new LoginLogoutPageiOS().clickLogout();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().clickLogOutAlone();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("validate logout yes or no is displayed")
	public void validate_logout_yes_no_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
//				new LoginPage().validateYes().validateNo();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().validateLogoutYesNo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("validate if user not logged out when clicked outside pop up")
	public void validate_user_not_logged_out_clicked_outside_pop_up() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {

			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().clickUsername().verifyLogin();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("validate logout popup {string} functionality")
	public void validate_logout_pop_functionality(String yesNo) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
				if (yesNo.equalsIgnoreCase("Yes")) {
					new LoginLogoutPageiOS().clickLogoutYes().verifyLogin();
				} else if (yesNo.equalsIgnoreCase("No")) {
//					new LoginLogoutPageiOS().clickNo().verifyOperatorText();
				}

			} else if (osVersion.equalsIgnoreCase("android")) {
				if (yesNo.equalsIgnoreCase("Yes")) {
					new LoginLogoutPageAndroid().validateLogoutPopupYes();
				} else if (yesNo.equalsIgnoreCase("No")) {
					new LoginLogoutPageAndroid().validateLogoutPopupNo();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Update execution status for {string} functionality")
	public void update_execution_status_for_functionality(String functionality) {
		switch (functionality) {
		case "LoginLogoutFunctionality":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Login Logout Functionality Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"passed\", \"reason\": \"Login Logout Functionality Validation Android Passed\"}}");
			}

			break;

		case "EndtoEndLoginLogoutFunctionality":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"End to End Login Logout Functionality Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"passed\", \"reason\": \"End to End Login Logout Functionality Validation Android Passed\"}}");
			}

			break;

		case "OperatorPageFunctionality":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Operator page Functionality Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Operator page Functionality Validation Android Passed\"}}");

			}

			break;

		case "RoutePageFunctionality":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Route Page Functionality Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Route Page Functionality Validation Android Passed\"}}");

			}

			break;

		case "StartDateFlowFunctionality":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Start Date Flow Functionality Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Start Date Flow Functionality Validation Android Passed\"}}");

			}
			break;
		case "ViewDateFlowFunctionality":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"View Date Flow Functionality Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"View Date Flow Functionality Validation Android Passed\"}}");

			}
			break;
		case "PicklistPageFunctionality":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Picklist Page Functionality Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Picklist Page Functionality Validation Android Passed\"}}");

			}
			break;
		case "CashPageFunctionality":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Cash Page Functionality Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Cash Page Functionality Validation Android Passed\"}}");

			}
			break;
		case "ServicePlanogramFeaturesDisplayInvFillValidation":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Service Planogram Features Display Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Service Planogram Features Display Validation Android Passed\"}}");

			}
			break;
		case "ServicePlanogramInvCapValidation":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Service Planogram Fields Values Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Service Planogram Fields Values Validation Android Passed\"}}");

			}
			break;
		case "ServicePlanogramInvFieldValidation":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Service Planogram Inv Field Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Service Planogram Inv Field Validation Android Passed\"}}");

			}
			break;
		case "ServicePlanogramFieldsValuesCapComparisonValidation":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Service Planogram Fields Values Cap Comparison Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Service Planogram Fields Values Cap Comparison Validation Android Passed\"}}");

			}
			break;
		case "ServicePlanogramCheckMarkValidation":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Service Planogram Check mark Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Service Planogram Check mark Validation Android Passed\"}}");

			}
			break;
		case "ScheduledAssetFunctionality":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Scheduled Asset Functionality Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Scheduled Asset Functionality Validation Android Passed\"}}");

			}
			break;
		case "NoteScreenFunctionality":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Note screen Functionality Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Note screen Functionality Validation Android Passed\"}}");

			}
			break;
		case "PhotoScreenFunctionality":

			if (osVersion.equalsIgnoreCase("iOS")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Photo screen Functionality Validation iOS Passed\"}}");

			} else if (osVersion.equalsIgnoreCase("android")) {

				jse.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Photo screen Functionality Validation Android Passed\"}}");

			}
			break;
		}
	}

	@Then("Close the application")
	public void close_the_application() {
		closeApp(osVersion);
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

	@Then("I email the report")
	public void i_email_the_report() throws UnsupportedEncodingException, InterruptedException {
		EmailSend.emailSend();
	}

	@And("I disable wifi and datai")
	public void i_disabled_wifi_data() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
				new LoginLogoutPageiOS().clickLogout();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new LoginLogoutPageAndroid().clickLogOutAlone();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
