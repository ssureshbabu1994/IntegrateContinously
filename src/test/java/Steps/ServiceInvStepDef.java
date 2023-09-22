package Steps;

import org.openqa.selenium.JavascriptExecutor;

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

public class ServiceInvStepDef extends MobileWrapper {
	public static String osVersion;
	public static String functional;
	JavascriptExecutor jse;

	@When("I navigate to {string} screen for {string}")
	public void i_navigate_to_screen(String screen,String OSVersion) {
		osVersion = OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().clickOnElement(screen);

			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@When("I click on {string} in Service Inventory screen")
	public void i_click_on_okay_or_cancel_in_Service_Inventory_screen(String okorCancelBtn) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().clickOnElement(okorCancelBtn);

			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("I click on Continue in Service Inventory screen")
	public void i_click_on_continue_in_Service_Inventory_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().clickOnContinueInErrorMsg();

			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("I click on Leave in Service Inventory screen")
	public void i_click_on_leave_in_Service_Inventory_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().clickOnLeaveInServiceInvIfDisplayed();

			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@When("I click on coils and fill values in {string} fields")
	public void i_click_on_coils_and_fill_values_fields(String field) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().fillInInvForAllCoils(field);

			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@When("I click on coils retrieved from Picklist screen and fill values in {string} fields")
	public void i_click_on_coils_retrieved_from_picklist_and_fill_values_fields(String field) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().fillInInvForAllCoilsRetrievedFromPickListScreen(field);

			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}



	@And("I add {string} in {string} field")
	public void i_add_value_in_field(String value, String field) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().addValueInField(value, field);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I click on Leave in Service Inv Error message if displayed")
	public void i_click_on_Leave_in_Service_Inv_Error_message_if_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().clickOnLeaveInServiceInvIfDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	

	@Then("I navigate back to select activity screen from Service Inv screen")
	public void i_navigate_back_to_select_activity_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().clickOnBackBtnInServiceInv();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate Inv mandatory error message displayed")
	public void validate_inv_mandatory_error_msg_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().validateInvMandatoryErrorMsg();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I enter value in {string} and {string} field in any of the coil")
	public void validate_inv_mandatory_error_msg_displayed(String field1,String field2) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().fillInFieldForAnyCoil(field1, field2);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate if {string} value cannot be lesser than Fill")
	public void validate_if_field_value_cannot_be_lesser_than_Fill(String field) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().validateIfInvCannotBeLesserThanFill(field);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate if {string} value cannot be greater than Cap")
	public void validate_if_field_value_cannot_be_greater_than_Cap(String field) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().validateIfInvCannotBeGreaterThanCap(field);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate coil details for each coil displayed")
	public void validate_coil_details_for_each_coil_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().validateCoilDetailsForEachCoil();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate fields dispalyed for each coil")
	public void validate_fields_dispalyed_for_each_coil() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().validateFieldsDisplayedForEachCoil();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate if {string} field value is empty by default")
	public void validate_if_field_values_are_value_by_default(String field) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().validateFieldValueIsEmptyByDefault(field);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate if fields values for each coil is not empty by default")
	public void validate_if_field_value_is_empty_by_default() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().validateFieldValueIsNotEmptyByDefault();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate field values of each coil is lesser than or equal to respective coil Cap value")
	public void validate_field_values_of_each_coil_is_lesser_than_or_equal_to_respective_coil() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().validateFieldValuesOfCoilIsLessOrEqualToItsCap();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate swipe left or right to move between coils is displayed")
	public void validate_swipe_left_or_right_to_move_between_coils_is_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().validateSwipeLeftRightToMoveBetweenCoilsTextDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate if coil details in Picklist screen is displayed in Service Inv screen")
	public void validate_if_coil_details_in_Picklist_screen_is_displayed_in_Service_Inv_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ServiceInvPageAndroid().validateCoilDetailsRetrievedFromPickListToDisplayServiceInv();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}


}
