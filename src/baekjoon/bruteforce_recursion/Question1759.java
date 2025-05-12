package baekjoon.bruteforce_recursion;

import java.util.*;
import java.io.*;

public class Question1759 {
    static int L, C;
    static char[] array;
    static char[] password;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        array = new char[C];
        password = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            array[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(array);
        backtrack(0, 0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtrack(int depth, int start) {
        if (depth == L) {
            if (isValid(password)) {
                sb.append(password).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password[depth] = array[i];
            backtrack(depth + 1, i + 1);
        }
    }

    private static boolean isValid(char[] password) {
        int vowels = 0;
        int consonants = 0;

        for (char ch : password) {
            if (isVowel(ch)) {
                vowels++;
            } else {
                consonants++;
            }
        }

        return vowels >= 1 && consonants >= 2;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
