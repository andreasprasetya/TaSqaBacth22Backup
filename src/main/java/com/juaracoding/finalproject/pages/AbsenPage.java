package com.juaracoding.finalproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AbsenPage {
  WebDriver driver;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
    WebElement buttonAbsen;

  @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
    WebElement  buttonCamera;

  @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/form/div[1]/div[2]/div")
    WebElement  timePicker;

  @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/form/div[2]")
    WebElement dropDown;

  @FindBy(xpath = "//textarea[@placeholder='Note'] ")//input[@name='note'] (tergantung tag-nya)
     WebElement noteTextField;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/form/button")
    WebElement buttonAbsenMasuk;


  public AbsenPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

    public void  onClickAbsen() {
        buttonAbsen.click();
    }

    public void  onClickCamera() {
        buttonCamera.click();
    }

  public int getTotalTime() {
      String value = timePicker.getAttribute("value");
      assert value != null;
      return value.length();
  }
  // dropDown bertipe WebElement
//   public int getTipe() {
//       Select select = new Select(dropDown);
//       return select.getOptions().size(); // jumlah item di dropdown
//  }
        public void setNote(String value) {
            noteTextField.sendKeys(value);  // Mengisi catatan baru
        }

  public void onclickAbsenMasuk() {
    buttonAbsenMasuk.click();
  }

    public void onClick() {
    }


//  public void login(String email, String password) {
//    setUsername(email);
//    setPassword(password);
//    onClick();
//}


}
