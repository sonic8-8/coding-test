package programmers.simple;

import java.util.*;

public class Question2 {
    public int solution(int[][] lines) {
        int[] array = new int[201 + 1];

        for (int i = 0; i < lines.length; i++) {
            int start = lines[i][0] + 100;
            int end = lines[i][1] + 100;
            for (int j = start; j < end; j++) {
                array[j]++;
            }
        }

        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 2) {
                answer++;
            }
        }

        return answer;
    }

    public int solution2(int[][] lines) {
        int index = -100;
        int answer = 0;
        while (index <= 100) {
            int count = 0;
            if (lines[0][0] <= index && index <= lines[0][1]) {
                count++;
            }
            if (lines[1][0] <= index && index <= lines[1][1]) {
                count++;
            }
            if (lines[2][0] <= index && index <= lines[2][1]) {
                count++;
            }
            if (count >= 2) {
                answer++;
            }
        }
        return answer;
    }
}
