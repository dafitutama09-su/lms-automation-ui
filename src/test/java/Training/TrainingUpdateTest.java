package Training;

import core.BaseTest;
import core.DriverManager;
import org.example.page.DashboardPage;
import org.example.page.LoginPage;
import org.example.page.Training.DetailTrainingPage;
import org.example.page.Training.UpdateTrainingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrainingUpdateTest extends BaseTest {
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
    public void TC_TRN_42_Verifikasi_update_content_video_berhasil_dengan_data_valid() {

        UpdateTrainingPage trainingPage =
                new UpdateTrainingPage(DriverManager.getDriver());

        trainingPage.searchTrainingByName("quality assurance advanced");
        trainingPage.waitForUiToSettle();
        trainingPage.clickDetailTraining();

        Assert.assertTrue(
                trainingPage.isAppiumDisplayed(),
                "Nama quality assurance advanced tidak muncul pada halaman detail"
        );


        trainingPage.clickFirstChapter();


        trainingPage.waitForUiToSettle();
        trainingPage.clickDeatilButtonChapter();

        trainingPage.MenujuEditContent(
                "Introduction to API update",
                "Materi pengenalan API testing update"
        );

        Assert.assertTrue(
                trainingPage.isSuccessDisplayed(),
                "Success message tidak muncul. Gagal Update Content"
        );


    }
















}
