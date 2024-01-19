package com.example.ParaBankTesting.frontTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountActivity extends BasePage{

    private By linkAccountResume = By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a");
    private By getTextBalanceResume = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");
    private By accountSelector = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    private By accountDetails = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");
    private By GO_btn = By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input");



    public AccountActivity(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void clickLinkAccountResume() {
        this.click(linkAccountResume);
    }
    public String getTextBalance() {
        return this.findElementByLocator(getTextBalanceResume).getText();
    }

    public void clickAccount() {
        this.click(accountSelector);
    }
    public String getTextAccountDetails() {
        return this.findElementByLocator(accountDetails).getText();
    }
    public void click_go () {
    this.click(GO_btn);
    }





}
