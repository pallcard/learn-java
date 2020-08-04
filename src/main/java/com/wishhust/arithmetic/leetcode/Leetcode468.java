package com.wishhust.arithmetic.leetcode;

public class Leetcode468 {
    public String validIPAddress(String IP) {
        if(IP.contains(".")) {
            String[] split = IP.split("\\.");
            if (split.length != 4) {
                return "Neither";
            }
            for (int i = 0; i < split.length; i++) {
                if (!isNum(split[i])) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (IP.contains(":")) {
            String[] split = IP.split(":");
            int length = 0;
            if (IP.startsWith(":")) {
                length++;
            }
            if (IP.endsWith(":")) {
                length++;
            }
            if (split.length != 8-length) {
                return "Neither";
            }

            for (int i = 0; i < split.length; i++) {
                if (split[i].length() > 4) {
                    return "Neither";
                }
                if (!isHexadecimal(split[i])) {
                    return "Neither";
                }

            }
            return "IPv6";
        }
        return "Neither";
    }

    // 0-255
    public static boolean isNum(String num) {
        if (num.length()>3 || num.length()<1) {
            return false;
        }

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) < '0' || num.charAt(i) > '9') {
                return false;
            }
        }
        if (num.length() > 1 && num.startsWith("0")) {
           return false;
        }
        if (Integer.parseInt(num) >= 0 && Integer.parseInt(num) <= 255) {
            return true;
        }
        return false;
    }

    public static boolean isHexadecimal(String num) {
        if (num.length() == 0) {
            return false;
        }
        String lowerNum = num.toLowerCase();
        for (int i = 0; i < lowerNum.length(); i++) {
            char c = lowerNum.charAt(i);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = new Leetcode468().validIPAddress("2001:db8:85a3:0::8a2E:0370:7334");
        System.out.println(s);
    }
}
