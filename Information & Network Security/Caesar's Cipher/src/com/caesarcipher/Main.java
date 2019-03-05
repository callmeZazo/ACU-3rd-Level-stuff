//Made by Z
package com.caesarcipher;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        program();
    }

    static void program(){
        Scanner userInput = new Scanner(System.in);
        int userChoice;
        System.out.println("Welcome to Caesar's Cipher program");
        while(true){
            System.out.println(" 1. Encrypt a text\n 2. Decrypt a text\n 3. Exit");
            userChoice = userInput.nextInt();
            switch(userChoice){
                case 1:
                    //encryption option
                    System.out.println("You have chosen encryption.");
                    encryption();
                    break;
                case 2:
                    //decryption option
                    System.out.println("You have chosen decryption.");
                    decryption();
                    break;
                case 3:
                    //exit program
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Choose another operation or exit the program.\n");
        }
    }

    static void encryption(){
        //Encryption function
        Scanner input = new Scanner(System.in);
        String text;
        String cipheredText = "";
        int key = (12*7)/14;
        int space = 32;
        System.out.println("Enter the text to be ciphered");
        text = input.nextLine();
        String plainText = text.replace(" ", "*");

        for(int i=0; i<plainText.length(); i++){
            int letter = plainText.charAt(i);
            //uppercase condition
            if(Character.isUpperCase(letter)){
                letter = letter + (key % 26);
                //excess condition
                if(letter > 'Z'){
                    letter = letter - 26;
                }
            }
            //lowercase condition
            else if(Character.isLowerCase(letter)){
                letter = letter + (key % 26);
                //excess condition
                if(letter > 'z'){
                    letter = letter - 26;
                }
            }
            //space condition
            else if(letter == '*'){
                letter = space;
            }
            cipheredText = cipheredText + (char) letter;
        }
        System.out.println("The encrypted text is: " + cipheredText);
    }

    static void decryption(){
        //decryption function
        Scanner input = new Scanner(System.in);
        String text;
        String plainText = "";
        int key = (12*7)/14;
        int space = 32;
        System.out.println("Enter the text to be deciphered");
        text = input.nextLine();
        String cipheredText = text.replace(" ", "*");

        for(int i=0; i<cipheredText.length(); i++){
            int letter = cipheredText.charAt(i);
            //uppercase condition
            if(Character.isUpperCase(letter)){
                letter = letter - (key % 26);
                //excess condition
                if(letter < 'A'){
                    letter = letter + 26;
                }
            }
            //lowercase condition
            else if(Character.isLowerCase(letter)){
                letter = letter - (key % 26);
                //excess condition
                if(letter < 'a'){
                    letter = letter + 26;
                }
            }
            //space condition
            else if(letter == '*'){
                letter = space;
            }
            plainText = plainText + (char) letter;
        }
        System.out.println("The plain text is: " + plainText);
    }
}
