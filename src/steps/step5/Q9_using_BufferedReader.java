package steps.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9_using_BufferedReader {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // StringBuilder를 사용하면 reverse를 간단하게 구현 할 수 있음
            int reverse1 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
            int reverse2 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

            System.out.println(reverse1 > reverse2 ? reverse1 : reverse2);

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
