package com.demoblaze.listeners;

import com.demoblaze.utils.DataProviderUtils;
import com.demoblaze.utils.ExcelUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setDataProvider("getData");
        iTestAnnotation.setDataProviderClass(DataProviderUtils.class);
        iTestAnnotation.setRetryAnalyzer(RetryFailedTests.class);

        List<Map<String, String>> excelList = ExcelUtils.getTestDetails("RUNMANAGER");

        for (int j = 0; j < excelList.size(); j++) {
            if (excelList.get(j).get("testname").equalsIgnoreCase(method.getName())) {
                iTestAnnotation.setGroups(excelList.get(j).get("groups").split(","));
            }
        }
    }
}
