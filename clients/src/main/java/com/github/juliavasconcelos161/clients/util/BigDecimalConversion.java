package com.github.juliavasconcelos161.clients.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConversion {
    public BigDecimal convert(String value)
    {
        if(value == null)
        {
            return null;
        }
        value = value.replace(".", "").replace(",",".");
        return new BigDecimal(value);
    }
}
