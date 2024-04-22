package ui;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import InsurancePages.Search;
import base.BaseTest;

	public class SearchBar extends BaseTest{

	    @Test(priority = 1)
	    public void NavigateToLogin() throws InterruptedException {
	        webDriver.get(properties.getProperty("testUrl"));
	        Search searchPage=new Search(webDriver);
	        searchPage.setEmail("rizwan@gmail.com");
	        searchPage.setPassword("Rizwan@23");
			Thread.sleep(1000);
			searchPage.clickOnLoginButton();
			Thread.sleep(1000);
	        String alertMessage = webDriver.switchTo().alert().getText();
	        System.out.println(alertMessage);
	        webDriver.switchTo().alert().accept();
	        Thread.sleep(1000);
	        
	    }
	    @Test(priority = 2)
	      public void testSearchbar() throws InterruptedException {
	    	 
	          Search searchPage=new Search(webDriver);
	          searchPage.clickOnSearchButton();
	          searchPage.SearchTextBox("Home");
	          Thread.sleep(1000);
	          searchPage.clickOnSearchBarButton();
	          WebElement homeInsurance1 = webDriver.findElement(By.xpath("/html/body/app-root/app-data-display/div/div/div[2]/table/tbody/tr[1]"));
	          homeInsurance1.isDisplayed();
	          WebElement homeInsurance2 = webDriver.findElement(By.xpath("/html/body/app-root/app-data-display/div/div/div[2]/table/tbody/tr[2]"));
	          homeInsurance2.isDisplayed();
	          WebElement homeGuardSecureBuy = webDriver.findElement(By.xpath("/html/body/app-root/app-data-display/div/div/div[2]/table/tbody/tr[1]/td[6]/button"));
	          homeGuardSecureBuy.click();
	          Thread.sleep(1000);
	          String currUrl=webDriver.getCurrentUrl();
	  		  String expectedUrl="http://localhost:4200/home-buy1";
	  		  Assert.assertEquals(currUrl, expectedUrl);
	  		  
	  		  WebElement CoverageDetilsPage = webDriver.findElement(By.xpath("/html/body/app-root/app-home-buy1-details/div/div[2]")); //for "Customer details" header
	          Assert.assertTrue(CoverageDetilsPage.isDisplayed());
	  		 //for scroll down
	 		  WebElement element=webDriver.findElement(By.xpath("/html/body/app-root/app-home-buy1-details/div/div[3]/button"));
	 	      JavascriptExecutor js=(JavascriptExecutor)webDriver;
	 	      js.executeScript("arguments[0].scrollIntoView()",element);
	 		 
	 	      Thread.sleep(1000);
	          searchPage.clickOnAcceptandProceedButton();
	          Thread.sleep(1000);
        }
	    @Test(priority = 3)
	    public void testCustomerDetails() {
	    	String currUrl=webDriver.getCurrentUrl();
	  		  String expectedUrl="http://localhost:4200/customer-details";
	  		  Assert.assertEquals(currUrl, expectedUrl);
	    }
	    
	}
	
    