package com.demoblaze.config;

import com.demoblaze.config.converters.StringToBooleanConverter;
import com.demoblaze.config.converters.StringToRunMode;
import com.demoblaze.config.converters.StringToURLConverter;
import com.demoblaze.enums.RunMode;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config/config.properties",
        "file:${user.dir}/src/test/resources/config/prod-config.properties",
})
public interface FrameworkConfig extends Config {

    @Key("environment")
    @DefaultValue("prod")
    String environment();

    @Key("${environment}.url")
    String webUrl();

    @DefaultValue("LOCAL")
    @Key("runMode")
    @ConverterClass(StringToRunMode.class)
    RunMode runMode();

    @Key("seleniumGridUrl")
    @ConverterClass(StringToURLConverter.class)
    URL seleniumGridURL();

    @Key("retryFailedTests")
    @ConverterClass(StringToBooleanConverter.class)
    Boolean retryFailedTests();

    @Key("${environment}.testData")
    String excelName();
}
