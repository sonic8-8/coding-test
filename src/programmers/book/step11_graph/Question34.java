package programmers.book.step11_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Question34 {
    public int[] solution(int[][] graph, int start, int n) {
        // 스택 구조 필요
        // start 부터 push 하고
        // graph 의 row를 start로 한 다음 for문을 돌면서 모든 인근 노드를 push
        // pop 하면서 방문 여부 확인 -> 근데 이 방문 여부를 확인할 자료구조를 뭐로 해야할지 고민임
        // ArrayList? Boolean도 넣어야하는데..

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        HashMap<Integer, Boolean> visitedMap = new HashMap<>();
        for (int i = 0; i < n; i++) {

        }

        stack.pop();
        return new int[]{0};
    }

    // 여러 값이 들어오고 서로 관련이 있는 복잡한 구조기 때문에
    ArrayList<Integer>[] adjacencyList;

    private static boolean[] isVisited;

    // 값이 계속 추가될 수 있기 때문에 리스트로 만듦
    ArrayList<Integer> traversalOrder;

    public int[] solution2(int[][] graph, int start, int n) {
        //인접리스트를 만들고 초기화
        adjacencyList = new ArrayList[n + 1];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        //graph를 인접리스트로 초기화
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[from].add(to);
        }

        //DFS를 재귀함수로 구현해서 넘기기
        isVisited = new boolean[n + 1]; // boolean 배열은 초깃값이 false로 초기화 됨을 이용
        traversalOrder = new ArrayList<>();
        dfs(start);

        //traversalOrder를 나중에 int[]로 변환해주기
        return traversalOrder.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int currentNode) {
        isVisited[currentNode] = true;
        traversalOrder.add(currentNode);

        for (int neighbor : adjacencyList[currentNode]) {
            if (!isVisited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Question34 question = new Question34();
        int[][] graph = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        for (int[] edge : graph) {
            System.out.println(edge[0] + " " + edge[1]);
        }
        int[] answer = question.solution2(graph, 1, 5);
        System.out.println(Arrays.toString(answer));
    }
}
