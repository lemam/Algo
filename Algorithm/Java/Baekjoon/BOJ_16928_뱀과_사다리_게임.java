/*
 * 백준 16928번 - 뱀과 사다리 게임 (골드 5)
 * 
 * 뱀과 사다리 게임을 즐겨 하는 큐브러버는 어느 날 궁금한 점이 생겼다.
 * 주사위를 조작해 내가 원하는 수가 나오게 만들 수 있다면, 최소 몇 번만에 도착점에 도착할 수 있을까?
 * 
 * 게임은 정육면체 주사위를 사용하며, 주사위의 각 면에는 1부터 6까지 수가 하나씩 적혀있다. 
 * 게임은 크기가 10×10이고, 총 100개의 칸으로 나누어져 있는 보드판에서 진행된다. 
 * 보드판에는 1부터 100까지 수가 하나씩 순서대로 적혀져 있다.
 * 
 * 플레이어는 주사위를 굴려 나온 수만큼 이동해야 한다. 
 * 만약 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없다. 
 * 
 * 도착한 칸이 사다리면, 사다리를 타고 위로 올라간다. 
 * 뱀이 있는 칸에 도착하면, 뱀을 따라서 내려가게 된다.
 * 
 * 즉, 사다리를 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 크고, 
 * 뱀을 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 작아진다.
 * 
 * 게임의 목표는 1번 칸에서 시작해서 100번 칸에 도착하는 것이다.
 * 게임판의 상태가 주어졌을 때, 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값을 구해보자.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과_사다리_게임 {
	private static int[] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사다리의 수
		int M = Integer.parseInt(st.nextToken()); // 뱀의 수

		board = new int[101]; // 보드판 배열

		// 보드판 배열 초기화
		for (int i = 1; i <= 100; i++)
			board[i] = i;

		// 사다리 정보 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken()); // 사다리 시작 칸
			int y = Integer.parseInt(st.nextToken()); // 사다리 끝 칸

			board[x] = y; // x번 칸에 도착하면 y번 칸으로 이동한다.
		}

		// 뱀 정보 입력
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken()); // 뱀 시작 칸
			int v = Integer.parseInt(st.nextToken()); // 뱀 끝 칸

			board[u] = v; // u번 칸에 도착하면 v번 칸으로 이동한다.
		}

		int answer = BFS(); // 주사위를 굴려야 하는 횟수의 최솟값

		System.out.println(answer);

		br.close();
	}

	private static int BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] visited = new int[101];

		queue.add(1);
		visited[1] = 0;

		while (true) {
			int curr = queue.poll();

			// 주사위가 1 ~ 6이 나오는 경우 탐색
			for (int i = 1; i <= 6; i++) {
				int next = curr + i;

				// 범위 밖이거나 이미 방문한 적이 있는 곳이면 건너 뛰기
				if (next > 100 || visited[board[next]] > 0)
					continue;

				// 다음 위치를 큐에 넣고, 주사위 횟수를 저장한다.
				queue.add(board[next]);
				visited[board[next]] = visited[curr] + 1;

				// 100이면 게임 종료이므로 주사위를 굴린 횟수를 반환한다.
				if (board[next] == 100)
					return visited[100];
			}
		}
	}
}
