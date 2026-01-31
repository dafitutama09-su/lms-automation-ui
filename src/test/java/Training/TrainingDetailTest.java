package Training;

import core.BaseTest;
import core.DriverManager;
import org.example.page.DashboardPage;
import org.example.page.LoginPage;
import org.example.page.Training.DetailTrainingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrainingDetailTest extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUpEmployee()  {

        LoginPage loginPage =
                new LoginPage(DriverManager.getDriver());

        loginPage.login(
                dotenv.get("Login_Username"),
                dotenv.get("Login_Password")
        );

        DashboardPage dashboardPage =
                new DashboardPage(DriverManager.getDriver());

        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        Assert.assertTrue(dashboardPage.isHelloAdminDisplayed());

        dashboardPage.clickButtonTraining();
    }

    @Test(groups = {"smoke"})
    public void TC_TRN_29_Verifikasi_pencarian_training_berdasarkan_nama() {

        DetailTrainingPage trainingPage =
                new DetailTrainingPage(DriverManager.getDriver());

        trainingPage.searchTrainingByName("Appium");

        Assert.assertTrue(
                trainingPage.isAppiumDisplayed(),
                "Nama Appium tidak muncul"
        );
    }

    @Test(groups = {"smoke"})
    public void TC_TRN_31_Verifikasi_halaman_detail_training_dapat_dibuka() {

        DetailTrainingPage trainingPage =
                new DetailTrainingPage(DriverManager.getDriver());

        trainingPage.searchTrainingByName("Appium");
        Assert.assertTrue(
                trainingPage.isAppiumDisplayed(),
                "Nama Appium tidak muncul pada Search pencarian"
        );

        trainingPage.waitForUiToSettle();
        trainingPage.clickDetailTraining();
        Assert.assertTrue(
                trainingPage.isDetailNameDisplayed(),
                "Nama Appium tidak muncul pada halaman detail"
        );

    }








}
