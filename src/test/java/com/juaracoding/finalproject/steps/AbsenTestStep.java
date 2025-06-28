package com.juaracoding.finalproject.steps;

import com.juaracoding.finalproject.DriverSingleton;
import com.juaracoding.finalproject.pages.AbsenPage;
import com.juaracoding.finalproject.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;



public class AbsenTestStep {
    WebDriver driver;
    SignInPage signInPage;
    AbsenPage absenPage;

    @Given("Pengguna berada di halaman Home")
    public void testStep01() {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://magang.dikahadir.com/apps/absent");
         signInPage = new SignInPage(driver);
        absenPage = new AbsenPage(driver);
        signInPage.login(" hadirsqa1@gmail.com", "SQA@Hadir12345");
    }

    @And("Pengguna Harus mengclik button absen")
    public void penggunaHarusMengclikButtonAbsen() throws InterruptedException {
        System.out.println("Lgi di posisis klik button");
        absenPage.onclickAbsenMasuk();
        Thread.sleep(2000);
    }

    @And("Pengguna mengambil foto selfie dengan wajah terlihat")
    public void penggunaMengambilFotoSelfieDenganWajahTerlihat() {
        absenPage.onClickCamera();
    }

    @Then("Muncul Form Absen")
    public void munculFormAbsen() {
        System.out.println("Form Absen muncul. Jam masuk: " + absenPage.getJamMasuk());
    }

    @Then("Jam masuk otomatis muncul")
    public void penggunaMemilihJamMasuk() {
        String jamMasuk = absenPage.getJamMasuk();
        System.out.println("Jam masuk yang diambil: " + jamMasuk);
    }

    @When("Pengguna memilih opsi {string}")
    public void penggunaMemilihOpsi(String opsi) {
        absenPage.pilihDariDropdown(opsi);
        System.out.println("Opsi dropdown yang dipilih: " + absenPage.getSelectedDropdownValue());
    }

    @And("Pengguna menambahkan catatan {string}")
    public void penggunaMenambahkanCatatan(String note) {
        absenPage.isiNote(note);
        System.out.println("Catatan yang diisi: " + absenPage.getNote());
    }

    @And("Pengguna menekan tombol Absen Masuk")
    public void penggunaMenekanTombolAbsenMasuk() {
        absenPage.onclickAbsenMasuk();
        System.out.println("Tombol Absen Masuk diklik.");
    }

    @Then("Sistem menampilkan pesan {string}")
    public void sistemMenampilkanPesan(String pesan) {
        // Implementasi pengambilan pesan dari UI jika ada, misal dengan WebElement pesanElement
        // String pesanUI = pesanElement.getText();
        // Assert.assertEquals(pesanUI, pesan);
        System.out.println("Pesan yang diharapkan: " + pesan);
    }
}
