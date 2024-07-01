package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage
{
    private WebDriver driver;
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By userName = By.xpath("(//p[contains(@class,'oxd-text')])[1]");
    private By passWord  = By.xpath("(//p[contains(@class,'oxd-text')])[2]");
    private String extractedUsername;
    private String extractedPassword;


    //Call Constructor and give instance of driver

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    // Navigate to OrangeHRM login page
    public  void goToLoginPage()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public String getUserName()
    {
        String username = driver.findElement(userName).getText();
        extractedUsername = username.split("\n")[0].split(": ")[1];
        System.out.println("Extracted Username: " + extractedUsername);
        return extractedUsername;
    }

    public String getPassword()
    {
        String password = driver.findElement(passWord).getText();
        extractedPassword = password.split("\n")[0].split(": ")[1];
        System.out.println("ExtractedPassword: " + password);
        return extractedPassword;
    }

    // Enter username
    public void enterUsername(String username)
    {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Enter password
    public void enterPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Click login button
    public void clickLoginButton() throws InterruptedException
    {
        driver.findElement(loginButton).click();
        Thread.sleep(4000);
    }

}

