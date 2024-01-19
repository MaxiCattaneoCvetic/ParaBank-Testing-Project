package com.example.ParaBankTesting.frontTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public Wait wait;

    private By inputName = By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input");
    private By inputPassword = By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input");
    private By loginBtn = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");


    protected BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(3000)); // -> No es que hacemos una espera de 3s, sino que esperamos hasta 3 segundos
        // En el caso de que el localizador se encuentre antes no hara la espera
    }


    // configuracion de nuestra web setup

    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    public void getUrl(String url) {
        driver.navigate().to(url);
    }

    public void closeWeb() {
        driver.quit();
    }

    protected WebElement findElementByLocator(By locator) {
        return driver.findElement(locator);
    }

    protected void sendKey(CharSequence key, By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)); // --> Esperamos a que el locator este presente.
        this.findElementByLocator(locator).sendKeys(key);

    }

    protected void sendText(String text, By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)); // --> Esperamos a que el locator este presente.
        WebElement locatorFounded = this.findElementByLocator(locator);
        locatorFounded.clear();
        locatorFounded.sendKeys(text);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)); // -> Esperamos a que el elemento sea clickeable
        driver.findElement(locator).click();
    }

    protected String getText(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)); // -> Esperamos a que el localizador este presente
        return this.findElementByLocator(locator).getText();
    }

    public void login(String userName, String password) {

        WebElement name = this.findElementByLocator(inputName);
        WebElement pass = this.findElementByLocator(inputPassword);
        name.clear();
        pass.clear();
        this.sendText(userName, inputName);
        this.sendText(password, inputPassword);
        this.click(loginBtn);


    }


}
