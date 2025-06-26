package com.juaracoding.finalproject.steps;

import com.juaracoding.finalproject.DriverSingleton;
import com.juaracoding.finalproject.pages.LogoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthenticationLogoutTestStep {

    WebDriver driver;
   LogoutPage LogoutPage;
    WebDriverWait wait;

    @Given("User sudah masuk ke dalam halam home")
    public void userSudahMasukKeDalamHalamHome() {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://magang.dikahadir.com/apps/absent");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LogoutPage= new LogoutPage(driver);
        // Jika perlu login otomatis, tambahkan step login di sini
    }

    @When("Klik menu bar")
    public void klikMenuBar() {
        LogoutPage.onMenuClick(); // klik tombol ☰
    }

    @When("Tunggu sampai muncul side bar")
    public void tungguSampaiMunculSideBar() {
        wait.until(ExpectedConditions.visibilityOf(LogoutPage.onLougoutClick()));
    }

    @Then("Klik Button logout")
    public void klikButtonLogout() {
        klikButtonLogout();
    }
}