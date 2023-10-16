import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 백준 1167번 - 트리의 지름 (골드 2)
 * 
 * 트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 
 * 트리의 지름을 구하는 프로그램을 작성하시오.
 * 
 * 정점 번호는 1부터 V까지 매겨져 있다.
 * 각 줄의 마지막에는 -1이 입력으로 주어진다.
 * 
 * 첫째 줄에 트리의 지름을 출력한다.
 */

public class BOJ_1167_트리의_지름 {
	private static class Node {
		int e, dist;

		public Node(int e, int dist) {
			this.e = e;
			this.dist = dist;
		}
	}

	private static List<Node>[] adjList;
	private static int maxNode, maxDist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int V = Integer.parseInt(br.readLine()); // 정점의 개수
		adjList = new ArrayList[V + 1]; // 인접 리스트

		// 인접 리스트 초기화
		for (int i = 1; i <= V; i++)
			adjList[i] = new ArrayList<>();

		// 간선 입력
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 현재 정점 번호

			while (true) {
				int e = Integer.parseInt(st.nextToken()); // 인접한 정점 번호
				if (e == -1) break;	// 각 줄의 마지막에는 -1이 입력된다.
				int dist = Integer.parseInt(st.nextToken()); // 인접한 정점까지의 거리

				adjList[num].add(new Node(e, dist)); // 간선 저장
			}
		}

		maxNode = 0; // 가장 먼 노드
		maxDist = 0; // 트리의 지름

		boolean[] visited = new boolean[V + 1];
		DFS(1, 0, visited); // 임의의 정점(1)에서 가장 먼 노드 찾기

		visited = new boolean[V + 1];
		DFS(maxNode, 0, visited); // 이전에 찾았던 노드에서 가장 먼 노드까지의 거리 구하기

		System.out.println(maxDist);

		br.close();
	}

	private static void DFS(int idx, int dist, boolean[] visited) {
		visited[idx] = true;

		// 이전에 구한 거리보다 크다면 거리와 노드를 저장한다.
		if (maxDist < dist) {
			maxDist = dist;
			maxNode = idx;
		}

		int size = adjList[idx].size();

		// 모든 간선 탐색
		for (int i = 0; i < size; i++) {
			Node node = adjList[idx].get(i); // 인접 정점

			// 이미 방문한 정점이면 건너 뛴다.
			if (visited[node.e]) continue;

			// 이동
			DFS(node.e, dist + node.dist, visited);
		}
	}
}
