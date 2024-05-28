package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * SWEA 1953번 - 탈주범 검거 (모의 SW 역량테스트)
 * 
 * 교도소로 이송 중이던 흉악범이 탈출하는 사건이 발생하여 수색에 나섰다.
 * 탈주범은 탈출한 지 한 시간 뒤, 맨홀 뚜껑을 통해 지하터널의 어느 한 지점으로 들어갔으며,
 * 지하 터널 어딘가에서 은신 중인 것으로 추정된다.
 * 
 * 터널끼리 연결이 되어 있는 경우 이동이 가능하므로 탈주범이 있을 수 있는 위치의 개수를 계산하여야 한다.
 * 탈주범은 시간당 1의 거리를 움직일 수 있다.
 * 지하 터널은 총 7 종류의 터널 구조물로 구성되어 있으며 각 구조물 별 설명은 [표 1]과 같다.
 * 
 * 지하 터널 지도와 맨홀 뚜껑의 위치, 경과된 시간이 주어질 때 탈주범이 위치할 수 있는 장소의 개수를 계산하는 프로그램을 작성하라.
 * 
 * 숫자 1 ~ 7은 해당 위치의 터널 구조물 타입을 의미하며 숫자 0 은 터널이 없는 장소를 의미한다.
 * 출력해야 할 정답은 탈주범이 위치할 수 있는 장소의 개수이다.
 */

public class SWEA_1953_탈주범_검거 {
	private static int N, M;
	private static int[][] map;

	private static class Tunnel {
		int r, c, type, time;

		public Tunnel(int r, int c, int pipe, int time) {
			this.r = r;
			this.c = c;
			this.type = pipe;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 지하 터널 지도의 세로 크기
			M = sc.nextInt(); // 지하 터널 지도의 가로 크기
			int R = sc.nextInt(); // 맨홀 뚜껑이 위치한장소의 세로 위치
			int C = sc.nextInt(); // 맨홀 뚜껑이 위치한장소의 가로 위치
			int L = sc.nextInt(); // 탈출 후 소요된 시간

			map = new int[N][M]; // 지하 터널 지도 배열

			// 지하 터널 지도 배열 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int answer = BFS(R, C, L); // 탈주범이 위치할 수 있는 장소의 개수

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	private static int BFS(int R, int C, int L) {
		Queue<Tunnel> queue = new LinkedList<>();
		queue.add(new Tunnel(R, C, map[R][C], 1)); // 맨홀 뚜껑 위치의 터널에서 시작

		boolean[][] visited = new boolean[N][M]; // 방문한 터널 위치 저장 배열
		visited[R][C] = true;

		int count = 0; // 방문한 터널의 개수

		// 12 3 6 9
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		while (!queue.isEmpty()) {
			Tunnel curr = queue.poll(); // 현재 터널

			// 현재 시간이 L을 초과하면 중단한다.
			if (curr.time > L)
				break;

			boolean[] currTunnelDir = getTunnelDir(curr.type); // 현재 터널이 이동할 수 있는 방향 배열

			for (int dir = 0; dir < 4; dir++) {
				// dir 방향으로 이동할 수 없으면 건너 뛴다.
				if (!currTunnelDir[dir])
					continue;

				// 다음 탐색할 터널의 위치 좌표
				int nr = curr.r + dr[dir];
				int nc = curr.c + dc[dir];

				// 범위 밖이거나 터널가 없거나 이미 방문한 곳이라면 건너 뛴다.
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || visited[nr][nc])
					continue;

				boolean[] nextTunnelDir = getTunnelDir(map[nr][nc]);	// 다음 파이프가 이동할 수 있는 방향 배열

				// 현재 터널과 연결되어 있다면
				if (nextTunnelDir[(dir + 2) % 4]) {
					// 다음 터널을 큐에 넣는다.
					queue.add(new Tunnel(nr, nc, map[nr][nc], curr.time + 1));
					visited[nr][nc] = true;
				}
			}

			count++;
		}

		return count;
	}

	// 터널의 type에 따라 이동할 수 있는 방향 배열을 반환한다.
	private static boolean[] getTunnelDir(int type) {
		switch (type) {
		// 12 3 6 9
		case 1:
			return new boolean[] { true, true, true, true };
		case 2:
			return new boolean[] { true, false, true, false };
		case 3:
			return new boolean[] { false, true, false, true };
		case 4:
			return new boolean[] { true, true, false, false };
		case 5:
			return new boolean[] { false, true, true, false };
		case 6:
			return new boolean[] { false, false, true, true };
		case 7:
			return new boolean[] { true, false, false, true };
		}
		return null;
	}
}
