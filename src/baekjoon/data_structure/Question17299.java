package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question17299 {
    static int N;
    static int[] nums;
    static int[] ngf;
    static HashMap<Integer, Integer> freqMap = new HashMap<>();
    static Stack<Integer> indexStack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        ngf = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < N; i++) {
            while (!indexStack.isEmpty() && freqMap.get(nums[indexStack.peek()]) < freqMap.get(nums[i])) {
                ngf[indexStack.pop()] = nums[i];
            }
            indexStack.push(i);
        }

        while (!indexStack.isEmpty()) {
            ngf[indexStack.pop()] = -1;
        }

        for (int num : ngf) {
            sb.append(num).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
