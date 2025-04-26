package programmers.simple;

import java.util.*;

class Question1 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int boonja = numer1 * denom2 + numer2 * denom1;
        int boonmo = denom1 * denom2;

        int gcd = gcd(boonja, boonmo);
        boonja /= gcd;
        boonmo /= gcd;

        return new int[]{boonja, boonmo};
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
