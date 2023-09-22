package Steps;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hpsf.Array;
import org.openqa.selenium.JavascriptExecutor;

import androidPages.DatePageAndroid;
import androidPages.LoginLogoutPageAndroid;
import androidPages.RoutePageAndroid;
import androidPages.ScheduledAssetPageAndroid;
import androidPages.ServiceInvPageAndroid;
import androidPages.OperatorPage;
import androidPages.PicklistPageAndroid;
import iOSPages.LoginLogoutPageiOS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobileWrap.MobileWrapper;

public class ScheduledAssetStepDef extends MobileWrapper {
	public static String osVersion;
	public static String functional;
	JavascriptExecutor jse;
	List<String> coilList=new ArrayList<>();

	@And("I click on asset in scheduled asset screen for {string}")
	public void i_click_on_asset_in_scheduled_asset_screen_for_OS(String OSVersion) {
		osVersion = OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ScheduledAssetPageAndroid().clickOnAsset();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I click on asset in scheduled asset screen having Service Inv mandatory for {string}")
	public void i_click_on_asset_in_scheduled_asset_screen_Service_Inv_mandatory_for_OS(String OSVersion) {
		osVersion = OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ScheduledAssetPageAndroid().clickOnAssetServiceInvMandatory();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I extract asset ID type and place from Scheduled asset screen for {string}")
	public void i_extract_asset_ID_type_and_place_from_Scheduled_asset_screen(String OSVersion) {
		osVersion = OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ScheduledAssetPageAndroid().extractAssetIDTypePlaceOfMachines();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I extract asset ID type and place of asset having Service Inv mandatory icon from Scheduled asset screen for {string}")
	public void i_extract_asset_ID_type_and_place_having_Service_Inv_mand_from_Scheduled_asset_screen(String OSVersion) {
		osVersion = OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ScheduledAssetPageAndroid().extractAssetIDTypePlaceOfMachinesServiceInvMandatory();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	@When("I click on {string} icon")
	public void i_click_on_icon(String icon) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ScheduledAssetPageAndroid().clickOnElement(icon);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate if selected route is displayed in scheduled asset screen")
	public void validate_if_selected_route_is_displayed_in_scheduled_asset_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ScheduledAssetPageAndroid().validateRouteDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate if locations are displayed")
	public void validate_if_locations_are_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ScheduledAssetPageAndroid().validateLocationsDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate if assets are displayed")
	public void validate_if_assets_are_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ScheduledAssetPageAndroid().validateAssetsDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate if {string} asset and {string} asset pane are displayed")
	public void validate_if_assets_panes_are_displayed(String scheduled,String serviced) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ScheduledAssetPageAndroid().validateAssetsPaneAreDisplayed(scheduled,serviced);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate if {string} action can be performed in scheduled asset screen for {string} version")
	public void validate_if_action_can_be_performed_in_scheduled_asset_screen(String anyOrNo,String OSVersion) {
		osVersion=OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ScheduledAssetPageAndroid().validateActionPerformed(anyOrNo);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I navigate back to Date screen from Scheduled Asset screen")
	public void i_navigate_back_to_date_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ScheduledAssetPageAndroid().clickOnBack();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("I click on another asset in scheduled asset screen")
	public void i_click_on_another_asset_in_scheduled_asset_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new ScheduledAssetPageAndroid().clickOnAnotherAsset();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	
}
