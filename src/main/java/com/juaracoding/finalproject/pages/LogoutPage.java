package com.juaracoding.finalproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    WebDriver driver;

    @FindBy(xpath = "//button[.//span[contains(@class,'bar')]]  //")
    WebElement clikMenu;

    @FindBy(xpath = "//div[contains(@class,'sidebar') or contains(@class,'drawer')]//div[contains(text(),'Menu')]")
    WebElement sideBar;

    @FindBy(xpath = "//*[@id='__next']/div/div/div/form/button[2]")
    WebElement logoutButton;

//    @FindBy(xpath = "//div[contains(@class,'Toastify')]")
//    WebElement errorMessage;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void onMenuClick() {
        clikMenu.click();
    }
    public void SideBar() {
        sideBar.click();
    }
    public WebElement onLougoutClick() {logoutButton.click();
        return null;
    }


//
//    public String getErrorMessage() {
//        return errorMessage.getText();
//    }

}


