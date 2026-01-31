package org.example.page.Employeee;

import org.example.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailEmployeePage extends BasePage {

    public DetailEmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search name, e-mail, phone...']")
    private WebElement searchInput;

    @FindBy(xpath = "//td[normalize-space()='Dika']")
    private WebElement verifynameDika;

    @FindBy(xpath = "//p[contains(normalize-space(),'Ucok')]")
    private WebElement verifynameUcok;

    @FindBy(id = "button-detail-employee-2")
    private WebElement buttondetailnameEmployee;

    @FindBy(xpath = "//p[normalize-space()='ucok']")
    private WebElement detailnameEmployee;

    @FindBy(xpath = "//button[.//p[normalize-space()='Filter by Angkatan']]")
    private WebElement buttonbyAngkatan;

    @FindBy(xpath = "//button[@role='menuitem' and normalize-space()='2024 Genap']")
    private WebElement button2024Genap;

    @FindBy(id = "button-detail-employee-0")
    private WebElement detailbyFilter;

    @FindBy(xpath = "//p[normalize-space()='2024 Genap']")
    private WebElement verifybyAngkatan;

    @FindBy(id = "button-detail-employee-1")
    private WebElement buttondetailKombinasi;

    @FindBy(xpath = "//p[normalize-space()='Bejo']")
    private WebElement verifydetailEmployeeBejo;

    // ===== ACTION =====
    public void searchEmployeeByName(String name) {
        waitForVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(name);
    }

    public void clickDetailUcok() {
        waitForClickable(buttondetailnameEmployee);
        buttondetailnameEmployee.click();
    }

    public void filterByAngkatan2024Genap() {
        waitForClickable(buttonbyAngkatan);
        buttonbyAngkatan.click();
        waitForClickable(button2024Genap);
        button2024Genap.click();
        waitForClickable(detailbyFilter);
        detailbyFilter.click();
    }

    public void filterdanPencarian() {
        waitForClickable(buttonbyAngkatan);
        buttonbyAngkatan.click();
        waitForClickable(button2024Genap);
        button2024Genap.click();
        waitForVisible(searchInput);
        searchInput.sendKeys("Bejo");
        waitForClickable(buttondetailKombinasi);
        buttondetailKombinasi.click(); }

    // ===== CHECK (RETURN BOOLEAN) =====
    public boolean isDikaDisplayed() {
        try {
            waitForVisible(verifynameDika);
            return verifynameDika.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isUcokDisplayed() {
        try {
            return verifynameUcok.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isUcokDetailDisplayed() {
        waitForVisible(detailnameEmployee);
        return detailnameEmployee.isDisplayed();
    }

    public boolean isAngkatan2024GenapDisplayed() {
        waitForVisible(verifybyAngkatan);
        return verifybyAngkatan.isDisplayed();
    }

    public boolean isBejoDetailDisplayed() {
        waitForVisible(verifydetailEmployeeBejo);
        return verifydetailEmployeeBejo.isDisplayed();
    }

    public boolean isBejoDetailByAngkatan() {
        waitForVisible(verifybyAngkatan);
        return verifybyAngkatan.isDisplayed();
    }
}

