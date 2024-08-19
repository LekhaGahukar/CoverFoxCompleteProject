package coverFoxBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class Base {
	static protected WebDriver driver;

	public void openBrowser() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.get("https://www.coverfox.com/");
		Reporter.log("Launching Browser", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		Reporter.log("Waiting....", true);

	}

	public void browserClose() throws InterruptedException {
		Reporter.log("Closing Browser", true);
		Thread.sleep(2000);
		driver.close();
	}
}
