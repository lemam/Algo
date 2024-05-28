package Baekjoon;/*
 * 백준 1260번 - DFS와 BFS (실버 2)
 * 
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
 * 정점 번호는 1번부터 N번까지이다.
 * 
 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
 * 입력으로 주어지는 간선은 양방향이다.
 * 
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. 
 * V부터 방문된 점을 순서대로 출력하면 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와_BFS {
	public static int N;
	
	public static int[][] arr;
	public static boolean[] visted;
	
	public static StringBuilder sb;
	public static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

		sb = new StringBuilder();
		queue = new LinkedList<Integer>();
		
		arr = new int[N + 1][N + 1]; // 인접 행렬
		visted = new boolean[N + 1]; // 방문 여부 확인 배열

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			// 간선이 연결하는 두 정점의 번호
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = arr[b][a] = 1;
		}

		dfs(V);
		sb.append("\n");
		
		// 초기화
		visted = new boolean[N + 1];
		
		bfs(V);
		
		System.out.println(sb.toString());

		br.close();
	}

	public static void bfs(int start) {
		queue.add(start);
		visted[start] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur + " ");
			
			for (int i = 0; i <= N; i++) {
				if (arr[cur][i] == 1 && !visted[i]) {
					queue.add(i);
					visted[i] = true;
				}
			}
		}
	}

	public static void dfs(int start) {
		visted[start] = true;
		sb.append(start + " ");
		
		for (int i = 0; i <= N; i++) {
			if (arr[start][i] == 1 && !visted[i]) {
				dfs(i);
			}
		}
	}
}
