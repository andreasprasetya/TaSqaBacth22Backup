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

    }

   @Then("Jam masuk otomatis muncul")
    public void penggunaMemilihJamMasuk() {

    }
//
//   @When("Pengguna memilih opsi {string}")
//    public void penggunaMemilihOpsi(String arg0) {
//   absenPage.pilihDariDropdown(opsi);
//    }
//
//   @And("Pengguna menambahkan catatan {string}")
//    public void penggunaMenambahkanCatatan(String arg0) {
//}
//
//    @And("Pengguna menekan tombol Absen Masuk")
//   public void penggunaMenekanTombolAbsenMasuk() {
//
//    }
//
//   @Then("Sistem menampilkan pesan {string}")
//   public void sistemMenampilkanPesan(String arg0) {
//   }
}
