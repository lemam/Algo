package SWEA;/*
 * SWEA 1961번 - 숫자 배열 회전 (D2)
 * 
 * N x N 행렬이 주어질 때,
 * 시계 방향으로 90도, 180도, 270도 회전한 모양을 출력하라.
 * 
 * 다음 N줄에 걸쳐서 90도, 180도, 270도 회전한 모양을 출력한다.
 * 입력과는 달리 출력에서는 회전한 모양 사이에만 공백이 존재함에 유의하라.
 */

import java.util.Scanner;

public class SWEA_1961_숫자_배열_회전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			// 배열 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			System.out.println("#" + tc);

			for (int i = 0; i < N; i++) {
				// 90도
				for (int j = N - 1; j >= 0; j--) {
					System.out.print(arr[j][i]);
				}

				System.out.print(" ");

				// 180도
				for (int j = N - 1; j >= 0; j--) {
					System.out.print(arr[N - 1 - i][j]);
				}

				System.out.print(" ");

				// 270도
				for (int j = 0; j < N; j++) {
					System.out.print(arr[j][N - 1 - i]);
				}

				System.out.println();
			}
		}

		sc.close();
	}
}
