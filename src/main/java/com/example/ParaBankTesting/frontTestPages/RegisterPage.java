package com.example.ParaBankTesting.frontTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    private final By inputFirstName = By.name("customer.firstName");
    private final By inputLastName = By.name("customer.lastName");
    private final By inputStreet = By.name("customer.address.street");
    private final By inputCity = By.name("customer.address.city");
    private final By inputState = By.name("customer.address.state");
    private final By inputZipCode = By.name("customer.address.zipCode");
    private final By inputPhoneNumber = By.name("customer.phoneNumber");
    private final By inputSsn = By.name("customer.ssn");
    private final By inputUserName = By.name("customer.username");
    private final By inputPassword = By.name("customer.password");
    private final By inputPasswordV = By.name("repeatedPassword");
    private final By msjSuccessful = By.xpath("//*[@id=\"rightPanel\"]/p");
    private final By buttonRegister = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");

    private final By registerLink = By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");



    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void writeInputName(String name) {
        sendText(name, inputFirstName);
    }

    public void writeInputLastName(String lastName) {
        sendText(lastName, inputLastName);
    }

    public void writeInputCity(String city) {
        sendText(city, inputCity);
    }

    public void writeInputAdress(String street) {
        sendText(street, inputStreet);
    }

    public void writeInputState(String state) {
        sendText(state, inputState);
    }

    public void writeInputZip(String zip) {
        sendText(zip, inputZipCode);
    }

    public void writeInputPhone(String phone) {
        sendText(phone, inputPhoneNumber);
    }

    public void writeInputSsn(String ssn) {
        sendText(ssn, inputSsn);
    }

    public void writeInputUsername(String username) {
        sendText(username, inputUserName);
    }

    public void writeInputPassword(String password) {
        sendText(password, inputPassword);
    }

    public void writeInputPasswordV(String passwordV) {
        sendText(passwordV, inputPasswordV);
    }


    public void clickButtonRegister() {
        click(buttonRegister);
    }




    public String register_successful() {
        String msj = this.getText(msjSuccessful);
        return msj;
    }

    public void goRegisterLink () {
        this.click(registerLink);
    }


}
