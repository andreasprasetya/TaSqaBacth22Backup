package com.juaracoding.finalproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
  WebDriver driver;

  @FindBy(id = "email")
  WebElement usernameField;

  @FindBy(id = "password")
  WebElement passwordField;

  @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/form[1]/button[2]")
  WebElement loginButton;

  @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[1]")
  WebElement errorMessage;

  public SignInPage(WebDriver driver) {
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
