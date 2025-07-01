//package com.juaracoding.finalproject.steps;
//
//import com.juaracoding.finalproject.DriverSingleton;
//import com.juaracoding.finalproject.pages.AbsenKeluarPage;
//import com.juaracoding.finalproject.pages.SignInPage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.Objects;
//
//public class AbsenKeluarTestStep {
//    private AbsenKeluarPage absenKeluarPage;
//
//    @Given("Pengguna berada di halaman Home")
//    public void initializePage() {
//        WebDriver driver = DriverSingleton.createOrGetDriver();
//        driver.get("https://magang.dikahadir.com/apps/absent");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        SignInPage signInPage = new SignInPage(driver);
//        absenKeluarPage = new AbsenKeluarPage(driver);
//
//        // Perform login
//        signInPage.login("hadirsqa1@gmail.com", "SQA@Hadir12345");
//
//        // Verify successful login
//        wait.until(d -> Objects.requireNonNull(d.getCurrentUrl()).contains("absent"));
//    }
//
//    @And("Memilih History Absen")
//    public void selectHistoryAbsen() {
//        // Verify history section is available
//        String historyHeader = absenKeluarPage.getHeaderHistoryAbsen();
//        System.out.println("History Absen Header: " + historyHeader);
//
//        // Click history button
//        absenKeluarPage.clickHistoryAbsen();
//    }
//
//    @When("Click Button keluar")
//    public void clickKeluarButton() {
//        absenKeluarPage.clickAbsenKeluar();
//
//        // Verify absen keluar form appears
//        if (!absenKeluarPage.isAbsenKeluarFormDisplayed()) {
//            throw new RuntimeException("Absen Keluar form failed to display");
//        }
//    }
//
//    @Then("Muncul Form Absen Keluar")
//    public void verifyAbsenKeluarForm() {
//        boolean isFormDisplayed = absenKeluarPage.isAbsenKeluarFormDisplayed();
//        System.out.println("Form Absen Keluar displayed: " + isFormDisplayed);
//
//        if (!isFormDisplayed) {
//            throw new RuntimeException("Form Absen Keluar not visible");
//        }
//    }
//
//    @Then("Verifikasi jam keluar otomatis muncul")
//    public void verifyAutoTimeKeluar() {
//        String timeKeluar = absenKeluarPage.getTimeKeluar();
//        System.out.println("Jam Keluar: " + timeKeluar);
//
//        if (timeKeluar == null || timeKeluar.isEmpty()) {
//            throw new RuntimeException("Jam keluar tidak muncul otomatis");
//        }
//    }
//
//    @And("Pengguna menambahkan catatan {string}")
//    public void fillNote(String note) {
//        absenKeluarPage.inputNote(note);
//
//        // Verify note was entered correctly
//        String enteredNote = absenKeluarPage.getNoteText();
//        System.out.println("Note yang diisi: " + enteredNote);
//
//        if (!enteredNote.equals(note)) {
//            throw new RuntimeException("Catatan tidak sesuai dengan yang diinput");
//        }
//    }
//
//    @And("Pengguna menekan tombol Absen Masuk")
//    public void submitAbsenKeluar() {
//        // Get data before submission for verification
//        String waktuKeluar = absenKeluarPage.getTimeKeluar();
//        String catatan = absenKeluarPage.getNoteText();
//
//        System.out.println("Data sebelum submit:");
//        System.out.println("- Waktu Keluar: " + waktuKeluar);
//        System.out.println("- Catatan: " + catatan);
//
//        // Submit the form
//        absenKeluarPage.submitAbsenKeluar();
//    }
//}