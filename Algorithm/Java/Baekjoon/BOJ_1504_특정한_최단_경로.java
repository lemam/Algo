import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한_최단_경로 {
	private static class Node implements Comparable<Node> {
		int e, dist;

		public Node(int e, int dist) {
			this.e = e;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}

	private static int INF = 200000 * 1000;
	private static int N, answer;
	private static List<Node>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수

		adjList = new ArrayList[N + 1]; // 인접 리스트

		// 인접 리스트 초기화
		for (int i = 0; i < N + 1; i++)
			adjList[i] = new ArrayList<>();

		// 간선 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 출발지
			int b = Integer.parseInt(st.nextToken()); // 도착지
			int c = Integer.parseInt(st.nextToken()); // 가중치

			adjList[a].add(new Node(b, c));
			adjList[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken()); // 반드시 거쳐야 할 정점1
		int v2 = Integer.parseInt(st.nextToken()); // 반드시 거쳐야 할 정점2

		// 1 -> v1 -> v2 -> N
		int result1 = 0;
		result1 += dijkstra(1, v1);
		result1 += dijkstra(v1, v2);
		result1 += dijkstra(v2, N);

		// 1 -> v2 -> v1 -> N
		int result2 = 0;
		result2 += dijkstra(1, v2);
		result2 += dijkstra(v2, v1);
		result2 += dijkstra(v1, N);

		// 경로가 없는 경우
		if (result1 >= INF && result2 >= INF)
			answer = -1;
		// 경로가 있을 경우 더 작은 값
		else
			answer = Math.min(result1, result2);

		System.out.println(answer);

		br.close();
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1]; // 방문 여부 배열
		int[] dist = new int[N + 1]; // start부터의 거리 배열

		Arrays.fill(dist, INF);
		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			// 이미 방문했던 정점이면 건너뛰기
			if (visited[curr.e])
				continue;

			visited[curr.e] = true;

			for (Node next : adjList[curr.e]) {
				if (dist[next.e] > curr.dist + next.dist) {
					dist[next.e] = curr.dist + next.dist;
					pq.add(new Node(next.e, dist[next.e]));
				}
			}
		}

		return dist[end];
	}
}
