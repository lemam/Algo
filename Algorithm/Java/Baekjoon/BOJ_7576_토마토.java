/*
 * 백준 7576번 - 토마토 (골드 5) 
 * 
 * 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 
 * 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. 
 * 
 * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 
 * 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
 * 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
 * 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 
 * 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
 * 
 * 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
 * 
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 
 * 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 * 
 * 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 * 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 
 * 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	private static class Tomato {
		int row, col;

		public Tomato(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	private static int M, N;
	private static int[][] box;
	private static Queue<Tomato> queue;

	// 12 3 6 9
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
		N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수

		box = new int[N][M]; // 하나의 상자에 저장된 토마토들의 정보 배열
		queue = new LinkedList<Tomato>();

		// 토마토 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());

				// 익은 토마토이면 큐에 넣는다.
				if (box[i][j] == 1)
					queue.add(new Tomato(i, j));
			}
		}

		BFS();

		int answer = 0; // 토마토가 모두 익을 때까지의 최소 날짜

		out: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 익지 않은 토마토가 발견되면 중단한다.
				if (box[i][j] == 0) {
					answer = box[i][j];
					break out;
				}

				// 배열에 저장된 최댓값을 찾는다.
				if (answer < box[i][j])
					answer = box[i][j];
			}
		}

		// 날짜를 1부터 시작했으므로 answer-1을 출력한다.
		System.out.println(answer - 1);

		br.close();
	}

	private static void BFS() {
		while (!queue.isEmpty()) {
			Tomato curr = queue.poll();

			for (int dir = 0; dir < 4; dir++) {
				// 다음 탐색 위치
				int nr = curr.row + dr[dir];
				int nc = curr.col + dc[dir];

				// 범위 밖이면 건너 뛴다.
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				// 익지 않은 토마토이면 익은 날짜를 배열에 저장하고 큐에 넣는다.
				if (box[nr][nc] == 0) {
					box[nr][nc] = box[curr.row][curr.col] + 1;
					queue.add(new Tomato(nr, nc));
				}
			}
		}
	}
}
