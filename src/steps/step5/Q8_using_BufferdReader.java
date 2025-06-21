package steps.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q8_using_BufferdReader {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            System.out.println(st.countTokens());

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
