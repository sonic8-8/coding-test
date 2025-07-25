package baekjoon.backtracking;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * 나올 수 있는 모든 경우의 수를 살펴야 한다 (브루트 포스)
 * 단순 for문으로 구현하기엔 경우의 수가 너무 많다. (백트래킹으로 전환)
 *
 * 백트래킹을 구현하기 위해 operator 배열을 만든다.
 *
 * operator 배열의 값이 0보다 클 경우만 살피면 된다. (가지치기)
 *
 * 하나의 경우의 수를 살피면 다음 경우를 위해
 * operator 배열의 값을 복원한다. (상태 복원)
 *
 * 상태 복원을 구현하기 쉬운 재귀함수를 이용한다. (재귀함수)
 */

/**
 * 메모리: 14376 KB
 * 시간: 108 ms
 * 난이도: 실버 1
 */
public class Question14888 {
    static int N;

    static int[] numbers;

    // 연산자를 담을 배열입니다. (+, -, *, /)
    static int[] operators;

    static StringBuilder sb = new StringBuilder();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // 연산은 첫 번째 숫자인 1(numbers[0])을 넣은 상태로 시작합니다.
        // 매개변수로는
        // 1)이번 연산에 사용할 숫자의 인덱스와
        // 2)직전 연산의 결과를 넣어줍니다.
        // - 1)에는 이번 연산에 사용할 두 번째 숫자 2(numbers[1])의 인덱스 1을 넣고
        // - 2)에는 직전 연산 결과인 숫자 1(numbers[0])을 넣어줍니다.
        backtrack(1, numbers[0]);

        sb.append(max).append("\n").append(min);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtrack(int current, int result) {
        // 현재 인덱스가 N에 도달하면 마지막 인덱스인 N-1까지 모두 살핀 것이므로,
        // 최소, 최대값을 계산합니다.
        if (current == N) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                // 사용 가능한 연산자가 있다면 사용하고,
                // 사용했다는 것을 표현하기 위해 값을 1만큼 줄입니다.
                // operators 배열의 모든 값이 0이 될 때까지 계산합니다.
                operators[i]--;
                int nextResult = calculateResult(result, numbers[current], i);

                // 재귀 함수를 이용해 경우의 수를 계산합니다.
                backtrack(current + 1, nextResult);

                // 다음 경우의 수를 계산하기 위해 상태를 회복합니다.
                operators[i]++;
            }
        }
    }

    // 1) 직전 연산 결과와
    // 2) 이번에 연산할 대상 숫자
    // 3) 어떤 연산을 할 것인지 인덱스
    // 를 받아 계산합니다.
    private static int calculateResult(int previousResult, int target, int operatorIndex) {
        if (operatorIndex == 0) {
            return previousResult + target;
        }
        if (operatorIndex == 1) {
            return previousResult - target;
        }
        if (operatorIndex == 2) {
            return previousResult * target;
        }
        if (operatorIndex == 3) {
            // 문제 요구사항을 지키기 위해 음수일 경우를 보정합니다.
            if (previousResult < 0) {
                // 직전 연산 결과를 양수로 바꾼 후 나누기로 몫을 구합니다.
                // 그 후 다시 음수로 바꿉니다.
                return -(-previousResult / target);
            }
            return previousResult / target;
        }
        return 0;
    }
}
