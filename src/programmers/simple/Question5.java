package programmers.simple;

public class Question5 {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        int answer = 0;

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        for (int i = 0; i < arrayA.length; i++) {
            if (arrayB[i] % gcdA == 0) {
                gcdA = 1;
            }
            if (arrayA[i] % gcdB == 0) {
                gcdB = 1;
            }
        }

        if (gcdA == 1 && gcdB == 1) {
            answer = 0;
        } else {
            answer = Math.max(gcdA, gcdB);
        }

        return answer;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
