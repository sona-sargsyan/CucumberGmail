package com.cucumber.pages;

import com.cucumber.driver.DriverSingletonFactory;

public class PageFactory {

 public static InboxPage getInboxPage(){

     return new  InboxPage(DriverSingletonFactory.getDriver());
 }
}
