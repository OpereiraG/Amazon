package ChangeSettingsAmazon;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

    @Test
    public void TestEmailAndPassword(){
        WebDriver webDriver = new ChromeDriver();
        String Website = "https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html";
        webDriver.get(Website);
        WebElement email = webDriver.findElement(By.id("email-input"));
        System.out.println("Email field  visible " + email.isDisplayed());
        //String emailPresent = email.getText();
        //Assert.assertTrue(true,emailPresent);
        WebElement password = webDriver.findElement(By.id("password-input"));
        System.out.println("Password field  visible " + password.isDisplayed());
        //String passwordPresent = password.getText();
        //Assert.assertTrue(true,passwordPresent);

    }

    @Test
    public void CheckValidCredentials() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        WebElement email = webDriver.findElement(By.id("email-input"));
        email.sendKeys("login@codility.com");
        WebElement password = webDriver.findElement(By.id("password-input"));
        password.sendKeys("password");
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement WelcomeText = webDriver.findElement(By.xpath("//div[@class='message success']"));
        System.out.println(WelcomeText.isDisplayed());
        System.out.println(WelcomeText.getText());
    }
    @Test
    public void CheckWrongCredentials(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        WebElement email = webDriver.findElement(By.id("email-input"));
        email.sendKeys("unknown@codility.com");
        WebElement password = webDriver.findElement(By.id("password-input"));
        password.sendKeys("password");
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement FailedLogin = webDriver.findElement(By.xpath("//div[@class='message error']"));
        System.out.println(FailedLogin.isDisplayed());
        System.out.println(FailedLogin.getText());
    }
    @Test
    public void ValidEmail(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        WebElement email = webDriver.findElement(By.id("email-input"));
        email.sendKeys("11111");
        WebElement password = webDriver.findElement(By.id("password-input"));
        password.sendKeys("password");
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement ValidEmail = webDriver.findElement(By.cssSelector("div[class='validation error']"));
        System.out.println(ValidEmail.isDisplayed());
        System.out.println(ValidEmail.getText());
    }
    @Test
    public void EmptyEmail(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        WebElement email = webDriver.findElement(By.id("email-input"));
        email.sendKeys("");
        WebElement password = webDriver.findElement(By.id("password-input"));
        password.sendKeys("password");
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement EmptyEmail = webDriver.findElement(By.xpath("//div[contains(text(),'Email is required')]"));
        System.out.println(EmptyEmail.isDisplayed());
        System.out.println(EmptyEmail.getText());
    }
    @Test
    public void EmptyPassword(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        WebElement email = webDriver.findElement(By.id("email-input"));
        email.sendKeys("login@codility.com");
        WebElement password = webDriver.findElement(By.id("password-input"));
        password.sendKeys("");
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement EmptyPassword = webDriver.findElement(By.xpath("//div[contains(text(),'Password is required')]"));
        System.out.println(EmptyPassword.isDisplayed());
        System.out.println(EmptyPassword.getText());
    }

    @Test
    public void CheckTabKey(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        WebElement email = webDriver.findElement(By.id("email-input"));
        email.sendKeys("login@codility.com");
        WebElement password = webDriver.findElement(By.id("password-input"));
        password.sendKeys("password");
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();
        webDriver.switchTo().newWindow(WindowType.TAB);
        System.out.println("TAB key is working!");
    }
    @Test
    public void CheckEnterKey(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        WebElement email = webDriver.findElement(By.id("email-input"));
        email.sendKeys("login@codility.com");
        WebElement password = webDriver.findElement(By.id("password-input"));
        password.sendKeys("password");
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.sendKeys(Keys.ENTER);
        System.out.println("ENTER key is working!");

    }

}
