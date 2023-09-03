/*
 * 백준 15650번 - N과 M (2) (실버 3)
 * 
 * 자연수 N과 M이 주어졌을 때, 
 * 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 
 * - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * - 고른 수열은 오름차순이어야 한다.
 * 
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과_M_2 {
	public static StringBuilder sb;
	public static int N;
	public static int M;
	public static int[] nums; // 1부터 N까지의 배열
	public static boolean[] visited; // 해당 원소 사용 유무
	public static int[] result;	// 저장 결과

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		visited = new boolean[N];
		result = new int[M];

		// nums 배열 할당
		for (int i = 1; i <= N; i++) {
			nums[i - 1] = i;
		}

		perm(0, 0);

		System.out.println(sb);

		br.close();
	}

	// 1부터 N까지 자연수 중에서 중복 없이 오름차순으로 M개를 고른 수열 생성
	// idx : 시작 인덱스
	// depth : 깊이
	public static void perm(int idx, int depth) {
		// M개의 수를 모두 골랐다면 수열을 출력한다. 
		if (depth == M) {
			for (int n : result)
				sb.append(n + " ");
			sb.append("\n");
			return;
		}
		
		// idx ~ N 중 하나를 순서대로 선택한다.
		for (int i = idx; i < N; i++) {
			// 이전에 선택한 숫자라면 건너뛴다.
			if (visited[i]) continue;
			
			// 선택한 수를 저장한다.
			result[depth] = nums[i];
			// 선택한 수의 방문을 표시한다.
			visited[i] = true;
			// 다음 숫자를 선택한다.
			perm(i + 1, depth + 1);
			// 선택한 수의 방문 표시를 원상복구한다.
			visited[i] = false;
		}
	}
}


