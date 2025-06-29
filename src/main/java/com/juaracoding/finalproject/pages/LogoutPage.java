package com.juaracoding.finalproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[1]/div[1]/div[2]/button")
    WebElement clikMenu;

    @FindBy(xpath = "/html/body/div[2]/div[3]")
    WebElement sideBar;

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//div[contains(@class,'Toastify')]")
    WebElement errorMessage;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void onMenuClick() throws InterruptedException {
        clikMenu.click();
        Thread.sleep(1000);
    }
    public void SideBar() throws InterruptedException {
        sideBar.click();
        Thread.sleep(1000);
    }
    public WebElement onLogoutClick() throws InterruptedException {
        logoutButton.click();
        Thread.sleep(1000);
        return null;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}
