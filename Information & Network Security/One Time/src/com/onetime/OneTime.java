package com.onetime;

import java.util.*;

public class OneTime {
    String plainText = "";
    String key = "";
    String cipherText = "";
    int letter;
    Scanner userInput = new Scanner(System.in);

    public OneTime(){
        int choice;
        System.out.print("Choose an operation: \n1.Encrypt\n2.Decrypt\n");
        choice = userInput.nextInt();

        switch(choice){
            case 1:
                System.out.print("Enter plain text: ");
                plainText = userInput.next();
                System.out.print("Enter key: ");
                key = userInput.next();
                encryption();
                break;
            case 2:
                System.out.print("Enter Ciphered text: ");
                cipherText = userInput.next();
                System.out.print("Enter key: ");
                key = userInput.next();
                decryption();
                break;
            default:
                System.out.println("Error, program will terminate!");
                break;
        }

    }

    public void encryption(){
        for(int i=0; i<plainText.length(); i++){
            int letter1 = plainText.charAt(i)%97;
            int letter2 = key.charAt(i)%97;
            letter = ((letter1 + letter2)%26)+97;
            cipherText = cipherText + (char)letter;
        }
        System.out.println("Cipher Text: " + cipherText);
    }

    public void decryption(){
        for(int i=0; i<cipherText.length(); i++){
            int letter1 = cipherText.charAt(i)%97;
            int letter2 = key.charAt(i)%97;
            letter = ((letter1 - letter2)%26) + 97;
            if(letter < 'a'){
                letter += 26;
            }
            plainText = plainText + (char)letter;
        }
        System.out.println("Plain text: " + plainText);
    }
}
