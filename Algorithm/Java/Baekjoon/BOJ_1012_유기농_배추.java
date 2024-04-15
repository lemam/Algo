import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농_배추 {
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;

	// 12, 3, 6, 9
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 배추밭의 가로길이
			N = Integer.parseInt(st.nextToken()); // 배추밭의 세로길이
			int K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

			map = new int[N][M]; // 배추밭 배열
			visited = new boolean[N][M]; // 방문 배열
			int answer = 0; // 최소의 배추흰지렁이 마리 수

			// 배추 위치 입력
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				// 배추의 위치
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[Y][X] = 1;
			}

			// 배추밭 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 배추가 아니거나 이미 방문한 배추이면 건너 뛴다.
					if (map[i][j] == 0 || visited[i][j])
						continue;

					// 방문하지 않은 배추인 경우 인접한 배추를 탐색한다.
					solution(i, j);
					answer++; // 지렁이 추가
				}
			}

			System.out.println(answer);
		}

		br.close();
	}

	private static void solution(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col });
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];

			for (int dir = 0; dir < 4; dir++) {
				// 다음 배추 위치
				int nr = r + dr[dir];
				int nc = c + dc[dir];

				// 범위 밖이거나 배추가 아니거나 이미 방문한 곳이면 건너 뛴다.
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || visited[nr][nc]) {
					continue;
				}

				queue.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
	}
}
