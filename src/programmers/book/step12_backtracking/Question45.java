package programmers.book.step12_backtracking;

public class Question45 {

    int maxCount;
    boolean[] visited;
    int[][] dungeons;

    public int solution(int k, int[][] dungeons) {
        //최소 필요 피로도 (기준)
        //소모 피로도 (탐험 후 소모됨)

        //최대한 많이 탐험
        //dangeons[1이상 8이하][2]

        //현재 피로도 k
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        explore(k, 0);
        return maxCount;
    }

    public void explore(int currentPiro, int exploredCount) {
        maxCount = Math.max(maxCount, exploredCount);

        for (int i = 0; i < dungeons.length; i++) {
            int requiredPiro = dungeons[i][0];
            int consumedPiro = dungeons[i][1];

            //유망함수: 방문한적없고 피로도가 부족하면 백트래킹
            if (!visited[i] && currentPiro >= requiredPiro) {
                visited[i] = true;
                explore(currentPiro - consumedPiro, exploredCount + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}
        };

        Question45 question = new Question45();
        int result = question.solution(k, dungeons);
        System.out.println("최대 탐험 가능 던전 수: " + result);
    }
}
