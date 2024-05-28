package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 백준 24444번 - 알고리즘 수업 - 너비 우선 탐색 1 (실버 2)
 * 
 * 오늘도 서준이는 너비 우선 탐색(BFS) 수업 조교를 하고 있다. 
 * 
 * N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다.
 * 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다. 
 * 정점 R에서 시작하여 너비 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.
 * 인접 정점은 오름차순으로 방문한다.
 */

public class BOJ_24444_알고리즘_수업_너비_우선_탐색_1 {
	public static List<Integer>[] adjList;
	public static int[] visited;
	public static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()); // 정점의 수
		int M = Integer.parseInt(st.nextToken()); // 간선의 수
		int R = Integer.parseInt(st.nextToken()); // 시작 정점

		adjList = new ArrayList[N + 1]; // 인접 리스트
		visited = new int[N + 1]; // 정점의 방문 순서 저장 배열
		cnt = 1; // 방문 순서 카운팅 변수

		// 인접 리스트 초기화
		for (int i = 0; i < N + 1; i++)
			adjList[i] = new ArrayList<>();

		// 간선 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			// 두 정점 u, v
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			// 무방향 그래프, 가중치 1
			adjList[u].add(v);
			adjList[v].add(u);
		}

		// 오름차순 정렬
		for (int i = 0; i < N + 1; i++)
			Collections.sort(adjList[i]);

		// 너비 우선 탐색
		bfs(R);

		// 방문 순서 출력
		for (int i = 1; i < N + 1; i++)
			sb.append(visited[i]).append("\n");
		
		System.out.print(sb);

		br.close();
	}

	// 너비 우선 탐색
	// v: 시작 정점
	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();

		visited[v] = cnt++; // 방문 순서 저장
		queue.add(v); // 시작 정점 큐에 저장

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			// 인접 정점 탐색
			for (int i : adjList[curr]) {
				// 방문하지 않았다면 큐에 저장한다.
				if (visited[i] == 0) {
					queue.add(i);
					visited[i] = cnt++; // 방문 순서 저장
				}
			}
		}
	}
}
