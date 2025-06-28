//package com.juaracoding.finalproject.pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class LogoutPage {
//    WebDriver driver;
//
//    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[1]/div[1]/div[2]/button")
//    WebElement clikMenu;
//
//    @FindBy(xpath = "/html/body/div[2]/div[3]")
//    WebElement sideBar;
//
//    @FindBy(xpath = "//button[contains(text(),'Logout')]")
//    WebElement logoutButton;
//
//    @FindBy(xpath = "//div[contains(@class,'Toastify')]")
//    WebElement errorMessage;
//
//    public LogoutPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//    public void onMenuClick() {
//        clikMenu.click();
//    }
//    public void SideBar() {
//        sideBar.click();
//    }
//    public WebElement onLogoutClick() {
//        logoutButton.click();
//        return null;
//    }
//
//    public String getErrorMessage() {
//        return errorMessage.getText();
//    }
//
//}
