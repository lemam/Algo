package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	private static int N, M;
	private static int[][] map;
	private static int cheese;

	// 12 3 6 9
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로 길이
		M = Integer.parseInt(st.nextToken()); // 가로 길이
		map = new int[N][M];

		int time = 0; // 걸린 시간
		cheese = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 치즈 개수 세기
				if (map[i][j] == 1) {
					cheese++;
				}
			}
		}

		int prevCheese = 0;

		while (cheese != 0) {
			prevCheese = cheese;
			time++;

			boolean[][] visited = new boolean[N][M];

			// 치즈 녹이기
			meltCheese(visited);
		}

		System.out.println(time + "\n" + prevCheese);

		br.close();
	}

	private static void meltCheese(boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.add(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];

				// 범위 밖이고 이미 방문한 곳이면 건너뛴다.
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
					continue;
				}

				// 방문 처리
				visited[nr][nc] = true;

				// 치즈가 없는 칸이면 큐에 넣는다.
				if (map[nr][nc] == 0) {
					queue.add(new int[] { nr, nc });
				}
				// 치즈가 있다면 그 치즈를 녹인다.
				else {
					cheese--;
					map[nr][nc] = 0;
				}
			}
		}
	}
}
