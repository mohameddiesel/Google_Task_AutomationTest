package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchedPage extends PageBase
{

	public SearchedPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="result-stats")
	public WebElement ResualtStatus ;
	
	//********************************************************************************************************
	public void StartTheNewSearch()
	{
		SearchByTextAndPressEnter(SearchBox,"salah");	
	}
	//********************************************************************************************************
	public void GoToPageNum(String Pagenumber)
	{
	String Pagenum =  "//a[@aria-label='Page "+Pagenumber+"']" ;
	WebElement pageNum = this.driver.findElement(By.xpath(Pagenum));
	ScrollDownAndClickOnElement(pageNum);
	}
}
