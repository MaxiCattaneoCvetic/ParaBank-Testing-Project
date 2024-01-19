package com.example.ParaBankTesting.frontTesting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.ParaBankTesting.frontTestPages.NewAccount;
import com.example.ParaBankTesting.frontTestPages.RegisterPage;
import com.example.ParaBankTesting.reports.ExtentFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountTest {

    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reportes_newAccount.html");
    static ExtentReports extent;

    public void login() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.getUrl("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        registerPage.login("maxxx", "testing");
    }


    @BeforeAll
    public static void create_report() {
        extent = ExtentFactory.getInsance(); // instanciamos la clase para crear reportes
        extent.attachReporter(info); // seleccionamos la ruta donde guardamos el report
    }


    @Test
    public void open_account() {
        ExtentTest test = extent.createTest("Registro nueva cuenta");
        test.log(Status.INFO, "Comienza el Test");

        NewAccount newAccount = new NewAccount(driver,wait);

        try {
            login();
            test.log(Status.INFO, "User logeado exitosamente");
            newAccount.click_open_new_acount();
            newAccount.click_open_new_acount_menu_saving();
            newAccount.clickButtonCreate_new_account();


            Assertions.assertEquals("Congratulations, your account is now open", newAccount.get_succesfully_message_new_account());

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
