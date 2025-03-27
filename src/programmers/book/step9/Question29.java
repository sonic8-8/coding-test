package programmers.book.step9;

import java.util.ArrayList;
import java.util.Arrays;

public class Question29 {
    public int[][] solution(int[][] nodeinfo) {
        //같은 곳을 다른 순서로 방문 = 트리
        //노드 (x,y)
        //같은 레벨이면 y가 동일, 자식 노드의 y는 부모보다 작다
        //x,y 좌표평면이랑 같음

        //전위, 후위 순회 결과를 담아서 return

        //문제1: "좌표로 노드"를 만들고 "근처에 있는 것의 경로를 이어줘야함"
        //-> 좌표로 노드 value를 부여하고
        //-> 근처에 있는 것을 자식 노드로 만들어야한다 (이거 어떻게 해야할 지 모르겠음)
        //-> n,n부터 0,0까지 순서대로 도는데 첫번째 노드의 x좌표를 기준으로 edge를 나누고
        //-> 그 다음 노드들도 마찬가지로 x좌표를 기준으로 오른쪽에 있는지 왼쪽에 있는지로 판별?

        //문제2: "전위, 후위 순회해야한다"
        //-> 트리를 만들어야함

        //nodeinfo[i]에서 i는 node의 value에 해당한다

        //노드를 "정렬"하는게 우선

        Node root = makeBinaryTree(nodeinfo);

        ArrayList<Integer> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList);

        ArrayList<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList);

        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static class Node {
        int x;
        int y;
        int value;
        Node left;
        Node right;

        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    private static Node makeBinaryTree(int[][] nodeinfo) {
        //각 노드에 대한 x, y 좌표를 저장한다
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) {
                return Integer.compare(o1.x, o2.x);
            }
            return Integer.compare(o2.y, o1.y);
        });

        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            Node parent = root;

            while (true) {
                if (nodes[i].x < parent.x) {
                    if (parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        //루트 노드를 반환
        return nodes[0];
    }

    public static void preOrder(Node current, ArrayList<Integer> answer) {
        if (current == null) {
            return;
        }

        answer.add(current.value);
        preOrder(current.left, answer);
        preOrder(current.right, answer);
    }

    public static void postOrder(Node current, ArrayList<Integer> answer) {
        if (current == null) {
            return;
        }

        postOrder(current.left, answer);
        postOrder(current.right, answer);
        answer.add(current.value);
    }
}
