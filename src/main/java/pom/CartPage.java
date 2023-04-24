package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	
	@FindBy(xpath="//button[text()='Add to cart']")      private List<WebElement> addToCart;
	@FindBy(xpath="//button[text()='Remove']")           private List<WebElement> remove;
	@FindBy(xpath="//button[@name='continue-shopping']") private WebElement continueShopping;
	@FindBy(xpath="//button[@name='checkout']")          private WebElement checkout;
	@FindBy(xpath="//div[@class='cart_quantity']")       private List<WebElement> quantity;
	@FindBy(xpath="//div[@class='cart_item_label']")     private List<WebElement> noOfcartitems;
	
	
  public CartPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
    }
	
  public void clickOnContinueShopping()
	{
		continueShopping.click();
	}
	
  public void clickOnCheckout()
  {
	  checkout.click();
	  
  }
  
 public int noOfProductPresentInTheCart()
 {
	  int totalNoOfItemsInCart =noOfcartitems.size();
	  return totalNoOfItemsInCart;
 }
 
 public void clickOnRemove(int index)
 {
	 remove.get(index).click();
 }
 public void clickOnAddToCart(int index)
 {
	 addToCart.get(index).click();
 }

	
}

