package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-username-or-email")
    private WebElement emailField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(id = "button-sign-in")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='wrong username or password']")
    private WebElement errorMessage;


    public boolean isErrorDisplayed() {
        waitForVisible(errorMessage);
        return errorMessage.isDisplayed();
    }



    public void login(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        click(loginButton);
    }
}


