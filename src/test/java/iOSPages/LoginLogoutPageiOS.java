package iOSPages;

import Pages.DataRead;
import mobileWrap.MobileWrapper;

public class LoginLogoutPageiOS extends MobileWrapper {

	DataRead data = new DataRead();
	String sheetName = "LoginDetails";

	String username = "(//XCUIElementTypeOther[@name=\"Username\"])[3]/XCUIElementTypeTextField";
	String usernameclear = "(//XCUIElementTypeOther[@name=\"Password Show\"])[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";
	String password = "//XCUIElementTypeOther[@name=\"Password\"]/XCUIElementTypeSecureTextField";
	String login = "(//XCUIElementTypeOther[@name=\"LOG IN\"])[2]";
	String show = "//XCUIElementTypeOther[@name=\"Show\"]";
	String usernameorpassword = "//XCUIElementTypeStaticText[@name=\"Username and Password cannot be empty\"]";
	String validpassword = "//XCUIElementTypeStaticText[@name=\" Please enter a valid Password\"]";
	String validUsername = "//XCUIElementTypeStaticText[@name=\"Please enter a valid Username\"]";
	String Operator = "//XCUIElementTypeStaticText[@name=\"Operator\"]";
	String logout = "//XCUIElementTypeOther[@name=\"Logout\"]";
	String yes = "(//XCUIElementTypeOther[@name=\"Yes\"])[2]";
	String itemSearch = "(//XCUIElementTypeOther[@name=\"123 Munch 1234 Dairy milk 1234 Milkybar 45 Cookies American Express Caffe coffee Chips Coco cola Coffe Machine Donuts Goodday Kitkat Lays Merinda Milk Pepsi Treat America Trident Vertical scroll bar, 2 pages Horizontal scroll bar, 1 page\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField";
	String item = "(//XCUIElementTypeOther[@name=\"Chips\"])[3]";

	String UserName = data.getCellData(sheetName, "Username", 2);
	String operatorData = data.getCellData(sheetName, "Operator", 2);

	public LoginLogoutPageiOS clickOperator() {
		click("xpath", item);

		return this;
	}

	public LoginLogoutPageiOS VerifyItemSearchFilterSuccessfully() {

		verifyText(operatorData, "xpath", item);

		return this;
	}

	public LoginLogoutPageiOS enterSearchItem() {
		enterValue(operatorData, "xpath", itemSearch);

		return this;
	}

	public LoginLogoutPageiOS verifyItemSearch() {
		eleIsDisplayed("xpath", itemSearch);

		return this;
	}

	public LoginLogoutPageiOS clickLogoutYes() {
		click("xpath", yes);

		return this;
	}

	public LoginLogoutPageiOS clickLogout() {
		click("xpath", logout);

		return this;
	}

	public LoginLogoutPageiOS verifyOperatorText() {
		eleIsDisplayed("xpath", Operator);

		return this;
	}

	public LoginLogoutPageiOS verifyValidUsernameError() {
		eleIsDisplayed("xpath", validUsername);

		return this;
	}

	public LoginLogoutPageiOS enterValidPassword(String pwd) {
		enterValue(pwd, "xpath", password);

		return this;
	}

	public LoginLogoutPageiOS enterPasswordAlone(String pwd) {
		clear("xpath", usernameclear);
		enterValue(pwd, "xpath", password);

		return this;
	}

	public LoginLogoutPageiOS verifyValidPasswordError() {
		eleIsDisplayed("xpath", validpassword);

		return this;
	}

	public LoginLogoutPageiOS enterEmailAddress(String emailAddress) {
		String user = UserName;
		enterValue(emailAddress, "xpath", username);

		return this;
	}

	public LoginLogoutPageiOS verifyUsernamePasswordError() {
		eleIsDisplayed("xpath", usernameorpassword);
		return this;
	}

	public LoginLogoutPageiOS clickLogin() {
		click("xpath", login);

		return this;
	}

	public LoginLogoutPageiOS verifyUsername() {
		eleIsDisplayed("xpath", username);
		return this;
	}

	public LoginLogoutPageiOS verifyPassword() {
		eleIsDisplayed("xpath", password);

		return this;
	}

	public LoginLogoutPageiOS verifyShowlink() {
		eleIsDisplayed("xpath", show);

		return this;
	}

	public LoginLogoutPageiOS verifyLogin() {
		eleIsDisplayed("xpath", login);

		return this;
	}

}
