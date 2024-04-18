package ui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import InsurancePages.Register;
import base.BaseTest;

public class RegisterPagePom extends BaseTest {
    
    
    @Test(priority = 1)
    public void testRegistrationPageHeader() {
    	webDriver.get(properties.getProperty("testUrl"));
        Register RegisterPage=new Register(webDriver);
        RegisterPage.signUpLink();
        WebElement ExpectedTitle = webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/h2")); //for "Register" title
        Assert.assertTrue(ExpectedTitle.isDisplayed());
    }

    @Test(priority = 2)
    public void NavigateToLogin() throws InterruptedException {
    	//webDriver.get(properties.getProperty("testUrl"));
        Register RegisterPage=new Register(webDriver);
        RegisterPage.loginLink();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void testSuccessfulRegistration() throws InterruptedException {
    	webDriver.get(properties.getProperty("testUrl"));
        Register RegisterPage=new Register(webDriver);
        RegisterPage.signUpLink();
        RegisterPage.setName("Murugesan");
        RegisterPage.setMobileNumber("98976555590");
        RegisterPage.setEmail("murumara13@gmail.com");
        RegisterPage.setPassword("Muru@13");
        RegisterPage.setConfirmPassword("Muru@13");
        RegisterPage.clickOnRegisterButton();
        Thread.sleep(1000);
        String alertMessage = webDriver.switchTo().alert().getText();
        System.out.println(alertMessage);
        webDriver.switchTo().alert().accept();
        }
    @Test(priority = 4)
    public void testRegisteredMail() throws InterruptedException {
    	webDriver.get(properties.getProperty("testUrl"));
        Register RegisterPage=new Register(webDriver);
        RegisterPage.signUpLink();
        RegisterPage.setName("Nexa");
        RegisterPage.setMobileNumber("9897655555");
        RegisterPage.setEmail("nexa@gmail.com");
        RegisterPage.setPassword("Maragatham@1314");
        RegisterPage.setConfirmPassword("Maragatham@1314");
        RegisterPage.clickOnRegisterButton();
        Thread.sleep(1000);
        WebElement errorMessageEmail= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[6]"));
        Assert.assertTrue(errorMessageEmail.isDisplayed(), "Email already exists");
        webDriver.navigate().refresh();
        }
    
    @Test(priority = 5)
    public void testMismatchPassword() throws InterruptedException {
    	//webDriver.get(properties.getProperty("testUrl"));
        Register RegisterPage=new Register(webDriver);
        //RegisterPage.signUpLink();
        RegisterPage.setName("Murugesan");
        RegisterPage.setMobileNumber("98976555590");
        RegisterPage.setEmail("murumara13@gmail.com");
        RegisterPage.setPassword("Muru@13");
        RegisterPage.setConfirmPassword("Muru@131");
        RegisterPage.clickOnRegisterButton();
        Thread.sleep(1000);
        String alertMessage1 = webDriver.switchTo().alert().getText();
        System.out.println("AlertMessage1 = " +alertMessage1);
        webDriver.switchTo().alert().accept();
        Thread.sleep(2000);
        String alertMessage2 = webDriver.switchTo().alert().getText();
        System.out.println("AlertMessage2 = " +alertMessage2);
        webDriver.switchTo().alert().accept();
        webDriver.navigate().refresh();
        }
    
    @Test(priority = 6)
    public void testInvalidRegistration() throws InterruptedException {
    	webDriver.get(properties.getProperty("testUrl"));
        Register RegisterPage=new Register(webDriver);
        RegisterPage.signUpLink();
        RegisterPage.setName("jwiew8980");
        RegisterPage.setMobileNumber("moal");
        RegisterPage.setEmail("mouale");
        RegisterPage.setPassword("1232232123");
        RegisterPage.setConfirmPassword("13");
        RegisterPage.clickOnRegisterButton();
        Thread.sleep(1000);
        
        String alertMessage1 = webDriver.switchTo().alert().getText();
        System.out.println("AlertMessage1 = " +alertMessage1);
        webDriver.switchTo().alert().accept();
        Thread.sleep(2000);
        String alertMessage2 = webDriver.switchTo().alert().getText();
        System.out.println("AlertMessage2 = " +alertMessage2);
        webDriver.switchTo().alert().accept();
        
        
        WebElement errorMessageName= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[1]/div/div"));
        WebElement errorMessageMobileNumber= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[2]/div/div"));
        WebElement errorMessageEmail= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[3]/div/div"));
        WebElement errorMessagePassword= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[4]/div/div"));
        
        
        Assert.assertTrue(errorMessageName.isDisplayed(),"Please enter alphabets only and It must contain a minimum of 3 letters");
        Assert.assertTrue(errorMessageMobileNumber.isDisplayed(), "Mobile Number begins with [6-9] only and it must be at least 10 digits");
        Assert.assertTrue(errorMessageEmail.isDisplayed(), "Invalid email format");
        Assert.assertTrue(errorMessagePassword.isDisplayed(), "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters");
        Thread.sleep(1000);
        webDriver.navigate().refresh();
        }

    @Test(priority = 7)
    public void testNoEntryRegistration() throws InterruptedException {
        Register RegisterPage=new Register(webDriver);
        RegisterPage.setName("");
        RegisterPage.setMobileNumber("");
        RegisterPage.setEmail("");
        RegisterPage.setPassword("");
        RegisterPage.setConfirmPassword("");
        RegisterPage.clickOnRegisterButton();
        Thread.sleep(1000);
        String alertMessage = webDriver.switchTo().alert().getText();
        System.out.println(alertMessage);
        webDriver.switchTo().alert().accept();
        
        WebElement errorMessageName= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[1]/div/div"));
        WebElement errorMessageMobileNumber= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[2]/div/div"));
        WebElement errorMessageEmail= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[3]/div/div"));
        WebElement errorMessagePassword= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[4]/div/div"));
        WebElement errorMessageConfirmPassword= webDriver.findElement(By.xpath("/html/body/app-root/app-registration/html/body/div/div/form/div[5]/div/div"));
        
        Assert.assertTrue(errorMessageName.isDisplayed(), "Name is required");
        Assert.assertTrue(errorMessageMobileNumber.isDisplayed(), "Mobile Number is required");
        Assert.assertTrue(errorMessageEmail.isDisplayed(), "Email is required");
        Assert.assertTrue(errorMessagePassword.isDisplayed(),"Password is required");
        Assert.assertTrue(errorMessageConfirmPassword.isDisplayed(),"Please confirm your password");
        Thread.sleep(2000);
    }

}
