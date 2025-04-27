package programmers.simple;

public class Question4 {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            n -= a;
            n += b;
            answer += b;
        }
        return answer;
    }

    public int solution2(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int receive = n / a * b;
            n = (n % a) + receive;
            answer += receive;
        }
        return answer;
    }
}
