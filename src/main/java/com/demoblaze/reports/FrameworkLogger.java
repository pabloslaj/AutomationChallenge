package com.demoblaze.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.demoblaze.enums.LogType;
import com.demoblaze.utils.ScreenshotUtils;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

public final class FrameworkLogger {

    private FrameworkLogger() {
    }

    private static final Consumer<String> PASS = (message) -> ExtentManager.getTest().pass(message);
    private static final Consumer<String> FAIL = (message) -> ExtentManager.getTest().fail(message);
    private static final Consumer<String> SKIP = (message) -> ExtentManager.getTest().skip(message);
    private static final Consumer<String> INFO = (message) -> ExtentManager.getTest().info(message);
    private static final Consumer<String> CONSOLE = (message) -> System.out.println("LOG: " + message);
    private static final Consumer<String> EXTENT_AND_CONSOLE = PASS.andThen(CONSOLE);
    private static final Consumer<String> TAKE_SCREENSHOT = (message) -> ExtentManager.getTest().info("",
            MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());

    private static final Map<LogType, Consumer<String>> MAP = new EnumMap<>(LogType.class);

    static {
        MAP.put(LogType.PASS, PASS);
        MAP.put(LogType.FAIL, FAIL.andThen(TAKE_SCREENSHOT));
        MAP.put(LogType.SKIP, SKIP.andThen(TAKE_SCREENSHOT));
        MAP.put(LogType.INFO, INFO);
        MAP.put(LogType.CONSOLE, CONSOLE);
        MAP.put(LogType.EXTENT_AND_CONSOLE, EXTENT_AND_CONSOLE);
    }

    //FIXME
    public static void log(LogType status, String message) {
        MAP.getOrDefault(status, EXTENT_AND_CONSOLE).accept(message);
    }

}
