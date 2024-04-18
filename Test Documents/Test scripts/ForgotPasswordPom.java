package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import InsurancePages.ForgotPassword;
import base.BaseTest;

public class ForgotPasswordPom extends BaseTest{

	@Test(priority=1)
	public void testForgotpassword() {
		webDriver.get(properties.getProperty("testUrl"));
		ForgotPassword forgotPwd = new ForgotPassword(webDriver);
		forgotPwd.clickOnForgotpassword();
		WebElement expectedTitle= webDriver.findElement(By.xpath("/html/body/app-root/app-forgot-password/div/div/div/h2"));
		expectedTitle.isDisplayed(); //Forgot Password headertitle
		String currUrl=webDriver.getCurrentUrl();
		String expectedUrl="http://localhost:4200/ForgotPassword";
		Assert.assertEquals(currUrl, expectedUrl);
		}
	
	@Test(priority = 2)
    public void testInValidEmailInput() throws InterruptedException {
		ForgotPassword forgotPwd = new ForgotPassword(webDriver);
		forgotPwd.enterEmail(""); //no entry email
		forgotPwd.clickOnSendOtpButton();
		Thread.sleep(1000);
		WebElement errorMessageEmail1= webDriver.findElement(By.xpath("/html/body/app-root/app-forgot-password/div/div/div/form/div/span"));
		Assert.assertTrue(errorMessageEmail1.isDisplayed(), "Email is required.");
		
		forgotPwd.enterEmail("mounika"); //invalid email
		forgotPwd.clickOnSendOtpButton();
		Thread.sleep(1000);
		WebElement errorMessageEmail2= webDriver.findElement(By.xpath("/html/body/app-root/app-forgot-password/div/div/div/form/div/span"));
		Assert.assertTrue(errorMessageEmail2.isDisplayed(), "Please enter a valid email.");
		webDriver.navigate().refresh();
		}
	
	
	@Test(priority = 3)
    public void testValidEmailInput() throws InterruptedException {
		ForgotPassword forgotPwd = new ForgotPassword(webDriver);
		//forgotPwd.clickOnForgotpassword();
		forgotPwd.enterEmail("mounikamurugesan1308@gmail.com"); 
		forgotPwd.clickOnSendOtpButton();
		Thread.sleep(5000);
		}
	/*@Test(priority = 4)
	public void readOTPFromEmail() throws InterruptedException {
        // Open the email website
        //webDriver.get("https://accounts.google.com/v3/signin/identifier?authuser=0&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ddm=0&dsh=S-134154640%3A1712941612620819&ec=GAlAFw&flowEntry=AddSession&flowName=GlifWebSignIn&hl=en&service=mail&theme=mn");
        webDriver.get("https://mail.google.com/mail/u/1/#inbox");
        // Log in to the email account
        WebElement emailField = webDriver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        WebElement nextButton = webDriver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
        WebElement passwordField =webDriver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));

        Thread.sleep(5000);
        emailField.sendKeys("mounikamurugesan1308@gmail.com");
        Thread.sleep(5000);
        nextButton.click();
        Thread.sleep(2000);
        passwordField.sendKeys("Mounika@13");
        nextButton.click();
        

        Thread.sleep(5000);
        WebElement otpEmail = webDriver.findElement(By.xpath("//div[contains(text(),'Your OTP for resetting the password is')]"));
        Thread.sleep(5000);
        
        String emailBody = otpEmail.getText();
        String otp = emailBody.substring(emailBody.lastIndexOf(":") + 1);

        
        System.out.println("OTP: " + otp);

        webDriver.get(properties.getProperty("testUrl"));
		ForgotPassword forgotPwd = new ForgotPassword(webDriver);
		forgotPwd.clickOnForgotpassword();
        forgotPwd.enterOtp(otp); //validOtp
        Thread.sleep(2000);
		forgotPwd.clickOnVerifyOtpButton();
		Thread.sleep(1000);
		String alertMessage = webDriver.switchTo().alert().getText();
		System.out.println("AlertMessage for valid OTP = " +alertMessage);
        webDriver.switchTo().alert().accept();
        Thread.sleep(2000);
    }*/
	
	@Test(priority = 4)
    public void verifyOtp() throws InterruptedException {
		ForgotPassword forgotPwd = new ForgotPassword(webDriver);
		Thread.sleep(2000);
		forgotPwd.enterOtp(""); //no entry Otp
		forgotPwd.clickOnVerifyOtpButton();
		Thread.sleep(1000);
		String alertMessage1 = webDriver.switchTo().alert().getText();
        System.out.println("AlertMessage for no entry OTP = " +alertMessage1);
        webDriver.switchTo().alert().accept();
        Thread.sleep(1000);
        
		forgotPwd.enterOtp("6778"); //invalidOtp
		Thread.sleep(1000);
		forgotPwd.clickOnVerifyOtpButton();
		Thread.sleep(1000);
		String alertMessage2 = webDriver.switchTo().alert().getText();
		System.out.println("AlertMessage for Invalid OTP = " +alertMessage2);
        webDriver.switchTo().alert().accept();
        Thread.sleep(1000);
        webDriver.navigate().refresh();
        
        forgotPwd.enterOtp(""); //validOtp
        Thread.sleep(8000);
		forgotPwd.clickOnVerifyOtpButton();
		Thread.sleep(1000);
		String alertMessage3 = webDriver.switchTo().alert().getText();
		System.out.println("AlertMessage for valid OTP = " +alertMessage3);
        webDriver.switchTo().alert().accept();
        Thread.sleep(2000);
        
        
	}
	
