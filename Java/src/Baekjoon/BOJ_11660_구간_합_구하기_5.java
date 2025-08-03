package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11660_구간_합_구하기_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 표의 크기
        int M = Integer.parseInt(st.nextToken());   // 합을 구해야 하는 횟수
        int[][] dp = new int[N + 1][N + 1];

        // 행별로 누적합 저장하기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        // M번 합 구하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int sum = 0;

            for (int x = x1; x <= x2; x++) {
                // `[x][y2]`까지의 누적합 - `[x][y1 - 1]`까지의 누적합
                sum += dp[x][y2] - dp[x][y1 - 1];
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
