package org.example.page.Employeee;

import org.example.core.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteEmployeePage extends BasePage {
    public DeleteEmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search name, e-mail, phone...']")
    private WebElement searchInput;

    @FindBy(id = "button-detail-employee-0")
    private WebElement buttondetailnameEmployee;

    @FindBy(xpath = "//p[normalize-space()='Dafit']")
    private WebElement detailnameEmployee;

    @FindBy(id = "delete-employee-button")
    private WebElement buttondeleteEmployee;

    @FindBy(id = "confirm-delete-button")
    private WebElement buttondeleteConfirmEmployee;

    @FindBy(xpath = "//*[contains(text(),'Success')]")
    private WebElement assertsucces;

    public void Deatilemployee(String namesearch) {
        // buka form add employee
        waitForVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(namesearch);

        waitForClickable(buttondetailnameEmployee);
        buttondetailnameEmployee.click();
    }
    public void DeleteAction() {
        waitForClickable(buttondeleteEmployee);
        buttondeleteEmployee.click();

        waitForClickable(buttondeleteConfirmEmployee);
        buttondeleteConfirmEmployee.click();
    }
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

}
