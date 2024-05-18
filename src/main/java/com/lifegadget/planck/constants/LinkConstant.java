package com.lifegadget.planck.constants;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@Getter
public class LinkConstant {
    public static BigInteger LINK_CODE_COUNTER =  new BigInteger("100000000000");
    public static String LINK_ELEMENTS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static  BigInteger BASE_FOR_LINK = new BigInteger(String.valueOf(62));
}
