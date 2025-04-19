package programmers.book.step16_greedy;

public class Question82 {
    public int solution(int n, int[] stations, int w) {
        //기지국 변경
        //변경하면 전파 도달 거리가 줄어듦
        //기지국 개수 "최소"
        //그리디 의심
        //아파트 개수: n
        //현재 기지국 설치된 아파트 번호: stations
        //전파 도달 거리: w

        //기준: 범위의 끝부분이 겹쳐야함
        //기지국 범위는 ((w * 2) + 1)
        //범위가 움직인다고 생각해야됨
        //왼쪽끝과 오른쪽끝을 비교 대상으로 생각하기

        int stationCount = 0;
        int coverage = (2 * w) + 1;
        int current = 1;

        for (int station : stations) {
            int left = station - w;
            int right = station + w;

            if (current < left) {
                int gap = left - current;
                stationCount += (gap + coverage - 1) / coverage; // 올림 처리를 위해 나머지 중 가장 큰 값을 더함
            }

            current = right + 1;
        }

        if (current <= n) {
            int gap = n - current + 1;
            stationCount += (gap + coverage - 1) / coverage;
        }

        return stationCount;
    }
}
