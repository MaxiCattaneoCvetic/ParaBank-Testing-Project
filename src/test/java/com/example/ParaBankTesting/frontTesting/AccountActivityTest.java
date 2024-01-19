package com.example.ParaBankTesting.frontTesting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.ah.A;
import com.example.ParaBankTesting.frontTestPages.AccountActivity;
import com.example.ParaBankTesting.frontTestPages.RegisterPage;
import com.example.ParaBankTesting.reports.ExtentFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class AccountActivityTest {

    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/activity.html");
    static ExtentReports extent;

    public  void login() {
        AccountActivity accountActivity = new AccountActivity(driver, wait);
        accountActivity.getUrl("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        accountActivity.login("asd", "asd");
    }

    @BeforeAll
    public static void create_report() {
        extent = ExtentFactory.getInsance(); // instanciamos la clase para crear reportes
        extent.attachReporter(info); // seleccionamos la ruta donde guardamos el report

    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
    }

    @BeforeEach
    public void setUp() {
        // Configurar opciones de Chrome para evitar redirección a HTTPS
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        //chromeOptions.addArguments("--headless");  // Si prefieres ejecutar en modo sin cabeza
        chromeOptions.addArguments("--disable-password-manager-reauthentication");
        chromeOptions.addArguments("--disable-save-password-bubble");
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofMillis(6000));
    }

    @AfterEach
    public void closePage() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.closeWeb();
    }

    @Test
    public void activityAccount() {
        login();
        ExtentTest test = extent.createTest("Activity Test");
        test.log(Status.INFO, "Comienza el Test");

        AccountActivity accountActivity = new AccountActivity(driver,wait);

        accountActivity.clickLinkAccountResume();
        Assertions.assertEquals("*Balance includes deposits that may be subject to holds",accountActivity.getTextBalance());
        accountActivity.clickAccount();
        Assertions.assertEquals("Account Details",accountActivity.getTextAccountDetails());
        accountActivity.click_go();



    }

}
