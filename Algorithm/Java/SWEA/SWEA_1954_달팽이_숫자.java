package Solution;

import java.io.File;
import java.util.Scanner;

/*
 * SW Expert Academy 1945번 - 달팽이 숫자
 *  
 * 달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.
 * 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.
 */

public class SWEA_1954_달팽이_숫자 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("input.txt"));
		int T = sc.nextInt();

		// 3 6 9 12
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 달팽이 크기
			int[][] snail = new int[N][N]; // 달팽이 배열
			int d = 0; // 탐색 방향

			int r = 0; // 현재 행
			int c = 0; // 현재 열
			int i = 1; // 반복 횟수

			// 나선형 순회
			while (i <= N * N) {
				snail[r][c] = i;

				// 다음 요소의 행과 열
				int nr = r + dr[d];
				int nc = c + dc[d];

				// 배열 범위 밖이거나 탐색한 곳이라면 방향을 바꾼다.
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || snail[nr][nc] > 0) {
					d = (d + 1) % 4;
				}

				// 다음 방향으로 이동
				r += dr[d];
				c += dc[d];
				i++;
			}

			System.out.println("#" + tc);

			// 달팽이 출력
			for (int[] arr : snail) {
				for (int n : arr) {
					System.out.print(n + " ");
				}
				System.out.println();
			}
		}

		sc.close();
	}
}
