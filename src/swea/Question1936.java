package swea;

import java.io.*;
import java.util.*;

public class Question1936 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = a - b;

        if (result == -1 || result == 2) {
            System.out.println("B");
        }

        if (result == 1 || result == -2) {
            System.out.println("A");
        }

        br.close();
    }
}