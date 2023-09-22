package Steps;

import org.openqa.selenium.JavascriptExecutor;

import androidPages.DatePageAndroid;
import androidPages.LoginLogoutPageAndroid;
import androidPages.RoutePageAndroid;
import androidPages.OperatorPage;
import iOSPages.LoginLogoutPageiOS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobileWrap.MobileWrapper;

public class DateStepDef extends MobileWrapper {
	public static String osVersion;
	public static String functional;
	JavascriptExecutor jse;

	
	@Then("validate if Date page is displayed for {string}")
	public void validate_if_date_page_is_displayed(String OSVersion) {
		osVersion = OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new DatePageAndroid().VerifyDateText();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	 
	 @And("validate if selected route is displayed in Date screen")
		public void validate_if_selected_route_is_displayed_in_date_screen() {
			try {
				if (osVersion.equalsIgnoreCase("iOS")) {
				} else if (osVersion.equalsIgnoreCase("android")) {
					new DatePageAndroid().validateSelectedRouteDisplayed();
				}
			} catch (Exception e) {
				closeApp(osVersion);
				e.printStackTrace();
			}
		}
	 
	 @And("validate if selected route with multiple schedules is displayed in Date screen")
		public void validate_if_selected_route_iwith_multiple_schedules_is_displayed_in_date_screen() {
			try {
				if (osVersion.equalsIgnoreCase("iOS")) {
				} else if (osVersion.equalsIgnoreCase("android")) {
					new DatePageAndroid().validateSelectedRouteWithMultipleSchedulesDisplayed();
				}
			} catch (Exception e) {
				closeApp(osVersion);
				e.printStackTrace();
			}
		}
	
	@And("validate if {string} and {string} buttons are displayed")
	public void validate_if_start_view_are_displayed(String start,String view) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new DatePageAndroid().verifyStartViewBtnsDsiplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate if dates are displayed in ascending order")
	public void validate_if_dates_displayed_ascending_order() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new DatePageAndroid().validateDatesInAscendingOrderDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@When("I click on enabled {string} button")
	public void i_click_on_enabled_button(String startOrView) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new DatePageAndroid().clickOnEnabledstartOrViewBtn(startOrView);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	

}
