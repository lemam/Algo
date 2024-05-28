package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로_탐색 {
	private static int N, M;
	private static int[][] map;

	// 12 3 6 9
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = arr[j] - '0';
			}
		}

		solution();

		System.out.println(map[N - 1][M - 1]);

		br.close();
	}

	private static void solution() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });

		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int row = now[0];
			int col = now[1];

			// 4방 탐색
			for (int dir = 0; dir < 4; dir++) {
				int nr = row + dr[dir];
				int nc = col + dc[dir];

				// map 밖이거나 이동할 수 없는 칸이거나 이미 방문한 곳이면 건너 뛴다.
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || visited[nr][nc]) {
					continue;
				}

				queue.add(new int[] { nr, nc });
				visited[nr][nc] = true;
				map[nr][nc] = map[row][col] + 1;
			}
		}
	}
}
