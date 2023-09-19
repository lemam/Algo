import java.util.Scanner;

/*
 * SWEA 7733번 - 치즈 도둑 (D4)
 * 
 * 치즈를 좋아하는 다혜는 한 변의 길이가 N인 정사각형 모양의 치즈를 샀다. 
 * 이 치즈는 특이하게도 N*N개의 모든 칸의 맛있는 정도가 동일하지 않다.
 * 맛있는 정도는 1부터 100 사이로 표현된다.
 * 
 * 명우는 치즈를 사서 냉동실에 넣어놨는데, 냉동실에는 치즈를 엄청 좋아하는 요정이 숨어있다.
 * 요정은 100일동안 치즈를 갉아먹는데, X번째날에는 맛있는 정도가 X인 칸을 먹어버린다.
 * 치즈 덩어리란 상, 하, 좌, 우로 인접한 칸들을 하나로 묶어놓은 것을 의미한다.
 * 
 * 100일 중에서 치즈덩어리가 가장 많을 때의 덩어리 개수를 구하는 프로그램을 작성하라.
 */

public class SWEA_7733_치즈_도둑 {
	// 12 3 6 9
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };

	public static int[][] cheese; // 치즈 배열
	public static boolean[][] visited; // 방문 처리 배열

	public static int N; // 치즈 한 변의 길이
	public static int answer; // 치즈 덩어리의 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			cheese = new int[N][N];
			answer = 1;

			// 치즈 배열 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
				}
			}

			solution();
			
			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	public static void solution() {
		// 100일동안 치즈 탐색
		for (int day = 1; day <= 100; day++) {
			// 요정은 X번째날에는 맛있는 정도가 X인 칸을 먹어버린다. (0으로 표시)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cheese[i][j] == day) {
						cheese[i][j] = 0;
					}
				}
			}
			
			answer = Math.max(answer, getCheeseCnt());
		}
	}

	// 상하좌우 연결된 치즈들을 하나의 치즈 덩어리라고 할 때, 치즈 덩어리의 개수를 반환한다.
	private static int getCheeseCnt() {
		int cnt = 0; // 치즈 덩어리의 개수

		visited = new boolean[N][N];

		// 치즈 덩어리 탐색
		// 탐색 시작 위치 : (i, j)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 이미 방문한 곳이면 건너 뛴다.
				if (visited[i][j] || cheese[i][j] == 0) continue;

				dfs(i, j);
				cnt++;
			}
		}

		return cnt;
	}

	public static void dfs(int row, int col) {
		visited[row][col] = true;

		// 4방향 탐색
		for (int dir = 0; dir < 4; dir++) {
			// 다음 탐색 위치
			int nr = row + dr[dir];
			int nc = col + dc[dir];

			// 범위 밖이거나 이미 방문한 곳이거나 치즈가 없다면 건너 뛴다.
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || cheese[nr][nc] == 0) {
				continue;
			}

			dfs(nr, nc);
		}
	}
}
