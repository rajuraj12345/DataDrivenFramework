package testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OverviewPage;
import pages.RequestDemoPage;
import utilities.DataUtil;

public class HomePageTest extends BaseTest {
	
//	@Parameters({"browser"})
	@Test(groups= "smoke",dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void Home(String username, String password, String firstName, String lastName, String postalCode ) throws InterruptedException {
		
		
		setUp("chrome");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.setLogin();

		HomePage hp = new HomePage(driver);
		hp.setThreedots();
		Thread.sleep(2000);
		hp.setAbout();
		
		String expecetdURL=prop.getProperty("ExpectedURL");
		String actualURL=BasePage.currentURL();
		
		Assert.assertEquals(expecetdURL, actualURL);
		
		RequestDemoPage rdp = new RequestDemoPage(driver);
		rdp.naviate();
		
		String currentURL=prop.getProperty("CurrentURL");
		String actualCurrentURL=BasePage.currentURL();
		
		Assert.assertEquals(currentURL, actualCurrentURL);
		
		Thread.sleep(2000);
		
		hp.highestItem();
		hp.cartButton();
		
		String cartURL=prop.getProperty("checkoutURL");
		String actualCartURL=BasePage.currentURL();
		
		Assert.assertEquals(cartURL, actualCartURL);
		
		CartPage cp = new CartPage(driver);
		cp.checkOut();
		
		CheckOutPage cop = new CheckOutPage(driver);
		cop.setFirstName(firstName);
		cop.setLastName(lastName);
		cop.setPostalCode(postalCode);
		cop.setContinueButton();
		
		OverviewPage op = new OverviewPage(driver);
		op.setAllprice();
		op.setFinish();
		
		
		
		
		
	}
	
	

}
