package org.example.page.Training;

import org.example.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpdateTrainingPage extends BasePage {
    public UpdateTrainingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search-training-input")
    private WebElement searchTrainingInput;

    @FindBy(xpath = "//a[contains(@href,'/training/detail')]")
    private WebElement detailTrainingButton;

    @FindBy(xpath = "//p[contains(normalize-space(),'quality assurance advanced')]")
    private WebElement verifyDetailName;

    @FindBy(xpath = "//div[@role='button'][.//div[starts-with(@id,'chapter-item')]]")
    private WebElement chapterbuttonItem;

    @FindBy(xpath = "//a[contains(@href,'/detail/')]/button[normalize-space()='Detail']")
    private WebElement btnDetailChapter;

    @FindBy(id = "button-update-content")
    private WebElement btnEditContent;

    @FindBy(id = "input-title-content")
    private WebElement inputContentTitle;

    @FindBy(xpath = "//div[@contenteditable='true']")
    private WebElement inputContentEditor;

    @FindBy(id = "modal-update-content-save-button")
    private WebElement btnSaveChanges;

    @FindBy(xpath = "//p[contains(text(),'Success update content')]")
    private WebElement SuccessUpdateChapter;


    public void searchTrainingByName(String name) {
        waitForVisible(searchTrainingInput);
        searchTrainingInput.clear();
        searchTrainingInput.sendKeys(name);
    }

    public void clickDetailTraining() {
        waitForClickable(detailTrainingButton);
        detailTrainingButton.click();
    }

    public void clickFirstChapter() {
        click(chapterbuttonItem); // pakai BasePage click()
    }



    public void clickDeatilButtonChapter() {
        waitForClickable(btnDetailChapter);
        btnDetailChapter.click();
    }

    public void MenujuEditContent(String namecontent, String description) {
        waitForClickable(btnEditContent);
        btnEditContent.click();

        waitForVisible(inputContentTitle);
        inputContentTitle.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        inputContentEditor.sendKeys(Keys.DELETE);
        inputContentTitle.sendKeys(namecontent);

        inputContentEditor.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        inputContentEditor.sendKeys(Keys.DELETE);
        inputContentEditor.sendKeys(description);

        waitForClickable(btnSaveChanges);
        btnSaveChanges.click();
    }

    public boolean isAppiumDisplayed() {
        try {
            waitForVisible(verifyDetailName);
            return verifyDetailName.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isSuccessDisplayed() {
        try {
            waitForVisible(SuccessUpdateChapter);
            return SuccessUpdateChapter.isDisplayed();
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
