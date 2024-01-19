package com.example.ParaBankTesting.frontTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccount extends BasePage {


    private final By open_new_account = By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a");

    private final By menu_new_account = By.xpath("//*[@id=\"type\"]");

    private final  By account_type_checking = By.xpath("//*[@id=\"type\"]/option[1]");
    private final  By account_type_savings = By.xpath("//*[@id=\"type\"]/option[2]");
    private final  By button_create_new_account = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input");
    private final  By new_account_successfully = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]");


    public NewAccount(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickButtonCreate_new_account() {
        click(button_create_new_account);
    }

    public void click_open_new_acount() {
        click(open_new_account);
    }
    public void click_open_new_acount_menu_saving() {
        click(menu_new_account);
        click(account_type_savings);

    }
    public void click_open_new_acount_menu_check() {
        click(menu_new_account);
        click(account_type_checking);
        clickButtonCreate_new_account();
    }
    public String get_succesfully_message_new_account() {
        return this.getText(new_account_successfully);

    }
}
