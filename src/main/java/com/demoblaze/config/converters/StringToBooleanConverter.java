package com.demoblaze.config.converters;

import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToBooleanConverter implements Converter<Boolean> {

    @Override
    public Boolean convert(Method method, String bool) {
        return Boolean.valueOf(bool);
    }
}
