//Zeyad Nofal 41610028

package com.productcipher;

import java.util.Scanner;

public class Main {
    // plain text, substitution text, transposition text
    public static String pT , sT , tT ;
    public static String word = "";
    public static int counter_pT = 0, counter_sT = 0, counter_word = 0, counter_letter = 0;
    public static char temp;
    public static int column, row;
    public static char matrix[][];

    public static void main(String[] args) {
        initializer();
        substitution();
        transposition();
        print();
    }

    public static void initializer(){
        Scanner user_pT = new Scanner(System.in);
        Scanner user_sT = new Scanner(System.in);
        Scanner user_tT = new Scanner(System.in);
        System.out.println("Enter plain text: ");
        pT = user_pT.next();
        System.out.println("Enter substitution text: ");
        sT = user_sT.next();
        System.out.println("Enter transposition text: ");
        tT = user_tT.next();
    }

    public static void substitution(){
        //substitution
        while(counter_pT < pT.length()){
            int letter = (((pT.charAt(counter_pT)%97 + sT.charAt(counter_sT% sT.length()))%97)%26)+97;
            word = word + (char)letter;
            counter_pT++;
            counter_sT++;
        }
    }

    public static void transposition(){
        column = tT.length();
        row = (int) Math.ceil((double) word.length() / (double) column);
        matrix = new char[row][column];
        //transposition
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(counter_word < word.length()) {
                    matrix[i][j] = word.charAt(counter_word);
                    counter_word++;
                }
                else{
                    matrix[i][j] = 'x';
                }
            }
        }
    }

    public static void print(){
        //print matrix
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nCiphered Text: ");
        char[] tT_array = tT.toCharArray();
        for(int i=0; i<column-1; i++){
            int letter = i;
            int j;
            for(j = i+1; j<column; j++){
                if(tT_array[j] < tT_array[i]){
                    letter = j;
                }
            }
            temp = tT_array[letter];
            tT_array[letter] = tT_array[i];
            tT_array[i] = temp;
        }

        while(counter_letter < tT.length()){
            for(int k=0; k<tT.length(); k++){
                if(tT_array[k] == tT.charAt(counter_letter)){
                    for(int x=0; x<row; x++){
                        System.out.print(matrix[x][k]);
                    }
                }
            }
            counter_letter++;
        }
    }
}
