package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 용액의 수
        int[] arr = new int[N]; // 용액의 특성값 배열

        // arr 배열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = N - 1;    // 최소, 최대 인덱스
        int water1 = 0, water2 = 0;     // 선택한 두 용액의 특성값
        int answer = Integer.MAX_VALUE; // 두 용액의 특성값의 합의 절댓값

        // 투 포인터
        while (left < right) {
            int sum = arr[left] + arr[right];   // 두 용액의 특성값의 합

            // 0에 가까운 값이면 갱신한다.
            if (answer > Math.abs(sum)) {
                answer = Math.abs(sum);
                water1 = arr[left];
                water2 = arr[right];
            }

            if (sum > 0) {          // 합이 양수이면 최대 용액 감소
                right--;
            } else if (sum < 0) {   // 합이 음수이면 최소 용액 감소
                left++;
            } else {                // 합이 0인 경우, 탐색 종료
                break;
            }
        }

        System.out.println(water1 + " " + water2);

        br.close();
    }
}
