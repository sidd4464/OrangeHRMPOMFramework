package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage
{

    private By adminTab = By.xpath("(//ul[@class='oxd-main-menu']//li)[1]");
    private By dashboardText = By.xpath("(//ul[@class='oxd-main-menu']//li)[8]");
    private  WebDriver driver;

    //Call Constructor
    public Homepage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnAdminTab()
    {
        driver.findElement(adminTab).click();
    }

    public void validateLogin()
    {
        driver.findElement(dashboardText).isDisplayed();
    }
}
