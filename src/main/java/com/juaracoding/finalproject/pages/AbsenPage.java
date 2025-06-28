//package com.juaracoding.finalproject.pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//
//
//public class AbsenPage {
//  WebDriver driver;
//
//    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
//    WebElement buttonAbsen;
//
//  @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/button")
//    WebElement  buttonCamera;
//
//  @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/form/div[1]")
//    WebElement  timePicker;
//
//  @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/form/div[2]")
//    WebElement dropDown;
//
//  @FindBy(xpath = "//textarea[@placeholder='Note'] ")//input[@name='note'] (tergantung tag-nya)
//     WebElement noteTextField;
//
//    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/form/button")
//    WebElement buttonAbsenMasuk;
//
//
//  public AbsenPage(WebDriver driver) {
//    this.driver = driver;
//    PageFactory.initElements(driver, this);
//  }
//
//    public void  onClickAbsen() {
//        buttonAbsen.click();
//    }
//
//    public void  onClickCamera() {
//        buttonCamera.click();
//    }
//
//  public int isiJamMasukOtomatis() {
//      LocalTime now = LocalTime.now();
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//      String jam = now.format(formatter);
//      timePicker.clear();
//      timePicker.sendKeys(jam);
//      System.out.println("Jam masuk otomatis diisi: " + jam);
//      return 0;
//  }
//
//    public void pilihDariDropdown(String value) {
//        Select select = new Select(dropDown);
//        select.selectByVisibleText(value);
//    }
//    public void isiNote(String note) {
//        noteTextField.clear();
//        noteTextField.sendKeys(note);
//    }
//          public void onclickAbsenMasuk() {
//              buttonAbsenMasuk.click();
//          }
//
//    public String getJamMasuk() {
//        return timePicker.getAttribute("value");
//    }
//
//    public String getNote() {
//        return noteTextField.getAttribute("value");
//    }
//
//    public String getSelectedDropdownValue() {
//        Select select = new Select(dropDown);
//        return select.getFirstSelectedOption().getText();
//    }
//
//}
