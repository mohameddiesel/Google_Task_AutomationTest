package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase

{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	public void SearchForItem()
	{
		SearchByTextAndPressEnter(SearchBox,"diesel");
	}
}