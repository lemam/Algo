package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
	private static int N, M, k, answer;
	private static int[][] map;
	private static List<Cctv> cctvList;

	// 12, 3, 6, 9
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };

	// CCTV 감시 방향 : 상(0), 우(1), 하(2), 좌(3)
	public static int[][][] mode = {
			{},
			{{0}, {1}, {2}, {3}},
			{{0, 2}, {1, 3}},
			{{0, 1}, {1, 2}, {2, 3}, {3, 0}},
			{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
			{{0, 1, 2, 3}}
	};

	private static class Cctv {
		int r, c, type;

		public Cctv(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvList = new ArrayList<>();
		answer = N * M;

		// map 입력 받기
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);

				if (map[i][j] >= 1 && map[i][j] <= 5) {
					answer--; // CCTV가 있는 곳은 사각지대가 아니다.
					// CCTV 위치를 저장한다.
					cctvList.add(new Cctv(i, j, map[i][j]));
				}
			}
		}

		k = cctvList.size();

		solution(0, map);

		System.out.println(answer);

		br.close();
	}

	private static void solution(int depth, int[][] currMap) {
		// 모든 CCTV를 확인한 경우
		if (depth == k) {
			// 사각지대를 구하고 최소값이면 answer에 갱신한다.
			answer = Math.min(answer, checkBlindSpot(currMap));
			return;
		}

		// 현재 CCTV의 정보 꺼내기
		int row = cctvList.get(depth).r;
		int col = cctvList.get(depth).c;
		int type = cctvList.get(depth).type;

		// 해당 CCTV 타입의 4가지 회전 상태를 모두 탐색
		for (int i = 0; i < mode[type].length; i++) {
			// map의 복사본 생성
			int[][] copyMap = new int[N][M];
			for (int j = 0; j < N; j++) {
				copyMap[j] = currMap[j].clone();
			}

			// 위에서 선택한 경우의 감시 방향 모두 탐색
			for (int j = 0; j < mode[type][i].length; j++) {
				int dir = mode[type][i][j]; // 감시 방향
				// 다음 탐색 위치
				int nr = row + dr[dir];
				int nc = col + dc[dir];

				// 해당 방향으로 감시 시작
				while (true) {
					// map의 범위를 벗어나거나 벽을 만나면 중단한다.
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || currMap[nr][nc] == 6) {
						break;
					}

					// copyMap에 감시 범위 표시
					copyMap[nr][nc] = -1;
					// 다음 탐색 위치로 이동
					nr += dr[dir];
					nc += dc[dir];
				}
			}

			// 다음 CCTV 선택
			solution(depth + 1, copyMap);
		}
	}

	// 사각지대의 개수를 센다.
	private static int checkBlindSpot(int[][] currMap) {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (currMap[i][j] == 0) {
					cnt++;
				}
			}
		}

		return cnt;
	}
}
