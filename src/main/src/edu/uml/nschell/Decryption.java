package edu.uml.nschell;


public class Decryption {
    public static String decryptText(String str) throws Exception {
        String decrypt = new StringBuilder(str).reverse().toString();
        return decrypt;
    }
}