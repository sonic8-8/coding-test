package programmers.bruteforce;

// [프로그래머스 소수찾기]
// 3자 이상 15자 이하
// 알파벳 소문자
// 숫자
// -_.
// .는 처음과 끝에 사용 X
// . 연속으로 사용 X

class Question2 {
    public String solution(String new_id) {
        String answer = "";

        // 1. 소문자 치환
        new_id = new_id.toLowerCase();

        // 2. 알파벳 소문자, 숫자, -_. 제외 제거
        for (int i = 0; i < new_id.length(); i++) {
            char target = new_id.charAt(i);
            if (Character.isAlphabetic(target) ||
                    Character.isDigit(target) ||
                    target == '-' || target == '_' || target == '.') {
                answer += target;
            }
        }

        // 3. ..를 .으로 치환
        while (answer.indexOf("..") != -1) {
            answer = answer.replace("..", ".");
        }

        // 4. .은 처음과 끝에 X
        if (!answer.isEmpty() && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        // 5. 빈 문자열이면 a를 대입
        if (answer.isEmpty()) {
            answer = "a";
        }

        // 6. 16자 이상이면 15자로 자르기, 제거 후 .이 끝에 위치하면 . 제거
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
        }
        if (answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        // 7. 2자 이하면 마지막 문자가 3자가 될 때까지 반복해서 붙이기
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}
