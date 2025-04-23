package baekjoon.dfs;

// 테스트 케이스마다 섬의 개수를 출력
// W, H 
// 1: 땅, 0: 바다
// W,H -> 0 0: 끝
// diag, 상하좌우

import java.util.*;
import java.io.*;

public class Question4963 {
    final static int MAX = 50 + 10;
    static int W, H;
    static boolean[][] map;
    static boolean[][] visited;
    static int answer;
    static int[] dirRow = new int[]{-1, -1, -1, 0, 0, +1, +1, +1};
    static int[] dirCol = new int[]{-1, 0, +1, -1, +1 , -1, 0, +1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            
            if (W == 0 && H == 0) {
                break;
            }
            
            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];
            answer = 0;
            
            
            for (int row = 1; row <= H; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 1; col <= W; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken()) == 1;
                }
            }
            
            for (int row = 1; row <= H; row++) {
                for (int col = 1; col <= W; col++) {
                    if (!visited[row][col] && map[row][col]) {
                        answer++;
                        dfs(row, col);
                    }
                }
            }
            
            bw.write(String.valueOf(answer));
            bw.newLine(); 
        }
        
        br.close();
        bw.close();
    }
    
    private static void dfs(int row, int col) {
        visited[row][col] = true;
        
        for (int i = 0; i < 8; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];
            
            if (!visited[newRow][newCol] && map[newRow][newCol]) {
                dfs(newRow, newCol);
            }
        }
    }
}