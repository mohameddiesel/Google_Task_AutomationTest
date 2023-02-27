package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
public class TestBase {
	public static WebDriver driver ;

	@BeforeSuite
	public void SetupEnv ()
	{

		String chromePath = System.getProperty("user.dir")+"//drivers//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	@AfterTest
	public void CloseWindow()
	{
		driver.close();
	}
	@AfterSuite
	public void Quit()
	{
		driver.quit();

	}}
