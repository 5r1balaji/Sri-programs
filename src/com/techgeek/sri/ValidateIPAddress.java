package com.techgeek.sri;

public class ValidateIPAddress{
    public static void main(String[] args) {
        String s = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        int start = 0;
        String validate = "4";
        String ip = "";
        try {
            for (int i = 0;i < s.length() ;i++) {
                if (s.charAt(i) == '.' && validate.equals("4")) {
                    ip = s.substring(start,i+1);
                } else if (s.charAt(i) == ':') {
                    validate = "6";
                }
                if (!validateIP(s,ip,validate)){
                    System.out.println("Neither");
                    return;
                }
                start = i+1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Neither");
        }

    }

    private static boolean validateIP(String s, String ip,String validate) {
        if (validate.equals("4")) {
            return isValidV4(ip);
        }
        return isValidV6(ip);
    }

    private static boolean isValidV6(String ip) {
        try {
            if (ip.length() != 4) {
                return false;
            }
        } catch (NumberFormatException e) {

        }


        return true;
    }

    private static boolean isValidV4(String ip) {
        try {
            int k = Integer.parseInt(ip);
            if (k < 0 || k > 255) {
                return false;
            }
            if (k == 0 && ip.length() > 1) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
