package programmers.bruteforce;

public class Question2_regex {
    public String solution(String new_id) {
        String answer = "";

        // 1. 소문자로 치환
        new_id = new_id.toLowerCase();

        // 2. 알파벳 소문자, 숫자, -_. 제외한 모든 문자 제거
        answer = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3. . 2번 이상 연속 -> . 하나로 치환
        answer = answer.replaceAll("\\.+", ".");

        // 4. . 이 처음이나 마지막에 위치하면 제거
        answer = answer.replaceAll("^[.]|[.]$", "");

        // 5. 빈 문자열이면 "a" 대입
        if (answer.isEmpty()) {
            answer = "a";
        }

        // 6. 길이가 16자 이상이면 15자 제외하고 제거, 제거 후 .이 끝에 위치하면 제거
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        // 7. 길이가 2자 이하면 3자가 될때까지 반복
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}
