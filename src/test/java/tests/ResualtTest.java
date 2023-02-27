package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchedPage;

public class ResualtTest extends TestBase {
	HomePage homeobj ;
	SearchedPage SearchedPageObj ;

	@Test(priority = 1)
	public void StartSearchForSomething () throws InterruptedException
	{
		homeobj =new HomePage(driver);
		homeobj.SearchForItem();

		SearchedPageObj = new SearchedPage(driver);
		Assert.assertTrue(SearchedPageObj.ResualtStatus.isDisplayed());
	}
	@Test(priority = 2)
	public void ComparePagesResualts()
	{
		SearchedPageObj = new SearchedPage(driver);
		SearchedPageObj.StartTheNewSearch();

		SearchedPageObj.GoToPageNum("2");
		Assert.assertFalse(SearchedPageObj.IsSuggesttionSearchAreEqual());
		int Page2Size =SearchedPageObj.GetPageSize();


		SearchedPageObj.GoToPageNum("3");
		Assert.assertFalse(SearchedPageObj.IsSuggesttionSearchAreEqual());
		int Page3Size =SearchedPageObj.GetPageSize();

		Assert.assertEquals(Page2Size, Page3Size);
	}
}
