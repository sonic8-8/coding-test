package programmers.book.step7;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Question16 {
    public int[] solution(int[] progresses, int[] speeds) {

        //문제1: 앞뒤가 있고, 앞에 있는 기능이 배포될때 뒤에 있는 기능도 같이 배포된다
        //-> 맨 앞쪽이 100이상이 되면 배포되고
        //-> 그때 맨앞쪽에 연속으로 붙어있는 것 중 100 이상인 기능들을 함께 배포한다
        //-> 100이상인 작업은 삭제한다

        //문제2: 작업 진도와 개발 속도가 각각 존재한다
        //-> 일단 하나씩 작업 진행률을 업데이트 해주고
        //-> 업데이트가 완료되면 그제서야 배포가 될지를 결정하면 됨
        //-> 진행률 업데이트 / 배포, 두 과정을 나누기

        //문제3: 배포마다 몇 개의 기능이 배포되는지를 return 해야됨
        //-> 배포는 하루에 1번만 이루어질 수 있다고 함

        //문제4: 연속으로 확인하는 걸 어떻게 해야되지?
        //첫 번째꺼가 100이상이면 poll() 하고 deploy++ 해주면 됨
        //그 다음꺼가 100이하면? 그럼 종료해야지
        //그 다음꺼가 100이상이면? 다시 poll()하고 deploy++
        //이 로직을 작성해줘야되는데 반복문으로 구현하는게 좀 애매함
        //queue 안에 100이상인 것이 있는데 peek()로 지금 대상이 100이상이 아닐 경우엔 종료하도록 하면 될듯?

        //문제5: 업데이트 로직에서 배포 후 사라진 요소의 speeds가 반영이 안되고 있음
        //-> speeds도 deque로 관리해야할듯

        ArrayDeque<Integer> progressesQueue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            progressesQueue.add(progresses[i]);
        }

        ArrayDeque<Integer> speedsQueue = new ArrayDeque<>();
        for (int i = 0; i < speeds.length; i++) {
            speedsQueue.add(speeds[i]);
        }

        System.out.println(progressesQueue);

        ArrayDeque<Integer> memory = new ArrayDeque<>();

        while (progressesQueue.size() > 0) {

            //업데이트
            for (int i = 0; i < speedsQueue.size(); i++) {
                int target = progressesQueue.poll();
                int speed = speedsQueue.poll();

                target += speed;
                if (target > 100) {
                    target = 100;
                }
                progressesQueue.add(target);
                speedsQueue.add(speed);
            }
            System.out.println("업데이트: " + progressesQueue);

            //배포
            int deploy = 0;
            while (progressesQueue.contains(100) && progressesQueue.peek() == 100) {
                progressesQueue.poll();
                speedsQueue.poll();
                deploy++;
            }

            //기록
            if (deploy > 0) {
                memory.add(deploy);
            }

        }

        int memorySize = memory.size();
        int[] answer = new int[memorySize];
        for (int i = 0; i < memorySize; i++) {
            int element = memory.poll();
            answer[i] = element;
        }

        return answer;

    }

    public static int[] solution2(int[] progresses, int[] speeds) {
        //배포까지 남은 날을 미리 구해놓고 이것들로 처리하는 방식도 있음

        int[] dayLeft = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
             dayLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int deploy = 0;
        int standard = dayLeft[0];

        Queue<Integer> answer = new ArrayDeque<>();

        for (int i = 0; i < dayLeft.length; i++) {
            if (dayLeft[i] <= standard) {
                deploy++;
            } else {
                answer.add(deploy);
                standard = dayLeft[i];
                deploy = 1;
            }
        }
        answer.add(deploy);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Question16 question = new Question16();
        int[] answer = question.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println("[" + answer[0] + ", " + answer[1] + "]");


        int[] answer2 = question.solution2(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println("[" + answer2[0] + ", " + answer2[1] + "]");
    }
}
