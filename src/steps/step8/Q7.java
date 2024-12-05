package steps.step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        final int lastDay = 1;

        int climbPerDay = Integer.parseInt(st.nextToken());
        int slidePerNight = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int actualClimb = climbPerDay - slidePerNight;

        int distanceBeforeLastDay = goal - climbPerDay;
        int dayCountBeforeLastDay = 0;

        if (distanceBeforeLastDay % actualClimb != 0) {
            dayCountBeforeLastDay = distanceBeforeLastDay / actualClimb + 1;
        } else {
            dayCountBeforeLastDay = distanceBeforeLastDay / actualClimb;
        }

        System.out.println(dayCountBeforeLastDay + lastDay);

    }
}