package com.lifegadget.planck.core.lib;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lifegadget.planck.constants.LinkConstant;
import jakarta.servlet.http.HttpServletRequest;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    public HashMap<String, Object> getObjectOfHttpServletRequest(HttpServletRequest httpServletRequest){
        HashMap<String, Object> jsonMap = new HashMap<>();

        // Add method
        jsonMap.put("method", httpServletRequest.getMethod());

        // Add headers
        HashMap<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, httpServletRequest.getHeader(headerName));
        }
        jsonMap.put("headers", headers);

        // Add parameters
        Map<String, String[]> parameters = httpServletRequest.getParameterMap();
        jsonMap.put("parameters", parameters);

        // Add remote address (IP)
        jsonMap.put("remoteAddr", httpServletRequest.getRemoteAddr());

        // Add additional info if needed
        jsonMap.put("remoteHost", httpServletRequest.getRemoteHost());
        jsonMap.put("remotePort", httpServletRequest.getRemotePort());
        jsonMap.put("localAddr", httpServletRequest.getLocalAddr());
        jsonMap.put("localName", httpServletRequest.getLocalName());
        jsonMap.put("localPort", httpServletRequest.getLocalPort());
        jsonMap.put("scheme", httpServletRequest.getScheme());
        jsonMap.put("protocol", httpServletRequest.getProtocol());
        jsonMap.put("requestURI", httpServletRequest.getRequestURI());
        jsonMap.put("requestURL", httpServletRequest.getRequestURL().toString());
        jsonMap.put("contextPath", httpServletRequest.getContextPath());
        jsonMap.put("servletPath", httpServletRequest.getServletPath());
        jsonMap.put("pathInfo", httpServletRequest.getPathInfo());
        return jsonMap;
    }
    public String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("X-Real-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        // In case of multiple IP addresses, take the first one
        if (ipAddress != null && ipAddress.contains(",")) {
            ipAddress = ipAddress.split(",")[0];
        }
        return ipAddress;
    }

}

