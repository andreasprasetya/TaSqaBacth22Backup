package com.juaracoding.finalproject.steps;

import com.juaracoding.finalproject.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.juaracoding.finalproject.DriverSingleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AuthenticationSignInTestStep {
  WebDriver driver;
  SignInPage signInPage;



  @Given("Buka halaman login untuk pengujian login valid")
  public void testStep01() {
    driver = DriverSingleton.createOrGetDriver();
    driver.get("https://magang.dikahadir.com/absen/login");
    signInPage = new SignInPage(driver);

  }

  @When("Masukkan username {string} dan password {string} valid")
  public void testStep02(String email, String password) throws InterruptedException {
    Thread.sleep(1000);
    signInPage.setUsername(email);
    Thread.sleep(1000);
    signInPage.setPassword(password);
    Thread.sleep(1000);
  }

  @And("Klik tombol login untuk login valid")
  public void testStep03() throws InterruptedException {
    signInPage.onClick();
   Thread.sleep(1000);
  }

  @Then("Pengguna berhasil masuk ke halaman absen")
  public void testStep04() {
    String expected = "https://magang.dikahadir.com/apps/absent";
    String actual = driver.getCurrentUrl();
    Assert.assertEquals(actual, expected);
  }
}
