package Employee;

import core.BaseTest;
import core.DriverManager;
import org.example.page.DashboardPage;
import org.example.page.Employeee.AddEmployeePage;
import org.example.page.Employeee.UpdateEmployeePage;
import org.example.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.FakerDataGenerator;

public class EmployeeUpdateTest extends BaseTest {

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
    }

    @Test(groups = {"smoke"})
    public void TC_EMP_17_Verifikasi_perubahan_data_karyawan_berhasil_dengan_data_valid() {

        UpdateEmployeePage employeePage =
                new UpdateEmployeePage(DriverManager.getDriver());
        employeePage.Deatilemployee(
                "Dafit"
        );
        Assert.assertTrue(
                employeePage.AssertnameDetail(),
                "Halaman detail Dafit seharusnya tampil setelah klik nama"
        );
        employeePage.updateemployee(
                FakerDataGenerator.validPhoneNumber(),
                "Student"
        );
        Assert.assertTrue(
                employeePage.AssertsuccesDisplayed(),
                "Notifikasi sukses tidak tampil meskipun proses update employee telah dilakukan"
        );

    }

    @Test(groups = {"smoke"})
    public void TC_EMP_18_Verifikasi_validasi_muncul_saat_nomor_telepon_dikosongkan_update_data_karyawan() throws InterruptedException {

        UpdateEmployeePage employeePage =
                new UpdateEmployeePage(DriverManager.getDriver());
        employeePage.Deatilemployee(
                "Dafit"
        );
        Assert.assertTrue(
                employeePage.AssertnameDetail(),
                "Halaman detail Dafit seharusnya tampil setelah klik nama"
        );
        employeePage.Updatedeatilinvalid();

        Assert.assertTrue(
                employeePage.AssertFailedDisplayed(),
                "Notifikasi failed tidak tampil ketika update nomor dengan field kosong"
        );

    }


}
