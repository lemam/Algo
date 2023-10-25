/*
 * 백준 13549번 - 숨바꼭질 3 (골드 5)
 * 
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 
 * 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
 * 수빈이는 걷거나 순간이동을 할 수 있다. 
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
 * 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
 * 
 * 수빈이와 동생의 위치가 주어졌을 때, 
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질_3 {
	private static class Node implements Comparable<Node> {
		int dest, cost;

		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	private static final int SIZE = 100001;
	private static final int INF = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		int K = Integer.parseInt(st.nextToken()); // 동생의 위치

		int answer = dijkstra(N, K);
		
		System.out.println(answer);
		
		br.close();
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[SIZE];
		int[] cost = new int[SIZE];

		Arrays.fill(cost, INF);
		cost[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();	// 현재 위치

			// 동생이 있는 위치의 도착하면 탐색을 종료한다.
			if (curr.dest == end) break;
				
			// 이미 방문한 정점이면 건너뛴다.
			if (visited[curr.dest])	continue;

			// 방문 처리
			visited[curr.dest] = true;

			// X-1로 이동할 경우
			int nx = curr.dest - 1;

			if (nx >= 0 && nx < SIZE) {
				if (cost[nx] > cost[curr.dest] + 1) {
					cost[nx] = cost[curr.dest] + 1;
					pq.add(new Node(nx, cost[nx]));
				}
			}

			// X+1로 이동할 경우
			nx = curr.dest + 1;

			if (nx >= 0 && nx < SIZE) {
				if (cost[nx] > cost[curr.dest] + 1) {
					cost[nx] = cost[curr.dest] + 1;
					pq.add(new Node(nx, cost[nx]));
				}
			}

			// X*2로 이동할 경우
			nx = curr.dest * 2;
			
			if (nx >= 0 && nx < SIZE) {
				if (cost[nx] > cost[curr.dest]) {
					cost[nx] = cost[curr.dest];
					pq.add(new Node(nx, cost[nx]));
				}
			}
		}
		
		return cost[end];
	}
}
