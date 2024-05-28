package Baekjoon;/*
 * 백준 1697번 - 숨바꼭질 (실버1)
 * 
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 
 * 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 
 * 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 * 
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 * 
 * 수빈이와 동생의 위치가 주어졌을 때, 
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	public static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		int K = Integer.parseInt(st.nextToken()); // 동생의 위치

		visited = new int[100001]; // 각 위치(점)를 방문한 시간(초) (0초를 1로 표현)

		System.out.println(bfs(N, K));

		br.close();
	}

	private static int bfs(int n, int k) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(n);
		visited[n] = 1; // 0초를 1로 표현

		while (!queue.isEmpty()) {
			int curr = queue.poll(); // 현재 위치

			// 현재 위치가 동생의 위치이면 중단한다.
			if (curr == k)
				return visited[curr] - 1; // 0초를 1로 표현했으므로 -1을 한다.

			// x-1로 이동
			if (curr - 1 >= 0 && visited[curr - 1] == 0) {
				visited[curr - 1] = visited[curr] + 1;
				queue.add(curr - 1);
			}

			// x+1로 이동
			if (curr + 1 <= 100000 && visited[curr + 1] == 0) {
				visited[curr + 1] = visited[curr] + 1;
				queue.add(curr + 1);
			}

			// x*2로 이동
			if (curr * 2 <= 100000 && visited[curr * 2] == 0) {
				visited[curr * 2] = visited[curr] + 1;
				queue.add(curr * 2);
			}
		}

		return -1;
	}
}
