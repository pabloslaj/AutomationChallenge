package com.demoblaze.testcases;

import com.demoblaze.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public final class SignUpTests extends BaseTest {

    private HomePage homePage;

    private SignUpTests() {
    }

    @BeforeMethod
    public void init() {
        homePage = new HomePage();
    }

    @Test
    public void tc_sign_up_001(Map<String, String> data) {
        // Perform register with a valid user and get the alert message:
        String alertMessage = homePage
                .performRegisterWithNonExistentUser()
                .getAlertMessage();

        // Compare is the message is as expected:
        Assert.assertEquals(alertMessage, data.get("alertMessage"), "The Alert message is not as expected");
    }

    @Test
    public void tc_sign_up_002(Map<String, String> data) {
        // Perform register with an existent user and get the alert message:
        String alertMessage = homePage
                .performRegister(data)
                .getAlertMessage();

        // Compare is the message is as expected:
        Assert.assertEquals(alertMessage, data.get("alertMessage"), "The Alert message is not as expected");
    }
}
