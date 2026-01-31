package org.example.page.Employeee;

import org.example.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage extends BasePage {

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "button-add-employee")
    private WebElement buttonaddemployee;

    @FindBy(id = "name")
    private WebElement fieldname;

    @FindBy(id = "employeeId")
    private WebElement fieldid;

    @FindBy(id = "email")
    private WebElement fieldemail;

    @FindBy(id = "phoneNumber")
    private WebElement fieldnumber;

    @FindBy(id = "division")
    private WebElement divisionDropdown;

    @FindBy(xpath = "//option[normalize-space()='Product']")
    private WebElement divisionProduct;

    @FindBy(id = "employeeRole")
    private WebElement fieldemployeerole;

    @FindBy(xpath = "//button[.//p[normalize-space()='Select Angkatan']]")
    private WebElement angkatanselect;

    @FindBy(xpath = "//div[@role='menu']//button[normalize-space()='2024 Genap']")
    private WebElement genapselect;

    @FindBy(id = "button-add-employee-submit")
    private WebElement buttonaddemployeenew;

    @FindBy(xpath = "//*[contains(text(),'Success')]")
    private WebElement assertsucces;

    @FindBy(xpath = "//p[normalize-space()='Manage Employee List']")
    private WebElement assertEmployeeList;

    @FindBy(xpath = "//*[contains(text(),'Failed')]")
    private WebElement assertfailed;

    @FindBy(xpath = "//*[contains(text(),'Required')]")
    private WebElement assertrequired;

    @FindBy(xpath = "//header[normalize-space()='Add New Employee']")
    private WebElement assertaddNewEmployeeTitle;


    public void addEmployeevalid(String name, String employeeId, String email, String phone, String role) {
        // buka form add employee
        waitForClickable(buttonaddemployee);
        buttonaddemployee.click();

        // isi field wajib
        waitForVisible(fieldname);
        fieldname.clear();
        fieldname.sendKeys(name);

        fieldid.clear();
        fieldid.sendKeys(employeeId);

        fieldemail.clear();
        fieldemail.sendKeys(email);

        fieldnumber.clear();
        fieldnumber.sendKeys(phone);

        waitForClickable(divisionDropdown);
        divisionDropdown.click();

        waitForClickable(divisionProduct);
        divisionProduct.click();

        fieldemployeerole.clear();
        fieldemployeerole.sendKeys(role);

        // submit
        waitForClickable(buttonaddemployeenew);
        buttonaddemployeenew.click();
    }
    // ===== ASSERT TC-EMP-11 =====
    public boolean AssertsuccesDisplayed() {
        try {
            waitForVisible(assertsucces);
            return assertsucces.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AssertEmployeeListPage() {
        return assertEmployeeList.isDisplayed();
    }

    // ===== ASSERT TC-EMP-12 =====
    public boolean AssertfailedDisplayed() {
        try {
            waitForVisible(assertfailed);
            return assertfailed.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isRequiredErrorDisplayed() {
        return assertrequired.isDisplayed();
    }

    // ===== ASSERT TC-EMP-13 =====
    public boolean Assertinvalidemail() {
        try {
            waitForVisible(assertfailed);
            return assertfailed.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isAddNewEmployeePageClosed() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOf(assertaddNewEmployeeTitle));
    }

    // ===== ASSERT TC-EMP-14 =====
    public boolean Assertinvaliddata() {
        try {
            waitForVisible(assertfailed);
            return assertfailed.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public String getAddEmployeeHeaderText() {
        return assertaddNewEmployeeTitle.getText();
    }

    // ===== ASSERT TC-EMP-15 =====
    public boolean Assertinvalidphone() {
        try {
            waitForVisible(assertfailed);
            return assertfailed.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean Assertrequiredphone() {
        return assertrequired.isDisplayed();
    }

    // ===== ASSERT TC-EMP-16 =====
    public boolean Assertinvalidname() {
        try {
            return assertfailed.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean Assertrequiredname() {
        return assertrequired.isDisplayed();
    }















}
