package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2169_로봇_조종하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 행
        int M = Integer.parseInt(st.nextToken());   // 열
        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];                 // (i, j) 위치에 도달했을 때 얻을 수 있는 최대 점수

        // map 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 행에 대하여 dp 수행
        // 첫번째 행은 (0,0)에서 시작해야 하므로 오른쪽으로만 이동 가능
        dp[0][0] = map[0][0];

        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }

        // 나머지 행들은 왼쪽, 오른쪽 이동 가능
        for (int i = 1; i < N; i++) {
            int[] left = new int[M];    // 왼쪽 -> 오른쪽 이동
            int[] right = new int[M];   // 오른쪽 -> 왼쪽 이동

            // 왼쪽 -> 오른쪽 이동
            left[0] = dp[i - 1][0] + map[i][0];
            for (int j = 1; j < M; j++) {
                // 왼쪽에서 시작하는 것과 위쪽에서 시작하는 것 중 최대값을 선택한다.
                left[j] = Math.max(left[j - 1], dp[i - 1][j]) + map[i][j];
            }

            // 오른쪽 -> 왼쪽 이동
            right[M - 1] = dp[i - 1][M - 1] + map[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                // 오른쪽에서 시작하는 것과 위쪽에서 시작하는 것 중 최대값을 선택한다.
                right[j] = Math.max(right[j + 1], dp[i - 1][j]) + map[i][j];
            }

            // 두 이동 결과에서 최대값 선택
            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        // 도착 지점의 최대값 출력
        System.out.println(dp[N - 1][M - 1]);

        br.close();
    }
}
