package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class OverviewPage extends BasePage{

	public OverviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//button[@id='finish']")
	private WebElement finish;
	
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']")
	private List<WebElement> allprice;



	public void setFinish() {
		
		finish.click();
	}



	public void setAllprice() {
		
		for(WebElement element:allprice) {
			
			String alltext=element.getText();
			System.out.println(alltext);
			
		}
	}

}
