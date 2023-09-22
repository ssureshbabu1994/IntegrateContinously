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

public class OperatorStepDef extends MobileWrapper {
	public static String osVersion;
	public static String functional;
	JavascriptExecutor jse;

	@Then("I verify operator text in {string}")
	public void i_verify_operator_text_in(String OSVersion) {
		osVersion = OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
				new LoginLogoutPageiOS().verifyOperatorText();
			} else if (osVersion.equalsIgnoreCase("android")) {
				new OperatorPage().verifyOperatorText();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("I click on operator")
	public void i_click_on_operator() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new OperatorPage().clickOnOperator();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("I extract list of operators")
	public void i_extract_list_of_operators() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new OperatorPage().extractOperartors();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	
	
	@And("I validate if logout button along with username is displayed")
	public void i_validate_if_logout_button_along_with_username_is_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new OperatorPage().validatelogoutWithUsernameDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@When("I enter invalid operator in operator search field")
	public void i_enter_operator_name_in_search_field() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new OperatorPage().enterInvalidOperator();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	
	@Then("I validate if invalid operator name eror message is displayed")
	public void i_validate_if_invalid_operator_name_eror_message_is_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new OperatorPage().validateInvalidateOperatorErrorMsg();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I clear operator field")
	public void i_clear_operator_field() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new OperatorPage().clearOperatorField();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I validate if operators are displayed in alphabetical order")
	public void i_validate_if_operators_are_displayed_in_alphabetical_order() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new OperatorPage().validateIfOperatorsAreDisplayedAlphabeticalOrder();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@When("I enter valid operator in operator search field")
	public void i_enter_valid_operator_in_field() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new OperatorPage().enterValidOperator();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate if list is narrowed down with operator entered")
	public void validate_if_list_is_narrowed_down_with_operator_entered() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new OperatorPage().validateIfListNarrowedDownOnOpEntry();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate if operator field is cleared on clicking close")
	public void validate_if_operator_field_is_cleared_on_clicking_close() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new OperatorPage().validateIfOpValueIsCleared();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	
	

}
