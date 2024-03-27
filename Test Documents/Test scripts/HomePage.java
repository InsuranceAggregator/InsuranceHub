package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

public class HomePage extends BaseTest{

    @Test(priority = 1)
    public void testSuccessfulLogin() throws InterruptedException {
    	webDriver.findElement(By.name("email")).sendKeys("mounikamargatham1@gmail.com");
        Thread.sleep(2000);
        webDriver.findElement(By.name("password")).sendKeys("Moni@1314");
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector(".btn.btn-primary")).click();
        
    }
    
     
        @Test(priority = 2)
        public void testProfileTab() throws InterruptedException {
            WebElement ProfileTab = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[1]/button"));
            ProfileTab.click();
            Thread.sleep(2000);
            WebElement CreateProfile= webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[1]/div/a[1]"));
            Assert.assertTrue(CreateProfile.isDisplayed());
            WebElement EditProfile= webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[1]/div/a[2]"));
            Assert.assertTrue(EditProfile.isDisplayed());
            WebElement Notifications= webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[1]/div/a[3]"));
            Assert.assertTrue(Notifications.isDisplayed());
            WebElement ChangePassword= webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[1]/div/a[4]"));
            Assert.assertTrue(ChangePassword.isDisplayed());
            WebElement SignOut = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[1]/div/a[5]"));
            Assert.assertTrue(SignOut.isDisplayed());
            
        }
     
        @Test(priority = 3)
        public void testPoliciesTab() throws InterruptedException {
        	WebElement PoliciesTab = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[1]/button"));
            PoliciesTab.click();
            Thread.sleep(2000);
            WebElement HealthInsurance= webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[1]/div/a[1]"));
            Assert.assertTrue(HealthInsurance.isDisplayed());
            WebElement LifeInsurance= webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[1]/div/a[2]"));
            Assert.assertTrue(LifeInsurance.isDisplayed());
            WebElement VehicleInsurance= webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[1]/div/a[3]"));
            Assert.assertTrue(VehicleInsurance.isDisplayed());
            WebElement HomeInsurance= webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[1]/div/a[4]"));
            Assert.assertTrue(HomeInsurance.isDisplayed());
            
        }
     
        /*@Test(priority = 4)
        public void testRenewalsTab() throws InterruptedException {
            WebElement renewalsTab = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[2]/button"));
            renewalsTab.click();
            Thread.sleep(2000);
            WebElement HealthInsurance= webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[2]/div/a[1]"));
            Assert.assertTrue(HealthInsurance.isDisplayed());
            WebElement LifeInsurance= webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[2]/div/a[2]"));
            Assert.assertTrue(LifeInsurance.isDisplayed());
            WebElement VehicleInsurance= webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[2]/div/a[3]"));
            Assert.assertTrue(VehicleInsurance.isDisplayed());
            WebElement HomeInsurance= webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[2]/div/a[4]"));
            Assert.assertTrue(HomeInsurance.isDisplayed());
            
        }*/
     
        @Test(priority = 5)
        public void testClaimsTab() throws InterruptedException {
            WebElement claimsTab = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[2]/button"));
            claimsTab.click();
            Thread.sleep(2000);
            WebElement FindaNewClaim = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[2]/div/a[1]"));
            Assert.assertTrue(FindaNewClaim.isDisplayed());
            WebElement ExistingClaim = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[2]/div/a[2]"));
            Assert.assertTrue(ExistingClaim.isDisplayed());
            WebElement TrackTheClaim = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[2]/div/a[3]"));
            Assert.assertTrue(TrackTheClaim.isDisplayed());
        }
     
        @Test(priority = 6)
        public void testSupportTab() throws InterruptedException {
            WebElement supportTab = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[3]/div[3]/button"));
            supportTab.click();
            Thread.sleep(2000);
            Assert.assertTrue(supportTab.isDisplayed());
 
            
            }
     
        @Test(priority = 7)
        public void testWelcomeMessage() {
            WebElement welcomeMessage1 = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/h1"));
            Assert.assertTrue(welcomeMessage1.isDisplayed(), "We provide you the best Insurance!");
            WebElement welcomeMessage2 = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/h2"));
            Assert.assertTrue(welcomeMessage2.isDisplayed(), "Secure the future, protect what's Important...");
        }
      @Test(priority = 8)
      public void testSearchbar() {
    	  WebElement SearchBar = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[2]"));
          Assert.assertTrue(SearchBar.isDisplayed());
          WebElement SearchTextBox = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/div/div[2]/input"));
          Assert.assertTrue(SearchTextBox.isDisplayed());
          WebElement SearchButton = webDriver.findElement(By.cssSelector(".search-btn"));
          Assert.assertTrue(SearchButton.isDisplayed());
      }
      @Test(priority = 9)
      public void testFooterText() {
    	  WebElement FooterText = webDriver.findElement(By.xpath("/html/body/app-root/app-homepage/div/footer/p"));
          Assert.assertTrue(FooterText.isDisplayed());
         
      }
    
        
}

