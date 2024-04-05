package ui;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

public class RegisterPagePom extends BaseTest {

    
    By signInLink= By.xpath("/html/body/app-root/app-login/body/div/div/p/a");

    By registerTitle = By.xpath("/html/body/app-root/app-registration/html/body/div/div/h2");
    
    By registerText = By.xpath( "/html/body/app-root/app-registration/html/body/div/div/div/p");
    
    By loginLink = By.xpath("/html/body/app-root/app-registration/html/body/div/div/div/p/a");
    
    By name = By.id("name");
    
    By mobileNumber = By.id("mobilenumber");
 
    By email = By.id("email");

    By password =By.id("password");
    
    By confirmPassword = By.id("confirmpassword");
    
    By registerButton = By.cssSelector(".btn.btn-primary");
    
    

        @Test(priority = 1)
        public void testRegistrationPageHeader() throws InterruptedException {
            clickElement(signInLink);
            Assert.assertTrue(isElementDisplayed(registerTitle));
        }

        @Test(priority = 2)
        public void NavigateToLogin() throws InterruptedException {
            Assert.assertTrue(isElementDisplayed(registerText));
            clickElement(loginLink);
            Thread.sleep(1000);
        }

        @Test(priority = 3)
        public void testSuccessfulRegistration() throws InterruptedException {
            clickElement(signInLink);
            enterText(name, "Marvel");
            Thread.sleep(1000);
            enterText(mobileNumber, "9767980909");
            Thread.sleep(1000);
            enterText(email, "marvel@gmail.com");
            Thread.sleep(1000);
            enterText(password, "Marvel@13");
            Thread.sleep(1000);
            enterText(confirmPassword, "Marvel@13");
            Thread.sleep(1000);
            clickElement(registerButton);
            Thread.sleep(1000);
            String alertMessage = webDriver.switchTo().alert().getText();
            System.out.println(alertMessage);
            webDriver.switchTo().alert().accept();
        }

        @Test(priority = 4)
        public void testInvalidRegistration() throws InterruptedException {
            clickElement(signInLink);
            enterText(name, "7676889@");
            Thread.sleep(1000);
            enterText(mobileNumber, "98656263581");
            Thread.sleep(1000);
            enterText(email, "moniiii");
            Thread.sleep(1000);
            enterText(password, "uhuuyiiy");
            Thread.sleep(1000);
            clickElement(registerButton);
            Thread.sleep(1000);
            String alertMessage1 = webDriver.switchTo().alert().getText();
            System.out.println("AlertMessage1 = " + alertMessage1);
            webDriver.switchTo().alert().accept();
            Thread.sleep(1000);
            String alertMessage2 = webDriver.switchTo().alert().getText();
            System.out.println("AlertMessage2 = " + alertMessage2);
            webDriver.switchTo().alert().accept();
        }

        @Test(priority = 5)
        public void testNoEntryRegistration() throws InterruptedException {
        	webDriver.navigate().refresh();
            enterText(name, "");
            Thread.sleep(1000);
            enterText(mobileNumber, "");
            Thread.sleep(1000);
            enterText(email, "");
            Thread.sleep(1000);
            enterText(password, "");
            Thread.sleep(1000);
            clickElement(registerButton);
            Thread.sleep(1000);
            String alertMessage = webDriver.switchTo().alert().getText();
            System.out.println("AlertMessage = " + alertMessage);
            webDriver.switchTo().alert().accept();
            //Thread.sleep(2000);
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
    }
