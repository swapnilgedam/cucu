package StepsDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.CreateCampaignPage;
import PageObjects.CreateNewContactPage;
import PageObjects.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends BaseClass{
	
	//public WebDriver driver;
	//public LoginPage lp;
	//CreateNewContactPage createcon;
	// CreateCampaignPage campaignpage;
	
	@Given("^User launch Chrome browser$")
	public void user_launch_Chrome_browser() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	    lp=new LoginPage(driver);
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) throws Throwable {
		
		driver.get(url);
	   
	}

	@When("^User enters Username as \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void user_enters_Username_as_and_Password(String username, String password) throws Throwable {
		lp.setUserName(username);
		lp.SetPassword(password);
	   
	}

	@When("^Click on Login$")
	public void click_on_Login() throws Throwable {
		
		lp.clickLogin();
	    
	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String title) throws Throwable {
		
		if (driver.getPageSource().contains("Incorrect username or password")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}
	    
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
		
		driver.quit();
	    
	}
	/// Contacts feature step definations.....................................................................................................

	@Then("^User can view Home page$")
	public void user_can_view_Home_page() throws Throwable {
		
		createcon=new CreateNewContactPage(driver);
		Assert.assertEquals("CRM Tech - View Profile",createcon.getPageTitle());
	    
	}

	@When("^User click on contacts menu$")
	public void user_click_on_contacts_menu() throws Throwable {
		createcon.clickOnContactsMenu();
	    
	}

	@When("^click on create contact$")
	public void click_on_create_contact() throws Throwable {
		createcon.clickOnCreateContact();
	}

	@Then("^User can view create contact page$")
	public void user_can_view_create_contact_page() throws Throwable {
		
		Assert.assertEquals("CRM Tech - Create Contacts",createcon.getPageTitle());
	    
	}

	@When("^user enters contact info$")
	public void user_enters_contact_info() throws Throwable {
		
		Thread.sleep(3000);
		createcon.setFirstName("abhishek");
		createcon.setLastName("Pathak");
	    
	}

	@When("^click on create button$")
	public void click_on_create_button() throws Throwable {
		Thread.sleep(2000);
		createcon.clickOnCreate();
	}

	@Then("^User can view contact added in all contacts$")
	public void user_can_view_contact_added_in_all_contacts() throws Throwable {
		
		createcon.clickOnContactsMenu();
		Assert.assertEquals("CRM Tech - Contacts",createcon.getPageTitle());
	    
	}
///marketing feature step defination
	
	@When("^User click on Marketing menu$")
	public void user_click_on_Marketing_menu() throws Throwable {
		campaignpage=new CreateCampaignPage(driver);
		campaignpage.clickOnMarketingMenu();
	    
	}

	@When("^click on create campaign$")
	public void click_on_create_campaign() throws Throwable {
		campaignpage.clickOnCreateCampaign();
	    
	}

	@Then("^User can view create campaign page$")
	public void user_can_view_create_campaign_page() throws Throwable {
		Assert.assertEquals("Create Campaign",campaignpage.getPageTitle());
	    
	}

	@When("^user enters campaign info$")
	public void user_enters_campaign_info() throws Throwable {
		campaignpage.setCampaignName("Double Blast Email");
		campaignpage.setList("ClientsFromPune");
		campaignpage.setEmailTempl("Custom");
		campaignpage.setAssignto("System Administrator");
		campaignpage.setVisibility("Public");
	   
	}

	@When("^click on create button for save campaign$")
	public void click_on_create_button_for_save_campaign() throws Throwable {
		campaignpage.clickOnCreateForSave();
	}

	@Then("^User can view campaign added in all camapign$")
	public void user_can_view_campaign_added_in_all_camapign() throws Throwable {
		campaignpage.clickOnMarketingMenu();
		Assert.assertEquals("Campaigns",campaignpage.getPageTitle());
		
	    
	}


}


