package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
	@FindBy(xpath="//button[text()='Finish']")   private WebElement finish;
	@FindBy(xpath="//button[@id='cancel']")      private WebElement cancel;
	
	
	
	public OverviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public void clickOnFinish()
	{
		finish.click();
	}
	
	public void clickOnCancel()
	{
		cancel.click();
	}
	public boolean isDisplyedFinish()
	{
		boolean display =finish.isDisplayed();
		return display;
	}
}
