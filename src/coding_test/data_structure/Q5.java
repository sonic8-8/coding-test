package coding_test.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q5 {
    public static void main(String[] args) throws IOException {
        // 백준: 1940번
        //
        // 정렬은 O(nlogn)의 시간 복잡도
        // 15,000 * 대략 100 은 1초도 안됨

        // 유니크한 값 + 제거하는 로직이네?
        // 정렬한 다음
        // 투 포인터로 접근

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        String[] token = br.readLine().split(" ");

        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = Integer.parseInt(token[i]);
        }

        Arrays.sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        int left = 0;
        int right = array.length - 1;
        int sum = 0;
        int count = 0;
        while (left < right) {
            sum = array[left] + array[right];

            if (sum > target) {
                right--;
            }
            if (sum < target) {
                left++;
            }
            if (sum == target) {
                left++;
                right--;
                count++;
            }
        }
        System.out.println(count);

    }
}
