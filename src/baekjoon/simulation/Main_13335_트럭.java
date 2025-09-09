package baekjoon.simulation;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * 다리를 길이 W의 큐(Queue)로 시뮬레이션한다.
 * - 큐의 각 원소는 다리 위 한 칸을 차지하는 트럭의 무게 (없으면 0)을 의미한다.
 * - 큐의 길이는 항상 W로 유지한다.
 *
 * 시뮬레이션 과정:
 * 1. 시간(time)을 1씩 증가시키며 진행한다.
 * 2. 매 초마다 다리 맨 앞 칸을 비워서(poll) 트럭이 이동하도록 한다.
 * 3. 다음 트럭이 다리 위에 올라올 수 있는지 확인한다.
 *    - 현재 무게 합 + 새 트럭 무게 ≤ L 이면 트럭을 추가
 *    - 아니면 0을 추가하여 다리 상태 유지
 * 4. 모든 트럭이 다리 위에 올라갈 때까지 반복한다.
 *
 * 마지막 트럭이 다리에 올라간 뒤에도 다리를 완전히 건너야 하므로,
 * 총 시간 = 시뮬레이션 시간 + 다리 길이(W) 가 된다.
 */

/**
 * 메모리: 14,412 KB
 * 시간: 124 ms
 * 난이도: 실버 1
 */
public class Main_13335_트럭 {
    static int N, W, L;
    static int[] truckWeights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 트럭 개수
        W = Integer.parseInt(st.nextToken()); // 단위 길이 (건너는데 필요한 시간)
        L = Integer.parseInt(st.nextToken()); // 최대 하중

        truckWeights = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            truckWeights[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        int totalWeight = 0;
        int index = 0;

        Queue<Integer> bridge = new ArrayDeque<>();
        // 다리 길이를 W로 유지하기 위해 W만큼 0으로 초기화
        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }

        // 모든 트럭이 다리 위에 올라갈 때까지 시뮬레이션
        while (index < N) {
            time++; // 시간 증가

            if (bridge.size() == W) {
                totalWeight -= bridge.poll(); // 한 칸 이동
            }

            // 다음 트럭을 다리 위에 올릴 수 있으면 올리고 아니면 0을 채우기
            if (index < N && totalWeight + truckWeights[index] <= L) {
                bridge.add(truckWeights[index]);
                totalWeight += truckWeights[index];
                index++;
            } else {
                bridge.add(0);
            }
        }

        // 마지막 트럭이 올라간 이후 다리를 지나갈 시간 W 더하기
        bw.write(String.valueOf(time + W));

        br.close();
        bw.close();
    }
}