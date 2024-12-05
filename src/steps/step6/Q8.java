package steps.step6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        // 전공평점 3.3이상

        Scanner sc = new Scanner(System.in);

        Map<String, Double> gradeMap = new HashMap<String, Double>();
        gradeMap.put("A+", 4.5);
        gradeMap.put("A0", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B0", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C0", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D0", 1.0);
        gradeMap.put("F", 0.0);

        double multipleValue = 0.0;
        double totalGrade = 0.0;

        for (int i = 0; i < 20; i++) {
            String inputString = sc.next();
            double inputGradePoint = sc.nextDouble();
            String inputGrade = sc.next();

            if (!inputGrade.equals("P")) {
                multipleValue += inputGradePoint * gradeMap.get(inputGrade);
                totalGrade += inputGradePoint;
            }
        }

        System.out.println(multipleValue/totalGrade);
    }
}
