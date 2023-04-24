package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	@FindBy(xpath="//input[@id='user-name']")   private WebElement  username;
	@FindBy(xpath="//input[@id='password']")    private WebElement password;
	@FindBy(xpath="//input[@id='login-button']")private WebElement login;
	@FindBy(xpath="//h3[@data-test='error']")   private WebElement errorMessage;
	
public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}


public void enterUsername(String user)
{
  username.sendKeys(user);
}

public void enterPassword(String pass)
{
	password.sendKeys(pass);
}

public void clickOnlogin()
{
	login.click();
}
public boolean DisplayingErrorMessage()
{
	boolean message=errorMessage.isDisplayed();
	return message;
}
}
