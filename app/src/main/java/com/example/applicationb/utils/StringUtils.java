package com.example.applicationb.utils;

import java.math.BigInteger;

abstract public class StringUtils {

    public static String hexToUTF8(String src) {
        return new String(new BigInteger(src, 16).toByteArray());
    }
}
