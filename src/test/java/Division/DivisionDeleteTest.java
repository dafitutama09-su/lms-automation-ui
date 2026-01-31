package Division;

import core.BaseTest;
import core.DriverManager;
import org.example.page.DashboardPage;
import org.example.page.Division.DeleteDivisionPage;
import org.example.page.Division.UpdateDivisionPage;
import org.example.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DivisionDeleteTest extends BaseTest {

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
    public void TC_EMP_28_Verifikasi_penghapusan_data_devision_berhasil() {

        DeleteDivisionPage divisionPage =
                new DeleteDivisionPage(DriverManager.getDriver());

        divisionPage.detailDevision(
                "Quality Assurance Junior"
        );
        Assert.assertTrue(
                divisionPage.DivisionnameDetail(),
                "Halaman Name detail tidak sesuai"
        );
        divisionPage.ActionDelete();

        divisionPage.VerifynameDelete("Quality Assurance Junior");
        Assert.assertTrue(
                divisionPage.isDivisionDeleted("Quality Assurance Junior"),
                "Data 'Quality Assurance Junior' masih muncul di Manage Division"
        );
    }

















}
