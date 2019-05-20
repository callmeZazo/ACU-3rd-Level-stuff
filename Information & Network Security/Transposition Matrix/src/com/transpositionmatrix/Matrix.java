package com.transpositionmatrix;

import java.util.Random;
import java.util.Scanner;

public class Matrix {

    public static void transposition() {
        String plainText;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter word:");
        plainText = userInput.nextLine();
        plainText = plainText.replace(" ", "");
        int max = 9, min = 5;
        int counter = 0;
        Random rand = new Random();
        int column = rand.nextInt(max - min + 1) + min;
        int row = (int) Math.ceil((double) plainText.length() / (double) column);
        char matrix[][] = new char[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (counter < plainText.length()) {
                    matrix[i][j] = plainText.charAt(counter);
                    counter++;
                }
            }
        }

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(matrix[j][i] + "\t");
            }
//            System.out.print();
        }
    }
}
