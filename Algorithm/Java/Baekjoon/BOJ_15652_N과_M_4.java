/*
 * 백준 15652번 - N과 M (4) (실버 3)
 * 
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 * 
 * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652_N과_M_4 {
	public static int N, M;
	public static int[] result;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];

		sb = new StringBuilder();

		// 1부터 N까지의 자연수 중 M개를 고른 수열 출력
		solution(1, 0);

		System.out.println(sb);

		br.close();
	}

	private static void solution(int idx, int depth) {
		if (depth == M) {
			for (int num : result)
				sb.append(num + " ");
			sb.append("\n");
			
			return;
		}

		for (int i = idx; i <= N; i++) {
			result[depth] = i;
			solution(i, depth + 1);
		}
	}
}
