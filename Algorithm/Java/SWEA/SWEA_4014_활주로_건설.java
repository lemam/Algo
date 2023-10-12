import java.util.Scanner;

/*
 * SWEA 4014번 - 활주로 건설 (모의 SW 역량테스트)
 * 
 * N * N 크기의 절벽지대에 활주로를 건설하려고 한다.
 * 각 셀의 숫자는 그 지형의 높이를 의미한다.
 * 활주로를 [Fig. 2] 와 같이 가로 또는 세로 방향으로 건설할 수 있는 가능성을 확인하려고 한다.
 * 
 * 활주로는 높이가 동일한 구간에서 건설이 가능하다.
 * 높이가 다른 구간의 경우 활주로가 끊어지기 때문에 [Fig. 3] 과 같은 경사로를 설치해야만 활주로를 건설 할 수 있다.
 * 
 * 경사로는 길이가 X 이고, 높이는 1 이다.
 * 경사로는 높이 차이가 1 이고 낮은 지형의 높이가 동일하게 경사로의 길이만큼 연속되는 곳에 설치 할 수 있다.
 * 동일한 셀에 두 개 이상의 경사로를 겹쳐서 사용할 수 없다.
 * 경사로는 세워서 사용할 수 없다.
 * 
 * 경사로의 길이 X 와 절벽지대의 높이 정보가 주어질 때, 
 * 활주로를 건설할 수 있는 경우의 수를 계산하는 프로그램을 작성하라.
 */

public class SWEA_4014_활주로_건설 {
	private static int N, X;
	private static int[][] map, rotateMap;
	private static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 지도의 한 변의 크기
			X = sc.nextInt(); // 경사로의 길이

			map = new int[N][N]; // 지도 배열
			rotateMap = new int[N][N]; // 지도 배열의 행을 열으로 바꾼 배열

			// 지도 배열 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = rotateMap[j][i] = sc.nextInt();
				}
			}

			answer = 0; // 활주로를 건설할 수 있는 경우의 수

			// 0열부터 N-1열까지 탐색
			for (int i = 0; i < N; i++) {
				checkRow(i, map);
				checkRow(i, rotateMap);
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	// r행에 활주로를 건설할 수 있는지 확인한다.
	private static void checkRow(int row, int[][] map) {
		int height = map[row][0]; // 시작 좌표의 높이
		boolean[] visited = new boolean[N]; // 방문 배열

		// 1행부터 N-1행까지 탐색
		for (int col = 1; col < N; col++) {
			// 현재 높이가 이전 높이보다 낮을 때
			if (height > map[row][col]) {
				// 두 높이의 차가 1이 아니거나 오른쪽에 경사로를 놓을 수 없으면 중단한다.
				if (height - map[row][col] != 1 || !checkDiff(row, col, map[row][col], map, visited))
					return;
			}
			// 현재 높이가 이전 높이보다 높을 때
			else if (height < map[row][col]) {
				// 두 높이의 차가 1이 아니거나 왼쪽에 경사로를 놓을 수 없으면 중단한다.
				if (map[row][col] - height != 1 || !checkDiff(row, col - X, height, map, visited))
					return;
			}

			height = map[row][col];
		}

		// 모든 조건에 맞으면 경우의 수를 1 증가한다.
		answer++;
	}

	// 경사로를 놓을 수 있는지 여부를 반환한다.
	private static boolean checkDiff(int r, int c, int height, int[][] map, boolean[] visited) {
		for (int nc = c; nc < c + X; nc++) {
			// nc가 범위 밖이거나 height와 같지 않거나 이미 방문한 곳이라면 중단한다.
			if (nc < 0 || nc >= N || map[r][nc] != height || visited[nc]) {
				return false;
			}
		}

		// 방문 처리
		for (int nc = c; nc < c + X; nc++)
			visited[nc] = true;

		return true;
	}
}
