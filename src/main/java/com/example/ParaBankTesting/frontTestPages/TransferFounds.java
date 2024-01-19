package com.example.ParaBankTesting.frontTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferFounds extends BasePage {

    private By transferLink = By.xpath("//*[@id=\"leftPanel\"]/ul/li[3]/a");
    private By transferTitle = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");
    private By inputAmount = By.id("amount");
    private By transfer_Successful_message = By.linkText("Transfer Complete!");
    private By transferBTN = By.linkText("Transfer");

    public TransferFounds(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void clickTransferLink() {
        this.click(transferLink);
    }

    public void insertAmount(String amount) {

        this.sendText(amount, inputAmount);

    }

    public void clickTransferBtn() {
        this.click(transferBTN);

    }
    public void clickTransferBtnENTER() {
        this.sendKey(Keys.ENTER,transferBTN);

    }

    public String getSuccessfulMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(transfer_Successful_message));
        String message = findElementByLocator(transfer_Successful_message).getText();
        return message;

    }
    public String getTransferTitle() {
        String message = findElementByLocator(transferTitle).getText();
        return message;

    }

}
