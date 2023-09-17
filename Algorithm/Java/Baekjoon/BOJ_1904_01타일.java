/*
 * 백준 1904번 - 01타일 (실버 3)
 * 
 * 지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다. 
 * 그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.
 * 
 * 어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다. 
 * 결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.
 * 
 * 그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다. 
 * 
 * 우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다. 
 * 단 타일들은 무한히 많은 것으로 가정하자.
 * 
 * 첫 번째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 * 첫 번째 줄에 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904_01타일 {
	public static long[] memo = new long[1000001]; // 경우의 수를 15746 으로 나눈 값을 저장하는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		memo[1] = 1;
		memo[2] = 2;

		// 개수가 피보나치 수의 수열처럼 증가함
		System.out.println(solution(N));

		br.close();
	}

	// 피보나치 수 알고리즘
	public static long solution(int n) {
		for (int i = 3; i <= n; i++) {
			memo[i] = (memo[i - 2] + memo[i - 1]) % 15746;
		}

		return memo[n];
	}
}
