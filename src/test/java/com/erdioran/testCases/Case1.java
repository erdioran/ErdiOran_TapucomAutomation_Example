package com.erdioran.testCases;

import com.aventstack.extentreports.ExtentTest;
import com.erdioran.base.BaseTest;
import com.erdioran.base.DriverManager;
import com.erdioran.utils.ExtentTestManager;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import static com.erdioran.base.Common.*;
import static com.erdioran.objectRepository.CommonOR.*;
import static com.erdioran.objectRepository.SignUpOR.*;
import static com.erdioran.objectRepository.MyInformation.*;
import static com.erdioran.utils.DataManager.getData;

public class Case1 extends BaseTest {

    public static final Logger LOGGER = LogManager.getLogger(Case1.class);

    @BeforeMethod()
    public void beforeSignUpTest(ITestContext context) {
        ExtentTest test = ExtentTestManager.getNode();
        test.assignCategory("Sign Up Tests");

    }


    @Test(description = "Sign Up Success", priority = 1)
    public void signUpSuccess() {
        ExtentTest test = ExtentTestManager.getNode();
        test.info("Sign Up Success");
        ExtentTestManager.info("Sign Up Success");

        signIn();
        click(VERIFY_NUMBER_CLOSE);
        Assert.assertTrue(findUserName());

        openPageInAccountTab(getData("category.information"));

        Assert.assertEquals(getAttributeValue(INFORMATION_NAME), getData("signupLogin.name"));
        Assert.assertEquals(getAttributeValue(INFORMATION_SURNAME), getData("signupLogin.surname"));
        Assert.assertEquals(getAttributeValue(INFORMATION_AREA_CODE), getData("signupLogin.countryCode"));
        Assert.assertTrue(checkCssValue(getData("signupLogin.phone"), "phoneNumber"));
    }

    @Test(description = "Check Tags in Page", priority = 2)
    public void checkTag() throws InterruptedException {
        ExtentTest test = ExtentTestManager.getNode();
        test.info("Check Tags in Page");
        ExtentTestManager.info("Check Tags in Page");

        login();
        click(ACCEPT_COOKIES);
        Thread.sleep(3000);

        String[] footer_test_pages = {FOOTER_OUR_CONSULTANTS_STRING, FOOTER_BECOME_OUR_CONSULTANT_STRING, FOOTER_TERMS_OF_USE_STRING, FOOTER_MEMBERSHIP_AGREEMENT_STRING, FOOTER_PRIVACY_POLICY_STRING, FOOTER_DISTANCE_SALES_AGREEMENT_STRING, FOOTER_GDPR_STRING, FOOTER_MARKETING_TEXT_STRING};
        String[] footer_h1_tags = {getData("h1Tags.footer_OUR_CONSULTANTS"), getData("h1Tags.footer_BECOME_OUR_CONSULTANT"), getData("h1Tags.footer_TERMS_OF_USE"), getData("h1Tags.footer_MEMBERSHIP_AGREEMENT"), getData("h1Tags.footer_PRIVACY_POLICY"), getData("h1Tags.footer_DISTANCE_SALES_AGREEMENT"), getData("h1Tags.footer_GDPR"), getData("h1Tags.footer_MARKETING_TEXT")};

        scrollIntoView(FOOTER);
        ArrayList wrongTags = hTagsCheck(footer_test_pages, footer_h1_tags);

        ExtentTestManager.info("Pages whose values don't match: " +String.valueOf(wrongTags));
        Assert.assertEquals(wrongTags.size(), 0);




    }


}
