package org.example;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest
{
    @Test
    public void login()
    {
        WebDriver driver = null;
        try {
            // Create page object
            driver = Base.setup();
            LoginPage loginPage = new LoginPage(driver);

            // Perform login
            loginPage.goToLoginPage();
            String userName = loginPage.getUserName();
            loginPage.enterUsername(userName);
             String password = loginPage.getPassword();
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
