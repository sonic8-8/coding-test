package programmers.book.step16_greedy;

import java.util.*;

public class Question79 {
    public int solution(int[] d, int budget) {
        //"최대한 많은 부서에게" 물품 지원
        //1000원 신청하면 1000원 지원해야함 더 적은 금액 지원 X

        //신청금액배열: d
        //예산: budget

        //그리디 의심
        int supportedDepartments = 0;

        Arrays.sort(d);

        for (int cost : d) {
            if (cost > budget) {
                break;
            }
            budget -= cost;
            supportedDepartments++;
        }
        return supportedDepartments;
    }
}
