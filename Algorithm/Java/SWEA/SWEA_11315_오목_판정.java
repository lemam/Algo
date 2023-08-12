package Solution;

import java.util.Scanner;

/*
 * SW Expert Academy 11315번 - 오목 판정
 * 
 * N X N 크기의 판이 있다.
 * 판의 각 칸에는 돌이 있거나 없을 수 있다.
 * 돌이 가로, 세로, 대각선 중 하나의 방향으로 다섯 개 이상 연속한 부분이 있는지 없는지 판정하는 프로그램을 작성하라.
 * 
 * 각 문자는 ‘o’또는 ‘.’으로, ‘o’는 돌이 있는 칸을 의미하고, ‘.’는 돌이 없는 칸을 의미한다.
 * 돌이 다섯 개 이상 연속한 부분이 있으면 “YES”를, 아니면 “NO”를 출력한다.
 */

public class SWEA_11315_오목_판정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 판의 크기
			String[][] table = new String[N][N]; // 판 배열
			String answer = "NO";
			
			// R, B, LB, RB
			int[] dr = { 0, 1, 1, 1};
			int[] dc = {1, 0, -1, 1};
			
			// 입력
			for (int i = 0; i < N; i++) {
				String[] str = sc.next().split("");

				for (int j = 0; j < N; j++) {
					table[i][j] = str[j];
				}
			}

			game: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 돌을 발견하면 돌을 센다.
					if (table[i][j].equals("o")) {
						// 오른쪽, 왼쪽, 왼쪽아래 대각선, 오른쪽아래 대각선 방향 순서대로 탐색
						for (int d = 0; d < 4; d++) {
							int cnt = 1; // 돌의 개수 (자신 포함)

							// 해당 방향으로 다음 4칸을 확인한다.
							for (int k = 1; k <= 4; k++) {
								int nr = i + dr[d] * k;
								int nc = j + dc[d] * k;

								// 배열의 범위를 넘으면 중지한다.
								if (nr < 0 || nr >= N)	break;
								if (nc < 0 || nc >= N)	break;

								// 만약 다음 칸에 돌이 있으면 개수를 센다.
								if (table[nr][nc].equals("o"))
									cnt++;
							}

							// 돌이 5개이면 게임을 끝낸다.
							if (cnt == 5) {
								answer = "YES";
								break game;
							}
						}
					}
				}
			}

			System.out.printf("#%d %s\n", tc, answer);
		}

		sc.close();
	}
}
