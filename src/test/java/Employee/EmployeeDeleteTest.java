package Employee;

import core.BaseTest;
import core.DriverManager;
import org.example.page.DashboardPage;
import org.example.page.Employeee.DeleteEmployeePage;
import org.example.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeDeleteTest extends BaseTest {
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
    public void TC_EMP_19_Verifikasi_penghapusan_data_karyawan_berhasil() {

        DeleteEmployeePage employeePage =
                new DeleteEmployeePage(DriverManager.getDriver());
        employeePage.Deatilemployee(
                "Dafit"
        );
        Assert.assertTrue(
                employeePage.AssertnameDetail(),
                "Halaman detail Dafit seharusnya tampil setelah klik nama"
        );
        employeePage.DeleteAction();
        Assert.assertTrue(
                employeePage.AssertsuccesDisplayed(),
                "Notifikasi sukses tidak tampil meskipun proses update employee telah dilakukan"
        );

    }








































}
