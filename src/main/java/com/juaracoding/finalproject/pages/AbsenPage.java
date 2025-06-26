package com.juaracoding.finalproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AbsenPage {
  WebDriver driver;


  @FindBy(xpath = "//div[contains(@class,'camera')")
    WebElement  camera;

  @FindBy(xpath = "//div[contains(text(),'Jam Absen')]/following-sibling::div")
    WebElement  timePicker;

  @FindBy(xpath = "//div[contains(text(),'Tipe Absen')]/following-sibling::div")
    WebElement dropDown;

  @FindBy(xpath = "//textarea[@placeholder='Note'] ")//input[@name='note'] (tergantung tag-nya)
     WebElement noteTextField;

  @FindBy(xpath = "//button[contains(text(),'Absen Masuk')]")
     WebElement buttonAbsen;

  public AbsenPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public int getTotalNames() {
      String value = timePicker.getAttribute("value");
      assert value != null;
      return value.length();
  }
//   Select select = new Select(dropDown); // dropDown bertipe WebElement
//   public int getTipe() {
//      return select.getOptions().size(); // jumlah item di dropdown
//  }
        public void setNote(String value) {

            noteTextField.sendKeys(value);  // Mengisi catatan baru
        }

  public void onClick() {
    buttonAbsen.click();
  }



//  public void login(String email, String password) {
//    setUsername(email);
//    setPassword(password);
//    onClick();
//  }


}
