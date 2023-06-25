package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.DataUtil;

public class LoginTest extends BaseTest {
	
	
	
	@Test(groups= "smoke",dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void loginTest(String username, String password) {
		
		setUp("chrome");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.setLogin();
		
	}

}
