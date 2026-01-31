package Division;

import core.BaseTest;
import core.DriverManager;
import org.example.page.DashboardPage;
import org.example.page.Division.AddDevisionPage;
import org.example.page.Division.DetailDivisionPage;
import org.example.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.FakerDataGenerator;

public class DivisionAddTest extends BaseTest {

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
    public void TC_EMP_22_Verifikasi_penambahan_division_berhasil_dengan_data_valid() {

        AddDevisionPage divisionPage =
                new AddDevisionPage(DriverManager.getDriver());
        divisionPage.VerifyHalamanNewDivision();

        Assert.assertTrue(
                divisionPage.AssertHalamanNewDivision(),
                "Halaman Add New Division tidak tampil"
        );

        divisionPage.addDevision(
                "Appium Testing",
                FakerDataGenerator.validDescription()
        );

        Assert.assertTrue(
                divisionPage.AssertSuccess(),
                "Notifikasi sukses tidak tampil meskipun proses penambahan division telah dilakukan"
        );
    }

    @Test(groups = {"smoke"})
    public void TC_EMP_23_Verifikasi_validasi_muncul_saat_field_wajib_dikosongkan() {

        AddDevisionPage divisionPage =
                new AddDevisionPage(DriverManager.getDriver());
        divisionPage.VerifyHalamanNewDivision();

        Assert.assertTrue(
                divisionPage.AssertHalamanNewDivision(),
                "Halaman Add New Division tidak tampil"
        );

        divisionPage.addDevision(
                FakerDataGenerator.validDivisionName(),
                ""
        );

        Assert.assertTrue(
                divisionPage.isDivisionDescriptionInvalid(),
                "Notifikasi Required tidak tampil karena data field wajib masih bisa dikosongkan"
        );

    }

    @Test(groups = {"smoke"})
    public void TC_EMP_24_Verifikasi_validasi_menambahkan_division_dengan_data_duplikat() {

        AddDevisionPage divisionPage =
                new AddDevisionPage(DriverManager.getDriver());
        divisionPage.VerifyHalamanNewDivision();

        Assert.assertTrue(
                divisionPage.AssertHalamanNewDivision(),
                "Halaman Add New Division tidak tampil"
        );

        divisionPage.addDevision(
                "Quality Assurance",
                "Belajar Dasar QA"
        );

        Assert.assertTrue(
                divisionPage.AssertFailed(),
                "Notifikasi failed tidak muncul dan data tetap tersimpan"
        );

    }

    @Test(groups = {"smoke"})
    public void TC_EMP_25_Verifikasi_validasi_nama_division_melebihi_30_karakter() {

        AddDevisionPage divisionPage =
                new AddDevisionPage(DriverManager.getDriver());
        divisionPage.VerifyHalamanNewDivision();

        Assert.assertTrue(
                divisionPage.AssertHalamanNewDivision(),
                "Halaman Add New Division tidak tampil"
        );

        divisionPage.addDevision(
                FakerDataGenerator.longNameOver30Char(),
                "QA Automation"
        );

        Assert.assertTrue(
                divisionPage.AssertFailed(),
                "Notifikasi failed tidak muncul dan data tetap tersimpan"
        );

    }






}
