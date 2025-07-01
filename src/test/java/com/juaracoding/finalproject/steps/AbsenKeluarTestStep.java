package com.juaracoding.finalproject.steps;

import com.juaracoding.finalproject.DriverSingleton;
import com.juaracoding.finalproject.pages.AbsenKeluarPage;
import com.juaracoding.finalproject.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class AbsenKeluarTestStep {
    private WebDriver driver;
    private SignInPage signInPage;
    private AbsenKeluarPage absenKeluarPage;

    @Given("Pengguna berada di halaman Home")
    public void initializePage() {
        driver = DriverSingleton.createOrGetDriver();

        // Pastikan dimulai dari halaman login
        driver.get("https://magang.dikahadir.com/apps/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        signInPage = new SignInPage(driver);
        absenKeluarPage = new AbsenKeluarPage(driver);

        // Verifikasi berada di halaman login
        wait.until(d -> Objects.requireNonNull(d.getCurrentUrl()).contains("login"));

        // Perform login
        signInPage.login("hadirsqa1@gmail.com", "SQA@Hadir12345");

        // Verifikasi login berhasil dan redirect ke halaman absent
        wait.until(d -> Objects.requireNonNull(d.getCurrentUrl()).contains("absent"));

        // Verifikasi tambahan bahwa user benar-benar sudah login
        // Misalnya dengan mengecek elemen yang hanya muncul setelah login
        wait.until(d -> absenKeluarPage.isUserLoggedIn());
    }
}





