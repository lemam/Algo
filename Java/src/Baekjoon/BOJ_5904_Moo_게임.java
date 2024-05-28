package Baekjoon;/*
 * 백준 5904번 - Moo 게임 (골드 5)
 * 
 * 이 게임은 Moo수열을 각 사람이 하나씩 순서대로 외치면 되는 게임이다.
 * 
 * Moo 수열은 길이가 무한대이며, 다음과 같이 생겼다. 
 * m o o m o o o m o o m o o o o m o o m o o o m o o m o o o o o 
 * 
 * Moo 수열은 다음과 같은 방법으로 재귀적으로 만들 수 있다. 
 * 먼저, S(0)을 길이가 3인 수열 "m o o"이라고 하자. 
 * 1보다 크거나 같은 모든 k에 대해서, S(k)는 S(k-1)과 o가 k+2개인 수열 "m o ... o" 와 S(k-1)을 합쳐서 만들 수 있다.
 * 
 * 위와 같은 식으로 만들면, 길이가 무한대인 문자열을 만들 수 있으며, 그 수열을 Moo 수열이라고 한다.
 * N이 주어졌을 때, Moo 수열의 N번째 글자를 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5904_Moo_게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int len = 3; // 수열의 길이
		int k = 0; // 수열의 인덱스

		// N보다 긴 수열 중 최소 길이인 수열 인덱스 구하기
		while (N > len) {
			k++;
			len = len * 2 + 1 + (k + 2); // S(k-1) + 'm' + 'o' * (k+2) + S(k-1)
		}

		char answer = solution(N - 1, k, len);	// N번째 글자

		System.out.println(answer);

		br.close();
	}

	// moo 수열의 N번째 글자 반환
	// N: 찾을 글자의 인덱스, K: 수열의 인덱스, currLen: 수열 S(K)의 길이
	private static char solution(int N, int K, int currLen) {
		// S(0)인 경우
		if (K == 0) {
			if (N == 0)	return 'm';
			else return 'o';
		}
		
		int prevLen = (currLen - (1 + (K + 2))) / 2; // S(K-1)의 길이
		
		// S(K)인 경우
		// 왼쪽 S(k-1)에 N번째 단어가 포함되어 있는 경우
		if (0 <= N && N <= prevLen - 1)
			return solution(N, K - 1, prevLen);
		
		// 가운데 수열에 N번째 단어가 포함되어 있는 경우
		else if (prevLen <= N && N <= prevLen + K + 2) {
			if (N == prevLen) return 'm';
			else return 'o';
		}
		
		// 오른쪽 S(k-1)에 N번째 단어가 포함되어 있는 경우
		else return solution(N - (prevLen + K + 3), K - 1, prevLen);
	}
}
