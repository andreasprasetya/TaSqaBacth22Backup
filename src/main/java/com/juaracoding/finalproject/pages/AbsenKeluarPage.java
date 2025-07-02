package com.juaracoding.finalproject.pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbsenKeluarPage {

    private final WebDriverWait wait;
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[1]/div[4]/div[2]/div[1]/div[2]/button")
    WebElement buttonKeluar;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/form")
    WebElement formAbsenKeluar;

    @FindBy(xpath = "//*[@id=\"mui-12\"]")
    WebElement timeInputKeluar;

    @FindBy(xpath = "//*[@id=\"mui-13\"]")
    WebElement noteTextFieldKeluar;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/form/div/div[3]/button")
    WebElement buttonAbsenKeluar;


    public AbsenKeluarPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void onClickButtonKeluar() {
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



    