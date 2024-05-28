package SWEA;

import java.util.Scanner;

/*
 * SWEA 2817번 - 부분 수열의 합 (D3)
 * 
 * A1, A2, ... , AN의 N개의 자연수가 주어졌을 때, 
 * 최소 1개 이상의 수를 선택하여 그 합이 K가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 */

public class SWEA_2817_부분_수열의_합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 자연수의 개수
			int K = sc.nextInt();
			int[] A = new int[N]; // 수열 배열

			int answer = 0; // 부분 수열의 합이 K가 되는 경우의 수

			// 배열 입력
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}

			// 부분집합 수만큼 돌리기
			for (int i = 0; i < (1 << N); i++) {
				int sum = 0;

				// i라는 부분집합의 원소 확인하기
				for (int j = 0; j < N; j++) {
					// 해당 i값에 j번째 비트가 존재하면 해당 값을 더함
					if ((i & (1 << j)) > 0) {
						sum += A[j];
					}
				}

				// 부분 수열의 합이 K와 같으면 개수를 센다.
				if (sum == K)
					answer++;
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
