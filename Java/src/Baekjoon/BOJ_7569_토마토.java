package Baekjoon;/*
 * 백준 7569번 - 토마토 (골드 5)
 * 
 * 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
 * 토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.
 * 
 * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 
 * 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
 * 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 
 * 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
 * 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.
 * 
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 
 * 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 * 
 * 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다. 
 * 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 
 * 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	private static class Tomato {
		int h, r, c;

		public Tomato(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}

	// 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
	private static int[] dh = { -1, 1, 0, 0, 0, 0 };
	private static int[] dr = { 0, 0, 0, 0, -1, 1 };
	private static int[] dc = { 0, 0, -1, 1, 0, 0 };

	private static int H, M, N;
	private static int[][][] box;
	private static Queue<Tomato> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
		N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수
		H = Integer.parseInt(st.nextToken()); // 쌓아올려지는 상자의 수

		box = new int[H][N][M]; // 토마토 상자 배열

		queue = new LinkedList<Tomato>();

		// 토마토 정보 입력
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());

					// 익은 토마토이면 큐에 넣는다.
					if (box[i][j][k] == 1)
						queue.add(new Tomato(i, j, k));
				}
			}
		}

		BFS();

		int answer = 0;	// 토마토가 모두 익을 때의 최소 일수

		// 모든 토마토가 익었는지 확인
		out: for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					// 익지 않은 토마토가 있는 경우
					if (box[i][j][k] == 0) {
						answer = 0;
						break out;
					}

					if (answer < box[i][j][k])
						answer = box[i][j][k];
				}
			}
		}
		
		System.out.println(answer - 1);

		br.close();
	}

	private static void BFS() {
		while (!queue.isEmpty()) {
			Tomato curr = queue.poll(); // 현재 탐색할 토마토

			for (int dir = 0; dir < 6; dir++) {
				// 다음 탐색 위치
				int nh = curr.h + dh[dir];
				int nr = curr.r + dr[dir];
				int nc = curr.c + dc[dir];

				// 범위 밖이면 건너 뛴다.
				if (nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				// 익지 않은 토마토이면 익은 날짜를 저장하고 큐에 넣는다.
				if (box[nh][nr][nc] == 0) {
					box[nh][nr][nc] = box[curr.h][curr.r][curr.c] + 1;
					queue.add(new Tomato(nh, nr, nc));
				}
			}
		}
	}
}
