import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_30024_옥수수밭 {
	private static class Corn implements Comparable<Corn> {
		int row, col, cost;

		public Corn(int row, int col, int cost) {
			this.row = row;
			this.col = col;
			this.cost = cost;
		}

		@Override
		public int compareTo(Corn o) {
			return o.cost - this.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()); // 행의 개수
		int M = Integer.parseInt(st.nextToken()); // 열의 개수
		int[][] map = new int[N + 1][M + 1]; // 옥수수밭 배열
		boolean[][] visited = new boolean[N + 1][M + 1];

		PriorityQueue<Corn> pq = new PriorityQueue<>();

		// 옥수수밭 배열 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 가장자리 옥수수를 우선순위 큐에 넣기
				if (i == 1 || i == N || j == 1 || j == M) {
					visited[i][j] = true;
					pq.add(new Corn(i, j, map[i][j]));
				}
			}
		}

		int K = Integer.parseInt(br.readLine()); // 수확할 수 있는 옥수수의 개수

		// 12 3 6 9
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		for (int cnt = 0; cnt < K; cnt++) {
			Corn curr = pq.poll();

			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = curr.row + dr[d];
				int nc = curr.col + dc[d];

				// 범위 밖이거나 이미 방문한 곳이면 건너뛴다.
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				pq.add(new Corn(nr, nc, map[nr][nc]));
			}

			// 수확한 옥수수 위치 출력
			sb.append(curr.row + " " + curr.col + "\n");
		}

		System.out.println(sb);

		br.close();
	}
}
