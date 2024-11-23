package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	public WebDriver ldriver;
	
	public CreateNewContactPage(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(ldriver, this);
		
	}
	@FindBy(xpath = "//li[@style='display: block;']//a[text()='Contacts']")
	public WebElement contactsLinks;
	
	@FindBy(xpath = "//li[@style='display: block;']//a[text()='Create Contact']")
	
	public WebElement newCreateContactlink;
	
	@FindBy(name ="Contacts[firstName]")
	public WebElement Fname;
	
	@FindBy(name = "Contacts[lastName]")
	
	public WebElement Lname;
	
	@FindBy(id ="save-button")
	public WebElement save;
	
	/// action method
	
	
	public String getPageTitle() {
		
		return ldriver.getTitle();
	}
	
	
	public void clickOnContactsMenu() {
		
			contactsLinks.click();
			
		}
	
	public void clickOnCreateContact() {
		
		Actions action = new Actions(ldriver);
		action.moveToElement(contactsLinks).build().perform();
		newCreateContactlink.click();
		
		}
	
	public void setFirstName(String fname) {
		Fname.sendKeys(fname);
		
	}
	
	public void setLastName(String lname) {
		Lname.sendKeys(lname);
	}
	
	
	public void clickOnCreate() {
		
		 save.click();
	}
	
	
	
	
	
	
	
	
	
	

}
