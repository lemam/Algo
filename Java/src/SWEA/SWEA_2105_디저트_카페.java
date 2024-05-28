package SWEA;

import java.util.Scanner;

/*
 * SWEA 2105번 - 디저트 카페 (모의 SW 역량테스트)
 * 
 * 친구들과 디저트 카페 투어를 할 계획이다.
 * [Fig. 1]과 같이 한 변의 길이가 N인 정사각형 모양을 가진 지역에 디저트 카페가 모여 있다.
 * 
 * 원 안의 숫자는 해당 디저트 카페에서 팔고 있는 디저트의 종류를 의미하고
 * 카페들 사이에는 대각선 방향으로 움직일 수 있는 길들이 있다.
 * 디저트 카페 투어는 어느 한 카페에서 출발하여
 * [Fig. 2]와 같이 대각선 방향으로 움직이고 사각형 모양을 그리며 출발한 카페로 돌아와야 한다.
 * 
 * 디저트 카페 투어를 하는 도중 해당 지역을 벗어나면 안 된다.
 * 또한, 친구들은 같은 종류의 디저트를 다시 먹는 것을 싫어한다.
 * 즉, [Fig. 3]과 같이 카페 투어 중에 같은 숫자의 디저트를 팔고 있는 카페가 있으면 안 된다.
 * 
 * 하나의 카페에서 디저트를 먹는 것도 안 된다.
 * 왔던 길을 다시 돌아가는 것도 안 된다.
 * 
 * 친구들과 디저트를 되도록 많이 먹으려고 한다.
 * 디저트 가게가 모여있는 지역의 한 변의 길이 N과 디저트 카페의 디저트 종류가 입력으로 주어질 때,
 * 임의의 한 카페에서 출발하여 대각선 방향으로 움직이고
 * 서로 다른 디저트를 먹으면서 사각형 모양을 그리며 다시 출발점으로 돌아오는 경우,
 * 디저트를 가장 많이 먹을 수 있는 경로를 찾고, 그 때의 디저트 수를 정답으로 출력하는 프로그램을 작성하라.
 * 
 * 만약, 디저트를 먹을 수 없는 경우 -1을 출력한다.
 */

public class SWEA_2105_디저트_카페 {
	public static int N;
	public static int[][] map;
	public static boolean[] desserts;
	public static int answer;

	// RB LB LT RT -
	public static int[] dr = { 1, 1, -1, -1, 0 };
	public static int[] dc = { 1, -1, -1, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 지역의 한 변의 길이
			map = new int[N][N]; // 디저트 종류 배열

			// 디저트 종류 배열 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			desserts = new boolean[101]; // 선택한 디저트 종류 배열
			answer = -1; // 디저트를 가장 많이 먹을 때의 디저트 수, 디저트를 먹을 수 없는 경우 -1

			for (int i = 0; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					desserts[map[i][j]] = true; // 시작 위치의 디저트 카페 방문
					dfs(1, i + 1, j + 1, 0, i, j);
					desserts[map[i][j]] = false; // 원상 복구
				}
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	public static void dfs(int cnt, int r, int c, int dir, int sr, int sc) {
		// 방향을 4번 바꾼 경우 종료한다.
		if (dir == 4)
			return;

		// 도착지점에 도착한 경우 결과값을 갱신하고 종료한다.
		if (r == sr && c == sc) {
			answer = Math.max(answer, cnt);
			return;
		}

		// 범위를 벗어난 경우 종료한다.
		if (r < 0 || r >= N || c < 0 || c >= N)
			return;

		// 이미 선택한 디저트를 선택한 경우 종료한다.
		if (desserts[map[r][c]])
			return;

		// 현재 위치의 디저트 카페 방문
		desserts[map[r][c]] = true;

		// 현재 방향으로 이동
		dfs(cnt + 1, r + dr[dir], c + dc[dir], dir, sr, sc);

		// 시계 방향으로 바꿔 이동
		dfs(cnt + 1, r + dr[dir + 1], c + dc[dir + 1], dir + 1, sr, sc);

		// 원상 복구
		desserts[map[r][c]] = false;
	}
}
