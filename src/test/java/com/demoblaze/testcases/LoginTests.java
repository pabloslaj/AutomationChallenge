package com.demoblaze.testcases;

import com.demoblaze.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public final class LoginTests extends BaseTest {

    private HomePage homePage;

    private LoginTests() {
    }

    @BeforeMethod
    public void init() {
        homePage = new HomePage();
    }

    @Test
    public void tc_login_001(Map<String, String> data) {
        // Perform login with specific user and get the Welcome Message:
        String welcomeMessage = homePage
                .performLogin(data)
                .getWelcomeMessage();

        // Compare is the message is as expected:
        Assert.assertEquals(welcomeMessage, data.get("welcomeMessage"), "The Welcome message is not as expected");
    }

    @Test
    public void tc_login_002(Map<String, String> data) {
        // Perform login with specific user and get the Alert Message:
        String alertMessage = homePage
                .performLoginWithNonExistentUser()
                .getAlertMessage();

        // Compare is the message is as expected:
        Assert.assertEquals(alertMessage, data.get("alertMessage"), "The Alert message is not as expected");
    }
}
