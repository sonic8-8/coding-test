package programmers.book.step9;

import java.util.*;

public class Question28 {
    public int solution(int[] info, int[][] edges) {
        //노드 방문마다 해당 노드의 양과 늑대를 추가
        //(양의 숫자 <= 늑대의 숫자) 조건이 되면 모든 양을 잡아먹음
        //양이 잡아먹히지 않기 + 최대한 많은 수의 양을 모아서 루트 노드로 돌아가기

        //문제1: 배열로 트리가 구현됨
        //-> edges[부모][자식] info[동물]

        //문제2: 양이 잡아먹히지 않으면서 최대한 많은 수의 양을 모아야함

        //문제3: 노드를 이동하는 걸 어떻게 구현할 것임?
        //-> 부모 노드 -> 자식 노드, [부모][자식]
        //-> 자식 노드 -> 부모 노드, [부모][자식]
        //-> 포인터 개념을 사용하면 편할듯
        //-> parent, child, value 이렇게 3가지로 구성되니까
        buildTree(info, edges);
        int maxSheep = 0;

        //BFS를 위해선 Queue를 구현해야함
        Queue<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));

        //BFS
        while(!queue.isEmpty()) {
            Info currentState = queue.poll();
            //현재 state로 이동하면서 추가한 양의 숫자와 이전까지 세어놓은 양의 숫자를 비교
            maxSheep = Math.max(maxSheep, currentState.sheep);
            //현재 노드의 "인접한 노드들"을 "앞으로 방문할 노드"에 추가
            currentState.toVisit.addAll(tree[currentState.node]);

            for (int next : currentState.toVisit) {
                HashSet<Integer> set = new HashSet<>(currentState.toVisit);
                set.remove(next);

                //늑대일 경우
                if (info[next] == 1) {
                    if (currentState.sheep != currentState.wolf + 1) {
                        queue.add(new Info(next, currentState.sheep, currentState.wolf + 1, set));
                    }
                } else {
                    queue.add(new Info(next, currentState.sheep + 1, currentState.wolf, set));
                }
            }
        }

        return maxSheep;
    }

    private static class Info {
        int node;
        int sheep;
        int wolf;
        HashSet<Integer> toVisit;

        public Info(int node, int sheep, int wolf, HashSet<Integer> toVisit) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.toVisit = toVisit;
        }
    }

    //ArrayList안에 ArrayList를 담는것임 이렇게 하면 가볍고 빠르다는 장점
    private static ArrayList<Integer>[] tree;

    //트리 구축
    private static void buildTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }
}
