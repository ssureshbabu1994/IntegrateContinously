package Steps;

import org.openqa.selenium.JavascriptExecutor;

import androidPages.CashPageAndroid;
import androidPages.LoginLogoutPageAndroid;
import androidPages.NotePageAndroid;
import androidPages.RoutePageAndroid;
import androidPages.ServiceInvPageAndroid;
import androidPages.OperatorPage;
import androidPages.PicklistPageAndroid;
import iOSPages.LoginLogoutPageiOS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobileWrap.MobileWrapper;

public class NoteStepDef extends MobileWrapper {
	public static String osVersion;
	public static String functional;
	JavascriptExecutor jse;

	@When("I click on {string} icon in select activity screen for {string}")
	public void i_click_on_note_screen_for_OS(String icon,String OSVersion) {
		osVersion = OSVersion;
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new NotePageAndroid().clickOnElement(icon);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}

	
	@Then("validate if route place and type is displayed in note screen")
	public void validate_if_route_and_place_and_type_is_displayed_in_note_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new NotePageAndroid().validateRoutePlaceTypeDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@And("validate if {string} is displayed in Note screen")
	public void validate_if_note_text_is_displayed_in_note_screen(String text) {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new NotePageAndroid().validateNoteTextDisplayed(text);
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("I navigate back to select activity screen from Note screen")
	public void i_navigate_back_to_select_activity_screen_from_Note_screen() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new NotePageAndroid().clickOnBack();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	 
	@And("validate if text box to compose message is displayed")
	public void validate_if_text_box_to_compose_message_is_displayed() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new NotePageAndroid().validateTextBoxToComposeMessageDisplayed();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate if user can enter text in note text box")
	public void validate_if_user_can_enter_text_in_note_text_box() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new NotePageAndroid().validateIfUserCanEnterTextInNoteTextBox();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("I navigate back and validate pop up confirmation")
	public void i_navigate_back_and_validate_pop_up_confirmation() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new NotePageAndroid().navigateBackAndValidateConfirmationPopUp();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	
	
	@And("validate if last saved note is displayed in Note text box")
	public void validate_if_last_saved_note_is_displayed_in_Note_text_box() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new NotePageAndroid().validateLastSavedNoteDisplayedInNoteTextBox();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
	@Then("validate user is able to edit the existing notes")
	public void validate_user_is_able_to_edit_the_existing_notes() {
		try {
			if (osVersion.equalsIgnoreCase("iOS")) {
			} else if (osVersion.equalsIgnoreCase("android")) {
				new NotePageAndroid().validateIfUserCanEditExistingNotes();
			}
		} catch (Exception e) {
			closeApp(osVersion);
			e.printStackTrace();
		}
	}
	
}
