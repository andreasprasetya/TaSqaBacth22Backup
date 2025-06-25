package com.juaracoding.finalproject.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.finalproject.DriverSingleton;
import com.juaracoding.finalproject.pages.SignInPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationInvalidSignInTestStep {
  WebDriver driver;
  SignInPage signInPage;

  @Given("Buka halaman login untuk pengujian login invalid")
  public void testStep01() {
    driver = DriverSingleton.createOrGetDriver();
    driver.get("https://magang.dikahadir.com/absen/login");
    signInPage = new SignInPage(driver);
  }

  @When("Masukkan username {string} dan password {string} tidak valid")
  public void testStep02(String username, String password) {
    signInPage.setUsername(username);
    signInPage.setPassword(password);
  }

  @And("Klik tombol login untuk login tidak valid")
  public void testStep03() {
    signInPage.onClick();
  }

  @Then("Pengguna akan melihat pesan error")
  public void testStep04() {
    String expected = "https://magang.dikahadir.com/absen/login";
    String actual = signInPage.getErrorMessage();

    Assert.assertEquals(actual, expected);
  }
}
