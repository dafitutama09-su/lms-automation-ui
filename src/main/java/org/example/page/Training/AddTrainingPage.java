package org.example.page.Training;

import org.example.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTrainingPage extends BasePage {
    public AddTrainingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search-training-input")
    private WebElement searchTrainingInput;

    @FindBy(xpath = "//p[contains(normalize-space(),'Appium Advance')]")
    private WebElement verifyDetailName;

    @FindBy(xpath = "//a[contains(@href,'/training/detail')]")
    private WebElement detailTrainingButton;

    @FindBy(id = "add-chapter-icon-button")
    private WebElement buttonAddChapter;

    @FindBy(xpath = "//input[@placeholder='Chapter Name']")
    private WebElement inputChapterName;

    @FindBy(xpath = "//textarea[@placeholder='Chapter Description']")
    private WebElement inputDescription;

    @FindBy(id = "add-chapter-submit-button")
    private WebElement buttonAddChapterconfirm;

    @FindBy(id = "add-training-button")
    private WebElement buttonAdd;

    @FindBy(xpath = "//input[@placeholder='Training name' and @name='title']")
    private WebElement trainingNameInput;

    @FindBy(xpath = "//textarea[@placeholder='Training description' and @name='description']")
    private WebElement trainingDescriptionTextarea;

    @FindBy(id = "add-training-submit-button")
    private WebElement buttonAddTrainingConfirm;

    @FindBy(xpath = "//header[normalize-space()='Add New Training']")
    private WebElement addNewTrainingHeader;

    @FindBy(xpath = "//*[contains(text(),'Success')]")
    private WebElement assertsucces;

    @FindBy(id = "title-feedback")
    private WebElement titleFeedbackRequired;

    @FindBy(xpath = "//*[contains(text(),'Failed')]")
    private WebElement assertfailed;


    // ===== ACTION/ASSERT TC-TRN-32 =====
    public void buttonNewTraining() {
        waitForClickable(buttonAdd);
        buttonAdd.click();
    }
    public void addTraining(String name, String Description) {
        waitForVisible(trainingNameInput);
        trainingNameInput.clear();
        trainingNameInput.sendKeys(name);

        trainingDescriptionTextarea.clear();
        trainingDescriptionTextarea.sendKeys(Description);

        waitForClickable(buttonAddTrainingConfirm);
        buttonAddTrainingConfirm.click();
    }
    public boolean isTrainingHeaderDisplayed() {
        waitForVisible(addNewTrainingHeader);
        return addNewTrainingHeader.isDisplayed();
    }
    public boolean isSuccessDisplayed() {
        try {
            waitForVisible(assertsucces);
            return assertsucces.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ===== ACTION/ASSERT TC-TRN-33 =====
    public boolean isTitleRequiredErrorDisplayed() {
        try {
            waitForVisible(titleFeedbackRequired);
            return titleFeedbackRequired.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ===== ACTION/ASSERT TC-TRN-34 =====
    public boolean isFailedDisplayed() {
        try {
            waitForVisible(assertfailed);
            return assertfailed.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

//    // ===== ACTION/ASSERT TC-TRN-37 =====
//
//    public void searchTrainingByName(String name) {
//        waitForVisible(searchTrainingInput);
//        searchTrainingInput.clear();
//        searchTrainingInput.sendKeys(name);
//    }
//
//    public void clickDetailTraining() {
//        waitForClickable(detailTrainingButton);
//        detailTrainingButton.click();
//    }
//
//    public boolean isDetailNameDisplayed() {
//        try {
//            waitForVisible(verifyDetailName);
//            return verifyDetailName.isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public void AddNewChapter(String name, String description) {
//        waitForClickable(detailTrainingButton);
//        detailTrainingButton.click();
//
//        waitForClickable(detailTrainingButton);
//        detailTrainingButton.click();
//    }
//
//
//
//
//
//
//    public void waitForUiToSettle() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ignored) {}
//    }

}
