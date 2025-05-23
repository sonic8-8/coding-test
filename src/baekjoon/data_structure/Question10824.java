package baekjoon.data_structure;

import java.io.*;
import java.util.StringTokenizer;

public class Question10824 {
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        String C = st.nextToken();
        String D = st.nextToken();

        result = Long.parseLong(A + B) + Long.parseLong(C + D);

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
