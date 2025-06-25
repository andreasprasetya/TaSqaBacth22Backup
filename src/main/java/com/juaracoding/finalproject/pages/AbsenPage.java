package com.juaracoding.finalproject.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Daftar produk muncul lengkap dengan nama, harga, dan tombol Add to Cart
 */
public class AbsenPage {
  WebDriver driver;

  @FindBy(xpath = "//div[@class='inventory_item_name']")
  List<WebElement> inventoryItemName;

  @FindBy(xpath = "//div[@class='inventory_item_price']")
  List<WebElement> inventoryItemPrice;

  @FindBy(xpath = "//div[@class='btn_primary btn_inventory']")
  List<WebElement> buttonAddToCart;

  public AbsenPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public int getTotalNames() {
    return inventoryItemName.size();
  }

  public int getTotalPrices() {
    return inventoryItemPrice.size();
  }

  public int getTotalButtons() {
    return buttonAddToCart.size();
  }

  public boolean hasAProducts() {
    return Arrays.asList(
        getTotalNames(),
        getTotalPrices(),
        getTotalButtons()).contains(6);
  }

}
