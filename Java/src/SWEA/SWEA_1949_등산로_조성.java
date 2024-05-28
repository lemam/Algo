package SWEA;

import java.util.Scanner;

/*
 * SWEA 1949번 - 등산로 조성 (모의 SW 역량테스트)
 * 
 * 등산로를 조성하려고 한다.
 * 등산로를 만들기 위한 부지는 N * N 크기를 가지고 있으며, 이곳에 최대한 긴 등산로를 만들 계획이다.
 * 등산로 부지는 아래 [Fig. 1]과 같이 숫자가 표시된 지도로 주어지며, 각 숫자는 지형의 높이를 나타낸다.
 * 
 * 등산로를 만드는 규칙은 다음과 같다.
 * 1. 등산로는 가장 높은 봉우리에서 시작해야 한다.
 * 2. 등산로는 산으로 올라갈 수 있도록 반드시 높은 지형에서 낮은 지형으로 가로 또는 세로 방향으로 연결이 되어야 한다.
 * 즉, 높이가 같은 곳 혹은 낮은 지형이나, 대각선 방향의 연결은 불가능하다.
 * 3. 긴 등산로를 만들기 위해 딱 한 곳을 정해서 최대 K 깊이만큼 지형을 깎는 공사를 할 수 있다.
 * 
 * N * N 크기의 지도가 주어지고, 최대 공사 가능 깊이 K가 주어진다.
 * 이때 만들 수 있는 가장 긴 등산로를 찾아 그 길이를 출력하는 프로그램을 작성하라.
 */

public class SWEA_1949_등산로_조성 {
	// 12 3 6 9
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };

	private static int N, K;
	private static int[][] map;
	private static boolean[][] visited;
	private static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 부지의 한 변의 길이
			K = sc.nextInt(); // 지형을 깎을 수 있는 최대 깊이

			map = new int[N][N]; // 부지 배열
			answer = 0; // 만들 수 있는 가장 긴 등산로의 길이

			int max = 0; // 가장 높은 봉우리의 높이

			// 부지 배열 입력 & 높이 최댓값 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					max = Math.max(max, map[i][j]);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 가장 높은 봉우리에서 등산로 탐색 시작
					if (map[i][j] == max) {
						visited = new boolean[N][N]; // 방문 배열
						solution(i, j, max, 1, false);
					}
				}
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	private static void solution(int r, int c, int v, int cnt, boolean isCutting) {
		// 봉우리의 높이가 0이면 탐색을 중단한다.
		if (v == 0) {
			// 등산로 최대 길이 갱신
			answer = Math.max(answer, cnt);
			return;
		}
		
		visited[r][c] = true;

		// 4방향 탐색
		for (int d = 0; d < 4; d++) {
			// 다음 탐색할 행, 열
			int nr = r + dr[d];
			int nc = c + dc[d];

			// 범위 밖이거나 이미 방문한 곳이면 건너 뛴다.
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
				continue;

			// 다음 봉우리의 높이가 현재 봉우리보다 낮은 지형이면 이동
			if (v > map[nr][nc]) {
				solution(nr, nc, map[nr][nc], cnt + 1, isCutting);
				visited[nr][nc] = false;
			}
			// 다음 봉우리의 높이가 현재 봉우리보다 높은 지형이면
			else {
				// 한 번도 깎은 적이 없고, (현재 봉우리 높이 - 1)의 높이가 되기 위해 깎는 높이가 K 이하이면 이동
				if (!isCutting && map[nr][nc] - (v - 1) <= K) {
					solution(nr, nc, v - 1, cnt + 1, true);
					visited[nr][nc] = false;
				}
			}
		}

		// 등산로 최대 길이 갱신
		answer = Math.max(answer, cnt);
	}
}
