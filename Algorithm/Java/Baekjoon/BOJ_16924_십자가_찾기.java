import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16924_십자가_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] map = new String[N][M];
		boolean[][] visited = new boolean[N][M];

		// map 입력
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = line[j];
			}
		}

		StringBuilder sb = new StringBuilder();
		int k = 0; // 십자가의 수

		// 12 3 6 9
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		// 격자판의 둘레(가장자리)에 위차한 *은 십자가의 중앙이 될 수 없으므로 탐색하지 않는다.
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				// 빈 칸이면 건너뛴다.
				if (map[i][j].equals("."))
					continue;

				// *이면 십자가의 크기를 증가시키며 탐색한다.
				loop: for (int size = 1;; size++) {
					// size 거리만큼의 상하좌우를 확인한다.
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d] * size;
						int nc = j + dc[d] * size;

						// 탐색 위치가 격자판 범위 밖이거나 빈 칸이면 탐색을 중단한다.
						if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc].equals(".")) {
							break loop;
						}
					}

					// 상하좌우 모두 *이 있다면 방문처리를 한다.
					visited[i][j] = true; // 중앙
					visited[i - size][j] = true; // 상
					visited[i + size][j] = true; // 하
					visited[i][j - size] = true; // 좌
					visited[i][j + size] = true; // 우

					// 십자가의 개수와 십자가의 정보를 저장한다.
					k++;
					sb.append((i + 1) + " " + (j + 1) + " " + size + "\n");
				}
			}
		}

		// 십자가에 포함되지 않는 *이 있는지 확인하기 위해 방문 횟수 확인한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// *인 칸에 방문처리가 되지 않았다면 십자가에 포함되지 않다는 뜻이므로 십자가의 개수(k)를 -1로 한다.
				if (map[i][j].equals("*") && !visited[i][j]) {
					k = -1;
					break;
				}
			}
		}

		// 십자가의 개수를 출력한다. 만들 수 없는 경우 -1을 출력한다.
		System.out.println(k);

		// 만약 십자가의 개수가 양수이면 십자가의 정보를 출력한다.
		if (k > 0) {
			System.out.println(sb);
		}

		br.close();
	}
}
