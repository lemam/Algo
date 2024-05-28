package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16922_로마_숫자_만들기 {
	private static int[] romanNum = { 1, 5, 10, 50 }; // 로마 숫자 배열
	private static boolean[] visited;
	private static int N, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 사용할 수 있는 문자의 개수
		visited = new boolean[50 * N + 1]; // 만들 수 있는 최댓값은 50 * B
		answer = 0; // 로마 숫자 N개를 사용해서 만들 수 있는 서로 다른 수의 개수

		dfs(0, 0, 0);

		System.out.println(answer);

		br.close();
	}

	private static void dfs(int depth, int sum, int start) {
		// 로마 숫자 N개를 선택한 경우
		if (depth == N) {
			// 수의 합이 이전에 나온 적 없는 수라면 개수를 센다.
			if (!visited[sum]) {
				answer++;
				visited[sum] = true;
			}
			return;
		}

		// 수 선택의 중복을 피하기 위해 start부터 탐색을 시작한다.
		for (int i = start; i < 4; i++) {
			dfs(depth + 1, sum + romanNum[i], i);
		}
	}
}
