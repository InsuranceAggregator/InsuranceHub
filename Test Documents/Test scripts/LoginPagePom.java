/*package ui;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

public class LoginPagePom extends BaseTest {

    By loginTitle = By.xpath("/html/body/app-root/app-login/body/div/h2");
    By email = By.name("email");
    By password = By.name("password");
    By loginButton = By.cssSelector(".btn.btn-primary");
    By errorMessageEmail= By.xpath("/html/body/app-root/app-login/body/div/form/div[1]/div");
    By errorMessagePassword = By.xpath("/html/body/app-root/app-login/body/div/form/div[2]/div");
    By signUpLink = By.xpath("/html/body/app-root/app-login/body/div/div/p/a");

    

    @Test(priority = 1)
    public void testLoginPageHeader() {
        webDriver.get(properties.getProperty("testUrl"));
        Assert.assertTrue(isElementDisplayed(loginTitle));
    }

    @Test(priority = 2)
    public void testSuccessfulLogin() throws InterruptedException {
    	webDriver.get(properties.getProperty("testUrl"));
        enterText(email, "marvel@gmail.com");
        Thread.sleep(1000);
        enterText(password, "Marvel@13");
        Thread.sleep(1000);
        clickElement(loginButton);
        Thread.sleep(1000);
        String alertMessage = webDriver.switchTo().alert().getText();
        System.out.println(alertMessage);
        webDriver.switchTo().alert().accept();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void testInvalidLogin() throws InterruptedException {
    	webDriver.get(properties.getProperty("testUrl"));
        enterText(email, "mouni");
        Thread.sleep(1000);
        clickElement(loginButton);
        Assert.assertTrue(isElementDisplayed(errorMessageEmail));
        Thread.sleep(1000);
        webDriver.navigate().refresh();
        enterText(email, "mounika.m@gmail.com"); // correct email
        Thread.sleep(1000);
        enterText(password, "81989180"); // invalid password
        Thread.sleep(1000);
        clickElement(loginButton);
        Thread.sleep(1000);
        String alertMessage = webDriver.switchTo().alert().getText();
        System.out.println(alertMessage);
        webDriver.switchTo().alert().accept();
        Thread.sleep(1000);
    }

    @Test(priority = 4)
    public void testNoentryLogin() throws InterruptedException {
    	webDriver.get(properties.getProperty("testUrl"));
        enterText(email, "");
        Thread.sleep(1000);
        enterText(password, "");
        Thread.sleep(1000);
        clickElement(loginButton);
        Assert.assertTrue(isElementDisplayed(errorMessageEmail));
        Assert.assertTrue(isElementDisplayed(errorMessagePassword));
        Thread.sleep(1000);
    }

    @Test(priority = 5)
    public void navigateToSignup() throws InterruptedException {
    	webDriver.get(properties.getProperty("testUrl"));
        Assert.assertTrue(isElementDisplayed(signUpLink));
        clickElement(signUpLink);
        Thread.sleep(1000);
    }

    private void clickElement(By locator) {
        webDriver.findElement(locator).click();
    }

    private void enterText(By locator, String text) {
        webDriver.findElement(locator).sendKeys(text);
    }
    private boolean isElementDisplayed(By locator) {
        return webDriver.findElement(locator).isDisplayed();
    }

    }*/
package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import InsurancePages.Login;
import base.BaseTest;


public class LoginPagePom extends BaseTest {

 

    @Test(priority = 1)
    public void testLoginPageHeader() {
        webDriver.get(properties.getProperty("testUrl"));
        WebElement ExpectedTitle = webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/h2")); //for "Login" title
        Assert.assertTrue(ExpectedTitle.isDisplayed());
        
    }

    @Test(priority = 2)
    public void testSuccessfulLogin() throws InterruptedException {
        webDriver.get(properties.getProperty("testUrl"));
        Login loginPage=new Login(webDriver);
		loginPage.setEmail("mounikamaragatham1@gmail.com");
		Thread.sleep(1000);
		loginPage.setPassword("Moni@1314");
		Thread.sleep(1000);
		loginPage.clickOnLoginButton();
		Thread.sleep(1000);
        String alertMessage = webDriver.switchTo().alert().getText();
        System.out.println(alertMessage);
        webDriver.switchTo().alert().accept();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void testInvalidLogin() throws InterruptedException {
        webDriver.get(properties.getProperty("testUrl"));
        Login loginPage=new Login(webDriver);
		loginPage.setEmail("alexa");
		Thread.sleep(1000);
		loginPage.clickOnLoginButton();
		Thread.sleep(1000);
		WebElement errorMessageEmail= webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/form/div[1]/div"));
        Assert.assertTrue(errorMessageEmail.isDisplayed());
        webDriver.navigate().refresh();
        loginPage.setEmail("mounikamaragatham1@gmail.com"); //correct email
		Thread.sleep(1000);
		loginPage.setPassword("7126381792");  //incorrect password
		Thread.sleep(1000);
		loginPage.clickOnLoginButton();
        Thread.sleep(1000);
        String alertMessage = webDriver.switchTo().alert().getText();
        System.out.println(alertMessage);
        webDriver.switchTo().alert().accept();
        Thread.sleep(1000);
    }

   

	@Test(priority = 4)
    public void testNoentryLogin() throws InterruptedException {
    	webDriver.get(properties.getProperty("testUrl"));
        Login loginPage=new Login(webDriver);
		loginPage.setEmail(""); //no entry
		Thread.sleep(1000);
		loginPage.setPassword("");
		Thread.sleep(1000);
		loginPage.clickOnLoginButton();
		Thread.sleep(1000);
       	WebElement errorMessageEmail= webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/form/div[1]/div"));
	    Assert.assertTrue(errorMessageEmail.isDisplayed());
	    Thread.sleep(2000);
	    WebElement errorMessagePassword= webDriver.findElement(By.xpath("/html/body/app-root/app-login/body/div/form/div[2]/div"));
	    Assert.assertTrue(errorMessagePassword.isDisplayed());
	    Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void navigateToSignup() throws InterruptedException {
        webDriver.get(properties.getProperty("testUrl"));
        Login loginPage=new Login(webDriver);
        loginPage.signUpLink();
        Thread.sleep(1000);
    }

    
}


