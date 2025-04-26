package baekjoon.bruteforce;

import java.io.*;

// 문자열 N
// row 마다 소문자, 대문자, 숫자, 공백 출력

class Question10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) {
            int lowerCase = 0;
            int upperCase = 0;
            int digit = 0;
            int space = 0;

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (Character.isLowerCase(ch)) {
                    lowerCase++;
                }

                if (Character.isUpperCase(ch)) {
                    upperCase++;
                }

                if (Character.isDigit(ch)) {
                    digit++;
                }

                if (Character.isWhitespace(ch)) {
                    space++;
                }
            }
            System.out.println(lowerCase + " " + upperCase + " " + digit + " " + space);
        }

        br.close();
    }
}
