package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import InsurancePages.CustomerSupport;
import base.BaseTest;

public class CustomerSupportTab extends BaseTest {
	

	@Test(priority = 1)
    public void NavigateToHomePage() throws InterruptedException {
        //webDriver.get(properties.getProperty("testUrl"));
        CustomerSupport support =new CustomerSupport(webDriver);
        support.setEmail("nexa@gmail.com");
        support.setPassword("Maragatham@1314");
		Thread.sleep(1000);
		support.clickOnLoginButton();
		Thread.sleep(1000);
        String alertMessage = webDriver.switchTo().alert().getText();
        System.out.println(alertMessage);
        webDriver.switchTo().alert().accept();
        Thread.sleep(1000);
	}
	@Test(priority = 2)
    public void testNoEntrySupportPage() throws InterruptedException {
		 CustomerSupport support =new CustomerSupport(webDriver);
		 support.clickOnSupportButton();
		 Thread.sleep(1000);
		 support.clickOnBackButton();
		 
		 Thread.sleep(1000);
		 support.clickOnSupportButton();
		 support.setName("");
		 support.setEmailinCustomerSupport("");
		 support.setPhoneNumber("");
		 support.setMessage("");
		 Thread.sleep(1000);
		 support.clickOnSubmitButton();
		 Thread.sleep(2000);
		 String alertMessage = webDriver.switchTo().alert().getText();
	     System.out.println("Alert Message for No Entry = " + alertMessage);
	     webDriver.switchTo().alert().accept();
	     Thread.sleep(1000);
		 
		 WebElement errorMessageName= webDriver.findElement(By.xpath("//*[@id=\"contact\"]/fieldset[1]/span"));
	     WebElement errorMessageEmail= webDriver.findElement(By.xpath("//*[@id=\"contact\"]/fieldset[2]/span"));
	     WebElement errorMessagePhoneNumber= webDriver.findElement(By.xpath("//*[@id=\"contact\"]/fieldset[3]/span"));
	     WebElement errorMessageMessage= webDriver.findElement(By.xpath("//*[@id=\"contact\"]/fieldset[4]/span"));
	        
	        
	     Assert.assertTrue(errorMessageName.isDisplayed(),"Name is required");
	     Assert.assertTrue(errorMessagePhoneNumber.isDisplayed(), "Email is required");
	     Assert.assertTrue(errorMessageEmail.isDisplayed(), "Phone number is required");
	     Assert.assertTrue(errorMessageMessage.isDisplayed(), "Please enter a message (10-250 characters).");
	     Thread.sleep(1000);
	    
	     
	}
	
	@Test(priority = 3)
    public void testInvalidSupportPage() throws InterruptedException {
		 CustomerSupport support =new CustomerSupport(webDriver);
		 support.setName("832819281");
		 support.setEmailinCustomerSupport("mouniii");
		 support.setPhoneNumber("1187889865535");
		 Thread.sleep(1000);
		 //for scroll down
		 WebElement element=webDriver.findElement(By.xpath("/html/body/app-root/app-customer-support/div[2]/div[2]/form/fieldset[5]/button[1]"));
	     JavascriptExecutor js=(JavascriptExecutor)webDriver;
	     js.executeScript("arguments[0].scrollIntoView()",element);
		 
	     Thread.sleep(1000);
	     
		 support.clickOnSubmitButton();
		 Thread.sleep(2000);
		 String alertMessage = webDriver.switchTo().alert().getText();
	     System.out.println("Alert Message for Invalid data = " + alertMessage);
	     webDriver.switchTo().alert().accept();
	     Thread.sleep(2000);
		 
		 WebElement errorMessageName= webDriver.findElement(By.xpath("//*[@id=\"contact\"]/fieldset[1]/span"));
	     WebElement errorMessageEmail= webDriver.findElement(By.xpath("//*[@id=\"contact\"]/fieldset[2]/span"));
	     WebElement errorMessagePhoneNumber= webDriver.findElement(By.xpath("//*[@id=\"contact\"]/fieldset[3]/span"));
	        
	     Assert.assertTrue(errorMessageName.isDisplayed(),"Please enter a valid name using only(letters and spaces)");
	     Assert.assertTrue(errorMessagePhoneNumber.isDisplayed(), "Invalid email format");
	     Assert.assertTrue(errorMessageEmail.isDisplayed(), "Please enter a valid phone number starting with 6-9 and having 10 digits");
	     Thread.sleep(1000);
	     webDriver.navigate().refresh();
	     
	}
	
	@Test(priority = 5)
    public void testSupportpage() throws InterruptedException {
		 CustomerSupport support =new CustomerSupport(webDriver);
		 Thread.sleep(1000);
		 support.clickOnSupportButton();
		 WebElement customerSuppportDetails= webDriver.findElement(By.xpath("/html/body/app-root/app-customer-support/div[2]"));
	     customerSuppportDetails.isDisplayed();
		 support.setName("Nexa");
		 support.setEmailinCustomerSupport("nexa@gmail.com");
		 support.setPhoneNumber("9867657897");
		 support.setMessage("Test Support page");
		 Thread.sleep(1000);
		 support.clickOnSubmitButton();
		 Thread.sleep(2000);
		 String alertMessage = webDriver.switchTo().alert().getText();
	     System.out.println("Alert Message for valid data = " + alertMessage);
	     webDriver.switchTo().alert().accept();
	     Thread.sleep(1000);
	     
	    
	    
	}
}