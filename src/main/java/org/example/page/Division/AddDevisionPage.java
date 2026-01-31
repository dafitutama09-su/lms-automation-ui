package org.example.page.Division;

import org.example.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddDevisionPage extends BasePage {
    public AddDevisionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add-division-button")
    private WebElement buttonDivisionAdd;

    @FindBy(xpath = "//header[normalize-space()='Add New Division']")
    private WebElement AssertHalamanNewDevision;

    @FindBy(xpath = "//input[@placeholder='Division name']")
    private WebElement FieldName;

    @FindBy(xpath = "//textarea[@placeholder='Division description']")
    private WebElement FieldDeskripsi;

    @FindBy(xpath = "//*[contains(text(),'Success')]")
    private WebElement assertsucces;

    @FindBy(id = "add-division-confirm-button")
    private WebElement buttonConfirmDivisionAdd;

    @FindBy(xpath = "//*[contains(text(),'Failed')]")
    private WebElement assertfailed;

    @FindBy(id = "description")
    private WebElement assertRequiredField;

    // ===== ACTION/ASSERT TC-EMP-22 =====
    public void VerifyHalamanNewDivision() {
        waitForClickable(buttonDivisionAdd);
        buttonDivisionAdd.click();
    }
    public void addDevision(String name, String Description) {
        waitForVisible(FieldName);
        FieldName.clear();
        FieldName.sendKeys(name);

        FieldDeskripsi.clear();
        FieldDeskripsi.sendKeys(Description);

        waitForClickable(buttonConfirmDivisionAdd);
        buttonConfirmDivisionAdd.click();
    }
    public boolean AssertHalamanNewDivision() {
        try {
            waitForVisible(AssertHalamanNewDevision);
            return AssertHalamanNewDevision.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean AssertSuccess() {
        try {
            waitForVisible(assertsucces);
            return assertsucces.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ===== ACTION/ASSERT TC-EMP-23 =====
    public boolean isDivisionDescriptionInvalid() {
        try {
            waitForVisible(assertRequiredField);
            return "true".equals(
                    assertRequiredField.getAttribute("aria-invalid")
            );
        } catch (Exception e) {
            return false;
        }
    }

    // ===== ACTION/ASSERT TC-EMP-24 =====
    public boolean AssertFailed() {
        try {
            waitForVisible(assertfailed);
            return assertfailed.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
