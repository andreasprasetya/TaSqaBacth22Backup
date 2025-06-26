package com.juaracoding.finalproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserManager {
  public static WebDriver build() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");

    return new ChromeDriver(options);
  }
}
