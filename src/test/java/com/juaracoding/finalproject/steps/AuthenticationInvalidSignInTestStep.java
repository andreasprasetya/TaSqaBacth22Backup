package com.juaracoding.finalproject.steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import com.juaracoding.finalproject.DriverSingleton;
import com.juaracoding.finalproject.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

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
  public void testStep02(String username, String password) throws InterruptedException {
    Thread.sleep(1000);
    signInPage.setUsername(username);
    Thread.sleep(1000);
    signInPage.setPassword(password);
    Thread.sleep(1000);
  }

  @And("Klik tombol login untuk login tidak valid")
  public void testStep03() {
    signInPage.onClick();
  }


//  @Then("Pengguna berhasil masuk ke halaman absen")
//  public void testStep04() {
//    String expected = "https://magang.dikahadir.com/absen/login";
//    String actual = signInPage.getErrorMessage();
//
//    Assert.assertEquals(actual, expected);
//  }
}
