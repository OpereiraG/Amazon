package ChangeSettingsAmazon;

import AmazonLogin.LoginAmazon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ChangeSettings {
    @Test
    public void changeSettings() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
        WebElement hoverSignIn = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverSignIn).perform();
        WebElement clickSignIn = driver.findElement(By.xpath("(//span[@class='nav-action-inner'])[1]"));
        clickSignIn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_email']")));
        WebElement UserName = driver.findElement(By.xpath("//input[@id='ap_email']"));
        UserName.sendKeys("TheBugHunters29@gmail.com");
        WebElement clickContinue = driver.findElement(By.xpath("( //input[@class='a-button-input'])[1]"));
        clickContinue.click();
        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys("Batch1529*");
        WebElement clickLoginButton = driver.findElement(By.className("a-button-input"));
        //Thread.sleep(2000);
        clickLoginButton.click();
        WebElement hoverAccountSettings = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(hoverAccountSettings).perform();
        WebElement clickAccount = driver.findElement(By.xpath("(//span[contains(text(),'Account')])[2]"));
        clickAccount.click();
        WebElement selectAddress = driver.findElement(By.xpath("//h2[contains(text(),'Your Addresses')]"));
        selectAddress.click();
        WebElement addAddress = driver.findElement(By.cssSelector(".a-box-inner.a-padding-extra-large"));
        addAddress.click();
        WebElement selectDropdown = driver.findElement(By.cssSelector(".a-button-text.a-declarative"));
        selectDropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Japan')]")));
        //Thread.sleep(3000);
        WebElement selectCountry = driver.findElement(By.xpath("//h2[contains(text(),'United States')]"));
        Select select = new Select(selectCountry);
        select.selectByVisibleText("United States");


    }
}
