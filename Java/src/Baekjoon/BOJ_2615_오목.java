package Baekjoon;/*
 * 백준 2615번 - 오목 (실버 1)
 * 
 * 오목은 바둑판에 검은 바둑알과 흰 바둑알을 교대로 놓아서 겨루는 게임이다.
 * 바둑판에는 19개의 가로줄과 19개의 세로줄이 그려져 있는데
 * 가로줄은 위에서부터 아래로 1번, 2번, ... ,19번의 번호가 붙고 세로줄은 왼쪽에서부터 오른쪽으로 1번, 2번, ... 19번의 번호가 붙는다.
 * 
 * 같은 색의 바둑알이 연속적으로 다섯 알을 놓이면 그 색이 이기게 된다.
 * 여기서 연속적이란 가로, 세로 또는 대각선 방향 모두를 뜻한다.
 * 하지만 여섯 알 이상이 연속적으로 놓인 경우에는 이긴 것이 아니다.
 *  
 * 입력으로 바둑판의 어떤 상태가 주어졌을 때, 검은색이 이겼는지, 흰색이 이겼는지 또는 아직 승부가 결정되지 않았는지를 판단하는 프로그램을 작성하시오.
 * 단, 검은색과 흰색이 동시에 이기거나 검은색 또는 흰색이 두 군데 이상에서 동시에 이기는 경우는 입력으로 들어오지 않는다.
 * 
 * 검은 바둑알은 1, 흰 바둑알은 2, 알이 놓이지 않는 자리는 0으로 표시
 * 첫줄에 검은색이 이겼을 경우에는 1을, 흰색이 이겼을 경우에는 2를, 아직 승부가 결정되지 않았을 경우에는 0을 출력한다.
 * 검은색 또는 흰색이 이겼을 경우에는 둘째 줄에 연속된 다섯 개의 바둑알 중에서 가장 왼쪽에 있는 바둑알(연속된 다섯 개의 바둑알이 세로로 놓인 경우, 그 중 가장 위에 있는 것)의 
 * 가로줄 번호와, 세로줄 번호를 순서대로 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// R, B, RB, LB
		int[] dr = { 0, 1, 1, 1 };
		int[] dc = { 1, 0, 1, -1 };

		int N = 19;
		int[][] board = new int[N][N]; // 바둑판

		int winner = 0; // 승리한 바둑돌
		int row = 0; // 가로줄
		int col = 0; // 세로줄

		// 바둑판 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 오목 완성 찾기
		game: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 돌이 없으면 스킵한다.
				if (board[i][j] == 0)
					continue;

				int color = board[i][j];

				// 증가하는 방향 탐색
				for (int k = 0; k < 4; k++) {
					int cnt = 1;
					int dist = 1;

					while (true) {
						// 다음 탐색 위치
						int nr = i + dr[k] * dist;
						int nc = j + dc[k] * dist;

						// 다음 위치가 배열 범위 밖이거나 해당 바둑돌이 아니면 중지한다.
						if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] != color) {
							break;
						}

						dist++;
						cnt++;
					}

					dist = 1;

					// 증가하는 방향의 반대 방향 탐색
					while (true) {
						// 다음 탐색 위치
						int nr = i - (dr[k] * dist);
						int nc = j - (dc[k] * dist);

						// 다음 위치가 배열 범위 밖이거나 해당 바둑돌이 아니면 중지한다.
						if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] != color) {
							break;
						}

						dist++;
						cnt++;
					}

					// 연속된 바둑돌이 5개이면 승리한다. (6개 이상은 승리한 것이 아니다.)
					if (cnt == 5) {
						winner = color;
						row = (k == 3) ? (i + 1 + 4) : i + 1;
						col = (k == 3) ? (j + 1 - 4) : j + 1;
						break game;
					}
				}
			}
		}

		System.out.println(winner);

		if (winner > 0)
			System.out.println(row + " " + col);

		br.close();
	}
}
