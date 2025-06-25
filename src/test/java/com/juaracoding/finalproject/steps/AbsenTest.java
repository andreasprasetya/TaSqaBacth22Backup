package com.juaracoding.finalproject.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.finalproject.DriverSingleton;
import com.juaracoding.finalproject.pages.AbsenPage;
import com.juaracoding.finalproject.pages.SignInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AbsenTest {
  WebDriver driver;
  SignInPage signInPage;
  AbsenPage absenPage;

  @Given("Pretest verifikasi, login dengan user valid")
  public void testStep01() {
    driver = DriverSingleton.createOrGetDriver();
    driver.get("https://magang.dikahadir.com/apps/absent");

    signInPage = new SignInPage(driver);
    absenPage = new AbsenPage(driver);
    signInPage.login("hadirsqa1@gmail.com", "SQA@Hadir12345");
  }

  @When("Verifikasi semua produk ditampilkan")
  public void testStep02() {
    Assert.assertTrue(absenPage.hasAProducts());
  }

  @Then("Daftar produk muncul lengkap dengan nama, harga, dan tombol Add to Cart")
  public void testStep03() {
    Assert.assertTrue(absenPage.checkProperty());
  }
}
