package com.erdioran.objectRepository;

import org.openqa.selenium.By;

public class LoginOR {


    public static final By LOGIN_BUTTON = By.xpath("//a[@class='item']");
    public static final By LOGIN_PHONE_NUMBER = By.xpath("//div[@class='loginArea']//input[@placeholder='(___) ___ __ __']");
    public static final By LOGIN_PASSWORD = By.xpath("//input[@data-parsley-required-message='Parolanızı giriniz']");
    public static final By LOGIN_BUTTON_POPUP = By.xpath("//button[contains(text(),'GİRİŞ YAP')]");

}

