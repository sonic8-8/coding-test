package baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * 아이디어: DFS로 섬을 구분하고 멀티소스 BFS로 섬의 최단 거리를 한 번에 구한다.
 */

/**
 * 백준 2146번
 * 난이도: 골드 3
 * 메모리: 16640 KB
 * 시간: 152 ms
 */
public class Question2146 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] distance;
    static int[][] islandId;
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 2][N + 2];
        distance = new int[N + 2][N + 2];
        visited = new boolean[N + 2][N + 2];
        islandId = new int[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. DFS로 각 섬을 구분하는 고유한 번호를 부여합니다.
        int id = 2;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j, id++);
                }
            }
        }

        // 2. 멀티소스 BFS를 사용해 최단 다리 길이를 찾습니다.
        // 멀티소스 BFS는 시작점을 여러 개로 설정해 동시에 BFS하기 때문에 한 번의 탐색으로 최단 거리를 찾을 수 있습니다.
        // 일반적인 BFS는 시작점을 하나만 설정하기 때문에 반복문을 수행해야합니다.
        multiSourceBfs();

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    private static void dfs(int row, int col, int islandId) {
        visited[row][col] = true;
        map[row][col] = islandId;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];

            // map 배열에서 0은 바다, 1은 육지를 뜻합니다.
            // visited 배열로 중복 방문을 방지합니다.
            // 이 문제에서 DFS의 목적은 두 가지 입니다.
            // 1) 섬(육지, 1)인지 확인하기
            // 2) 연결된 육지라면 섬에 고유 번호를 할당하기
            if (!visited[newRow][newCol] && map[newRow][newCol] == 1) {
                dfs(newRow, newCol, islandId);
            }
        }
    }


    // 멀티소스 BFS는 시작점을 여러 개 설정할 수 있다는 장점이 있습니다.
    // 이 문제는 멀티소스 BFS를 통해 최단 다리 길이를 구하는 것을 목적으로 합니다.
    // 모든 섬의 경계면을 시작점으로 추가합니다.
    private static void multiSourceBfs() {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N + 2; i++) {
            Arrays.fill(distance[i], -1);
            Arrays.fill(islandId[i], 0);
        }

        // 섬 경계를 큐에 넣고 islandId 배열을 초기화 합니다.
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                if (map[row][col] >= 2) {
                    boolean isEdge = false;

                    // 네 방향을 살핍니다.
                    for (int d = 0; d < 4; d++) {
                        int newRow = row + dirRow[d];
                        int newCol = col + dirCol[d];

                        // 주변이 바다(0)일 경우 경계면입니다.
                        if (map[newRow][newCol] == 0) {
                            isEdge = true;
                            break;
                        }
                    }
                    if (isEdge) {
                        queue.add(new int[]{row, col});
                        distance[row][col] = 0;
                        islandId[row][col] = map[row][col];
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + dirRow[i];
                int newCol = col + dirCol[i];

                if (newRow < 1 || newRow > N || newCol < 1 || newCol > N) continue;

                // 같은 섬 출신이면 무시합니다.
                if (islandId[newRow][newCol] == islandId[row][col]) continue;

                // 아직 방문하지 않은 바다일 경우 다리 길이를 1 증가시킵니다.
                if (map[newRow][newCol] == 0 && distance[newRow][newCol] == -1) {
                    distance[newRow][newCol] = distance[row][col] + 1;
                    islandId[newRow][newCol] = islandId[row][col];
                    queue.add(new int[]{newRow, newCol});
                }
                // 두 섬이 만났을 경우 다리 길이가 최소인지 확인합니다.
                else if (islandId[newRow][newCol] != 0 && islandId[newRow][newCol] != islandId[row][col]) {
                    int bridgeLength = distance[row][col] + distance[newRow][newCol];
                    min = Math.min(min, bridgeLength);
                }
            }
        }
    }
}

