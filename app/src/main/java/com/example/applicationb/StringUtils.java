package com.example.applicationb;

import java.math.BigInteger;

public class StringUtils {

    public static String hexToUTF8(String src) {
        return new String(new BigInteger(src, 16).toByteArray());
    }
}
