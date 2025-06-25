package com.juaracoding.finalproject.steps;

import com.juaracoding.finalproject.DriverSingleton;
import com.juaracoding.finalproject.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;



public class AbsenTest {
    WebDriver driver;
    SignInPage signInPage;

    @Given("Buka halaman home untuk pengujian absen masuk")
    public void testStep01() {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://magang.dikahadir.com/apps/absent");
        signInPage = new SignInPage(driver);
    }

    @Given("Pengguna berada di halaman Home")
    public void penggunaBeradaDiHalamanHome() {
        
    }

    @And("Pengguna Harus mengclik button absen")
    public void penggunaHarusMengclikButtonAbsen() {
        
    }

    @And("Pengguna mengambil foto selfie dengan wajah terlihat")
    public void penggunaMengambilFotoSelfieDenganWajahTerlihat() {
        
    }

    @Then("Muncul Form Absen")
    public void munculFormAbsen() {
        
    }

    @Then("Pengguna memilih jam masuk")
    public void penggunaMemilihJamMasuk() {
        
    }

    @When("Pengguna memilih opsi {string}")
    public void penggunaMemilihOpsi(String arg0) {
        
    }

    @And("Pengguna menambahkan catatan {string}")
    public void penggunaMenambahkanCatatan(String arg0) {
        
    }

    @And("Pengguna menekan tombol Absen Masuk")
    public void penggunaMenekanTombolAbsenMasuk() {
        
    }

    @Then("Sistem menampilkan pesan {string}")
    public void sistemMenampilkanPesan(String arg0) {
    }
}
