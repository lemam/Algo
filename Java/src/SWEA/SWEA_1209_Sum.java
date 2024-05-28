package SWEA;

import java.util.Scanner;

/*
 * SW Expert Academy 1209번 - Sum
 * 
 * 다음 100X100의 2차원 배열이 주어질 때, 
 * 각 행의 합, 각 열의 합, 각 대각선의 합 중 최댓값을 구하는 프로그램을 작성하여라.
 */

public class SWEA_1209_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt();
			int N = 100;
			int[][] map = new int[N][N];
			int max = 0;
			
			// 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 행
			for (int i = 0; i < N; i++) {
				int sum = 0;

				for (int j = 0; j < N; j++) {
					sum += map[i][j];
				}

				max = Math.max(max, sum);
			}
			

			// 열
			for (int j = 0; j < N; j++) {
				int sum = 0;

				for (int i = 0; i < N; i++) {
					sum += map[i][j];
				}

				max = Math.max(max, sum);
			}

			// 왼쪽 아래 대각선
			int sum1 = 0;
			for (int i = 0; i < N; i++) {
				sum1 += map[i][i];
			}

			max = Math.max(max, sum1);

			// 왼쪽 아래 대각선
			int sum2 = 0;
			for (int i = 0; i < N; i++) {
				sum2 += map[i][N - 1 - i];
			}

			max = Math.max(max, sum2);
			
			System.out.printf("#%d %d\n",t, max);
		}

		sc.close();
	}
}
