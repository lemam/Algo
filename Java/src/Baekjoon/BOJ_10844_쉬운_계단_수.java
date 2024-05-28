package Baekjoon;/*
 * 백준 10844번 - 쉬운 계단 수 (실버 1)
 * 
 * 45656이란 수를 보자.
 * 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
 * N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844_쉬운_계단_수 {
	private final static long MOD = 1000000000;
	private static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		dp = new long[N + 1][10]; // N 자릿수에 각각의 자릿값(0~9)

		// 첫번째 자릿수는 1로 초기화
		for (int i = 0; i < 10; i++)
			dp[1][i] = 1;

		// 두번째 자릿수부터 N까지 탐색
		for (int i = 2; i <= N; i++) {
			// i번째 자릿수의 자릿값들을 탐색 (0~9)
			for (int j = 0; j < 10; j++) {
				// 자릿값이 0이면 이전 자릿값은 무조건 1만 가능하다.
				if (j == 0)
					dp[i][0] = dp[i - 1][1] % MOD;
				// 자릿값이 9이면 이전 자릿값은 무조건 8만 가능하다.
				else if (j == 9)
					dp[i][9] = dp[i - 1][8] % MOD;
				// 이전 자릿수의 자릿값 +1, -1의 경우의 수의 합
				else
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1] % MOD;
			}
		}
		
		long answer = 0;

		// 마지막 자릿수인 1~9까지의 경우의 수를 모두 더해준다.
		for (int i = 1; i <= 9; i++)
			answer += dp[N][i];

		System.out.println(answer % MOD);

		br.close();
	}
}
