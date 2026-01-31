package org.example.page.Division;

import org.example.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailDivisionPage extends BasePage {

    public DetailDivisionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search division...']")
    private WebElement searchDivisionInput;

    @FindBy(xpath = "//td[normalize-space()='QA Division']")
    private WebElement qaDivisionsearch;

    @FindBy(id = "detail-division-button")
    private WebElement buttonDetail;

    @FindBy(xpath = "//p[normalize-space()='QA Division']")
    private WebElement AssertqaDivisionText;

    // ===== ACTION/ASSERT TC-EMP-20 =====
    public void searchDivisionByName(String name) {
        waitForVisible(searchDivisionInput);
        searchDivisionInput.clear();
        searchDivisionInput.sendKeys(name);
    }
    public boolean AssertqaDivision() {
        try {
            waitForVisible(qaDivisionsearch);
            return qaDivisionsearch.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ===== ACTION/ASSERT TC-EMP-21 =====
    public void VerifyDetailDivision() {
        waitForClickable(buttonDetail);
        buttonDetail.click();
    }
    public boolean AssertNameDetailDivision() {
        try {
            waitForVisible(AssertqaDivisionText);
            return AssertqaDivisionText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }




}
