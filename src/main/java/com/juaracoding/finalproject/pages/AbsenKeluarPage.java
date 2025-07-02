package com.juaracoding.finalproject.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class AbsenKeluarPage {

    // Locators for the elements on the Absen Keluar page
//    private final By historyAbsensiSection = By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/p[1]");
//    private final By absenMasukEntries = By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/p[2]");
//    private final By tipeAbsen = By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/p[3]");
//    private final By waktuMasuk = By.xpath(".//*[@id=\"__next\"]/div/div/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/p[4]");
//    private final By Note = By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/p[5]");


    private final WebDriverWait wait;
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[1]/div[4]/div[2]/div[1]/div[2]/button")
    private WebElement buttonKeluar;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/form")
    WebElement formAbsenKeluar;

    @FindBy(xpath = "//*[@id=\"mui-12\"]")
    WebElement timeInputKeluar;

    @FindBy(xpath = "//*[@id=\"mui-13\"]")
    WebElement noteTextFieldKeluar;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/form/div/div[3]/button")
    WebElement buttonAbsenKeluar;

    public void scrollTobuttonKeluar() {
        // Scroll ke elemen buttonKeluar
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", buttonKeluar);

        // Tunggu hingga elemen terlihat
        wait.until(ExpectedConditions.visibilityOf(buttonKeluar));

        // Beri sedikit waktu untuk animasi scroll
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public AbsenKeluarPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.buttonKeluar = buttonKeluar;
        PageFactory.initElements(driver, this);
    }

    public void onClickButtonKeluar() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonKeluar));
        wait.until(ExpectedConditions.elementToBeClickable(buttonKeluar));
        buttonKeluar.click();
    }


    public boolean isAbsenFormDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(formAbsenKeluar));
            return !formAbsenKeluar.isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

    public String getTimeInputKeluar() {
        wait.until(ExpectedConditions.visibilityOf(timeInputKeluar));
        return timeInputKeluar.getText(); // Diubah dari getAttribute("value") ke getText()
    }

    public void isiNote(String note) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(noteTextFieldKeluar));

        noteTextFieldKeluar.clear();
        Thread.sleep(2000);
        noteTextFieldKeluar.sendKeys(note);
    }

    public String getNoteTextKeluer() {
        wait.until(ExpectedConditions.visibilityOf(noteTextFieldKeluar));
        return noteTextFieldKeluar.getAttribute("value");
    }

    public void onClickAbsenKeluar() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonAbsenKeluar));
        buttonAbsenKeluar.click();
    }

    }
//
//    public void navigateToAbsenKeluar() {
//        // Navigasi ke halaman absen keluar
//        driver.get("https://magang.dikahadir.com/apps/absent");
//    }
//
//
//    public AbsenMasukData getLatestAbsenMasukData() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(historyAbsensiSection));
//        WebElement historySection = driver.findElement(historyAbsensiSection);
//
//        List<WebElement> entries = historySection.findElements(absenMasukEntries);
//        if (entries.isEmpty()) {
//            throw new RuntimeException("Tidak ada data absen masuk yang ditemukan");
//        }
//
//         //Ambil data absen masuk terbaru (pertama dalam list)
//        WebElement latestEntry = entries.getFirst();
//        AbsenMasukData data = new AbsenMasukData();
//        data.setTanggal(latestEntry.findElement(tipeAbsen).getText());
//        data.setWaktuMasuk(latestEntry.findElement(waktuMasuk).getText());
//        data.setNote(latestEntry.findElement(Note).getText());
//        return data;
//    }
//
//    // Class untuk menyimpan data absen masuk
//    @Getter
//    public static class AbsenMasukData {
//        // Getters and Setters
//        private String tipeAbsen;
//        @Setter
//        private String waktuMasuk;
//        @Setter
//        private String note;
//
//        public void setTanggal(String tanggal) {
//            this.tipeAbsen = tipeAbsen;
//        }
//
//        @Override
//        public String toString() {
//            return "AbsenMasukData{" +
//                    "tipeAbsen='" + tipeAbsen+ '\'' +
//                    ", waktuMasuk='" + waktuMasuk + '\'' +
//                    ", note='" + note+ '\'' +
//                    '}';
//        }
//    }








    