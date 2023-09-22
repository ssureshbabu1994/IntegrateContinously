package Steps;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hpsf.Array;
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

public class PicklistStepDef extends MobileWrapper {
	public static String osVersion;
	public static String functional;
	JavascriptExecutor jse;
	List<String> coilList=new ArrayList<>();

	
	
	@Then("I extract all the Coil Details from Picklist ")
	public void i_extract_all_the_Coil_Details_from_Picklist() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new PicklistPageAndroid().extractCoilsDetails();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}


	@Then("validate if route place and type is displayed in Pick list screen for {string}")
	public void validate_if_route_and_place_and_type_is_displayed_in_Pick_list_screen(String OSVersion) {
		osVersion=OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new PicklistPageAndroid().validateRoutePlaceTypeDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@And("validate if {string} icon has {string} mark")
	public void validate_if_icon_has_mark(String icon, String compOrNoCompMark) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				if (compOrNoCompMark.equalsIgnoreCase("not completed")) {
					new PicklistPageAndroid().checkMarkNotDisplayed(icon);
				} else if (compOrNoCompMark.equalsIgnoreCase("completed")) {
					new PicklistPageAndroid().checkMarkDisplayed(icon);

				}
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@Then("I click on {string} button")
	public void i_click_on_button(String buttonName) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new PicklistPageAndroid().clickOnElement(buttonName);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@And("I navigate back to select activity screen from Pick list screen")
	public void i_navigate_back_to_select_activity_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new PicklistPageAndroid().clickOnBackBtnInPicklist();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

//	@And("I validate coil details display in Picklist screen")
//	public void i_validate_coil_display_in_picklist_screen() {
//		try {
//			if (osVersion.equalsIgnoreCase("iOS")) {
//			} else if (osVersion.equalsIgnoreCase("android")) {
//				new PicklistPageAndroid().validateCoilDetailsDisplay();
//			}
//		} catch (Exception e) {
//			closeApp(osVersion);
//			e.printStackTrace();
//		}
//	}

	@And("I validate price mismatch error message in Pick list screen if displayed")
	public void i_validate_price_mismatch_error_message_in_Pick_list_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new PicklistPageAndroid().validateDexPriceMismatchIfDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	
	@And("I extract coils details from Picklist screen")
	public void i_extract_coils_details_from_Picklist_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				coilList=new PicklistPageAndroid().extractCoilsDetails();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	
	
	@And("I extract coil names from Picklist screen to validate in Service Inventory screen")
	public void i_extract_coil_names_from_Picklist_screen_to_validate_in_Service_Inventory_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new PicklistPageAndroid().extractCoilsNames();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
}
