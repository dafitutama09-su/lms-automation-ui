package Division;

import core.BaseTest;
import core.DriverManager;
import org.example.page.DashboardPage;
import org.example.page.Division.DetailDivisionPage;
import org.example.page.Employeee.AddEmployeePage;
import org.example.page.Employeee.DetailEmployeePage;
import org.example.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DivisionDetailTest extends BaseTest {

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
    public void TC_EMP_20_Verifikasi_pencarian_Division_berdasarkan_nama() {

        DetailDivisionPage divisionPage =
                new DetailDivisionPage(DriverManager.getDriver());
        divisionPage.searchDivisionByName("QA Division");

        Assert.assertTrue(
                divisionPage.AssertqaDivision(),
                "Nama QA Division tidak muncul"
        );
    }

    @Test(groups = {"smoke"})
    public void TC_EMP_21_Verifikasi_halaman_detail_Division_dapat_dibuka() {

        DetailDivisionPage divisionPage =
                new DetailDivisionPage(DriverManager.getDriver());
        divisionPage.searchDivisionByName("QA Division");

        Assert.assertTrue(
                divisionPage.AssertqaDivision(),
                "Nama QA Division tidak muncul pada search By name"
        );

        divisionPage.VerifyDetailDivision();

        Assert.assertTrue(
                divisionPage.AssertNameDetailDivision(),
                "Nama QA Division tidak muncul pada halaman detail"
        );
    }










}
