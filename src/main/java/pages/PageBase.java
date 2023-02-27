package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase
{

	public WebDriver driver ;

	public  PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	//Search bar 
	@FindBy(xpath ="//input[@aria-label='بحث' or @aria-label='Search']")
	WebElement SearchBox ;

	@FindBy(xpath="//button[@aria-label='بحث' or @aria-label='Search']")
	WebElement SearchBtn;

	//********************************************************************************************************
	public void waitUntilWebElemntsVisiable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(80));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//********************************************************************************************************
	
	public void SearchByTextAndPressEnter(WebElement Element ,String value)
	{
		Element.clear();
		Element.sendKeys(value);
		Element.sendKeys(Keys.ENTER);
	}
	//********************************************************************************************************		
	public void ScrollDownAndClickOnElement(WebElement Element)
	{
		waitUntilWebElemntsVisiable(Element);
		Actions builder = new Actions(driver);
		builder.moveToElement(Element).build().perform();
		Element.click();
	}
	//********************************************************************************************************
	//Get all PageLinkes and Put them in the list then return the list size
	public int GetPageSize()
	{
		List<WebElement> PageLinks=driver.findElements(By.className("MjjYud"));
		return PageLinks.size();
	}
	//********************************************************************************************************
	//this function to get all alternatives Links in suggestion area and compare if they are equal or not 
	public boolean IsSuggesttionSearchAreEqual()
	{
		//XPath = all a inside b and their have parent called span
		List<WebElement> SuggesttionSearch=driver.findElements(By.xpath("(//a//b)//parent::span")); 
		for(int i=0;i<SuggesttionSearch.size()-1;i++)
		{
			for(int j=i+1;j<SuggesttionSearch.size();j++)
			{
				if(SuggesttionSearch.get(i).getText().equals(SuggesttionSearch.get(j).getText()) )
				{
					return true ;
				}	
			}
		}
		return false ;
	}}
