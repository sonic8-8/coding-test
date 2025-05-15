package baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class Question10866 {
    static int N;
    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }
            if (cmd.equals("push_back")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            if (cmd.equals("pop_front")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            }
            if (cmd.equals("pop_back")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            }
            if (cmd.equals("size")) {
                sb.append(deque.size()).append("\n");
            }
            if (cmd.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            }
            if (cmd.equals("front")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            }
            if (cmd.equals("back")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
