package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	@FindBy(xpath="//button[text()='Add to cart']")            private List<WebElement> addToCart;
	@FindBy(xpath="//select//option")                          private List<WebElement> productSorting;
	@FindBy(xpath="//div[@class='inventory_item_price']")      private List<WebElement> prices;
	@FindBy(xpath="//div[@class='inventory_item_description']")private List<WebElement> NoProductDisplay;
	@FindBy(xpath="//button[text()='Remove']")                 private List<WebElement> removeProductFromcart;
	@FindBy(xpath="//a[@class='shopping_cart_link']")          private WebElement cartLink; 
	
	public ProductPage(WebDriver driver) {
	PageFactory.initElements(driver,this );
	}
	
	public void clickOnAddToCart(int index)
	{
		addToCart.get(index).click();
	}
	
	public void clickonRemove(int index)
	{
		removeProductFromcart.get(index).click();
	}
	
	public int TotalNoOfProductDisplay()
    {
	int products =NoProductDisplay.size();
	return products;
     }
	public void clickOnCart()
	{
		cartLink.click();
	}

}
