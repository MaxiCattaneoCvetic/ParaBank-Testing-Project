package com.example.ParaBankTesting.frontTesting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.ah.A;
import com.example.ParaBankTesting.frontTestPages.RegisterPage;
import com.example.ParaBankTesting.reports.ExtentFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class RegisterTest {


    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reportes_registro.html");
    static ExtentReports extent;
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public static void create_report() {
        extent = ExtentFactory.getInsance(); // instanciamos la clase para crear reportes
        extent.attachReporter(info); // seleccionamos la ruta donde guardamos el report
    }


    @BeforeEach
    public void setUp() {
        // Configurar opciones de Chrome para evitar redirección a HTTPS
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        // chromeOptions.addArguments("--headless");  // Si prefieres ejecutar en modo sin cabeza
        chromeOptions.addArguments("--disable-password-manager-reauthentication");
        chromeOptions.addArguments("--disable-save-password-bubble");

        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
    }

    @AfterEach
    public void closePage() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.closeWeb();
    }

    public void login() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.getUrl("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        registerPage.login("maxxx", "testing");
    }

    @Test
    public void form_complete() {
        ExtentTest test = extent.createTest("Registro Exitoso");
        test.log(Status.INFO, "Comienza el Test");

        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.getUrl("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");

        // iniciamos sesion

        try {
            registerPage.goRegisterLink();
            test.log(Status.PASS, "Ingreso en el formulario de Registro");

            registerPage.writeInputName("Maxi");
            registerPage.writeInputLastName("Cvetic");
            registerPage.writeInputAdress("Avenida testing");
            registerPage.writeInputCity("CABA");
            registerPage.writeInputState("state testing");
            registerPage.writeInputZip("2125");
            registerPage.writeInputPhone("515115");
            registerPage.writeInputSsn("21212");
            registerPage.writeInputUsername("maxxx");
            registerPage.writeInputPassword("testing");
            registerPage.writeInputPasswordV("testing");

            registerPage.clickButtonRegister();

            Assertions.assertEquals("Your account was created successfully. You are now logged in.", registerPage.register_successful());
            System.out.println("Test - Nuevo usuario completado con exito");
        } catch (Exception error) {
            test.log(Status.FAIL, "Se produjo una excepción durante la ejecución del test: " + error.getMessage());
        }

    }

    @Test
    public void open_account() {
        ExtentTest test = extent.createTest("Registro nueva cuenta");
        test.log(Status.INFO, "Comienza el Test");

        RegisterPage registerPage = new RegisterPage(driver, wait);


        try {
            login();
            test.log(Status.INFO, "User logeado exitosamente");
            registerPage.click_open_new_acount();
            registerPage.click_open_new_acount_menu_saving();
            registerPage.clickButtonCreate_new_account();

            Assertions.assertEquals("Congratulations, your account is now open", registerPage.get_succesfully_message_new_account());

            test.log(Status.PASS, "El test se completo correctamente");
            System.out.println("Test - Nueva cuenta completado con exito");


        } catch (Error e) {
            System.out.println(e);
        }
    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
    }
}
