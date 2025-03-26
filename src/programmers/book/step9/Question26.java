package programmers.book.step9;

public class Question26 {
    public int solution(int n, int a, int b) {
        //n: 참가자 수
        //a: 참가자 번호
        //b: 경쟁자 번호

        //문제1: 대진표 자체가 그림을 그려봤을때 트리 모양임
        //-> 트리를 만들어서 사용하면 됨?
        //-> 트리를 만들 필요까진 없었고 그냥 아이디어를 얻는 정도였음

        //문제2: 토너먼트인데 승자만 올라가고 라운드마다 번호가 바뀐다
        //1
        //1 2
        //1 2 3 4
        //12 34 56 78
        //-> 밑에서부터 위로 올라가는 형태인데 그럼 postorder인가?
        //-> 한 번 비교하고 올라가니까?
        //-> 그런것보다 그냥 트리 구조에서 아이디어를 떠올려 해결하는 문제였음

        int answer;
        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        return answer;
    }
}
