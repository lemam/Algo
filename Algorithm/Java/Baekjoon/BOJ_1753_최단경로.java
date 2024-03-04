import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	private static class Node implements Comparable<Node> {
		int v; // 도착점
		int w; // 가중치

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node other) {
			return this.w - other.w;
		}
	}

	private static final int INF = Integer.MAX_VALUE;
	private static int V;
	private static List<Node>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

		// 정점의 번호는 1부터 시작하므로 V+1
		adjList = new ArrayList[V + 1]; // 인접 리스트

		// 인접 리스트 초기화
		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 간선 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			// 인접한 두 정점
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			// 가중치
			int w = Integer.parseInt(st.nextToken());

			adjList[u].add(new Node(v, w));
		}

		// 다익스트라 알고리즘
		int[] dist = solution(K);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i] + "\n");
			}
		}
		
		System.out.println(sb);

		br.close();
	}

	private static int[] solution(int start) {
		boolean[] visited = new boolean[V + 1]; // 정점 방문 배열
		int[] dist = new int[V + 1]; // start에서부터 해당 정점까지의 거리 배열
		PriorityQueue<Node> pq = new PriorityQueue<>();

		Arrays.fill(dist, INF);
		dist[start] = 0;

		// 시작 노드를 우선순위 큐에 넣는다.
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			int now = pq.poll().v; // 현재 정점

			// 이미 방문한 노드이면 건너 뛴다.
			if (visited[now])
				continue;

			// 방문 처리
			visited[now] = true;

			// 현재 정점과 인접한 모든 정점 탐색
			for (Node node : adjList[now]) {
				// dist[node.v] : start ~ node까지의 거리
				// dist[now] + node.w : start ~ now ~ node까지의 거리
				// now를 경유해서 가는 거리가 더 작을 경우 dist[node.v]를 갱신하고 해당 정점을 큐에 넣는다.
				if (dist[node.v] > dist[now] + node.w) {
					dist[node.v] = dist[now] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}

		return dist;
	}
}
