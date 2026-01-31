package org.example.page.Training;

import org.example.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DetailTrainingPage extends BasePage {
    public DetailTrainingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search-training-input")
    private WebElement searchTrainingInput;

    @FindBy(xpath = "//td[normalize-space()='Appium']")
    private WebElement verifyappiumname;

    @FindBy(xpath = "//a[contains(@href,'/training/detail')]")
    private WebElement detailTrainingButton;

    @FindBy(xpath = "//p[contains(normalize-space(),'Appium')]")
    private WebElement verifyDetailName;

    // ===== ACTION/ASSERT TC-TRN-29 =====
    public void searchTrainingByName(String name) {
        waitForVisible(searchTrainingInput);
        searchTrainingInput.clear();
        searchTrainingInput.sendKeys(name);
    }
    public boolean isAppiumDisplayed() {
        try {
            waitForVisible(verifyappiumname);
            return verifyappiumname.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ===== ACTION/ASSERT TC-TRN-31 =====
    public void clickDetailTraining() {
        waitForClickable(detailTrainingButton);
        detailTrainingButton.click();
    }

    public boolean isDetailNameDisplayed() {
        try {
            waitForVisible(verifyDetailName);
            return verifyDetailName.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void waitForUiToSettle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
    }



}
