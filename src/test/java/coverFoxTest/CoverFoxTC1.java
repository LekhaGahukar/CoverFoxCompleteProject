package coverFoxTest;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import coverFoxBase.Base;
import coverFoxPOM.CoverFoxAddressDetails;
import coverFoxPOM.CoverFoxHealthplan;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.coverFoxMemberDetails;
import coverFoxPOM.CoverFoxResultCombinePage;
import coverFoxUtility.Utility;
@Listeners(coverFoxUtility.Listener.class)
public class CoverFoxTC1 extends Base {

	CoverFoxHomePage homePage;
	CoverFoxHealthplan healthPlanPage;
	CoverFoxAddressDetails addressDetailsPage;
	coverFoxMemberDetails memberDetailsPage;
	CoverFoxResultCombinePage resultPage;
	String filePath;
	public static org.apache.log4j.Logger logger;
	

	@BeforeTest
	public void launchBrowser() {
		logger=org.apache.log4j.Logger.getLogger("CoverFoxInsurance");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Opening Browser");
		openBrowser();
		homePage = new CoverFoxHomePage(driver);
		healthPlanPage = new CoverFoxHealthplan(driver);
		addressDetailsPage = new CoverFoxAddressDetails(driver);
		memberDetailsPage = new coverFoxMemberDetails(driver);
		resultPage = new CoverFoxResultCombinePage(driver);

		filePath = System.getProperty("user.dir")+"\\velocityData.xlsx";
	}

	@BeforeClass
	public void preConditions() throws InterruptedException, EncryptedDocumentException, IOException {
		homePage.clickOnGenderButton();
		logger.info("Clicking On Gender Button");
		Thread.sleep(1000);
		healthPlanPage.clickOnNextButton();
	    logger.info("clicking on next button");
		memberDetailsPage.selectAgeFromDropDown(Utility.readExcelsheet(filePath, "Sheet5", 0, 0));
		logger.warn("Enter age between 18 to 90");
		logger.info("Handle age drop-down");
        
		memberDetailsPage.clickOnNextButton();
		 logger.info("clicking on next button");
		Thread.sleep(1000);
		addressDetailsPage.pinCodeTextBox(Utility.readExcelsheet(filePath, "Sheet5", 0, 1));
		logger.warn("Please entering valid pincode");
		logger.info("entering pincode");
		addressDetailsPage.mobileNoTextBox(Utility.readExcelsheet(filePath, "Sheet5", 0, 2));
		logger.warn("Please entering valid mobile number");
		logger.info("entering mobile number");
		addressDetailsPage.clickOnContinueButton();
		logger.info("clicking on continue button");

	}

	@Test
	public void validateBanners() throws InterruptedException {
		Thread.sleep(4000);
		//Assert.fail();
		int bannerPlanNumbers = resultPage.getPlanNumersFromBanners();
		int StringplanNumbers = resultPage.getPlanNumersFromString();
		logger.info("Validating Banner");
	    Assert.assertEquals(StringplanNumbers, bannerPlanNumbers,"Plans on banners not matching with results, TC failed");

	}

	@Test

	public void validateIsdisplyedSortPlan() throws IOException, InterruptedException {
		Thread.sleep(4000);
		//Assert.fail();
		boolean result = resultPage.getSortPlansIsDisplyed();
		logger.info("Validating presence of sort Button");
		Assert.assertTrue(result, "Sort plan DropDown is not displyed ,TC is failed");
		//Utility.screenshot(driver, "validateIsdisplyedSortPlan");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		logger.info("Closing Browser");
		browserClose();
	}
}
