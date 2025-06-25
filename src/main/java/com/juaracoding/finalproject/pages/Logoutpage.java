package com.juaracoding.finalproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpage {
    WebDriver driver;

    @FindBy(id = "email")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    public Logoutpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String value) {
        usernameField.sendKeys(value);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void onClick() {
        loginButton.click();
    }

    public void login(String email, String password) {
        setUsername(email);
        setPassword(password);
        onClick();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}


