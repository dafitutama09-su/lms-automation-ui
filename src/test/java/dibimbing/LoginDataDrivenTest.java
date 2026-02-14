package dibimbing;

import core.DriverManager;
import core.TestUtils;
import org.example.page.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Properties;

public class LoginDataDrivenTest {

    private Properties config;

    @BeforeClass
    public void loadConfig() {
        config = core.ConfigReader.loadProperties("staging");
    }

    @DataProvider(name = "loginCsvData")
    public Object[][] loginCsvData() {
        return TestUtils.getTestDataFromCsv("data/loginData.csv");
    }

    @Test(dataProvider = "loginCsvData", groups = {"smoke"})
    public void testLoginDataDrivenCsv(
            String testCaseId,
            String username,
            String password,
            String expectedResult
    ) {

        Reporter.log("Running TestCase: " + testCaseId, true);

        // 🔥 1 DATA = 1 DRIVER
        DriverManager.initDriver("chrome");

        try {
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(config.getProperty("baseUrl"));

            LoginPage loginPage =
                    new LoginPage(DriverManager.getDriver());

            loginPage.login(username, password);

            WebDriverWait wait =
                    new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

            if (expectedResult.equalsIgnoreCase("success")) {

                wait.until(ExpectedConditions.urlContains("/admin/dashboard"));

                Assert.assertTrue(
                        DriverManager.getDriver()
                                .getCurrentUrl()
                                .contains("/admin/dashboard"),
                        testCaseId + " - Login sukses tapi tidak redirect"
                );

            } else {

                Assert.assertTrue(
                        loginPage.isErrorDisplayed(),
                        testCaseId + " - Login gagal tapi error tidak muncul"
                );
            }

        } finally {
            // 🔥 PASTI CLOSE SETIAP DATA
            DriverManager.quitDriver();
            Reporter.log("Finished TestCase: " + testCaseId, true);
        }
    }
}



