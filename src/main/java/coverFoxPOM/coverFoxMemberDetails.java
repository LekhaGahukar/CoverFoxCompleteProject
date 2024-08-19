package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class coverFoxMemberDetails {
	// webelement
	@FindBy(xpath = "//select[@id='Age-You']")
	private WebElement ageDropDownList;
	@FindBy(xpath = "//div[text()='Next']")
	private WebElement nextButton;

	// constructor
	public coverFoxMemberDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// methods
	public void selectAgeFromDropDown(String agevalue)
	{
		Select s = new Select(ageDropDownList);
		s.selectByValue(agevalue+"y");
	}

	public void clickOnNextButton() {
		nextButton.click();
	}

	public void ageDropDownList(String excelsheet) {
		// TODO Auto-generated method stub
		
	}

}
