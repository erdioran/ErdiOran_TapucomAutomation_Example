package com.erdioran.objectRepository;

import org.openqa.selenium.By;

public class SignUpOR {

    public static final By SIGN_UP_BUTTON = By.xpath("//a[normalize-space()='Ücretsiz Üye Ol']");
    public static final By SIGN_UP_BUTTON_POPUP = By.xpath("//button[normalize-space()='Üye Ol']");

    public static final By SIGN_UP_NAME = By.xpath("//input[@id='_isim']");
    public static final By SIGN_UP_SUR_NAME = By.xpath("//div[@class='row margin-top']//div[2]//div[1]//input[1]");
    public static final By SIGN_UP_PHONE_NUMBER = By.xpath("//div[@class='registerArea']//input[@placeholder='(___) ___ __ __']");
    public static final By SIGN_UP_PHONE_NUMBER_AREA = By.xpath("//div[@class='registerArea']//div[@class='area-code float-label']");
    public static final By SIGN_UP_PHONE_NUMBER_AREA_SELECT = By.xpath("//select[@name='registerAreaCode']");
    public static final By SIGN_UP_PASSWORD = By.xpath("//input[@data-parsley-required-message='Parola giriniz.']");
    public static final By SIGN_UP_MARKETING_CHECKBOX = By.xpath("//label[@for='marketingPermit']");
    public static final By SIGN_UP_AGREEMENT_CHECKBOX = By.xpath("//label[@for='agreementApprove']");
    public static final By SIGN_UP_CLOSE_POPUP = By.xpath("//div[@aria-labelledby='Kayıt Ol']//button[@aria-label='Kapat']");

    public static final By VERIFY_NUMBER_CLOSE = By.xpath("//button[@class='close reload']");

}
