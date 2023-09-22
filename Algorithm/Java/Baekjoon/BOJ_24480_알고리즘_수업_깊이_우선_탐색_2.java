import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 백준 24480번 - 알고리즘 수업 - 깊이 우선 탐색 2 (실버 2)
 * 
 * 오늘도 서준이는 깊이 우선 탐색(DFS) 수업 조교를 하고 있다. 
 * 
 * N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다.
 * 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다.
 * 정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.
 * 인접 정점은 내림차순으로 방문한다.
 * 
 * i번째 줄에는 정점 i의 방문 순서를 출력한다. 
 * 시작 정점의 방문 순서는 1이다. 
 * 시작 정점에서 방문할 수 없는 경우 0을 출력한다.
 */

public class BOJ_24480_알고리즘_수업_깊이_우선_탐색_2 {
	public static List<Integer>[] adjList;
	public static int[] visited;
	public static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점의 수
		int M = Integer.parseInt(st.nextToken()); // 간선의 수
		int R = Integer.parseInt(st.nextToken()); // 시작 정점

		adjList = new ArrayList[N + 1]; // 인접 리스트
		visited = new int[N + 1]; // 각 정점을 방문한 정점의 번호를 저장하는 배열

		cnt = 1; // count 배열의 인덱스

		// 인접 리스트 초기화
		for (int i = 0; i < N + 1; i++)
			adjList[i] = new ArrayList<>();

		// 간선 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			// 두 정점 u, v
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			// 양방향 간선, 가중치 1
			adjList[u].add(v);
			adjList[v].add(u);
		}

		// 인접 정점 내림차순 정렬
		for (int i = 0; i < N + 1; i++)
			Collections.sort(adjList[i], Collections.reverseOrder());

		// 깊이 우선 탐색
		dfs(R);

		// 방문 순서 출력
		for (int i = 1; i < N+1; i++)
			System.out.println(visited[i]);

		br.close();
	}

	// 깊이 우선 탐색
	// v : 시작 정점
	private static void dfs(int v) {
		visited[v] = cnt++; // 방문 체크

		int size = adjList[v].size();

		// 인접한 정점 순회
		for (int i = 0; i < size; i++) {
			int x = adjList[v].get(i); // 인접 정점 번호

			// 아직 방문하지 않았으면 탐색한다.
			if (visited[x] == 0)
				dfs(x);
		}
	}
}
