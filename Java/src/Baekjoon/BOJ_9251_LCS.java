package Baekjoon;

import java.io.*;

public class BOJ_9251_LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int[][] dp = new int[str1.length + 1][str2.length + 1];

        // 모든 문자 탐색
        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                // `i-1`과 `j-1`번째 문자가 서로 같다면
                if (str1[i - 1] == str2[j - 1]) {
                    // 왼쪽 대각선 위 `i-1, j-1`의 dp에 +1 한 값으로 갱신한다.
                    // (비교하는 글자가 있기 바로 전 LCS + 1)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신한다.
                // (기존에 주어진 무낮열로 만들 수 있었던 LCS 중 최대값)
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[str1.length][str2.length]);

        br.close();
    }
}
