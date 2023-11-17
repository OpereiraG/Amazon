import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginAmazon {
     @Test
     public void successfullyLogin() throws InterruptedException {

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
          UserName.sendKeys("TheBugHunters29@gmail.com");
          WebElement clickContinue = driver.findElement(By.xpath("( //input[@class='a-button-input'])[1]"));
          clickContinue.click();
          WebElement password = driver.findElement(By.id("ap_password"));
          password.sendKeys("Batch1529*");
          WebElement clickLoginButton = driver.findElement(By.className("a-button-input"));
          clickLoginButton.click();


     }
}
