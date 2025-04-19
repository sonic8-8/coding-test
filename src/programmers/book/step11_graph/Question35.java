package programmers.book.step11_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Question35 {
    //방문여부
    private static boolean[] isVisited;
    //순서대로 방문한 곳을 기록할 리스트
    private static ArrayList<Integer> traversalOrder;
    //인접 리스트
    ArrayList<Integer>[] adjList;

    public int[] solution(int[][] graph, int start, int n) {
        //인접 리스트 초기화
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        //그래프를 인접 리스트에 초기화
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            adjList[from].add(to);
        }

        //BFS
        isVisited = new boolean[n + 1];
        traversalOrder = new ArrayList<>();
        bfs(start);

        //int 배열로 변환해서 출력
        return traversalOrder.stream().mapToInt(Integer::intValue).toArray();
    }

    private void bfs(int startNode) {
        //BFS는 우선순위큐로 구현
        Queue<Integer> queue = new ArrayDeque<>();

        //큐에 넣으면서 방문 체크
        queue.add(startNode);
        isVisited[startNode] = true;

        //큐가 비어질때까지 반복
        while (!queue.isEmpty()) {
            //큐에서 뽑으면서 방문 순서 결과에 추가
            int currentNode = queue.poll();
            traversalOrder.add(currentNode);

            //큐에 넣으면서 방문 체크
            for (int neighbor : adjList[currentNode]) {
                if (!isVisited[neighbor]) {
                    queue.add(neighbor);
                    isVisited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}};
        int start = 1;
        int n = 9;
        int[] solution = new Question35().solution(graph, start, n);
        System.out.println(Arrays.toString(solution));
    }
}
