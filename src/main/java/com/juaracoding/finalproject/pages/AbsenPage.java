package com.juaracoding.finalproject.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbsenPage {
    private final WebDriverWait wait;
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div/button")
    WebElement buttonAbsen;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/button")
    WebElement buttonCamera;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]")
    WebElement absenForm;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/form/div[1]")
    WebElement timeInput; // untuk ambil jam masuk otomatis sesuai device dan open browser

    @FindBy(css = "div[role='combobox']")
    WebElement selectOptions; // Diperbaiki xpath untuk select element

    @FindBy(xpath = "//ul[@aria-labelledby='is_wfh']/li[2]")
    WebElement selectOptionsWFH; // Diperbaiki xpath untuk select element

    @FindBy(xpath = "//label[@id='wfh']/following-sibling::div//input")
    WebElement noteTextField;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/form/button")
    WebElement buttonAbsenMasuk;

    public AbsenPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getSelectedDropdownValue() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(selectOptionsWFH));
        String text = selectOptionsWFH.getText();
        selectOptionsWFH.click();
        return text; // Mengembalikan teks yang dipilih
    }

    public void isiNote(String note) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(noteTextField));
        noteTextField.clear();
        Thread.sleep(2000);
        noteTextField.sendKeys(note);
    }

    public String getNoteText() {
        wait.until(ExpectedConditions.visibilityOf(noteTextField));
        return noteTextField.getAttribute("value");
    }

    public void onclickAbsenMasuk() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonAbsenMasuk));
        buttonAbsenMasuk.click();
    }

    public boolean isAbsenFormDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(absenForm));
            return absenForm.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}