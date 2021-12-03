package com.omsu.imit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String reversed = "";
        String str = " I love Java  ";
        String[] words = str.split(" ");
        String[] string = new String[words.length];

        for(int i=0;i< string.length/2;i++){
            string[i]=words[words.length-1-i];
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}