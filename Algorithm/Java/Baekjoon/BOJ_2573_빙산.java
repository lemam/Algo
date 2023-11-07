import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {
	private static int N, M;
	private static int[][] map, seaCnt;

	// 12 3 6 9
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 행의 개수
		M = Integer.parseInt(st.nextToken()); // 열의 개수
		map = new int[N][M]; // 빙산 높이 배열

		// 빙산 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0; // 현재 시간(년)

		while (true) {
			seaCnt = new int[N][M]; // 각 빙산의 인접한 바다의 개수를 저장할 배열

			// 1. 빙산 덩어리 개수 확인하기
			int count = getCount(); // 빙산 덩어리 개수

			// 덩어리 개수가 2개 이상이면 중단한다.
			if (count >= 2) break;
			
			// 분리되지 않고 모든 빙산이 녹을 때는 0을 출력한다.
			if (count == 0) {
				year = 0;
				break;
			}

			// 2. 빙산 녹이기
			goNextYear();
			year++;
		}

		System.out.println(year);

		br.close();
	}

	private static void goNextYear() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 바다이면 건너뛴다.
				if (map[i][j] == 0)
					continue;

				// 빙산이면 인접한 바다의 개수만큼 뺀다.
				map[i][j] -= seaCnt[i][j];

				// 저장된 높이는 0보다 더 줄어들지 않는다.
				if (map[i][j] < 0)
					map[i][j] = 0;
			}
		}
	}

	private static int getCount() {
		boolean[][] visited = new boolean[N][M];
		int count = 0; // 덩어리의 개수

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 바다이면 건너뛴다.
				if (map[i][j] == 0)	continue;

				// 이미 방문한 곳이면 건너뛴다.
				if (visited[i][j]) continue;

				visited[i][j] = true;

				// 덩어리 한 개 탐색
				bfs(i, j, visited);

				count++;
			}
		}

		return count;
	}

	private static void bfs(int startRow, int startCol, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { startRow, startCol });

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			// 4방향 탐색
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				// 범위 밖이거나 방문한 곳이면 건너 뛴다.
				if (nr < 0 || nr >= N || nc < 0 || nr >= N || visited[nr][nc])
					continue;

				// 바다이면 개수를 센다.
				if (map[nr][nc] == 0) {
					seaCnt[curr[0]][curr[1]]++;
					continue;
				}

				visited[nr][nc] = true;
				queue.add(new int[] { nr, nc });
			}
		}
	}
}
