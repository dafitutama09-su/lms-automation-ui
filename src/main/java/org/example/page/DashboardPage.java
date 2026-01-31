package org.example.page;

import org.example.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[contains(normalize-space(), 'Dashboard')]")
    private WebElement dashboard;

    @FindBy(xpath = "//p[normalize-space()='Hello Admin']")
    private WebElement helloAdmin;

    @FindBy(xpath = "//p[normalize-space()='Employee']")
    private WebElement buttonEmployee;

    @FindBy(xpath = "//button[@role='tab' and normalize-space()='Division']")
    private WebElement divisionTab;

    @FindBy(xpath = "//p[normalize-space()='Training']")
    private WebElement trainingTab;

    // ===== HELPER (UNTUK TEST) =====
    public boolean isDashboardDisplayed() {
        try {
            waitForVisible(dashboard);
            return dashboard.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isHelloAdminDisplayed() {
        try {
            waitForVisible(helloAdmin);
            return helloAdmin.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ===== ACTION =====
    public void clickButtonEmployee() {
        waitForClickable(buttonEmployee);
        buttonEmployee.click();
    }

    public void clickButtonDivision() {
        waitForClickable(divisionTab);
        divisionTab.click();
    }

    public void clickButtonTraining() {
        waitForClickable(trainingTab);
        trainingTab.click();
    }
}






