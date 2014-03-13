package edu.uml.nschell;


public class Encryption {

    public static String encryptText(String st) throws Exception {

        String encrypt = new StringBuilder(st).reverse().toString();

        return encrypt;
    }
}