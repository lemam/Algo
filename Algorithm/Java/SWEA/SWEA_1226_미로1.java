import java.util.Scanner;

/*
 * SWEA 1226번 - 미로1 (D4)
 * 
 * 16*16 행렬의 형태로 만들어진 미로에서 흰색 바탕은 길, 노란색 바탕은 벽을 나타낸다.
 * 가장 좌상단에 있는 칸을 (0, 0)의 기준으로 하여, 가로방향을 x 방향, 세로방향을 y 방향이라고 할 때, 
 * 미로의 시작점은 (1, 1)이고 도착점은 (13, 13)이다.
 * 
 * 주어진 미로의 출발점으로부터 도착지점까지 갈 수 있는 길이 있는지 판단하는 프로그램을 작성하라.
 * 
 * 총 10개의 테스트케이스가 주어진다.
 * 테스트 케이스에서 1은 벽을 나타내며 0은 길, 2는 출발점, 3은 도착점을 나타낸다.
 * 도달 가능 여부를 1 또는 0으로 표시한다 (1 - 가능함, 0 - 가능하지 않음).
 */

public class SWEA_1226_미로1 {
	public static final int MAZE_SIZE = 16;	// 미로 한 변의 길이

	// 12 3 6 9
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };

	public static int[][] maze; // 미로 배열 (0: 길, 1: 벽, 2: 출발점, 3: 도착점)
	public static boolean[][] visited; // 방문 처리 배열
	
	public static int answer;	// 도달 가능 여부

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10; // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt(); // 테스트 케이스 번호

			maze = new int[MAZE_SIZE][MAZE_SIZE];
			visited = new boolean[MAZE_SIZE][MAZE_SIZE];
			
			answer = 0;

			// 미로 정보 입력
			for (int i = 0; i < MAZE_SIZE; i++) {
				String line = sc.next();

				for (int j = 0; j < MAZE_SIZE; j++) {
					maze[i][j] = Character.getNumericValue(line.charAt(j));
				}
			}

			// 시작점에서 출발하여 경로 탐색
			dfs(1, 1);
			
			System.out.printf("#%d %d\n", t, answer);
		}

		sc.close();
	}

	public static void dfs(int row, int col) {
		// 현재 위치 방문
		visited[row][col] = true;
		
		// 4방향 탐색
		for (int i = 0; i < 4; i++) {
			// 다음 탐색 위치
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			// 다음 탐색 위치가 벽이거나 이미 방문한 곳이라면 건너 뛴다.
			if (maze[nr][nc] == 1 || visited[nr][nc]) continue;
			
			// 다음 탐색 위치가 도작점이면 도달 가능 여부를 1로 표시하고 탐색을 중단한다.
			if (maze[nr][nc] == 3) {
				answer = 1;
				return;
			}
			
			// 다음 탐색 위치가 길이면 탐색한다.
			dfs(nr, nc);
		}
	}
}
