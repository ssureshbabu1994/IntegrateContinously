package Steps;

import org.openqa.selenium.JavascriptExecutor;

import androidPages.LoginLogoutPageAndroid;
import androidPages.RoutePageAndroid;
import androidPages.OperatorPage;
import iOSPages.LoginLogoutPageiOS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobileWrap.MobileWrapper;

public class RouteStepDef extends MobileWrapper {
	public static String osVersion;
	public static String functional;
	JavascriptExecutor jse;

	
	
	@Then("I click on route in {string}")
	public void i_click_on_route(String OSVersion) {
		osVersion=OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new RoutePageAndroid().clickOnRoute();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("I click on route with multiple schedules in {string}")
	public void i_click_on_route_with_multiple_schedules(String OSVersion) {
		osVersion=OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new RoutePageAndroid().clickOnRouteWithMultipleSchedules();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	
	
	@When("I enter invalid route in route search field in {string}")
	public void i_enter_route_name_in_search_field(String OSVersion) {
		osVersion=OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new RoutePageAndroid().enterInvalidRoute();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	
	@Then("I validate if invalid route name eror message is displayed")
	public void i_validate_if_invalid_route_name_eror_message_is_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new RoutePageAndroid().validateInvalidateRouteErrorMsg();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I clear route field")
	public void i_clear_route_field() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new RoutePageAndroid().clearRouteField();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I validate if routes are displayed in alphabetical order")
	public void i_validate_if_routes_are_displayed_in_alphabetical_order() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new RoutePageAndroid().validateIfRoutesAreDisplayedAlphabeticalOrder();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@When("I enter valid route in route search field")
	public void i_enter_valid_route_in_field() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new RoutePageAndroid().enterValidRoute();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate if list is narrowed down with route entered")
	public void validate_if_list_is_narrowed_down_with_route_entered() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new RoutePageAndroid().validateIfListNarrowedDownOnRouteEntry();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate if route field is cleared on clicking close")
	public void validate_if_route_field_is_cleared_on_clicking_close() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new RoutePageAndroid().validateIfRouteValueIsCleared();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate if route page is displayed in {string}")
	public void validate_if_route_page_is_displayed(String OSVersion) {
		osVersion=OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new RoutePageAndroid().VerifyRouteText();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate if {string} screen is displayed")
	public void validate_if_scheduled_asset_screen__is_displayed(String screenName) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new RoutePageAndroid().validateScheduledAssetScreenDisplayed(screenName);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("I extract list of routes")
	public void i_extract_list_of_routes() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new RoutePageAndroid().extractOperartors();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

}
