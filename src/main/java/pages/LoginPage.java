package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	 @FindBy(id="Email")
	 WebElement username;
	 
	 @FindBy(xpath="//input[@value='admin']")
	 WebElement password;
	 
	  @FindBy(xpath="//button[@type='submit']")
	  WebElement loginButton;
	  
	  public LoginPage(WebDriver driver) {
		  this.driver=driver;
		  PageFactory.initElements(driver,this);
	  }
	  public  void login(String email,String pass) {
		  username.clear();
		  username.sendKeys(email);
		  password.clear();
		  password.sendKeys(pass);;
		  loginButton.click();
	  }
    
}
