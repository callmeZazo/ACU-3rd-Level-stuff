package com.caesardechiper;

public class Main {

    public static void main(String[] args) {
	    String decipheredText = "pbqvatvfnoyrffbaylsbegurfznegbarf";
	    String plainText;
	    for(int key=1; key<26; key++){
	        plainText = "";
	        for(int counter=0; counter<decipheredText.length(); counter++){
	            int l = decipheredText.charAt(counter);
	            l = l - (key%26);
                if(l < 'a'){
                    l += 26;
                }
                plainText += (char)l;
            }
            System.out.println(plainText);
        }
    }
}
