package com.juaracoding.finalproject.steps;

import com.juaracoding.finalproject.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.juaracoding.finalproject.DriverSingleton;
import com.juaracoding.finalproject.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class AuthenticationSignInTestStep {
  WebDriver driver;
  SignInPage signInPage;
//  AbsenPage absenPage;


  @Given("Buka halaman login untuk pengujian login valid")
  public void testStep01() {
    driver = DriverSingleton.createOrGetDriver();
    driver.get("https://magang.dikahadir.com/absen/login");
    signInPage = new SignInPage(driver);
//    absenPage = new AbsenPage(driver);
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
    System.out.println("Lgi di posisis klik button");
    signInPage.onClick();
   Thread.sleep(2000);
  }

  @Then("Pengguna berhasil masuk ke halaman absen")
  public void testStep04() {
//    absenPage.onClickAbsen();
    String expected = "https://magang.dikahadir.com/apps/absent";
    String actual = driver.getCurrentUrl();
    Assert.assertEquals(actual, expected);
  }
}
