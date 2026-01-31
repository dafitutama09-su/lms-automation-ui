package org.example.page.Division;

import org.example.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeleteDivisionPage extends BasePage {
    public DeleteDivisionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search division...']")
    private WebElement searchDivisionInput;

    @FindBy(id = "detail-division-button")
    private WebElement buttonDetail;

    @FindBy(xpath = "//p[normalize-space()='Quality Assurance Junior']")
    private WebElement AssertDetailDivisionName;

    @FindBy(id = "edit-division-button")
    private WebElement editButton;

    @FindBy(id = "delete-division-button")
    private WebElement deleteButton;

    @FindBy(id = "delete-division-confirm-button")
    private WebElement deleteButtonConfirm;


    public void detailDevision(String name) {
        waitForVisible(searchDivisionInput);
        searchDivisionInput.clear();
        searchDivisionInput.sendKeys(name);

        waitForClickable(buttonDetail);
        buttonDetail.click();
    }

    public void ActionDelete() {
        waitForClickable(editButton);
        editButton.click();

        waitForClickable(deleteButton);
        deleteButton.click();

        waitForClickable(deleteButtonConfirm);
        deleteButtonConfirm.click();
    }

    public void VerifynameDelete(String name) {
        waitForVisible(searchDivisionInput);
        searchDivisionInput.clear();
        searchDivisionInput.sendKeys(name);
    }

    public boolean DivisionnameDetail() {
        try {
            waitForVisible(AssertDetailDivisionName);
            return AssertDetailDivisionName.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isDivisionDeleted(String divisionName) {
        return driver.findElements(
                By.xpath("//td[normalize-space()='" + divisionName + "']")
        ).isEmpty();
    }



}
