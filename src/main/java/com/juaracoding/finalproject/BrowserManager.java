package com.juaracoding.finalproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BrowserManager {
  public static WebDriver build() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--use-fake-ui-for-media-stream");

    return new ChromeDriver(options);
  }
}
