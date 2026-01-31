package Training;

import core.BaseTest;
import core.DriverManager;
import org.apache.commons.math3.analysis.function.Add;
import org.example.page.DashboardPage;
import org.example.page.LoginPage;
import org.example.page.Training.AddTrainingPage;
import org.example.page.Training.DetailTrainingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.FakerDataGenerator;

public class TrainingAddTest extends BaseTest {

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
    public void TC_TRN_32_Verifikasi_penambahan_training_berhasil_dengan_data_valid() {

        AddTrainingPage trainingPage =
                new AddTrainingPage(DriverManager.getDriver());

        trainingPage.buttonNewTraining();
        Assert.assertTrue(
                trainingPage.isTrainingHeaderDisplayed(),
                "Halaman Add New Training tidak muncul"
        );

        trainingPage.addTraining(
                FakerDataGenerator.validTrainingName(),
                FakerDataGenerator.validDescription()
        );
        Assert.assertTrue(
                trainingPage.isSuccessDisplayed(),
                "Notifikasi Success tidak tampil. Data tidak tersimpan"
        );
    }

    @Test(groups = {"smoke"})
    public void TC_TRN_33_Verifikasi_validasi_Training_Name_dikosongkan_pada_Add_raining()  {

        AddTrainingPage trainingPage =
                new AddTrainingPage(DriverManager.getDriver());

        trainingPage.buttonNewTraining();
        Assert.assertTrue(
                trainingPage.isTrainingHeaderDisplayed(),
                "Halaman Add New Training tidak muncul"
        );

        trainingPage.addTraining(
                "",
                FakerDataGenerator.validDescription()
        );
        Assert.assertTrue(
                trainingPage.isTitleRequiredErrorDisplayed(),
                "Error 'Required' tidak muncul pada field Title"
        );
    }

    @Test(groups = {"smoke"})
    public void TC_TRN_34_Verifikasi_validasi_muncul_saat_Training_Name_duplikat_pada_Add_Training()  {

        AddTrainingPage trainingPage =
                new AddTrainingPage(DriverManager.getDriver());

        trainingPage.buttonNewTraining();
        Assert.assertTrue(
                trainingPage.isTrainingHeaderDisplayed(),
                "Halaman Add New Training tidak muncul"
        );

        trainingPage.addTraining(
                "Quality Assurance",
                "Training Automation"
        );
        Assert.assertTrue(
                trainingPage.isFailedDisplayed(),
                "Notifikasi Failed tidak muncul. Data tetap tersimpan"
        );
    }

    @Test(groups = {"smoke"})
    public void TC_TRN_35_Verifikasi_batas_maksimal_30_karakter_pada_Trainin_Name_saat_Add_Training()  {

        AddTrainingPage trainingPage =
                new AddTrainingPage(DriverManager.getDriver());

        trainingPage.buttonNewTraining();
        Assert.assertTrue(
                trainingPage.isTrainingHeaderDisplayed(),
                "Halaman Add New Training tidak muncul"
        );

        trainingPage.addTraining(
                FakerDataGenerator.invalidName30(),
                "Training Automation"
        );
        Assert.assertTrue(
                trainingPage.isFailedDisplayed(),
                "Notifikasi Failed tidak muncul. Data tetap tersimpan"
        );
    }




}
