package coverFoxPOM;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxResultCombinePage {
	// int result,numberOfBanner;
//webelements
	@FindBy(xpath = "//div[contains(text(),'Health Insurance Plans')]")
	private WebElement headingText;
	@FindBy(xpath = "//div[@class='plan-card-container']")
	private List<WebElement> banner;
	@FindBy(xpath = "//div[@class='f-select']")
	private WebElement dropdownlistisDisplyed;

	// constructor
	public CoverFoxResultCombinePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// methods
	public void getHeaderTextAndBannerCount() {
		String mytext = headingText.getText();
		System.out.println(mytext);
		String[] arr = mytext.split(" ");
		String numberInString = arr[0];
		int result = Integer.parseInt(numberInString);

		int numberOfBanner = banner.size();
		System.out.println(numberOfBanner);
		if (result == numberOfBanner) {
			System.out.println("Test Case is Passed");
		} else {
			System.out.println("Test Case is failed");
		}

	}

	public int getPlanNumersFromString() {
		String ar[] = headingText.getText().split(" ");
		int result1 = Integer.parseInt(ar[0]);
		return result1;
	}

	public int getPlanNumersFromBanners() {
		int bannerSize = banner.size();
		return bannerSize;
	}

	public boolean getSortPlansIsDisplyed() {
		boolean result = dropdownlistisDisplyed.isDisplayed();
		return result;
	}
}
