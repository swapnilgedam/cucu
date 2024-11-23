package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(id = "LoginForm_username")
	public WebElement txt_username;
	
	@FindBy(id = "LoginForm_password")
	public WebElement txt_password;
	
	@FindBy(xpath = "//div[@id='signin-button-container']//button[@id='signin-button']")
	public WebElement loginbtn;
	
	
	public void setUserName(String uname) {
		txt_username.sendKeys(uname);
	}
	
	public void SetPassword(String pwd) {
		txt_password.sendKeys(pwd);
		
	}
	
	public void clickLogin() {
		
		WebDriverWait wait = new WebDriverWait(ldriver,50);
		wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(By.xpath("//div[@id='signin-button-container']//button[@id='signin-button']"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='signin-button-container']//button[@id='signin-button']"))));
		//WebElement login=driver.findElement(By.xpath("//div[@id='signin-button-container']//button[@id='signin-button']"));
		WebElement login=loginbtn;
		Actions act = new Actions(ldriver);
		act.click(ldriver.findElement(By.id("signin-button"))).perform();//four
		act.clickAndHold(login).release().perform();//six
		act.moveToElement(login).click().perform();//eight

		
		
		
		
		
		
		
		
		
	}

}
