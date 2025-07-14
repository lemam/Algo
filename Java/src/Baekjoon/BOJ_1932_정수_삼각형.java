package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1932_정수_삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());    // 삼각형의 크기
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        // arr 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];   // dp 초기화

        // 누적합 수행
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j] + arr[i][j];
                } else if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1] + arr[i][j];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                }
            }
        }

        // 출력
        int answer = 0;

        for (int num : dp[N - 1]) {
            answer = Math.max(answer, num);
        }

        System.out.println(answer);

        br.close();
    }
}
