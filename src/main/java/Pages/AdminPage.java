package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import java.io.File;
import java.io.IOException;

public class AdminPage
 {
    private By tableRows = By.xpath("(//div[@class='oxd-table']//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-row')])[3]");
    private WebDriver driver;
    private By userRoleInputGroup = By.xpath("(//div[contains(@class,'oxd-input-group')])[1]");
    private By usernamegridBox = By.xpath("(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[4]");
    private By saveButton = By.xpath("//button[@type='submit']");
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnEditOption() {
        WebElement rows = driver.findElement(tableRows);
        rows.findElement(By.xpath("(//div[@class='oxd-table-cell-actions']//button)[2]")).click();
    }

    public void changeUserRole() {
        WebElement inputGroup = driver.findElement(userRoleInputGroup);
        inputGroup.findElement(By.xpath("//div[contains(@class,'oxd-select-text-input')]")).sendKeys("Admin");
        inputGroup.findElement(By.xpath("//div[@class='oxd-select-text--after']")).click();
    }

    public void validateUserName(){
        WebElement usernameBox = driver.findElement(usernamegridBox);
        String Username = usernameBox.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).getText();
        System.out.println(Username);
    }

    public void clickOnSaveButton() throws InterruptedException {
        driver.findElement(saveButton).click();

        Thread.sleep(3000);
    }

    public void takeScreenshotForRoleChange() throws IOException {
        WebElement rows = driver.findElement(tableRows);
        File screenshot = rows.getScreenshotAs(OutputType.FILE);
        File destination = new File(".//src//main//Screenshots//screenshot.png");
        FileHandler.copy(screenshot, destination);
        System.out.println("Screenshot of the element saved at: " + destination.getAbsolutePath());
    }
}
