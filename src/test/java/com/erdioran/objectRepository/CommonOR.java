package com.erdioran.objectRepository;

import org.openqa.selenium.By;

public class CommonOR {


    public static final By TOP_ACCOUNT_MENU = By.xpath("//body/div[@class='view home-page']/header[@class='main-header top-menu cover-menu variants']/div[@class='container']/nav[@class='navbar']/div[@class='user']/div[@class='has-sub-menu after-login-action']/a[1]//*[name()='svg']");
    public static final By ACCEPT_COOKIES = By.xpath("//button[normalize-space()='Çerezleri Kabul Et']");
    public static final By FOOTER = By.xpath("//i[@class='tp tp-linkedin']");


    public static final String FOOTER_OUR_CONSULTANTS_STRING = "Danışmanlarımız";
    public static final String FOOTER_BECOME_OUR_CONSULTANT_STRING= "Danışmanımız Olun";
    public static final String FOOTER_TERMS_OF_USE_STRING= "Kullanım Koşulları";
    public static final String FOOTER_MEMBERSHIP_AGREEMENT_STRING= "Üyelik Sözleşmesi";
    public static final String FOOTER_PRIVACY_POLICY_STRING= "Gizlilik Politikası";
    public static final String FOOTER_DISTANCE_SALES_AGREEMENT_STRING= "Mesafeli Satış Sözleşmesi";
    public static final String FOOTER_GDPR_STRING= "Kişisel Verilerin Korunması Politikası";
    public static final String FOOTER_MARKETING_TEXT_STRING= "Pazarlama ve Açık Rıza Aydınlatma Metni";


}
