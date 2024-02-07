package com.example.mall.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

public final class CookieUtil {


    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        return getCookieValue(request, cookieName, false);
    }

    /**
     *
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName, boolean isDecoder) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    if (isDecoder) {
                        retValue = URLDecoder.decode(cookieList[i].getValue(), "UTF-8");
                    } else {
                        retValue = cookieList[i].getValue();
                    }
                    if(Objects.equals(retValue, "null") ||retValue==null) {
//                        System.out.println("NULLLLLLLLLLLLLLLLLLLLL!");
                        continue;} //
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return retValue;
    }


//    public static String getCookieValue(HttpServletRequest request, String cookieName, String encodeString) {
//        Cookie[] cookieList = request.getCookies();
//        if (cookieList == null || cookieName == null) {
//            return null;
//        }
//        String retValue = null;
//        try {
//            for (int i = 0; i < cookieList.length; i++) {
//                if (cookieList[i].getName().equals(cookieName)) {
//                    retValue = URLDecoder.decode(cookieList[i].getValue(), encodeString);
//                    break;
//                }
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return retValue;
//    }


//    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
//                                 String cookieValue) {
//        if(!(cookieValue.isEmpty() && cookieValue!=null))setCookie(request, response, cookieName, cookieValue, -1);
//    }

    public static void setCookie(HttpServletResponse response, String cookieName,
                                     String cookieValue) {
    
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
    }

 
//    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
//                                 String cookieValue, int cookieMaxage) {
//        setCookie(request, response, cookieName, cookieValue, cookieMaxage, false);
//    }
//
//   
//    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
//                                 String cookieValue, boolean isEncode) {
//        setCookie(request, response, cookieName, cookieValue, -1, isEncode);
//    }

//   
//    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
//                                 String cookieValue, int cookieMaxage, boolean isEncode) {
//        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, isEncode);
//    }
//
//    
//    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
//                                 String cookieValue, int cookieMaxage, String encodeString) {
//        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, encodeString);
//    }
//
//    
//    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response,
//                                    String cookieName) {
//        doSetCookie(request, response, cookieName, "", -1, false);
//    }
//
//    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
//                                          String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
//        try {
//            if (cookieValue == null) {
//                cookieValue = "";
//            } else if (isEncode) {
//                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
//            }
//            Cookie cookie = new Cookie(cookieName, cookieValue);
//            if (cookieMaxage > 0)
//                cookie.setMaxAge(cookieMaxage);
//            if (null != request) {
//                String domainName = getDomainName(request);
//                System.out.println(domainName);
//                if (!"localhost".equals(domainName)) {
//                    cookie.setDomain(domainName);
//                }
//            }
//            cookie.setPath("/");
//            response.addCookie(cookie);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//

}