package com.des;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    static Cipher cipher;

    public static String encrypt(String plainText, SecretKey key) throws Exception{
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encode = Base64.getEncoder();
        String encryptedText = encode.encodeToString(encryptedByte);
        return encryptedText;
    }

    public static String decrypt(String encryptedText, SecretKey key) throws Exception{
        Base64.Decoder decode = Base64.getDecoder();
        byte[] encryptedTextByte = decode.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }

    public static void main(String[] args) throws Exception{
        // write your code here
        KeyGenerator keygen = KeyGenerator.getInstance("DES");
        SecretKey key = keygen.generateKey();
        cipher = Cipher.getInstance("DES");
        Scanner input = new Scanner(System.in);

        String plainText = input.nextLine();
        String cipheredText = encrypt(plainText, key);
        String decipheredText = decrypt(cipheredText, key);
        System.out.println("Plain text: " + plainText);
        System.out.println("Encrypted text: " + cipheredText);
        System.out.println("Deciphered text: " + decipheredText);
    }
}

