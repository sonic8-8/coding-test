package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * 재료를 적절히 섞어서 신맛과 쓴맛의 차이를 작게 만들려고 한다.
 * 재료를 적어도 하나 사용해서 요리를 만든다.
 * -> 전체 부분집합을 탐색하되, 공집합은 제외하는 방식으로 구현
 * -> 백트래킹을 이용한 부분집합 탐색
 * -> 각 단계에서 해당 재료를 사용할지 말지 결정하기
 * ->  isSelected를 매개변수로 넘겨서 구현 해당 재료를 사용할지 말지 결정
 */

/**
 * 메모리: 14128 KB
 * 시간: 104 ms
 * 난이도: 실버 2
 */
public class Main_2961_도영이가만든맛있는음식 {
    static int N;
    static int[][] foods;

    static final int SOUR = 0;
    static final int BITTER = 1;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        foods = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            foods[i][SOUR] = Integer.parseInt(st.nextToken());
            foods[i][BITTER] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 1, 0, false);

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    private static void backtrack(int start, int totalSour, int totalBitter, boolean selected) {
        if (start == N) {
            if (selected) {
                int diff = Math.abs(totalSour - totalBitter);
                min = Math.min(min, diff);
            }
            return;
        }

        int nextTotalSour = totalSour * foods[start][SOUR];
        int nextTotalBitter = totalBitter + foods[start][BITTER];

        // 현재 자료를 선택하는 경우
        backtrack(start + 1, nextTotalSour, nextTotalBitter, true);

        // 현재 재료를 선택하지 않는 경우 (아무것도 선택하지 않는 경우를 걸러내기 위함)
        backtrack(start + 1, totalSour, totalBitter, selected);
    }
}