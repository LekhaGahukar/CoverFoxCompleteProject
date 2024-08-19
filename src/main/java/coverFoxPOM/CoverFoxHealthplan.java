package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHealthplan {
	// webelements
	@FindBy(className = "next-btn")
	private WebElement nextbutton;

	// constructor
	public CoverFoxHealthplan(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// method
	public void clickOnNextButton() {
		nextbutton.click();
	}

}
