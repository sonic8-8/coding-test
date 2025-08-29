package baekjoon.divide_and_conquer;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * 분할 정복 (재귀호출)
 * <p>
 * 입력 받은 board를 탐색하며
 * 모든 영역이 같은지 확인합니다.
 * 영역이 다르다면 분할합니다.
 * 재귀 함수에 매개변수로 탐색할 영역을 넘겨줍니다.
 */

/**
 * 메모리: 14204 KB
 * 시간: 108 ns
 * 난이도: 실버 1
 */
public class Main_1992_쿼드트리 {
    static int N;
    static int[][] board;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int startRow = 0;
        int endRow = N - 1;
        int startCol = 0;
        int endCol = N - 1;

        compressBoard(startRow, endRow, startCol, endCol);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void compressBoard(int startRow, int endRow, int startCol, int endCol) {
        // 각 영억을 탐색하며 0과 1 구성 확인
        int firstValue = board[startRow][startCol];
        boolean isAllSame = true;

        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                if (firstValue != board[row][col]) {
                    isAllSame = false;
                    break;
                }
            }
        }

        // 만약 범위 내의 숫자가 모두 동일하다면 압축
        if (isAllSame) {
            sb.append(firstValue);
            return;
        }

        // 숫자가 다를 경우 분할
        int midRow = (startRow + endRow) / 2;
        int midCol = (startCol + endCol) / 2;

        sb.append("(");
        compressBoard(startRow, midRow, startCol, midCol);
        compressBoard(startRow, midRow, midCol + 1, endCol);
        compressBoard(midRow + 1, endRow, startCol, midCol);
        compressBoard(midRow + 1, endRow, midCol + 1, endCol);
        sb.append(")");
    }
}