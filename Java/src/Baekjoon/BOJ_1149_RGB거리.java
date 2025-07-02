package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());    // 집의 수
        int[][] cost = new int[N][3];   // 각 집에 색을 칠하는 비용 (0: 빨강, 1: 초록, 2: 파랑)
        int[][] dp = new int[N][3];

        // cost 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp의 첫번째 값을 각 색상비용의 첫번째 값으로 초기화
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        // dp[i][c] = `지금까지의 가능한 모든 경우의 누적수 중 최소값` + `현재 집의 c 색깔을 칠하는 비용`
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        // 3개의 누적수 중 최소값 출력
        System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));

        br.close();
    }
}

