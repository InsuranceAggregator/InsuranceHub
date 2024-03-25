package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

public class RegistrationPage extends BaseTest{
    
    @Test(priority = 1)
    public void testRegistrationPageHeader() throws InterruptedException {
    	webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/div/p/a")).click(); //signon link
        WebElement ExpectedTitle = webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/h2")); //for "Register" title
        Assert.assertTrue(ExpectedTitle.isDisplayed());
        
    }
    @Test(priority = 2)
    public void NavigateToLogin() throws InterruptedException {
    	//webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/div/p/a")).click();
        WebElement ExpectedText = webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/div/p"));
        Assert.assertTrue(ExpectedText.isDisplayed());
        webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/div/p/a")).click(); //login link
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    public void testSuccessfulRegistration() throws InterruptedException {
    	webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/div/p/a")).click();
    	webDriver.findElement(By.id("name")).sendKeys("Mounika");
        Thread.sleep(2000);
        webDriver.findElement(By.id("mobile")).sendKeys("9865626358");
        Thread.sleep(2000);
        webDriver.findElement(By.id("email")).sendKeys("mounikamargatham1@gmail.com");
        Thread.sleep(2000);
        webDriver.findElement(By.id("password")).sendKeys("Moni@1314");
        Thread.sleep(2000);
        webDriver.findElement(By.id("confirmPassword")).sendKeys("Moni@1314");
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(2000);
        
        String alertMessage = webDriver.switchTo().alert().getText();
        System.out.println(alertMessage);
        webDriver.switchTo().alert().accept();
        
    }
 
    @Test(priority = 4)
    public void testInvalidRegistration() throws InterruptedException {
    	webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/div/p/a")).click();
    	webDriver.findElement(By.id("name")).sendKeys("7676889@");
        Thread.sleep(2000);
        webDriver.findElement(By.id("mobile")).sendKeys("98656263581");
        Thread.sleep(2000);
        webDriver.findElement(By.id("email")).sendKeys("moniiii");
        Thread.sleep(2000);
        webDriver.findElement(By.id("password")).sendKeys("uhuuyiiy");
        Thread.sleep(2000);
        //webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/button")).click(); //register button
        webDriver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(2000);
        
        String alertMessage1 = webDriver.switchTo().alert().getText();
        System.out.println("AlertMessage1 = " +alertMessage1);
        webDriver.switchTo().alert().accept();
        Thread.sleep(2000);
        String alertMessage2 = webDriver.switchTo().alert().getText();
        System.out.println("AlertMessage2 = " +alertMessage2);
        webDriver.switchTo().alert().accept();
        
        
        WebElement errorMessageName= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[1]/div/div"));
        Assert.assertTrue(errorMessageName.isDisplayed());
        Thread.sleep(2000);
        WebElement errorMessageMobileNumber= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[2]/div/div"));
        Assert.assertTrue(errorMessageMobileNumber.isDisplayed());
        Thread.sleep(2000);
        WebElement errorMessageEmail= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[3]/div/div"));
        Assert.assertTrue(errorMessageEmail.isDisplayed());
        Thread.sleep(2000);
        WebElement errorMessagePassword= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[4]/div/div"));
        Assert.assertTrue(errorMessagePassword.isDisplayed());
        WebElement errorMessageConfirmPassword= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[5]/div/div"));
        Assert.assertTrue(errorMessageConfirmPassword.isDisplayed());
        Thread.sleep(2000);
        webDriver.navigate().refresh();
    }
    @Test(priority = 5)
    public void testNoEntryRegistration() throws InterruptedException {
    	//webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/div/p/a")).click();
    	webDriver.findElement(By.id("name")).sendKeys("");
        Thread.sleep(2000);
        webDriver.findElement(By.id("mobile")).sendKeys("");
        Thread.sleep(2000);
        webDriver.findElement(By.id("email")).sendKeys("");
        Thread.sleep(2000);
        webDriver.findElement(By.id("password")).sendKeys("");
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector(".btn.btn-primary")).click();
        //webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/button")).click();
        Thread.sleep(2000);
        
        String alertMessage = webDriver.switchTo().alert().getText();
        System.out.println("AlertMessage = " +alertMessage);
        webDriver.switchTo().alert().accept();
        Thread.sleep(2000);
        
        WebElement errorMessageName= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[1]/div/div"));
        Assert.assertTrue(errorMessageName.isDisplayed());
        Thread.sleep(2000);
        WebElement errorMessageMobileNumber= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[2]/div/div"));
        Assert.assertTrue(errorMessageMobileNumber.isDisplayed());
        Thread.sleep(2000);
        WebElement errorMessageEmail= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[3]/div/div"));
        Assert.assertTrue(errorMessageEmail.isDisplayed());
        Thread.sleep(2000);
        WebElement errorMessagePassword= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[4]/div/div"));
        Assert.assertTrue(errorMessagePassword.isDisplayed());
        WebElement errorMessageConfirmPassword= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[5]/div/div"));
        Assert.assertTrue(errorMessageConfirmPassword.isDisplayed());
        Thread.sleep(2000);
        
    }
       
}


