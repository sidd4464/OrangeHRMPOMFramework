package org.example;

import Pages.AdminPage;
import Pages.Homepage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class EndToEndTest {

    @Test
    public void endToEndTest()
    {
        WebDriver driver = null;
        try {
            // Create page object
            driver = Base.setup();
            LoginPage loginPage = new LoginPage(driver);
            Homepage homepage = new Homepage(driver);
            AdminPage adminPage = new AdminPage(driver);

            // Perform login
            loginPage.goToLoginPage();
            String userName = loginPage.getUserName();
            loginPage.enterUsername(userName);
            String password = loginPage.getPassword();
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();
            homepage.validateLogin();
            //Click on Admin Tab
            homepage.clickOnAdminTab();
            // Click on EditIcon
            Thread.sleep(3000);
            adminPage.clickOnEditOption();
            Thread.sleep(2000);
            adminPage.changeUserRole();
            adminPage.validateUserName();
            adminPage.clickOnSaveButton();
            Thread.sleep(2000);
            adminPage.takeScreenshotForRoleChange();




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
