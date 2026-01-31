package dibimbing;

import core.BaseTest;
import core.DriverManager;
import org.example.page.DashboardPage;
import org.example.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void testLoginSuccess() {

        LoginPage loginPage =
                new LoginPage(DriverManager.getDriver());

        // ===== ACTION =====
        loginPage.login(
                dotenv.get("Login_Username"),
                dotenv.get("Login_Password")
        );

        // ===== ASSERT LOGIN SUKSES =====
        DashboardPage dashboardPage =
                new DashboardPage(DriverManager.getDriver());

        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard tidak muncul setelah login"
        );

        Assert.assertTrue(
                dashboardPage.isHelloAdminDisplayed(),
                "Tulisan Hello Admin tidak muncul"
        );
    }
}




