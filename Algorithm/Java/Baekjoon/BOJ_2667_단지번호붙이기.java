import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
	private static int N;
	private static char[][] map;
	private static boolean[][] visited;

	// 12 3 6 9
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 지도의 크기
		map = new char[N][N]; // 지도 배열
		visited = new boolean[N][N]; // 방문 배열

		// 지도 입력
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int danji = 0; // 단지 수
		ArrayList<Integer> countList = new ArrayList<>();	// 집의 수 리스트

		// 지도 BFS 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '0' || visited[i][j])
					continue;
				
				countList.add(solution(i, j));
				danji++;
			}
		}
		
		// 집의 수 오름차순 정렬
		Collections.sort(countList);
		
		// 출력
		System.out.println(danji);
		for (int count : countList)
			System.out.println(count);

		br.close();
	}

	private static int solution(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		int count = 1;	// 집의 개수 (현재 위치 포함)

		queue.add(new int[] { row, col });
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];

			// 4방 탐색
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == '0' || visited[nr][nc])
					continue;

				queue.add(new int[] { nr, nc });
				visited[nr][nc] = true;
				count++;

			}
		}

		return count;
	}
}
