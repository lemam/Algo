package Baekjoon;

import java.io.*;

public class BOJ_2631_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 아이들의 수
        int[] arr = new int[N];                     // 아이들 순서 배열

        // arr 입력
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];          // LIS(최장 증가 부분 수열) 배열
        int max = Integer.MIN_VALUE;    // LIS 길이

        // dp 실행
        for (int i = 0; i < N; i++) {
            dp[i] = 1;  // 자기 자신 포함

            // 자신의 앞에 숫자들을 탐색
            for (int j = 0; j < i; j++) {
                // 탐색 숫자가 자신보다 작은 값이고 (arr[j] < arr[i])
                // 탐색 숫자의 dp로 자신의 dp의 최댓값을 갱신할 수 있다면 (dp[j] + 1 > dp[i])
                // dp를 더 긴 수열로 갱신한다.
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }

        // 움직여야 할 아이의 수 출력
        System.out.println(N - max);

        br.close();
    }
}