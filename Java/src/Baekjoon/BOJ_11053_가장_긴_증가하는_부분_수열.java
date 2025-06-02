package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11053_가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());   // 수열의 크기
        int[] A = new int[N];   // 수열
        int[] dp = new int[N];  // i번째 값이 가지는 가장 긴 증가하는 부분 수열의 길이
        int answer = 0;

        // 수열 A 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 모든 값을 탐색
        for (int i = 0; i < N; i++) {
            dp[i] = 1;  // 초기화

            // `i-1` ~ `0`까지 확인하면서 작은 값 찾기
            for (int j = i - 1; j >= 0; j--) {
                // A[i]보다 작은 값이 있으면 그 값의 부분 수열 길이에서 1을 더 늘릴 수 있다.
                // 현재 부분 수열 길이와 비교하여 더 큰 값으로 갱신한다.
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);

        br.close();
    }
}
