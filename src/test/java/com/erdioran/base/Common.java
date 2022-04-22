package com.erdioran.base;

import static com.erdioran.utils.DataManager.getData;
import static com.erdioran.objectRepository.LoginOR.*;
import static com.erdioran.objectRepository.CommonOR.*;
import static com.erdioran.objectRepository.SignUpOR.*;

import com.erdioran.utils.Helper;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class Common extends Page {

    private static final Logger LOGGER = LogManager.getLogger(Common.class);

    public static void login() {
        login(getData("signupLogin.phone"), getData("signupLogin.password"));
    }

    public static void login(String phone, String password) {
        LOGGER.info("Logging into Tapu.com");
        WebDriver driver = DriverManager.getDriver();
        try {
            driver.get(getData("common.url"));
            Helper.sleepInSeconds(5);
        } catch (Exception e) {
            LOGGER.info("Page failed to load. Trying again");
            driver.navigate().refresh();
        }
        Assert.assertEquals(checkIfWebElementExists(LOGIN_BUTTON), true);
        click(LOGIN_BUTTON);
        try {
            checkIfWebElementExists(LOGIN_BUTTON_POPUP);
            Helper.sleepInSeconds(5);
        } catch (Exception e) {
            LOGGER.info("Login page failed to load.");
        }

        enterCredentials(phone, password);
        click(LOGIN_BUTTON_POPUP);


    }

    public static void signIn() {
        signIn(getData("signupLogin.name"), getData("signupLogin.surname"), getData("signupLogin.phone"), getData("signupLogin.password"));
    }

    public static void signIn(String name, String surname, String phone, String password) {
        LOGGER.info("Sign up page");
        WebDriver driver = DriverManager.getDriver();
        try {
            driver.get(getData("common.url"));
            Helper.sleepInSeconds(5);
        } catch (Exception e) {
            LOGGER.info("Page failed to load. Trying again");
            driver.navigate().refresh();
        }
        click(SIGN_UP_BUTTON);
        try {
            checkIfWebElementExists(SIGN_UP_BUTTON_POPUP);
            Helper.sleepInSeconds(5);
        } catch (Exception e) {
            LOGGER.info("Sign up page failed to load.");
        }

        signInCredentials(name, surname, phone, password);
        approveAllSignUpCheckbox();
        click(SIGN_UP_BUTTON_POPUP);


    }

    public static void signInCredentials(String name, String surname, String phone, String password) {
        enterText(SIGN_UP_NAME, name);
        enterText(SIGN_UP_SUR_NAME, surname);
        choosePhoneAreaCountry();
        enterText(SIGN_UP_PHONE_NUMBER, phone);
        enterText(SIGN_UP_PASSWORD, password);
    }

    public static void choosePhoneAreaCountry() {
        Select objSelect = new Select(DriverManager.getDriver().findElement(SIGN_UP_PHONE_NUMBER_AREA_SELECT));
        objSelect.selectByVisibleText(getData("signupLogin.country"));
    }


    public static void approveAllSignUpCheckbox() {
        click(SIGN_UP_MARKETING_CHECKBOX);
        click(SIGN_UP_AGREEMENT_CHECKBOX);
    }

    public static boolean findUserName() {
        boolean displayed = DriverManager.getDriver().findElement(By.xpath("//span[normalize-space()='" + getData("signupLogin.name") + " " + getData("signupLogin.surname") + "']")).isDisplayed();
        return displayed;
    }

    public static boolean checkCssValue(String value, String name) {
        boolean displayed=DriverManager.getDriver().findElement(By.cssSelector("input[placeholder='(___) ___ __ __'][value='"+value+"'][name='"+name+"']")).isDisplayed();
        return displayed;
    }

    public static void openPageInAccountTab(String pagename) {
        hoverToElement(TOP_ACCOUNT_MENU);
        click(By.xpath("//a[@href='/hesabim?tab=account']//span[contains(text(),'" + pagename + "')]"));
    }


    public static ArrayList<String> hTagsCheck(String[] footer_test_pages, String[] footer_h1_tags) {
        ArrayList<String> wrongPages=new ArrayList<>();
        for (int i = 0; i < footer_test_pages.length; i++) {
            click(By.linkText(footer_test_pages[i]));

            try {
                SoftAssert softAssert = new SoftAssert();
                softAssert.assertTrue(DriverManager.getDriver().findElement(getH1(footer_h1_tags[i])).isDisplayed());
            } catch (Exception e) {
                LOGGER.error("H1 tag doesn't match. Page: " + (footer_test_pages[i]));
                wrongPages.add(footer_test_pages[i]);
            }
            scrollIntoView(FOOTER);
        }
        return wrongPages;

    }

    public static void enterCredentials(String phone, String password) {
        choosePhoneAreaCountry();
        enterText(LOGIN_PHONE_NUMBER, phone);
        enterText(LOGIN_PASSWORD, password);
    }

}
