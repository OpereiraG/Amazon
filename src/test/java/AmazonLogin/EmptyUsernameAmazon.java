package AmazonLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EmptyUsernameAmazon {
@Test
    public void EmptyUsername() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
        WebElement hoverSignIn = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverSignIn).perform();
        WebElement clickSignIn = driver.findElement(By.xpath("(//span[@class='nav-action-inner'])[1]"));
        clickSignIn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_email']")));
        WebElement UserName = driver.findElement(By.xpath("//input[@id='ap_email']"));
        UserName.sendKeys("");
        WebElement clickContinue = driver.findElement(By.xpath("( //input[@class='a-button-input'])[1]"));
        clickContinue.click();
        WebElement actual = driver.findElement(By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]"));
        String actualTrue = actual.getText();
        String expected = "Enter your email or mobile phone number";
        Assert.assertEquals(actualTrue, expected);
        System.out.println("Test passed!");

    }
}
