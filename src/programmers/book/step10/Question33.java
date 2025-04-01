package programmers.book.step10;

import java.util.Arrays;

public class Question33 {

    private static int[] parent;

    public int solution(int n, int[][] costs) {
        //모든 섬이 서로 통행 가능하도록 최소 비용을 return
        //다리 여러번 건너기 o
        //이어져있기만 하면 됨
        //set도 그래프로 만드니까

        //n: 섬의 개수
        //costs[i][0] costs[i][1]: 연결되는 두 섬의 번호
        //costs[i][2]: 다리 건설 비용

        //순서가 바뀌더라도 같은 연결로 본다

        //문제1: 최적 경로 찾는 문제임
        //-> union, find를 사용하는건가?

        //문제2: 모든 다리가 서로 연결돼야함
        //-> 같은 루트노드를 갖게 만들면 되는거 아님?
        //-> 처음 입력받은 섬을 루트 노드로 해서 트리 만들면 될듯?

        //최소 비용으로 다리를 이어야하니까 비용을 기주능로 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        //parent 초기화
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        //다리 잇기
        int answer = 0;
        int bridge = 0;

        for (int[] edge : costs) {

            if (bridge == n -1) {
                break;
            }

            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);

                bridge++;
                answer += edge[2];
            }
        }

        return answer;

    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
}
