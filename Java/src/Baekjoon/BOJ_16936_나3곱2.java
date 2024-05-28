package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16936_나3곱2 {
	private static int N;
	private static long[] arrA, arrB;
	private static boolean flag;
	
	/*
	 * [visited 배열을 쓰지 않은 이유]
	 * 수열에 중복된 수가 나오는 경우는 없다.
	 * x를 기준으로 연산 진행 시 어떤 y의 값이 된다.
	 * 즉, y = (x / 3^n) * 2^m이고,
	 * 이는 2^m / 3^n = 1을 만족하는 m, n 이 존재하는 것이다.
	 * 그러나 2와 3은 서로소이므로 만족하는 경우는 m = n = 0인 경우뿐이다.
	 * 그러므로 중복이 되는 경우는 없다.
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 수열의 크기
		arrA = new long[N]; // 수열 A
		arrB = new long[N]; // 수열 B
		flag = false;

		// 수열 B 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrB[i] = Long.parseLong(st.nextToken());
		}

		// 수열 B를 오름차순으로 정렬
		/*
		 * [정렬을 하는 이유]
		 * 현재 값보다 작은 값만 탐색하거나(나3) 큰 값만 탐색할 수 있기 때문에(곱2)
		 * 시간 복잡도를 효율적으로 사용할 수 있다.
		 */
		Arrays.sort(arrB);

		// 수열 B의 모든 수를 x로 지정하여 모든 경우의 수 탐색
		for (int i = 0; i < N; i++) {
			dfs(0, i);
			
			if (flag)
				break;
		}
		
		// 수열 A 출력
		StringBuilder sb = new StringBuilder();
		for (long num : arrA) {
			sb.append(num + " ");
		}
		
		System.out.println(sb);
		
		br.close();
	}

	// 나3곱2 진행
	private static void dfs(int depth, int idx) {
		// 순서 저장
		arrA[depth] = arrB[idx];

		// 모든 순서를 찾은 경우
		if (depth == N - 1) {
			flag = true;
			return;
		}

		// 나3 진행
		if (arrB[idx] % 3 == 0) {
			long num = arrB[idx] / 3;

			// 현재 값보다 작은 수만 탐색
			for (int i = idx - 1; i >= 0; i--) {
				// 수열 B에 존재하는 경우
				if (num == arrB[i]) {
					dfs(depth + 1, i);
					break;
				}
			}
		}

		long num = arrB[idx] * 2;

		// 현재 값보다 큰 수만 탐색
		for (int i = idx + 1; i < N; i++) {
			// 수열 B에 존재하는 경우
			if (num == arrB[i]) {
				dfs(depth + 1, i);
				break;
			}
		}
	}
}
