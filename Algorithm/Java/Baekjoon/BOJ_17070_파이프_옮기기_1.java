import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 17070번 - 파이프 옮기기 1 (골드 5)
 * 
 * 유현이가 새 집으로 이사했다. 
 * 새 집의 크기는 N×N의 격자판으로 나타낼 수 있고, 1×1크기의 정사각형 칸으로 나누어져 있다. 
 * 각각의 칸은 (r, c)로 나타낼 수 있다. 
 * 여기서 r은 행의 번호, c는 열의 번호이고, 행과 열의 번호는 1부터 시작한다. 
 * 각각의 칸은 빈 칸이거나 벽이다.
 * 
 * 오늘은 집 수리를 위해서 파이프 하나를 옮기려고 한다. 
 * 파이프는 아래와 같은 형태이고, 2개의 연속된 칸을 차지하는 크기이다.
 * 파이프는 회전시킬 수 있으며, 아래와 같이 3가지 방향이 가능하다. (가로, 세로, 오른쪽 아래 대각선 모양)
 * 
 * 파이프는 매우 무겁기 때문에, 유현이는 파이프를 밀어서 이동시키려고 한다.
 * 벽에는 새로운 벽지를 발랐기 때문에, 파이프가 벽을 긁으면 안 된다. 
 * 즉, 파이프는 항상 빈 칸만 차지해야 한다.
 * 
 * 파이프를 밀 수 있는 방향은 총 3가지가 있으며, →, ↘, ↓ 방향이다.
 * 파이프는 밀면서 회전시킬 수 있다.
 * 회전은 45도만 회전시킬 수 있으며, 
 * 미는 방향은 오른쪽, 아래, 또는 오른쪽 아래 대각선 방향이어야 한다.
 * 
 * 파이프가 가로로 놓여진 경우에 가능한 이동 방법은 총 2가지, 
 * 세로로 놓여진 경우에는 2가지, 
 * 대각선 방향으로 놓여진 경우에는 3가지가 있다.
 * 
 * 가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로이다. 
 * 파이프의 한쪽 끝을 (N, N)로 이동시키는 방법의 개수를 구해보자.
 * 
 * 빈 칸은 0, 벽은 1로 주어진다. (1, 1)과 (1, 2)는 항상 빈 칸이다.
 * 첫째 줄에 파이프의 한쪽 끝을 (N, N)으로 이동시키는 방법의 수를 출력한다. 
 * 이동시킬 수 없는 경우에는 0을 출력한다. 
 */

public class BOJ_17070_파이프_옮기기_1 {
	public static int N;
	public static int[][] map;
	public static boolean[][] visited;
	public static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 집의 크기
		map = new int[N + 1][N + 1]; // 집의 상태 배열
		visited = new boolean[N + 1][N + 1]; // 파이프 방문 배열

		// 집의 상태 배열 입력
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = 0; // 이동시키는 방법의 개수

		visited[1][1] = true;
		dfs(1, 2, 0);
		visited[1][1] = false;

		System.out.println(answer);

		br.close();
	}

	// r: 행, c: 열, dir: 파이프 방향 (0: 가로, 1: 세로, 2: 대각선)
	public static void dfs(int r, int c, int dir) {
		// 현재 위치가 범위 밖이거나 이미 파이프 또는 벽이 있으면 중단한다.
		if (r < 0 || r > N || c < 0 || c > N || visited[r][c] || map[r][c] == 1)
			return;

		// 대각선 방향으로 이동할 경우 현재 위치의 위쪽과 왼쪽 칸에 파이프 또는 벽이 있으면 중단한다.
		if (dir == 2 && (visited[r - 1][c] || visited[r][c - 1] || map[r - 1][c] == 1 || map[r][c - 1] == 1))
			return;

		// 도착 지점에 도착하면 개수를 세고 중단한다.
		if (r == N && c == N) {
			answer++;
			return;
		}

		// 현재 위치에 파이프 놓기
		visited[r][c] = true;

		// 가로 방향으로 이동
		if (dir != 1)
			dfs(r, c + 1, 0);

		// 세로 방향으로 이동
		if (dir != 0)
			dfs(r + 1, c, 1);

		// 대각선 방향으로 이동
		dfs(r + 1, c + 1, 2);

		// 원상 복구
		visited[r][c] = false;
	}
}
