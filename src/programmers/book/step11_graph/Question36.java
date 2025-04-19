package programmers.book.step11_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Question36 {

    //노드 간의 관계 뿐만 아니라 가중치까지 갖는 "구조적 값"이니까 클래스로 만들기
    public class Node {
        int destination;
        int weight;

        public Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public int[] solution(int[][] graph, int start, int n) {
        //인접리스트
        ArrayList<Node>[] adjList = new ArrayList[n];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        //그래프를 인접리스트에 초기화
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            adjList[from].add(new Node(to, cost));
        }

        // 구하고자 하는 대상! 비용(가중치의 합)이 가장 적게 드는 경로를 "최단 거리"라고 함
        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        minDistance[start] = 0;

        //우선순위 큐로 최소 비용 계산
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node Edge = pq.poll();
            int currentNode = Edge.destination; // 우선순위 큐에서 뽑히면 이동했다고 생각하면 됨 그래서 현재 노드가 되는것
            int currentCost = Edge.weight; // 이 가중치가 비용 계산을 위한 값이라는 걸 의미하기 위해 cost로 표현

            //특정 노드까지 갈 수 있는 경로는 여러 개 있을 수 있지만 그 중에서 비용(가중치의 합)이 적게 드는 것만 처리하는 것
            if (minDistance[currentNode] < currentCost) {
                continue;
            }


            for (Node neighbor : adjList[currentNode]) {
                //최단 거리인지 확인하려는 대상
                int newDistance = currentNode + neighbor.weight;

                //검증 대상이 지금까지 계산해왔던 최단 거리보다 작을 경우 값 변경
                if (minDistance[neighbor.destination] > newDistance) {
                    minDistance[neighbor.destination] = newDistance;
                    //우선순위 큐에 요소가 없어질때까지 반복하려고 다시 넣음
                    pq.add(new Node(neighbor.destination, newDistance));
                }
            }
        }

        return minDistance;
    }
}
