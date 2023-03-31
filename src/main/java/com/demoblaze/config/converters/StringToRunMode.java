package com.demoblaze.config.converters;

import com.demoblaze.enums.RunMode;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToRunMode implements Converter<RunMode> {

    @Override
    public RunMode convert(Method method, String runMode) {
        return RunMode.valueOf(runMode.toUpperCase());
    }
}
