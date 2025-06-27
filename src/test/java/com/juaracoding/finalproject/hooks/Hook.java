package com.juaracoding.finalproject.hooks;

import com.juaracoding.finalproject.DriverSingleton;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
  @Before
  public void initialize() {
    DriverSingleton.createOrGetDriver();
  }
//
//  @After
//  public void finalTeardown() {
//    DriverSingleton.quitDriver();
//  }
}
