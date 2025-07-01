package com.juaracoding.finalproject.steps;

import com.juaracoding.finalproject.DriverSingleton;
import com.juaracoding.finalproject.pages.AbsenPage;
import com.juaracoding.finalproject.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class AbsenTestStep {
    private WebDriver driver;
    private AbsenPage absenPage;

    @Given("Pengguna berada di halaman Home")
    public void initializePage() {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://magang.dikahadir.com/apps/absent");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        SignInPage signInPage = new SignInPage(driver);
        absenPage = new AbsenPage(driver);

        // Perform login and verify
        signInPage.login("hadirsqa1@gmail.com", "SQA@Hadir12345");
//        signInPage.login("komar@gmail.com ", "Komar123");

    }

    @And("Pengguna Harus mengclik button absen")
    public void clickAbsenButton() {
        absenPage.onClickAbsen();
    }

    @And("Pengguna mengambil foto selfie dengan wajah terlihat")
    public void takeSelfie() throws IOException, InterruptedException {
        absenPage.onClickCamera();
        String screenshotPath = "C:\\Users\\Andreas Prasetya\\OneDrive\\Pictures\\Screenshots\\";
        takeScreenshot(driver, screenshotPath);
    }

    @Then("Muncul Form Absen")
    public void verifyAbsenForm() {
        if (absenPage.isAbsenFormDisplayed()) {
            throw new RuntimeException("Absen form not visible");
        }
    }

    @Then("Jam masuk otomatis muncul")
    public void verifyAutoTime() {
        String time = absenPage.getTimeInput();
        if (time == null || time.isEmpty()) {
            throw new RuntimeException("Time not displayed automatically");
        }
        System.out.println("Auto time displayed: " + time);
    }

    @When("Pengguna memilih opsi {string}")
    public void selectAttendanceOption(String option) throws InterruptedException {
        absenPage.pilihDariDropdown(option);

    }

    @And("Pengguna menambahkan catatan {string}")
    public void addNote(String note) {
        absenPage.isiNote(note);

        String enteredNote = absenPage.getNoteText();
        if (!enteredNote.equals(note)) {
            throw new RuntimeException("Note not entered correctly");
        }
    }

    @And("Pengguna menekan tombol Absen Masuk")
    public void submitAbsen() throws InterruptedException {
        // Capture data before submission
        String time = absenPage.getTimeInput();
        String type = absenPage.getSelectedDropdownValue();
        String note = absenPage.getNoteText();

        absenPage.onclickAbsenMasuk();

        System.out.println("Absen submitted with:");
        System.out.println("Time: " + time);
        System.out.println("Type: " + type);
        System.out.println("Note: " + note);
    }

    private void takeScreenshot(WebDriver driver, String savePath) throws IOException {
        File directory = new File(savePath);
        if (!directory.exists()) {
//            directory.mkdirs();
            System.out.println("Directory does not exist, creating: " + savePath);
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = "Absen_Selfie_" + timestamp + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(savePath + filename);

        FileUtils.copyFile(screenshot, destination);
        System.out.println("Screenshot saved: " + destination.getAbsolutePath());
    }
}