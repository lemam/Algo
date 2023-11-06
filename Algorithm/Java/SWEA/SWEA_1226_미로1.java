/*
 * SWEA 1226번 - 미로1
 * 
 * 아래 그림과 같은 미로가 있다.
 * 16*16 행렬의 형태로 만들어진 미로에서 흰색 바탕은 길, 노란색 바탕은 벽을 나타낸다.
 * 가장 좌상단에 있는 칸을 (0, 0)의 기준으로 하여, 
 * 가로방향을 x 방향, 세로방향을 y 방향이라고 할 때, 
 * 미로의 시작점은 (1, 1)이고 도착점은 (13, 13)이다.
 * 
 * 주어진 미로의 출발점으로부터 도착지점까지 갈 수 있는 길이 있는지 판단하는 프로그램을 작성하라.
 * 
 * 총 10개의 테스트케이스가 주어진다.
 * 테스트 케이스에서 1은 벽을 나타내며 0은 길, 2는 출발점, 3은 도착점을 나타낸다.
 * 도달 가능 여부를 1 또는 0으로 표시한다 (1 - 가능함, 0 - 가능하지 않음).
 */

import java.util.Scanner;

public class SWEA_1226_미로1 {
	private static class Pos {
		int row, col;

		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	private static final int N = 16;
	
	private static int[][] map;
	private static boolean[][] visited;
	private static int answer;

	// 12 3 6 9
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int tcNum = Integer.parseInt(sc.next()); // 테스트 케이스 번호
			Pos start = null, end = null; // 시작점, 도착점
			map = new int[N][N]; // 미로 배열

			// 미로 정보 입력
			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = Character.getNumericValue(line.charAt(j));

					// 시작점, 도착점 저장
					if (map[i][j] == 2)
						start = new Pos(i, j);
					else if (map[i][j] == 3)
						end = new Pos(i, j);
				}
			}
			
			visited = new boolean[N][N];
			answer = 0;	// 도착점 도달 가능 여부

			DFS(start, end);
			
			System.out.printf("#%d %d\n", tcNum, answer);
		}

		sc.close();
	}

	private static void DFS(Pos pos, Pos end) {
		// 도착점에 도달하면 중단한다.
		if (pos.row == end.row && pos.col == end.col) {
			answer = 1;
			return;
		}

		visited[pos.row][pos.col] = true;

		for (int dir = 0; dir < 4; dir++) {
			int nr = pos.row + dr[dir];
			int nc = pos.col + dc[dir];

			// 범위 밖이거나 벽이거나 이미 방문한 곳이면 건너 뛴다.
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1 || visited[nr][nc])
				continue;

			// 다음 위치 탐색
			DFS(new Pos(nr, nc), end);
		}
	}
}
