//package com.juaracoding.finalproject.pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//public class AbsenKeluarPage {
//    private final WebDriverWait wait;
//    WebDriver driver;
//
//    // Element untuk history absen
//    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[1]/div[4]/div[1]/p")
//    WebElement headerHistoryAbsen;
//
//    @FindBy(xpath = "//button[contains(text(),'History Absen')]")
//    WebElement historyAbsenButton;
//
//    // Element untuk absen keluar
//    @FindBy(xpath = "//button[contains(text(),'Absen Keluar')]")
//    WebElement buttonKeluarAbsen;
//
//    // Element form absen keluar
//    @FindBy(xpath = "//div[contains(@class,'absen-keluar-form')]")
//    WebElement absenKeluarForm;
//
//    @FindBy(xpath = "//div[contains(@class,'time-input')]")
//    WebElement timeInputKeluar;
//
//    @FindBy(xpath = "//textarea[@placeholder='Catatan']")
//    WebElement noteTextArea;
//
//    @FindBy(xpath = "//button[contains(text(),'Submit Absen Keluar')]")
//    WebElement buttonSubmitAbsenKeluar;
//
//    public AbsenKeluarPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        PageFactory.initElements(driver, this);
//    }
//
//    // Method untuk history absen
//    public String getHeaderHistoryAbsen() {
//        wait.until(ExpectedConditions.visibilityOf(headerHistoryAbsen));
//        return headerHistoryAbsen.getText();
//    }
//
//    public void clickHistoryAbsen() {
//        wait.until(ExpectedConditions.elementToBeClickable(historyAbsenButton));
//        historyAbsenButton.click();
//    }
//
//    // Method untuk absen keluar
//    public void clickAbsenKeluar() {
//        wait.until(ExpectedConditions.elementToBeClickable(buttonKeluarAbsen));
//        buttonKeluarAbsen.click();
//    }
//
//    public boolean isAbsenKeluarFormDisplayed() {
//        try {
//            wait.until(ExpectedConditions.visibilityOf(absenKeluarForm));
//            return absenKeluarForm.isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public String getTimeKeluar() {
//        wait.until(ExpectedConditions.visibilityOf(timeInputKeluar));
//        return timeInputKeluar.getText();
//    }
//
//    public void inputNote(String note) {
//        wait.until(ExpectedConditions.visibilityOf(noteTextArea));
//        noteTextArea.clear();
//        noteTextArea.sendKeys(note);
//    }
//
//    public String getNoteText() {
//        wait.until(ExpectedConditions.visibilityOf(noteTextArea));
//        return noteTextArea.getAttribute("value");
//    }
//
//    public void submitAbsenKeluar() {
//        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmitAbsenKeluar));
//        buttonSubmitAbsenKeluar.click();
//    }
//}