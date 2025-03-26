package programmers.book.step9;

import java.util.ArrayList;
import java.util.Arrays;

public class Question25 {
    public static String[] solution(int[] nodes) {
        //문제1: 전위, 중위, 후위 순회 결과를 반환해야됨
        //ArrayList, 포인터 만들기, 배열 3가지 방법이 있음
        //여기선 배열을 이용해서 만들어보자

        String[] answer = new String[3];
        answer[0] = preorder(nodes, 0).trim();
        answer[1] = inorder(nodes, 0).trim();
        answer[2] = postorder(nodes, 0).trim();

        return answer;
    }

    private static String preorder(int[] nodes, int index) {
        if (index >= nodes.length) {
            return "";
        }

        return nodes[index] + " " +
                preorder(nodes,  2 * index + 1) +
                preorder(nodes, 2 * index + 2);
    }

    private static String inorder(int[] nodes, int index) {
        if (index >= nodes.length) {
            return "";
        }

        return inorder(nodes, 2 * index + 1) +
                nodes[index] + " " +
                inorder(nodes, 2 * index + 2);
    }

    private static String postorder(int[] nodes, int index) {
        if (index >= nodes.length) {
            return "";
        }

        return postorder(nodes, 2 * index + 1) +
                postorder(nodes, 2 * index + 2) +
                nodes[index] + " ";
    }

    public static void main(String[] args) {
        String[] answer = solution(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("기댓값: [1 2 4 5 3 6 7, 4 2 5 1 6 3 7, 4 5 2 6 7 3 1]");
        System.out.println("실제값: " + Arrays.toString(answer));
    }
}
