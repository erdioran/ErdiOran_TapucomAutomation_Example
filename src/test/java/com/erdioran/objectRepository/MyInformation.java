package com.erdioran.objectRepository;

import org.openqa.selenium.By;

public class MyInformation {


    public static final By INFORMATION_NAME = By.xpath("//input[@name='firstName']");
    public static final By INFORMATION_SURNAME = By.xpath("//input[@name='lastName']");
    public static final By INFORMATION_AREA_CODE = By.xpath("//form[@action='/api/savePersonalInfo']//select[@name='loginAreaCode']");
    public static final By INFORMATION_PHONE = By.xpath("//input[@name='phoneNumber']");
}

