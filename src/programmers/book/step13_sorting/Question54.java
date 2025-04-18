package programmers.book.step13_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question54 {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int target = commands[i][2] - 1;

            int[] processed = Arrays.copyOfRange(array, start, end);
            Arrays.sort(processed);
            result[i] = processed[target];
        }
        return result;
    }

    public int[] solution2(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int target = commands[i][2] - 1;

            ArrayList<Integer> arr = new ArrayList<>();

            for (int j = start; j <= end; j++) {
                arr.add(array[j]);
            }

            Collections.sort(arr);
            result[i] = arr.get(target);
        }
        return result;
    }
}
