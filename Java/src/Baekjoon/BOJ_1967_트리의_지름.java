package Baekjoon;/*
 * 백준 1967번 - 트리의 지름 (골드 4)
 * 
 * 트리(tree)는 사이클이 없는 무방향 그래프이다. 
 * 트리에서는 어떤 두 노드를 선택해도 둘 사이에 경로가 항상 하나만 존재하게 된다. 
 * 트리에서 어떤 두 노드를 선택해서 양쪽으로 쫙 당길 때, 가장 길게 늘어나는 경우가 있을 것이다. 
 * 이럴 때 트리의 모든 노드들은 이 두 노드를 지름의 끝 점으로 하는 원 안에 들어가게 된다.
 * 
 * 이런 두 노드 사이의 경로의 길이를 트리의 지름이라고 한다. 
 * 정확히 정의하자면 트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이를 말한다.
 * 
 * 입력으로 루트가 있는 트리를 가중치가 있는 간선들로 줄 때, 
 * 트리의 지름을 구해서 출력하는 프로그램을 작성하시오. 
 * 트리의 노드는 1부터 n까지 번호가 매겨져 있다.
 * 
 * 간선에 대한 정보는 부모 노드의 번호가 작은 것이 먼저 입력되고, 
 * 부모 노드의 번호가 같으면 자식 노드의 번호가 작은 것이 먼저 입력된다. 
 * 루트 노드의 번호는 항상 1이라고 가정하며, 간선의 가중치는 100보다 크지 않은 양의 정수이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1967_트리의_지름 {
	private static class Node {
		int e, dist;

		public Node(int e, int dist) {
			super();
			this.e = e;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [e=" + e + ", dist=" + dist + "]";
		}
	}

	private static List<Node>[] adjList;
	private static int maxNode, maxDist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 노드의 개수
		adjList = new ArrayList[n + 1]; // 인접 리스트

		// 인접 리스트 초기화
		for (int i = 0; i < n + 1; i++)
			adjList[i] = new ArrayList<Node>();

		// 간선 입력
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken()); // 부모 노드
			int e = Integer.parseInt(st.nextToken()); // 자식 노드
			int dist = Integer.parseInt(st.nextToken()); // 간선의 가중치

			// 무방향
			adjList[num].add(new Node(e, dist));
			adjList[e].add(new Node(num, dist));
		}

		maxNode = 0; // 가장 먼 노드
		maxDist = 0; // 트리의 지름

		boolean[] visited = new boolean[n + 1];
		dfs(1, 0, visited); // 임의의 정점(1)에서 가장 먼 노드 찾기

		visited = new boolean[n + 1];
		dfs(maxNode, 0, visited); // 이전에 찾았던 노드에서 가장 먼 노드까지의 거리 구하기

		System.out.println(maxDist);

		br.close();
	}

	private static void dfs(int idx, int dist, boolean[] visited) {
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
			dfs(node.e, dist + node.dist, visited);
		}
	}
}
