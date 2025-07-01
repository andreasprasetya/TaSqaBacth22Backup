package com.juaracoding.finalproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage {
  WebDriver driver;

  @FindBy(xpath = "//*[@id='email']")
  WebElement usernameField;

  @FindBy(xpath = "//*[@id='password']")
  WebElement passwordField;

  @FindBy(xpath = "//button[@type='submit']")
  WebElement loginButton;



//    @FindBy(xpath = "//div[contains(@class,'Toastify')]")
//    WebElement errorMessage;


  public SignInPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void setUsername(String value) {
    usernameField.sendKeys(value);
  }

//  public void setUsernameField(String email) {
//    passwordField.sendKeys(email);
//  }

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

//    public String getErrorMessage() {
//        return errorMessage.getText();
//    }

  }

