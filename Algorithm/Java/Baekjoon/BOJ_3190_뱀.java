/*
 * 백준 3190번 - 뱀 (골드 4)
 * 
 * 'Dummy' 라는 도스게임이 있다.
 * 이 게임에는 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다.
 * 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
 * 
 * 게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다. 
 * 보드의 상하좌우 끝에 벽이 있다.
 * 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 
 * 뱀은 처음에 오른쪽을 향한다.
 * 
 * 뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.
 * 1. 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
 * 2. 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
 * 3. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
 * 4. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
 * 
 * 사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.
 * 
 * 맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3190_뱀 {
	private static int N;
	private static int[][] map;
	private static List<int[]> snake;
	private static Map<Integer, String> path;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 보드의 크기
		int K = Integer.parseInt(br.readLine()); // 사과의 개수

		map = new int[N][N]; // 보드 배열
		snake = new ArrayList<int[]>(); // 뱀 위치 리스트
		path = new HashMap<Integer, String>(); // 뱀의 방향 정보 맵

		// 사과 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;

			map[row][col] = 1;
		}

		int L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수

		// 뱀의 방향 정보 입력
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken()); // 시간
			String C = st.nextToken(); // 회전 방향

			path.put(X, C);
		}

		System.out.println(getTime());

		br.close();
	}

	private static int getTime() {
		int r = 0, c = 0;	// 현재 위치 행열 좌표
		int time = 0;	// 현재 시간
		int dir = 1;	// 현재 이동 방향

		snake.add(new int[] { 0, 0 });

		// 12 3 6 9
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		while (true) {
			time++;

			// 1. 다음 위치 확인하기
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			// 2. 그 위치가 범위 밖이거나 자기 자신인지 확인한다.
			// 맞다면 게임을 끝낸다.
			if (checkGameOver(nr, nc))
				break;

			// 3. 한 칸 이동하기
			snake.add(new int[] { nr, nc });
			r = nr;
			c = nc;

			// 4. 사과이면 사과를 제거하고 꼬리를 추가한다.
			// 사과가 아니면 꼬리를 제거한다.
			if (map[r][c] == 1) {
				map[r][c] = 0;
			} else {
				snake.remove(0);
			}

			// 5. 방향을 바꾸는 시간이면 방향을 변경한다.
			if (path.containsKey(time)) {
				// 오른쪽으로 회전
				if (path.get(time).equals("D")) {
					dir = (dir + 1) % 4;
				}
				// 왼쪽으로 회전
				else {
					dir -= 1;
					if (dir == -1)
						dir = 3;
				}
			}
		}

		return time;
	}

	private static boolean checkGameOver(int nr, int nc) {
		if (nr < 0 || nr >= N || nc < 0 || nc >= N)
			return true;

		for (int[] pos : snake) {
			if (nr == pos[0] && nc == pos[1])
				return true;
		}

		return false;
	}
}
