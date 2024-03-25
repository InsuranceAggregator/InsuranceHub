package ui;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
//import io.github.bonigarcia.wdm.WebDriverManager;



    
	/*public void verifyLogin() throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
	      driver=new ChromeDriver();
		  driver.manage().window().maximize();
	      driver.get("baseurl");
	      driver.findElement(By.name("Email")).sendKeys("mounikamurugesan1308@gmail.com");
	      Thread.sleep(2000);
	      driver.findElement(By.name("Password")).sendKeys("moni@13");
	      Thread.sleep(2000);
	      driver.findElement(By.id("button")).click();*/

public class LoginPage extends BaseTest {
    /*@BeforeClass
    public void LaunchApp() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/login");
        driver.manage().window().maximize();
    }*/
 
    @Test(priority = 1)
    public void testLoginPageHeader() {
    	 WebElement ExpectedTitle = webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/h2")); //for "Login" title
         Assert.assertTrue(ExpectedTitle.isDisplayed());
    }
 
    @Test(priority = 2)
    public void testSuccessfulLogin() throws InterruptedException {
    	
    	webDriver.findElement(By.name("email")).sendKeys("mounikamargatham1@gmail.com");
        Thread.sleep(2000);
        webDriver.findElement(By.name("password")).sendKeys("Moni@1314");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/form/div[3]/div[1]/button")).click();
        Thread.sleep(2000);
        //WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        //Assert.assertTrue(welcomeMessage.isDisplayed());
        
    }
 
    @Test(priority = 3)
    public void testInvalidLogin() throws InterruptedException {
    	webDriver.get(properties.getProperty("testUrl"));
    	webDriver.findElement(By.name("email")).sendKeys("mouni");
        Thread.sleep(2000);
        webDriver.findElement(By.name("password")).sendKeys("121823982");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/form/div[3]/div[1]/button")).click();
        WebElement errorMessageEmail= webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/form/div[1]/div"));
        Assert.assertTrue(errorMessageEmail.isDisplayed());
        Thread.sleep(2000);
        WebElement errorMessagePassword= webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/form/div[2]/div"));
        Assert.assertTrue(errorMessagePassword.isDisplayed()); 
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void testNoentryLogin() throws InterruptedException {
    	webDriver.get(properties.getProperty("testUrl"));
    	webDriver.findElement(By.name("email")).sendKeys("");
        Thread.sleep(2000);
        webDriver.findElement(By.name("password")).sendKeys("");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/form/div[3]/div[1]/button")).click();
        WebElement errorMessageEmail= webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/form/div[1]/div"));
        Assert.assertTrue(errorMessageEmail.isDisplayed());
        Thread.sleep(2000);
        WebElement errorMessagePassword= webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/form/div[2]/div"));
        Assert.assertTrue(errorMessagePassword.isDisplayed());
        Thread.sleep(2000);
    }
    @Test(priority=5)
    public void NavigateToSignup() throws InterruptedException {
    	webDriver.get(properties.getProperty("testUrl"));
        WebElement ExpectedText = webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/div/p"));
        Assert.assertTrue(ExpectedText.isDisplayed());
        webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/div/p/a")).click(); //signon link
        Thread.sleep(2000);
    
}
}
