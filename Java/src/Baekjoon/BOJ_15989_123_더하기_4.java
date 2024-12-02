package Baekjoon;

import java.io.*;

public class BOJ_15989_123_더하기_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스의 수
        int[][] dp = new int[10001][4]; // [만들려는 숫자][수식의 마지막 숫자]

        // 1 ~ 3까지 만들 수 있는 수식의 경우의 수를 저장한다.
        dp[1][1] = 1;   // 1
        dp[2][1] = 1;   // 1 + 1
        dp[2][2] = 1;   // 2
        dp[3][1] = 1;   // 1 + 1 + 1
        dp[3][2] = 1;   // 1 + 2
        dp[3][3] = 1;   // 3

        // 4 ~ 10000까지의 수식의 경우의 수를 계산한다.
        // dp[i][1] = dp[i-1][1];
        // dp[i][2] = dp[i-2][1] + dp[i-2][2];
        // dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3]; (n >= 4)
        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        StringBuilder sb = new StringBuilder();

        // 테스트 케이스(n)를 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}

