package test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.CartPage;
import pom.Checkoutpage;
import pom.LoginPage;
import pom.OverviewPage;
import pom.ProductPage;
import utility.Report;
@Listeners(test.Listeners.class)

public class VerifyLoginFunctionality extends BaseClass{
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void setUpReports()
	{
		reports= Report.createReports();
	}
	
	
	
//	@DataProvider(name="loginData")
//	public Object [][] loginTestData()
//	{   
//		return new Object [][] {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},{"problem_user","secret_sauce"},{"performance_glitch_user","secret_sauce"}};
//	}
//	
	@BeforeMethod
	@Parameters({"browser"})
	public void openBrowser(String browser)
	{
		driver=Browser.launchBrowser(browser);
		
	}
	
	
	@Test//(dataProvider="loginData")
	public void verifyLoginFunctionalityWithStandardUser()
	{   test=reports.createTest("verifyLoginFunctionalityWithStandardUser");
		LoginPage loginPage= new LoginPage(driver);
		
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnlogin();
		ProductPage productPage = new ProductPage(driver);
		Assert.assertEquals(6,productPage.TotalNoOfProductDisplay() );
		
	}
	@Test
	public void verifyLoginFunctionalityWithLockedUser()
	{ test=reports.createTest("verifyLoginFunctionalityWithLockedUser");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("locked_out_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnlogin();
		Assert.assertEquals(true, loginPage.DisplayingErrorMessage());
	}
	@Test
	public void verifyLoginWithProblemUser()
	{ test=reports.createTest("verifyLoginWithProblemUser");
		LoginPage loginPage= new LoginPage(driver);
		loginPage.enterUsername("problem_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnlogin();
	    ProductPage productPage = new ProductPage(driver);
	    Assert.assertEquals(6,productPage.TotalNoOfProductDisplay() );
	}
	@Test
	public void verifyLoginWithPerformanceGlitchUser()
	{ test=reports.createTest("verifyLoginWithPerformanceGlitchUser");
		LoginPage loginPage= new LoginPage(driver);
		loginPage.enterUsername("performance_glitch_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnlogin();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		ProductPage productPage = new ProductPage(driver);
	    Assert.assertEquals(6,productPage.TotalNoOfProductDisplay() );
		
	}
	
	@Test
	public void verifyCustomerShouldBeAbledToaddProductInTheCart()
	{test=reports.createTest("verifyCustomerShouldBeAbledToaddProductInTheCart");
        LoginPage loginPage= new LoginPage(driver);
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnlogin();
		
		ProductPage productPage= new ProductPage(driver);
		productPage.clickOnAddToCart(0);
		productPage.clickOnCart();
		CartPage cartPage= new CartPage(driver);
		Assert.assertEquals(true, 0<cartPage.noOfProductPresentInTheCart());
	}
	
	@Test
	public void verifyCustomerShouldBeAbledToAddMultipleProduct()
	{
	test=reports.createTest("verifyCustomerShouldBeAbledToAddMultipleProduct");
    LoginPage loginPage= new LoginPage(driver);
	loginPage.enterUsername("standard_user");
	loginPage.enterPassword("secret_sauce");
	loginPage.clickOnlogin();
	
	ProductPage productPage= new ProductPage(driver);
	productPage.clickOnAddToCart(0);
	productPage.clickOnAddToCart(2);
	productPage.clickOnCart();
	CartPage cartPage= new CartPage(driver);
	
	Assert.assertTrue(1<cartPage.noOfProductPresentInTheCart());
		
	}
	
	@Test
	public void VerifyIfCustomerIsAbleToRemoveProductFromCart()
	{
		test=reports.createTest("VerifyIfCustomerIsAbleToRemoveProductFromCart");
        LoginPage loginPage= new LoginPage(driver);
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnlogin();
		
		ProductPage productPage= new ProductPage(driver);
		productPage.clickOnAddToCart(0);
		productPage.clickOnCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickOnRemove(0);
		Assert.assertEquals(0, cartPage.noOfProductPresentInTheCart());
		
	}
	@Test
	public void verifyIfCustomerAbleToPlaceAnOrder()
	{
		test=reports.createTest("verifyIfCustomerAbleToPlaceAnOrder");
        LoginPage loginPage= new LoginPage(driver);
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnlogin();
		
		ProductPage productPage= new ProductPage(driver);
		productPage.clickOnAddToCart(2);
		productPage.clickOnCart();
		
		CartPage cartPage= new CartPage(driver);
		cartPage.clickOnCheckout();
		Checkoutpage checkoutpage= new Checkoutpage(driver);
		checkoutpage.enterFirstName("shilpa");
		checkoutpage.enterLastName("dukare");
		checkoutpage.enterPostalCode("411017");
		checkoutpage.clickOnContinue();
		OverviewPage overviewPage= new OverviewPage(driver);
		Assert.assertEquals(true, overviewPage.isDisplyedFinish());
	}
	
	@AfterMethod
	public void getTestResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getName());
		}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getName());
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterTest
	public void publishReport()
	{
		reports.flush();
	}
	
}
