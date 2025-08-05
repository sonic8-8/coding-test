package baekjoon.dfs;

import java.io.*;
import java.util.*;

/**
 * 아이디어:
 * 트리 구조를 만들어야 한다.
 * -> 이중 배열을 이용해서 [루트 노드][왼쪽노드, 오른쪽노드] 형태로 연결하기
 *
 * 트리 순회를 구현해야한다.
 * -> DFS를 구현하기 쉬운 재귀 함수로 구현하기
 *
 * 'A', 0, 1이 반복되면서 가독성이 떨어진다.
 * -> 반복되는 매직 넘버를 상수 추출
 * -> START_NODE, LEFT, RIGHT
 */

/**
 * 메모리: 14080 KB
 * 시간: 124 ms
 * 난이도: 실버 1
 */
public class Main_1991_트리순회 {
    static int N;
    static char[][] tree;
    static StringBuilder sb = new StringBuilder();

    static final char START_NODE = 'A';
    static final int LEFT = 0;
    static final int RIGHT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        tree = new char[N][2]; // 0: left, 1: right

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char rootNode = st.nextToken().charAt(0);
            char leftNode = st.nextToken().charAt(0);
            char rightNode = st.nextToken().charAt(0);

            int rootToInt = rootNode - 'A';

            tree[rootToInt][LEFT] = leftNode;
            tree[rootToInt][RIGHT] = rightNode;
        }

        preorder(START_NODE);
        sb.append("\n");

        inorder(START_NODE);
        sb.append("\n");

        postorder(START_NODE);
        sb.append("\n");

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void preorder(char node) {
        if (node == '.') {
            return;
        }

        int nodeToInt = node - 'A';

        sb.append(node);
        preorder(tree[nodeToInt][LEFT]);
        preorder(tree[nodeToInt][RIGHT]);
    }

    private static void inorder(char node) {
        if (node == '.') {
            return;
        }

        int nodeToInt = node - 'A';

        inorder(tree[nodeToInt][LEFT]);
        sb.append(node);
        inorder(tree[nodeToInt][RIGHT]);
    }

    private static void postorder(char node) {
        if (node == '.') {
            return;
        }

        int nodeToInt = node - 'A';

        postorder(tree[nodeToInt][LEFT]);
        postorder(tree[nodeToInt][RIGHT]);
        sb.append(node);
    }
}

