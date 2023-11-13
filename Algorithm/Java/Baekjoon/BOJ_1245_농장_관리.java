import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1245_농장_관리 {
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;

	// T TR, R, BR, B, BL, L, TL
	private static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 농장의 세로 길이
		M = Integer.parseInt(st.nextToken()); // 농장의 가로 길이

		map = new int[N][M]; // 농장 배열
		visited = new boolean[N][M]; // 농장 배열

		// 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int peekCnt = 0; // 산봉우리의 개수

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					continue;

				if (BFS(i, j))
					peekCnt++;
			}
		}

		System.out.println(peekCnt);

		br.close();
	}

	private static boolean BFS(int startRow, int startCol) {
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.add(new int[] { startRow, startCol });
		visited[startRow][startCol] = true;

		boolean isPeek = true;	// 산봉우리 여부

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currRow = curr[0];
			int currCol = curr[1];

			// 8방향 탐색
			for (int d = 0; d < 8; d++) {
				int nr = currRow + dr[d];
				int nc = currCol + dc[d];

				// 범위 밖이면 건너뛴다.
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				// 시작 높이보다 높으면 산봉우리가 아님을 표시한다.
				if (map[startRow][startCol] < map[nr][nc]) {
					isPeek = false;
				}

				// 아직 방문하지 않은 곳이고 높이가 시작 높이와 같다면 큐에 넣는다.
				if (!visited[nr][nc] && map[startRow][startCol] == map[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc });
				}
			}
		}

		return isPeek;
	}
}
