package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_3687_성냥개비 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());   // 테스트케이스 수
        int[] arr = {1, 7, 4, 2, 0, 8}; // 성냥 2 ~ 7개로 만들 수 있는 숫자들
        long[] dp = new long[101];  // dp[i]: i개의 성냥으로 만들 수 있는 최소 숫자 (2 ≤ n ≤ 100)

        // 최소 수 계산을 위한 DP 초기화
        initDp(dp, arr);

        StringBuilder sb = new StringBuilder();

        // 테스트케이스 수행
        for (int i = 0; i < TC; i++) {
            int n = Integer.parseInt(br.readLine());    // 성냥개비 개수

            sb.append(dp[n]).append(" ");   // 최소 수 출력

            // 최대 수 출력 (자리수 늘리기)
            // n이 짝수이면 1을 `n/2`개 붙이기
            // 홀수이면 "7"(3) + 1을 `(n-3)/2`개 붙이기
            if (n % 2 == 0) sb.append(convertMax(n / 2));
            else sb.append("7").append(convertMax((n - 3) / 2));

            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static String convertMax(int n) {
        return "1".repeat(Math.max(0, n));
    }

    private static void initDp(long[] dp, int[] arr) {
        Arrays.fill(dp, Long.MAX_VALUE);    // 가장 큰 값으로 초기화

        // 성냥개비 수에 따른 초기값 세팅
        // 성냥 2 ~ 8개로 만들 수 있는 가장 작은 숫자를 미리 세팅
        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10; // "1"(2) + "0"(6)

        // dp 채우기
        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                // `i - j`개의 최소수 뒤에 `j`개로 만들 수 있는 숫자 붙이기
                // 그 중 최소값을 dp에 저장
                String temp = String.valueOf(dp[i - j]) + String.valueOf(arr[j - 2]);
                dp[i] = Math.min(Long.parseLong(temp), dp[i]);
            }
        }
    }
}
