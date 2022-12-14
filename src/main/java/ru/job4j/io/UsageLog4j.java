package ru.job4j.io;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte byteVal = 34;
        short shortVal = 12634;
        int integerVal = 3299567;
        long longVal = 23478462345L;
        float floatVal = 73.322F;
        double doubleVal = 456.75436D;
        char charVal = 'E';
        boolean booleanVal = false;
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        LOG.debug("byte: {}, short: {}, integer: {}, long: {}, float: {}, double: {}, char: {}, boolean: {}",
                byteVal, shortVal, integerVal, longVal, floatVal, doubleVal, charVal, booleanVal);
    }
}