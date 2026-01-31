package Employee;

import core.BaseTest;
import core.DriverManager;
import org.example.page.DashboardPage;
import org.example.page.Employeee.DetailEmployeePage;
import org.example.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeDetailTest extends BaseTest {

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

    // ===== TC-EMP-06 =====
    @Test(groups = {"smoke"})
    public void TC_EMP_06_Verifikasi_pencarian_karyawan_berdasarkan_nama() {

        DetailEmployeePage employeePage =
                new DetailEmployeePage(DriverManager.getDriver());

        employeePage.searchEmployeeByName("Dika");

        Assert.assertTrue(
                employeePage.isDikaDisplayed(),
                "Nama Dika tidak muncul"
        );

        Assert.assertFalse(
                employeePage.isUcokDisplayed(),
                "Data lain masih muncul setelah search"
        );
    }

    // ===== TC-EMP-08 =====
    @Test(groups = {"smoke"})
    public void TC_EMP_08_Verifikasi_halaman_detail_karyawan_dapat_dibuka() {

        DetailEmployeePage employeePage =
                new DetailEmployeePage(DriverManager.getDriver());

        employeePage.searchEmployeeByName("Ucok");
        employeePage.clickDetailUcok();

        Assert.assertTrue(
                employeePage.isUcokDetailDisplayed(),
                "Detail employee Ucok tidak muncul"
        );
    }

    // ===== TC-EMP-09 =====
//    @Test(groups = {"smoke"})
//    public void TC_EMP_10_Verifikasi_filter_karyawan_berdasarkan_angkatan() {
//
//        DetailEmployeePage employeePage =
//                new DetailEmployeePage(DriverManager.getDriver());
//
//        employeePage.filterByAngkatan2024Genap();
//
//        Assert.assertTrue(
//                employeePage.isAngkatan2024GenapDisplayed(),
//                "Filter angkatan tidak berhasil"
//        );
//    }

    // ===== TC-EMP-10 =====
//    @Test(groups = {"smoke"})
//    public void TC_EMP_10_Verifikasi_kombinasi_filter_dan_pencarian_karyawan() {
//
//        DetailEmployeePage employeePage =
//                new DetailEmployeePage(DriverManager.getDriver());
//
//        employeePage.filterdanPencarian();
//
//        Assert.assertTrue(
//                employeePage.isBejoDetailDisplayed(),
//                "Data Bejo tidak sesuai setelah filter dan search"
//        );
//        Assert.assertTrue(
//                employeePage.isBejoDetailByAngkatan(),
//                "Angkatan tidak sesuai di halaman detail"
//        );
//    }
}




