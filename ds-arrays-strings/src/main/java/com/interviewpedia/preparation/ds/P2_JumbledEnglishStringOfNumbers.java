package com.interviewpedia.preparation.ds;

/*
    https://stackoverflow.com/a/69996814
*/
public class P2_JumbledEnglishStringOfNumbers {

    private static String[] numString = {
            "zero",
                "one",
            "two",
                "three",
            "four",
                "five",
            "six",
                "seven",
            "eight",
                "nine"
    };

    public static void main(String[] args) {
//        String input = "OTNWEHRE";
        String input = "owoftnuoer";
        int[] frequency = new int[10];
        for (char ch : input.toLowerCase().toCharArray()) {
            if (ch == 'z') frequency[0]++;
            if (ch == 'w') frequency[2]++;
            if (ch == 'u') frequency[4]++;
            if (ch == 'x') frequency[6]++;
            if (ch == 'g') frequency[8]++;
            if (ch == 'o') frequency[1]++;
            if (ch == 'h') frequency[3]++;
            if (ch == 'f') frequency[5]++;
            if (ch == 's') frequency[7]++;
            if (ch == 'i') frequency[9]++;
        }

        frequency[1] = frequency[1] - (frequency[0] + frequency[2] + frequency[4]);
        frequency[3] = frequency[3] - frequency[8];
        frequency[5] = frequency[5] - frequency[4];
        frequency[7] = frequency[7] - frequency[6];
        frequency[9] = frequency[9] - (frequency[5] + frequency[6]);

        for (int i = 0; i < frequency.length; i++) {
            for(int j=1; j<=frequency[i]; j++) System.out.print(numString[i] + ", ");
        }
    }
}
