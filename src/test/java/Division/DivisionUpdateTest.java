package Division;

import core.BaseTest;
import core.DriverManager;
import org.example.page.DashboardPage;
import org.example.page.Division.AddDevisionPage;
import org.example.page.Division.UpdateDivisionPage;
import org.example.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.FakerDataGenerator;

public class DivisionUpdateTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpEmployee() {

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

        dashboardPage.clickButtonEmployee();
        dashboardPage.clickButtonDivision();
    }

    @Test(groups = {"smoke"})
    public void TC_EMP_26_Verifikasi_update_data_karyawan_berhasil_dengan_data_valid() {

        UpdateDivisionPage divisionPage =
                new UpdateDivisionPage(DriverManager.getDriver());

        divisionPage.detailDevision(
                "Appium Testing"
        );
        Assert.assertTrue(
                divisionPage.DivisionnameDetail(),
                "Halaman Name detail tidak sesuai"
        );
        divisionPage.editDevision(
                "Quality Assurance Junior",
                FakerDataGenerator.validDescription()
        );
        Assert.assertTrue(
                divisionPage.DivisionnameDetailUpdate(),
                "Perubahan data tidak berhasil"
        );
    }

    @Test(groups = {"smoke"})
    public void TC_EMP_27_Verifikasi_validasi_field_wajib_dikosongkan_saat_edit_data_division() {

        UpdateDivisionPage divisionPage =
                new UpdateDivisionPage(DriverManager.getDriver());

        divisionPage.detailDevision(
                "Quality Assurance Junior"
        );
        Assert.assertTrue(
                divisionPage.DivisionnameDetail2(),
                "Halaman Name detail tidak sesuai"
        );
        divisionPage.editDevision(
                "Quality Assurance Junior",
                ""
        );
        Assert.assertTrue(
                divisionPage.IsRequiredDisplayed(),
                "Notifikasi Required tidak tampil, data tetap tersimpan"
        );
    }






}
