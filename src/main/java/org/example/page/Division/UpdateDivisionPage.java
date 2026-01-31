package org.example.page.Division;

import org.example.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateDivisionPage extends BasePage {

    public UpdateDivisionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search division...']")
    private WebElement searchDivisionInput;

    @FindBy(id = "detail-division-button")
    private WebElement buttonDetail;

    @FindBy(id = "edit-division-button")
    private WebElement editButton;

    @FindBy(xpath = "//input[@placeholder='Division name']")
    private WebElement FieldName;

    @FindBy(xpath = "//textarea[@placeholder='Division description']")
    private WebElement FieldDeskripsi;

    @FindBy(id = "edit-division-confirm-button")
    private WebElement ButtoneditConfirm;

    @FindBy(xpath = "//p[normalize-space()='Appium Testing']")
    private WebElement AssertDetailDivisionText;

    @FindBy(xpath = "//p[normalize-space()='Quality Assurance Junior']")
    private WebElement AssertDetailDivisionUpdate;

    @FindBy(id = "description")
    private WebElement assertRequiredField;

    // ===== ACTION/ASSERT TC-EMP-26 =====
    public void detailDevision(String name) {
        waitForVisible(searchDivisionInput);
        searchDivisionInput.clear();
        searchDivisionInput.sendKeys(name);

        waitForClickable(buttonDetail);
        buttonDetail.click();
    }

    public void editDevision(String name, String description) {
        waitForClickable(editButton);
        editButton.click();

        waitForVisible(FieldName);
        FieldName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        FieldName.sendKeys(name);

        FieldDeskripsi.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        FieldDeskripsi.sendKeys(Keys.DELETE);
        FieldDeskripsi.sendKeys(description);

        waitForClickable(ButtoneditConfirm);
        ButtoneditConfirm.click();

    }

    public boolean DivisionnameDetail() {
        try {
            waitForVisible(AssertDetailDivisionText);
            return AssertDetailDivisionText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean DivisionnameDetailUpdate() {
        try {
            waitForVisible(AssertDetailDivisionUpdate);
            return AssertDetailDivisionUpdate.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ===== ACTION/ASSERT TC-EMP-27 =====
    public boolean DivisionnameDetail2() {
        try {
            waitForVisible(AssertDetailDivisionUpdate);
            return AssertDetailDivisionUpdate.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean IsRequiredDisplayed() {
        try {
            waitForVisible(assertRequiredField);
            return "true".equals(
                    assertRequiredField.getAttribute("aria-invalid")
            );
        } catch (Exception e) {
            return false;
        }
    }













}