	@Test(priority = 5)
    public void verifyNoEntryResetpassword() throws InterruptedException {
		//webDriver.get("http://localhost:4200/password-reset/reset-password");
		ForgotPassword forgotPwd = new ForgotPassword(webDriver);
		forgotPwd.setNewPassword(""); //no entry
		forgotPwd.setConfirmPassword(""); //no entry
		forgotPwd.clickOnResetPasswordButton();
		Thread.sleep(2000);
		String alertMessage1 = webDriver.switchTo().alert().getText();
	    System.out.println("AlertMessage for NoEntryPassword= " +alertMessage1);
	    webDriver.switchTo().alert().accept();
	    Thread.sleep(2000);
		WebElement errorMessageNewPassword1= webDriver.findElement(By.xpath("/html/body/app-root/app-password-reset-success/div/div/div/form/div[3]/div"));
		Assert.assertTrue(errorMessageNewPassword1.isDisplayed(), "Password is required.");
		WebElement errorMessageConfirmPassword= webDriver.findElement(By.xpath("/html/body/app-root/app-password-reset-success/div/div/div/form/div[4]/div"));
		Assert.assertTrue(errorMessageConfirmPassword.isDisplayed(), "Confirm password is required.");
		
	}
		
	 @Test(priority = 6)
	 public void verifyInvalidResetpassword() throws InterruptedException {
		 
		ForgotPassword forgotPwd = new ForgotPassword(webDriver);
		forgotPwd.setNewPassword("7898980"); //invalid password
		forgotPwd.clickOnNewPassworddEye();
		Thread.sleep(2000);
		forgotPwd.clickOnResetPasswordButton();
		Thread.sleep(2000);
	    String alertMessage2 = webDriver.switchTo().alert().getText();
	    System.out.println("AlertMessage for InvalidPassword= " +alertMessage2);
	    webDriver.switchTo().alert().accept();
	    Thread.sleep(2000);
		WebElement errorMessageNewPassword2= webDriver.findElement(By.xpath("/html/body/app-root/app-password-reset-success/div/div/div/form/div[3]/div"));
		Assert.assertTrue(errorMessageNewPassword2.isDisplayed(), "Password must contain at least one number, one uppercase and lowercase letter, and at least 8 characters.");
		Thread.sleep(2000);
		
	 }
	 
	 @Test(priority = 7)
	 public void verifyMisMatchResetpassword() throws InterruptedException {
		 
		ForgotPassword forgotPwd = new ForgotPassword(webDriver);
		
		
		forgotPwd.setNewPassword("Mounikamoni@13"); //valid password
		forgotPwd.clickOnNewPassworddEye();
		Thread.sleep(5000);
		forgotPwd.setConfirmPassword("Mounikamoni@1");// other password
		forgotPwd.clickOnConfirmPasswordEye();
		Thread.sleep(2000);
		forgotPwd.clickOnResetPasswordButton();
		Thread.sleep(2000);
		  
	    String alertMessage3 = webDriver.switchTo().alert().getText();
	    System.out.println("AlertMessage for mismatchPassword= " +alertMessage3);
	    webDriver.switchTo().alert().accept();
	    Thread.sleep(2000);
	  
	   
	 }
	 
	 @Test(priority = 8)
	 public void verifyResetpassword() throws InterruptedException {
		ForgotPassword forgotPwd = new ForgotPassword(webDriver);
	    forgotPwd.setNewPassword("Murumoni@14"); //valid password
	    forgotPwd.clickOnNewPassworddEye();
		Thread.sleep(2000);
		forgotPwd.setConfirmPassword("Murumoni@14"); // valid password
		forgotPwd.clickOnConfirmPasswordEye();
		Thread.sleep(2000);
		forgotPwd.clickOnResetPasswordButton();
		Thread.sleep(2000);
	    String alertMessage4 = webDriver.switchTo().alert().getText();
	    System.out.println("AlertMessage for ResetPassword= " +alertMessage4);
	    webDriver.switchTo().alert().accept();
	    Thread.sleep(2000);
	    String currUrl=webDriver.getCurrentUrl();
		String expectedUrl="http://localhost:4200/login";
		Assert.assertEquals(currUrl, expectedUrl);
	}
}
	
