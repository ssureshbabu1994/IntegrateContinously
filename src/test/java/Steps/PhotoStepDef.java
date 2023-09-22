package Steps;

import org.openqa.selenium.JavascriptExecutor;

import androidPages.CashPageAndroid;
import androidPages.LoginLogoutPageAndroid;
import androidPages.NotePageAndroid;
import androidPages.RoutePageAndroid;
import androidPages.ServiceInvPageAndroid;
import androidPages.OperatorPage;
import androidPages.PhotoPageAndroid;
import androidPages.PicklistPageAndroid;
import iOSPages.LoginLogoutPageiOS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobileWrap.MobileWrapper;

public class PhotoStepDef extends MobileWrapper {
	public static String osVersion;
	public static String functional;
	JavascriptExecutor jse;

	@When("I click on {string} icon and navigate to photo screen for {string}")
	public void i_click_on_photo_screen_for_OS(String icon, String OSVersion) {
		osVersion = OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new PhotoPageAndroid().clickOnElement(icon);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@Then("validate if photo features are displayed")
	public void validate_if_photo_features_are_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new PhotoPageAndroid().validatePhotoFeaturesDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@Then("validate if Photo icon is displayed")
	public void validate_if_icon_is_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new PhotoPageAndroid().validatePhotoIconDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@And("I click on {string} icon in photo screen")
	public void i_click_on_icon_in_photo_screen(String icon) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new PhotoPageAndroid().clickOnIconInPhotoScreen(icon);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate if Preview option is displayed for the previously captured photo")
	public void validate_if_Preview_option_is_displayed_for_the_previously_captured_photo() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new PhotoPageAndroid().validatePreviewOptionOfCapturedPhotoDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

}
