package phase8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5 {
    public static void main(String[] args) {
        // 1
        // 2 - 7 (6개)
        // 8 - 19 (12개)
        // 20 - 37 (18개)
        // 38 - 61 (24개)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int input = Integer.parseInt(br.readLine());
            int room = 1;
            int floor = 1;

            while (true) {
                if (input > room) {
                    room += floor * 6;
                    floor++;
                } else {
                    break;
                }
            }

            System.out.println(floor);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
