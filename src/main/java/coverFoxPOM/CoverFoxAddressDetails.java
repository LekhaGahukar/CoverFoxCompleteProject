package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxAddressDetails {
	@FindBy(xpath = "//input[@class='mp-input-text']")
	private WebElement pincodefield;
	@FindBy(id = "want-expert")
	private WebElement mobilenumberfield;
	@FindBy(className = "next-btn")
	private WebElement continueButton;
	@FindBy(xpath = "//div[contains(text(),' Please enter a valid pincode ')]")
	private WebElement pinErrorMsg;
	@FindBy(xpath = "//div[contains(text(),' Please enter a valid mobile no. ')]")
    private WebElement mobileErrorMsg;
	// constructor
	public CoverFoxAddressDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// method
	public void pinCodeTextBox(String pincodeValue) {
		pincodefield.sendKeys(pincodeValue);

	}

	public void mobileNoTextBox(String mobileNoValue) {
		mobilenumberfield.sendKeys(mobileNoValue);

	}

	
	public void pinCodeError(String pinCodeWrongValue)
	{
		pinErrorMsg.sendKeys(pinCodeWrongValue);
		
	}
	
	public void mobileNoError(String mobileNoWrongValue)
	
	{
		mobileErrorMsg.sendKeys(mobileNoWrongValue);
		
	}
	public String getPinErrorMsg()
	{
		String errorPinMsg = pinErrorMsg.getText();
		return errorPinMsg;
	}
	
	public String getMobErrorMsg()
	{
		String errorMobMsg=mobileErrorMsg.getText();
		return errorMobMsg;
	}
	public void clickOnContinueButton() {
		continueButton.click();
	}

}
