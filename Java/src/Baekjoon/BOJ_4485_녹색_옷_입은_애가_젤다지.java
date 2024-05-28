package Baekjoon;/*
 * 백준 4485번 - 녹색 옷 입은 애가 젤다지? (골드 4)
 * 
 * 젤다의 전설 게임에서 화폐의 단위는 루피(rupee)다. 
 * 그런데 간혹 '도둑루피'라 불리는 검정색 루피도 존재하는데, 이걸 획득하면 오히려 소지한 루피가 감소하게 된다!
 * 
 * 젤다의 전설 시리즈의 주인공, 링크는 지금 도둑루피만 가득한 N x N 크기의 동굴의 제일 왼쪽 위에 있다.
 * [0][0]번 칸이기도 하다. 
 * 링크는 이 동굴의 반대편 출구, 제일 오른쪽 아래 칸인 [N-1][N-1]까지 이동해야 한다. 
 * 동굴의 각 칸마다 도둑루피가 있는데, 이 칸을 지나면 해당 도둑루피의 크기만큼 소지금을 잃게 된다. 
 * 링크는 잃는 금액을 최소로 하여 동굴 건너편까지 이동해야 하며, 한 번에 상하좌우 인접한 곳으로 1칸씩 이동할 수 있다.
 * 링크가 잃을 수밖에 없는 최소 금액은 얼마일까?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색_옷_입은_애가_젤다지 {
	private static class Node implements Comparable<Node> {
		int r, c, cost;

		public Node(int x, int y, int cost) {
			this.r = x;
			this.c = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	private static int N;
	private static int[][] map;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int tc = 1;	// 테스트 케이스 번호
		
		while (true) {
			N = Integer.parseInt(br.readLine()); // 동굴의 크기
			
			// N = 0인 입력이 주어지면 전체 입력이 종료된다.
			if (N == 0) break;
			
			map = new int[N][N]; // 동굴 배열

			// 도둑 루피 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = solution(0, 0); // 링크가 잃을 수밖에 없는 최소 금액
			
			sb.append("Problem " + tc++ + ": " + answer + "\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}

	private static int solution(int sr, int sc) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean[][] visited = new boolean[N][N];
		int[][] cost = new int[N][N];

		// 3 6 9 12
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		for (int[] arr : cost)
			Arrays.fill(arr, Integer.MAX_VALUE);
		
		cost[sr][sc] = map[sr][sc];
		visited[sr][sc] = true;
		pq.add(new Node(sr, sc, map[sr][sc]));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			// 다음 이동할 오른쪽과 아래 길 탐색
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				// 범위 밖이거나 방문한 곳이면 건너 뛴다.
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
					continue;

				// 지금까지 저장된 최소 금액보다 현재 경로로 왔을 때의 금액이 더 최소라면 갱신한다.
				if (cost[nr][nc] > curr.cost + map[nr][nc]) {
					visited[nr][nc] = true;
					cost[nr][nc] = curr.cost + map[nr][nc];
					pq.add(new Node(nr, nc, cost[nr][nc]));
				}
			}
		}
		
		return cost[N - 1][N - 1];
	}
}
