package com.demoblaze.utils;

import com.demoblaze.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public final class DataProviderUtils {

    private DataProviderUtils() {
    }

    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider()
    public static Object[] getData(Method m) {
        String testName = m.getName();

        if (list.isEmpty()) {
            list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDataSheet());
        }

        List<Map<String, String>> smallList = new ArrayList<>(list);

        Predicate<Map<String, String>> isTestNameNotMatching = map -> !map.get("testname").equalsIgnoreCase(testName);
        Predicate<Map<String, String>> isExecuteColumnNo = map -> map.get("execute").equalsIgnoreCase("no");

        smallList.removeIf(isTestNameNotMatching.or(isExecuteColumnNo));
        return smallList.toArray();
    }

}
