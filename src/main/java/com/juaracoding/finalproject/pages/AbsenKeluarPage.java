package com.juaracoding.finalproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbsenKeluarPage {
    WebDriver driver;


    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
    WebElement historyAbsen;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/button")
    WebElement  buttonKeluar;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/form/div[1]")
    WebElement  halamanKoreksi;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    private WebElement iconJamMasuk;

    @FindBy(xpath = "(//button[@type='button'])[4]")
    private WebElement iconJamKeluar;

    @FindBy(xpath = "//input[@id='mui-4']")
    private WebElement valueJamMasuk;

    @FindBy(xpath = "//input[@id='mui-5']")
    private WebElement valueJamKeluar;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnAjukanKoreksi;

    public AbsenKeluarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
