package Solution;

import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * SW Expert Academy 2001번 - 파리 퇴치 (D2)
 * 
 * N x N 배열 안의 숫자는 해당 영역에 존재하는 파리의 개수를 의미한다.
 * M x M 크기의 파리채를 한 번 내리쳐 최대한 많은 파리를 죽이고자 한다.
 * 죽은 파리의 개수를 구하라.
 */

public class SWEA_2001_파리_퇴치 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 배열의 크기
			int M = sc.nextInt(); // 파리채 범위
			int max = 0; // 죽은 파리의 개수의 최대값

			int[][] map = new int[N][N]; // 파리 개수 배열

			// 배열 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 0에서 N-M+1까지 시작 요소 순회
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0;

					// 파리채 범위 순회
					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							sum += map[i + k][j + l];
						}
					}

					// 최댓값 갱신
					max = Math.max(sum, max);
				}
			}

			System.out.printf("#%d %d\n", tc, max);
		}

		sc.close();
	}
}
