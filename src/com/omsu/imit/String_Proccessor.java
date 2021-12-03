package com.omsu.imit;


public class String_Proccessor {

    public static String copy(String s, int n) {
        if (n == 0) {
            s = "";
        }
        if (n < 0) {
            throw new IllegalArgumentException();
        } else {
            String L = s;
            for (int i = 0; i < n - 1; i++) {
                s += L;
            }
        }
        return s;
    }

    public static int getCountSubs(String big, String s2) {
        int result = 0, count = 0;
        char[] s3 = big.toCharArray();
        char[] s4 = s2.toCharArray();
        for (int i = 0; i < s3.length; i++) {
            if (s3[i] == s4[i]) {
                count++;
            }
        }
        return result;
    }

    //#3
    public static String replace(String s) {
        s = s.replace("1", "один");
        s = s.replace("2", "два");
        s = s.replace("3", "три");
        System.out.println(s);
        return  s;
    }

    public static void deleteSymbol(StringBuilder s) {
        StringBuilder strBuf = new StringBuilder(s);
        System.out.println(strBuf.length());
        for (int i = 1; i < s.length() ; i += 1) {
            s.deleteCharAt(i);
        }
//        s = strBuf;
        System.out.println(s);

    }


    //#5
    public static String swapWords(String string){
        char[] s = string.toCharArray();
        String[] stringsArray=new String[s.length];
        for(int i=0;i<s.length;i++){
            stringsArray[i]= String.valueOf(s[i]);
        }


        return s.toString();
    }


}
