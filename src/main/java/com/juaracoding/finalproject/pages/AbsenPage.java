package com.juaracoding.finalproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/form/div[2]/select")
    WebElement selectOptions; // Diperbaiki xpath untuk select element

    @FindBy(xpath = "//textarea[@placeholder='Note']")
    WebElement noteTextField;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/form/button")
    WebElement buttonAbsenMasuk;

    public AbsenPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void onClickAbsen() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonAbsen));
        buttonAbsen.click();
    }

    public void onClickCamera() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonCamera));
        buttonCamera.click();
        // Tambahkan delay untuk memastikan kamera siap
        try {
            Thread.sleep(2000); // Tunggu 2 detik untuk kamera siap
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getTimeInput() {
        wait.until(ExpectedConditions.visibilityOf(timeInput));
        return timeInput.getText(); // Diubah dari getAttribute("value") ke getText()
    }

    public void pilihDariDropdown(String value) {
        wait.until(ExpectedConditions.visibilityOf(selectOptions));
        Select select = new Select(selectOptions);
        select.selectByVisibleText(value);
    }

    public String getSelectedDropdownValue() {
        wait.until(ExpectedConditions.visibilityOf(selectOptions));
        Select select = new Select(selectOptions);
        return select.getFirstSelectedOption().getText();
    }

    public void isiNote(String note) {
        wait.until(ExpectedConditions.visibilityOf(noteTextField));
        noteTextField.clear();
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
            return !absenForm.isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

}