package Employee;

import core.BaseTest;
import core.DriverManager;
import org.example.page.DashboardPage;
import org.example.page.Employeee.AddEmployeePage;
import org.example.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.FakerDataGenerator;

public class EmployeeAddTest extends BaseTest {

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
    public void TC_EMP_11_Verifikasi_penambahan_karyawan_berhasil_dengan_data_valid() {

        AddEmployeePage employeePage =
                new AddEmployeePage(DriverManager.getDriver());
        employeePage.addEmployeevalid(
                "Dafit",
                FakerDataGenerator.validEmployeeId(),
                FakerDataGenerator.validEmail(),
                FakerDataGenerator.validPhoneNumber(),
                "Mentor"
        );
        Assert.assertTrue(
                employeePage.AssertsuccesDisplayed(),
                "Notifikasi sukses tidak tampil meskipun proses penambahan employee telah dilakukan"
        );
        Assert.assertTrue(
                employeePage.AssertEmployeeListPage(),
                "Gagal redirect: halaman masih di Add New Employee, Manage Employee List tidak tampil"
        );
    }

    @Test(groups = {"smoke"})
    public void TC_EMP_12_Verifikasi_validasi_muncul_saat_salah_satu_field_wajib_dikosongkan() {

        AddEmployeePage employeePage =
                new AddEmployeePage(DriverManager.getDriver());
        employeePage.addEmployeevalid(
                "Dafit",
                "012",
                "dafit15@gmail.com",
                "081288405512",
                ""
        );
        Assert.assertTrue(
                employeePage.AssertfailedDisplayed(),
                "Notifikasi failed tidak tampil ketika salah satu field wajib dikosongkan"
        );
        Assert.assertTrue(
                employeePage.isRequiredErrorDisplayed(),
                "Pesan 'Required' seharusnya tampil ketika field wajib dikosongkan"
        );
    }

    @Test(groups = {"smoke"})
    public void TC_EMP_13_Verifikasi_validasi_muncul_saat_format_email_tidak_valid() {

        AddEmployeePage employeePage =
                new AddEmployeePage(DriverManager.getDriver());
        employeePage.addEmployeevalid(
                FakerDataGenerator.validName(),
                FakerDataGenerator.validEmployeeId(),
                FakerDataGenerator.invalidEmail(),
                FakerDataGenerator.validPhoneNumber(),
                "Mentor"
        );
        Assert.assertTrue(
                employeePage.Assertinvalidemail(),
                "Notifikasi failed tidak tampil ketika format email tidak valid"
        );
        Assert.assertFalse(
                employeePage.isAddNewEmployeePageClosed(),
                "Halman Add New Employee tertutup padahal format email tidak valid"
        );
    }

    @Test(groups = {"smoke"})
    public void TC_EMP_14_Verifikasi_validasi_muncul_penambahan_data_karyawan_dengan_data_duplikat() {

        AddEmployeePage employeePage =
                new AddEmployeePage(DriverManager.getDriver());
        employeePage.addEmployeevalid(
                "Dafit",
                "012",
                "dafit145@gmail.com",
                "081288405512",
                "Mentor"
        );
        Assert.assertTrue(
                employeePage.Assertinvaliddata(),
                "Notifikasi failed tidak tampil ketika format data duplikat"
        );
        Assert.assertTrue(
                employeePage.getAddEmployeeHeaderText().contains("Add New Employee"),
                "Halaman seharusnya tetap di Add New Employee ketika submit gagal"
        );
    }

    @Test(groups = {"smoke"})
    public void TC_EMP_15_Verifikasi_validasi_muncul_saat_telepon_berisi_karakter_non_angka() {

        AddEmployeePage employeePage =
                new AddEmployeePage(DriverManager.getDriver());
        employeePage.addEmployeevalid(
                FakerDataGenerator.validName(),
                FakerDataGenerator.validEmployeeId(),
                FakerDataGenerator.invalidEmail(),
                "abc@#$",
                "student"
        );
        Assert.assertTrue(
                employeePage.Assertinvalidphone(),
                "Notifikasi failed tidak tampil ketika format phone tidak valid"
        );
        Assert.assertTrue(
                employeePage.Assertrequiredphone(),
                "Notifikasi failed tidak tampil ketika format phone tidak valid"
        );
    }

    @Test(groups = {"smoke"})
    public void TC_EMP_16_Verifikasi_validasi_nama_karyawan_melebihi_30_karakter() {

        AddEmployeePage employeePage =
                new AddEmployeePage(DriverManager.getDriver());
        employeePage.addEmployeevalid(
                FakerDataGenerator.invalidName30(),
                FakerDataGenerator.validEmployeeId(),
                FakerDataGenerator.validEmail(),
                FakerDataGenerator.validPhoneNumber(),
                "student"
        );
        Assert.assertTrue(
                employeePage.Assertinvalidname(),
                "Notifikasi failed tidak tampil ketika format phone tidak valid"
        );
        Assert.assertTrue(
                employeePage.Assertrequiredname(),
                "Notifikasi failed tidak tampil ketika format phone tidak valid"
        );
    }


















}
