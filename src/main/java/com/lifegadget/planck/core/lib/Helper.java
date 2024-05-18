package com.lifegadget.planck.core.lib;

import com.lifegadget.planck.constants.LinkConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;


@Component
public class Helper {

    LinkConstant linkConstant;

    public String createSortCode(Long linkId) {
        BigInteger linkCounter = linkConstant.LINK_CODE_COUNTER.add(new BigInteger(String.valueOf(linkId)));
        String shorturl = base10ToBase62(linkCounter);
        return shorturl;
    }
    public String base10ToBase62(BigInteger n) {
        StringBuilder sb = new StringBuilder();
        while (n.compareTo(BigInteger.ZERO) != 0) {
            BigInteger currMod = n.mod(linkConstant.BASE_FOR_LINK);
            sb.insert(0, linkConstant.LINK_ELEMENTS.charAt(currMod.intValue()));
            n = n.subtract(currMod).divide(linkConstant.BASE_FOR_LINK);
        }
        while (sb.length() != 7) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
    public Long linkIdFromCode(String shortCode) {
        return base62ToBase10(shortCode);
    }
    public Long base62ToBase10(String s) {
        BigInteger n = BigInteger.ZERO;
        for (int i = 0; i < s.length(); i++) {
            n = n.multiply(linkConstant.BASE_FOR_LINK).add(new BigInteger(String.valueOf(convertCharToInt(s.charAt(i)))));
        }
        return n.subtract(linkConstant.LINK_CODE_COUNTER).longValue();
    }
    public int convertCharToInt(char c) {
        if (c >= '0' && c <= '9')
            return c - '0';
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 36;
        }
        return -1;
    }
}
