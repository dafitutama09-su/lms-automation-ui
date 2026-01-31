package core;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {

    private static final Logger log = LogManager.getLogger(BaseTest.class);

    protected static Properties config;
    protected static Dotenv dotenv;

    @BeforeSuite(alwaysRun = true)
    public void loadConfig() {

        // ===== LOAD CONFIG PROPERTIES =====
        String env = System.getProperty("env"); // -Penv=staging / production
        env = (env == null || env.isEmpty()) ? "staging" : env;
        config = ConfigReader.loadProperties(env);

        // ===== LOAD .env FILE =====
        dotenv = Dotenv.configure()
                .ignoreIfMissing() // aman walau file .env belum ada
                .load();

        log.info("Loaded config env: {}", env);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        DriverManager.initDriver(browser);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(config.getProperty("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

