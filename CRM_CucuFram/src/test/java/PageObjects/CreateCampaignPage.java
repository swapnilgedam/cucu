package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCampaignPage {
	
	public WebDriver ldriver;
	
	public CreateCampaignPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
  
	@FindBy(xpath = "//li[@style='display: block;']//a[text()='Marketing']")
	public WebElement marketinglink;
	
	
	@FindBy(xpath = "//li[@style='display: block;']//a[text()='Create Campaign']")
	
	public WebElement createcamp;
	
	@FindBy(xpath = "//input[@title='Name']")
	public WebElement camp;
	
	@FindBy(xpath = "//select[@name='Campaign[listId]']")
	
	public WebElement list;
	
	@FindBy(xpath = "//select[@name='Campaign[template]']")
	
	public WebElement EmailTemp;
	
	@FindBy(xpath = "//select[@name='Campaign[assignedTo]']")
	
	public WebElement assignto;
	
	@FindBy(xpath = "//select[@name='Campaign[visibility]']")
	
	public WebElement visibility;
	
	
	@FindBy(xpath = "//input[@name='yt2']")
	
	public WebElement create;
	
	//action method
      public String getPageTitle() {
		
		return ldriver.getTitle();
	}
	
	
	public void clickOnMarketingMenu() {
		
		marketinglink.click();
			
		}
	
	public void clickOnCreateCampaign() {
		
		Actions action = new Actions(ldriver);
		action.moveToElement(marketinglink).build().perform();
		createcamp.click();
		
		} 
	
	public void setCampaignName(String campname) {
		
		camp.sendKeys(campname);
		
	}
	
	public void setList(String value) {
		
		Select select=new Select(list);
		
		select.selectByVisibleText(value);
	}
	
	public void setEmailTempl(String value) {
      Select select=new Select(EmailTemp);
		
		select.selectByVisibleText(value);
		
	}
	public void setAssignto(String value) {
	      Select select=new Select(assignto);
			
			select.selectByVisibleText(value);
			
		}
	public void setVisibility(String value) {
	      Select select=new Select(visibility);
			
			select.selectByVisibleText(value);
			
		}
	public void clickOnCreateForSave() {
		
		create.click();
		
	}
}
