package Steps;

import org.openqa.selenium.JavascriptExecutor;

import androidPages.CashPageAndroid;
import androidPages.LoginLogoutPageAndroid;
import androidPages.RoutePageAndroid;
import androidPages.ServiceInvPageAndroid;
import androidPages.OperatorPage;
import androidPages.PicklistPageAndroid;
import iOSPages.LoginLogoutPageiOS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobileWrap.MobileWrapper;

public class CashStepDef extends MobileWrapper {
	public static String osVersion;
	public static String functional;
	JavascriptExecutor jse;

	@When("I click on {string} icon for {string}")
	public void i_click_on_cash_screen_for_OS(String icon,String OSVersion) {
		osVersion = OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().clickOnElement(icon);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@And("validate if cash headers are displayed")
	public void validate_if_cash_headers_are_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().validateCashHeadersDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@Then("validate the character limits of all fields")
	public void validate_character_limits_of_all_fields() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().validatecharLimitsOfAllFields();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	

	@Then("validate data is saved for all fields in cash page")
	public void validate_if_data_saved_for_all_fields_in_cash_page() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().validateDataIsSavedForAllFields();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("I click on {string} button in cash screen")
	public void i_click_on_button_in_cash_screen(String buttonName) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().clickOnElement(buttonName);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("I click on Okay button in cash screen")
	public void i_click_on_okay_button_in_cash_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().clickOnOkayBtn();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate if route place and type is displayed in Cash screen")
	public void validate_if_route_and_place_and_type_is_displayed_in_cash_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().validateRoutePlaceTypeDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate if {string} icon has {string} mark on all fields entry")
	public void validate_if_icon_has_mark(String icon, String compOrNoCompMark) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				if (compOrNoCompMark.equalsIgnoreCase("not completed")) {
					new CashPageAndroid().checkMarkNotDisplayed();
				} else if (compOrNoCompMark.equalsIgnoreCase("completed")) {
					new CashPageAndroid().checkMarkDisplayed();

				}
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I click on {string} field")
	public void i_click_on_field(String field) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().clickOnEle(field);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate watermark displayed for  all feilds in cash screen")
	public void validate_watermark_displayed_for_all_feilds_in_cash_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().validateWatermarkDisplayedForAllFields();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I navigate back to Scheduled asset screen from select activity screen")
	public void i_navigate_back_to_Scheduled_asset_screen_from_select_activity_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().navigateBackToScheduledAssetScreen();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	
	@And("validate if {string} field accepts decimal value")
	public void validate_if_field_accepts_decimal_value(String field) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().validateDecimalValueInField(field);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("I validate if doing tap on field will make focus to {string}")
	public void i_validate_if_doing_tab_will_move_focus_to_field(String field) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().validateOnClickingTapFocusIsOnField(field);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I enter previous asset value in {string} field")
	public void i_enter_previous_asset_value_in_field(String field) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().enterPreviousAssetFieldValue(field);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate if duplicate {string} value error message is displayed")
	public void validate_if_duplicate_field_value_error_message_is_displayed(String field) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new CashPageAndroid().validateDuplicateBagValueAlert();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	 

	
}
