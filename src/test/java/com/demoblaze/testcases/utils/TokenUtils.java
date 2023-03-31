package com.demoblaze.testcases.utils;

import br.com.six2six.fixturefactory.Fixture;
import com.demoblaze.api.DemoBlazeApi;
import com.demoblaze.api.fixtures.entity.UserDetailsData;
import com.demoblaze.driver.DriverManager;
import org.openqa.selenium.Cookie;

import static com.demoblaze.enums.LogType.CONSOLE;
import static com.demoblaze.reports.FrameworkLogger.log;

public final class TokenUtils {

    private TokenUtils() {

    }

    public static void randomRegisterAndSetCookie() {
        String authToken = registerAndGetToken();
        try {
            log(CONSOLE, String.format("Proceed to set the Token %s", authToken));
            Cookie cookie = new Cookie("tokenp_", authToken);
            DriverManager.getDriver().manage().addCookie(cookie);
            DriverManager.getDriver().navigate().refresh();
        } catch (Exception e) {
            log(CONSOLE, "Not possible to set the token");
        }
    }

    private static String registerAndGetToken() {
        UserDetailsData userDetails = Fixture.from(UserDetailsData.class).gimme("valid_random");
        log(CONSOLE, userDetails.toString());
        DemoBlazeApi.createUser(userDetails);
        String body = DemoBlazeApi
                .login(userDetails)
                .getBody()
                .asString();

        String authToken = body
                .substring(body.indexOf(":") + 2)
                .replace("\"", "")
                .replace("\n", "");

        return authToken;
    }
}
