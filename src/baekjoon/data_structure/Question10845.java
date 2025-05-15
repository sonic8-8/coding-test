package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question10845 {
    static int N;
    static Deque<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
            if (str.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
            }
            if (str.equals("size")) {
                sb.append(queue.size()).append("\n");
            }
            if (str.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            }
            if (str.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.getFirst()).append("\n");
            }
            if (str.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : queue.getLast()).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
