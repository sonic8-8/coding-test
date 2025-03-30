package programmers.book.step10;

import java.util.ArrayList;
import java.util.Arrays;

public class Question30 {

    private static int[] parents;

    public static Boolean[] solution(int k, int[][] operation ) {
        //[i][0]: union 연산, 랭크가 높은 집합으로 루트 노드를 설정하는 것
        //[i][1]: find 연산, 루트 노드를 찾는 것인데 각 노드의 루트 노드를 찾는게 목적이니까 최적화 가능, 재귀함수를 통해 구현

        //집합을 그래프로 나타내야함
        //배열로 나타내야하는거지

        parents = new int[k];

        //초기 노드 초기화
        for (int i = 0; i < k; i++) {
            parents[i] = i;
        }

        //루트 노드 값이 크면
        //루트 노드 값이 작은 것의 부모 노드가 됨
        ArrayList<Boolean> answer = new ArrayList<>();

        for (int i = 0; i < k; i ++) {
            if (operation[i][0] == 0) {
                union(operation[i][1], operation[i][2]);
            } else {
                answer.add(find(operation[i][0]) == find(operation[i][1]));
            }
        }

        return answer.toArray(Boolean[]::new);
    }

    private static void union(int x, int y) {
        //큰 루트 노드를 작은 루트 노드의 부모로 만들기
        int root1 = find(x);
        int root2 = find(y);

        if (root1 > root2) {
            parents[root2] = root1;
        } else {
            parents[root1] = root2;
        }
    }

    private static int find(int x) {
        //루트 노드를 찾아서 반환한다
        if (parents[x] == x) {
            return x;
        }
        parents[x] = find(parents[x]);
        return parents[x];
    }

    public static void main(String[] args) {
        Boolean[] answer = solution(3, new int[][]{{0,0,1}, {0,1,2}, {1,1,2}});
        System.out.println(Arrays.toString(answer));

    }
}
