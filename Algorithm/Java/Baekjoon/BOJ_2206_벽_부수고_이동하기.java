import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽_부수고_이동하기 {
	// 12, 3, 6, 9
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };

	private static int N, M;
	private static int[][] map;
	private static int[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M][2];

		// 맵 입력
		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = line[j] - '0';
			}
		}

		System.out.println(solution()); 

		br.close();
	}

	private static int solution() {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] { 0, 0, 0 }); // 행, 열, 벽을 부쉈는가
		visited[0][0][0] = 1;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int row = now[0];
			int col = now[1];
			int isBreak = now[2];

			// 끝점에 도착하면 종료한다.
			if (row == N - 1 && col == M - 1)
				return visited[row][col][isBreak];

			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];

				// 맵 밖이거나 이미 방문한 곳이면 스킵한다.
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc][isBreak] > 0)
					continue;

				// 벽이 아닌 경우
				if (map[nr][nc] == 0) {
					visited[nr][nc][isBreak] = visited[row][col][isBreak] + 1;
					queue.add(new int[] { nr, nc, isBreak });
				}

				// 벽이고 벽을 부술 수 있는 기회가 있는 경우
				if (map[nr][nc] == 1 && isBreak == 0) {
					visited[nr][nc][1] = visited[row][col][isBreak] + 1;
					queue.add(new int[] { nr, nc, 1 });
				}
			}
		}

		return -1;

	}
}
