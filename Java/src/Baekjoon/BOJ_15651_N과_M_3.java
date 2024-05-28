package Baekjoon;/*
 * 백준 15651번 - N과 M (3) (실버 3)
 * 
 * 자연수 N과 M이 주어졌을 때, 
 * 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * - 같은 수를 여러 번 골라도 된다.
 * 
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_N과_M_3 {
	public static int N;
	public static int M;
	public static boolean[] visited;
	public static int[] result;
	public static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		result = new int[M];
		sb = new StringBuilder();

		perm(0);
		
		System.out.println(sb);

		br.close();
	}

	public static void perm(int depth) {
		if (depth == M) {
			for (int n : result)
				sb.append(n + " ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			result[depth] = i + 1;
			visited[i] = true;
			perm(depth+1);
			visited[i] = false;
		}
	}
}