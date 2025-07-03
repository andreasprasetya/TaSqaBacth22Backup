package com.juaracoding.finalproject.steps;

import com.juaracoding.finalproject.DriverSingleton;
import com.juaracoding.finalproject.pages.AbsenKeluarPage;
import com.juaracoding.finalproject.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class AbsenKeluarTestStep {
    private WebDriver driver;
    private SignInPage signInPage;
    private AbsenKeluarPage absenKeluarPage;
    private  JavascriptExecutor jsExecutor;
    private WebDriverWait wait;



    @Given("Pengguna Harus Melakukan Login Kembali")
    public void penggunaHarusMelakukanLoginKembali() {

        driver= DriverSingleton.createOrGetDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://magang.dikahadir.com/absen/login");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.login("hadirsqa1@gmail.com", "SQA@Hadir12345");
        //  signInPage.login("komar@gmail.com", "Komar123 ");
    }

    @Given("Pengguna berada di halaman Home")
    public void initializePage() {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://magang.dikahadir.com/apps/absent");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        SignInPage signInPage = new SignInPage(driver);
        absenKeluarPage = new AbsenKeluarPage(driver);

        // Perform login and verify
        signInPage.login("hadirsqa1@gmail.com", "SQA@Hadir12345");
//      signInPage.login("komar@gmail.com ", "Komar123");
    }

    @Then("Click Button keluar")
    public void clickButtonKeluar(WebElement element) {
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        absenKeluarPage.onClickButtonKeluar();

    }

    @And("Muncul Form Absen Keluar")
    public void munculFormAbsenKeluar() {
        if (!absenKeluarPage.isAbsenKeluarFormDisplayed()) {
            throw new RuntimeException("Form Absen Keluar tidak muncul");
        }

    }

    @Then("Jam Keluar otomatis muncul")
    public void jamKeluarOtomatisMuncul() {
        String time = absenKeluarPage.getTimeInputKeluar();
        if (time == null || time.isEmpty()) {
            throw new RuntimeException("Time not displayed automatically");
        }
        System.out.println("Auto time displayed: " + time);
    }

    @And("Pengguna menambahkan catatan {string}")
    public void addNote(String note) throws InterruptedException {
        Thread.sleep(2000);
        absenKeluarPage.isiNote(note);
        Thread.sleep(2000);
        String enteredNote = absenKeluarPage.getNoteTextKeluer();
        Thread.sleep(2000);
//        if (!enteredNote.equals(note)) {
//            throw new RuntimeException("Note not entered correctly");
//        }
    }

    @And("Pengguna menekan tombol Absen Keluar")
    public void penggunaMenekanTombolAbsenKeluar() {
        // Capture data before submission
        String time = absenKeluarPage.getTimeInputKeluar();
//        String type = absenPage.getSelectedDropdownValue();
        String note = absenKeluarPage.getNoteTextKeluer();

        absenKeluarPage.onClickAbsenKeluar();
    }


    public void AutoScrollAndClick(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void scrollIntoView(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", element);
        wait.until(ExpectedConditions.visibilityOf(element));
        try {
            Thread.sleep(500); // Beri waktu untuk animasi
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void scrollAndClick(WebElement element) {
        scrollIntoView(element);
        element.click();
    }



}





