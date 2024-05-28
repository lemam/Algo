package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16938_캠프_준비 {
	private static int N, L, R, X, answer;
	private static int[] levelArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 문제 개수
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		levelArr = new int[N]; // 문제 난이도 배열
		answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			levelArr[i] = Integer.parseInt(st.nextToken());
		}

		solution(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

		System.out.println(answer);

		br.close();
	}

	private static void solution(int cnt, int idx, int sum, int min, int max) {
		// 조건 확인하기
		// 1. 문제는 두 개 이상
		// 2. L <= 문제 난이도의 합 <= R
		// 3. 가장 어려운 문제와 가장 쉬운 문제의 난이도 차 >= X
		if (cnt >= 2) {
			if (sum >= L && sum <= R && max - min >= X) {
				answer++;
			}
		}

		// 문제 조합 만들기
		for (int i = idx; i < N; i++) {
			solution(cnt + 1, i + 1, sum + levelArr[i], Math.min(min, levelArr[i]), Math.max(max, levelArr[i]));
		}
	}
}
