package com.demoblaze.driver.factory;

import com.demoblaze.driver.IWebDriver;
import com.demoblaze.driver.LocalWebDriverImpl;
import com.demoblaze.enums.RunMode;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {

    private static final Map<RunMode, Supplier<IWebDriver>> WEB = new EnumMap<>(RunMode.class);

    static {
        WEB.put(RunMode.LOCAL, LocalWebDriverImpl::new);
    }

    private DriverFactory() {
    }

    public static IWebDriver getDriver(RunMode runModeType) {
        return WEB.get(runModeType).get();
    }


}
