package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Main_13335_트럭 {
    static int N, W, L;
    static int[] trucks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        // N: 트럭 개수
        // W: 단위 길이 (건너는데 필요한 시간)
        // L: 최대 하중

        // 단위 시간에 단위 길이W 만큼만 이동할 수 있다
        // 동시에 올라가 있는 트럭 무게 합은 L 이하여야한다
        // 완전히 지나가려면 W + 1초가 필요함

        trucks = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 W 만큼의 트럭 개수가 다리 위에 올라 갈 수 있음
        for (int i = 0; i < N; i++) {

        }

        bw.write();

        br.close();
        bw.close();
    }
}
