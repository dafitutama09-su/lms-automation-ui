package org.example.page.Employeee;

import org.example.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateEmployeePage extends BasePage {

    public UpdateEmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search name, e-mail, phone...']")
    private WebElement searchInput;

    @FindBy(id = "button-detail-employee-0")
    private WebElement buttondetailnameEmployee;

    @FindBy(xpath = "//p[normalize-space()='Dafit']")
    private WebElement detailnameEmployee;

    @FindBy(id = "edit-employee-button")
    private WebElement buttoneditEmployee;

    @FindBy(id = "edit-employee-name-input")
    private WebElement fieldnameEdit;

    @FindBy(id = "edit-employee-employee-id-input")
    private WebElement fieldemployeeIdEdit;

    @FindBy(id = "edit-employee-email-input")
    private WebElement fieldemailEdit;

    @FindBy(id = "edit-employee-phone-number-input")
    private WebElement fieldphoneEdit;

    @FindBy(id = "edit-employee-division-select")
    private WebElement divisionSelect;

    @FindBy(xpath = "//select[@id='edit-employee-division-select']/option[normalize-space()='Product']")
    private WebElement productOption;

    @FindBy(id = "edit-employee-employee-role-input")
    private WebElement fieldroleEdit;

    @FindBy(id = "edit-employee-save-changes-button")
    private WebElement Buttonsavechange;

    @FindBy(xpath = "//*[contains(text(),'Success')]")
    private WebElement assertsucces;

    @FindBy(xpath = "//*[contains(text(),'Failed')]")
    private WebElement assertfailed;


    public void Deatilemployee(String namesearch) {
        // buka form add employee
        waitForVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(namesearch);

        waitForClickable(buttondetailnameEmployee);
        buttondetailnameEmployee.click();
    }

    public void updateemployee(String phone, String role) {

        waitForClickable(buttoneditEmployee);
        buttoneditEmployee.click();

        waitForVisible(fieldphoneEdit);
        fieldphoneEdit.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldphoneEdit.sendKeys(phone);

        fieldroleEdit.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldroleEdit.sendKeys(Keys.DELETE);
        fieldroleEdit.sendKeys(role);

        waitForClickable(Buttonsavechange);
        Buttonsavechange.click();
    }
    // ===== ASSERT TC-EMP-17 =====
    public boolean AssertnameDetail() {
        try {
            waitForVisible(detailnameEmployee);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean AssertsuccesDisplayed() {
        try {
            waitForVisible(assertsucces);
            return assertsucces.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void Updatedeatilinvalid() {
        waitForClickable(buttoneditEmployee);
        buttoneditEmployee.click();

        waitForVisible(fieldphoneEdit);
        fieldphoneEdit.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldphoneEdit.sendKeys(Keys.DELETE);

        waitForClickable(Buttonsavechange);
        Buttonsavechange.click();
    }

    // ===== ASSERT TC-EMP-18 =====
    public boolean AssertFailedDisplayed() {
        try {
            waitForVisible(assertfailed);
            return assertfailed.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }






















}
