package com.abril.editora.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

    public static String encodedHex(String pass) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigestPass[] = algorithm.digest(pass.getBytes("UTF-8"));

            StringBuilder hexStringPass = new StringBuilder();
            for (byte b : messageDigestPass) {
                hexStringPass.append(String.format("%02X", 0xFF & b));
            }
            String passHex = hexStringPass.toString();
            System.out.println(passHex);
            return passHex;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
