package ChangeSettingsAmazon;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Luma {
    static String website1 = "https://magento.softwaretestingboard.com/";
    static WebDriver driver = new ChromeDriver();

    @Test
    public void Login() throws InterruptedException {

        driver.get(website1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get(website1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement clickSignIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In')][1]"));
        clickSignIn.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("TheBugHunters29@gmail.com");
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("Batch1529*ll");
        WebElement clickContinue = driver.findElement(By.name("send"));
        clickContinue.sendKeys(Keys.ENTER);
        WebElement clickArrow = driver.findElement(By.xpath("(//span[@class='customer-name'])[1]"));
        clickArrow.click();
        WebElement clickAccount = driver.findElement(By.xpath("(//a[contains(text(),'My Account')])[1]"));
        clickAccount.click();
        WebElement clickChangePassword = driver.findElement(By.cssSelector("a[class='action change-password']"));
        clickChangePassword.click();
        WebElement currentPassword = driver.findElement(By.id("current-password"));
        currentPassword.sendKeys("Batch1529*l");
        WebElement newPassword = driver.findElement(By.id("password"));
        newPassword.sendKeys("Batch1529*ll");
        WebElement ConfirmNewPassword = driver.findElement(By.id("password-confirmation"));
        ConfirmNewPassword.sendKeys("Batch1529*ll");
        WebElement savePassword = driver.findElement(By.xpath("//button[@class='action save primary']"));
        savePassword.click();
        /*JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1500)", "");*/
    }

    @Test
    public void incorrectPassword() {
        driver.get(website1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get(website1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement clickSignIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In')][1]"));
        clickSignIn.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("TheBugHunters29@gmail.com");
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("Batch1529");
        WebElement clickContinue = driver.findElement(By.name("send"));
        clickContinue.sendKeys(Keys.ENTER);
        WebElement errorMSG = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]"));
        System.out.println(errorMSG.isDisplayed());//Not needed
        String errorMsg = errorMSG.getText();
        Assert.assertTrue(true, errorMsg);
        System.out.println("Error Msg is visible!!");

    }

    @Test
    public void incorrectUsername() {
        driver.get(website1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get(website1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement clickSignIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In')][1]"));
        clickSignIn.click();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("BugHunters29@gmail.com");
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("Batch1529*ll");
        WebElement clickContinue = driver.findElement(By.name("send"));
        clickContinue.sendKeys(Keys.ENTER);
        WebElement errorMSG = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]"));
        System.out.println(errorMSG.isDisplayed());//Not needed
        String errorMsg = errorMSG.getText();
        Assert.assertTrue(true, errorMsg);
        System.out.println("Error Msg is visible!!");



    }


}
