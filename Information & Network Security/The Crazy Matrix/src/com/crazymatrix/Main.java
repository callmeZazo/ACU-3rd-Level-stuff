package com.crazymatrix;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    matrixFiller();
    }
    public static void matrixFiller(){
        char matrix[][] = new char[5][5];
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter key: ");
        String key = userInput.next();
        int counter=0, letter=97;
        String newKey = key.replace('i', 'j');
        newKey = removeDuplicate(newKey);
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(counter < newKey.length()){
                    matrix[i][j] = newKey.charAt(counter);
                    counter++;
                }
                else{
                    int k = 0;
                    while(k<newKey.length()){
                        if(letter == 'i'){
                            letter++;
                        }
                        if(newKey.charAt(k) == (char)letter){
                            letter++;
                            k=0;
                        }
                        else{
                            k++;
                        }
                    }
                    matrix[i][j] = (char)letter;
                    letter++;
                }
            }
        }
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static String removeDuplicate(String word) {
        char[] l = word.toCharArray();
        String newWord = "";
        for (int i = 0; i < l.length; i++) {
            if (!newWord.contains("" + l[i])) {
                newWord = newWord + l[i];
            }
        }
        return newWord;
    }
}
