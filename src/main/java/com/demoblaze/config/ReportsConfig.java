package com.demoblaze.config;

import com.demoblaze.config.converters.StringToBooleanConverter;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config/config-report.properties"
})
public interface ReportsConfig extends Config {

    @Key("failedStepScreenshots")
    @ConverterClass(StringToBooleanConverter.class)
    boolean failedStepScreenshots();

    @Key("skippedTestScreenshots")
    @ConverterClass(StringToBooleanConverter.class)
    boolean skippedTestScreenshots();

    @Key("passedStepsScreenshots")
    @ConverterClass(StringToBooleanConverter.class)
    boolean passedStepsScreenshots();

}
