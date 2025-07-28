package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());    // 테스트케이스

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n + 1];    // 스티커의 점수
            int[][] dp = new int[2][n + 1];     // `i`번째 줄의 `j`번째 스티커를 선택했을 때 최댓값

            // arr 입력
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 첫번째 값 dp에 초기화
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            // dp[1][i - 1]와 dp[1][i - 2] 중 가장 큰 값을 가진 스티커를 선택하여 누적합
            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
            }

            // 마지막 누적된 점수들 중 최댓값을 출력
            int max = Math.max(dp[0][n], dp[1][n]);
            sb.append(max).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
