package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage {
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstName;
	@FindBy(xpath="//input[@id='last-name']")  private WebElement lastName;
	@FindBy(xpath="//input[@id='postal-code']")private WebElement postalCode;
	@FindBy(xpath="//button[@id='cancel']")    private WebElement cancel;
	@FindBy(xpath="//input[@id='continue']")   private WebElement Continue;
	
	
	public Checkoutpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
 public void enterFirstName(String name)
 {
	 firstName.sendKeys(name);
 }
 public void enterLastName(String lastname)
 {
	 lastName.sendKeys(lastname);
 }
 public void enterPostalCode(String pin)
 {
	 postalCode.sendKeys(pin);
 }
 public void clickOnCancel()
 {
	 cancel.click();
 }
 public void clickOnContinue()
 {
	 Continue.click();
 }
}
