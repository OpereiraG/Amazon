package ChangeSettingsAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Costco {


        private WebDriver driver;
        private String BaseURL;

        @Test
        public void Validcredentials() throws InterruptedException {

            driver = new ChromeDriver();
            BaseURL = "https://www.costco.com/";


            driver.navigate().to(BaseURL);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

            WebElement signIn_Register = driver.findElement(By.xpath("//a[@id='header_sign_in']"));
            signIn_Register.click();

            //Thread.sleep(4000);
            WebElement emailFld = driver.findElement(By.xpath("//input[@id='signInName']"));
            emailFld.sendKeys("TheBugHunters29@gmail.com");

           //Thread.sleep(4000);
            WebElement passwordFld = driver.findElement(By.xpath("//input[@type='password']"));
            passwordFld.sendKeys("Batch1529*");


            //Thread.sleep(4000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sign In')]")));
            WebElement signInBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
            signInBtn.sendKeys(Keys.ENTER);


           /* Thread.sleep(6000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='myaccount-react-d']")));
            WebElement accountBtn = driver.findElement(By.xpath("//button[@id='myaccount-react-d']"));
            accountBtn.click();*/





    }
}
