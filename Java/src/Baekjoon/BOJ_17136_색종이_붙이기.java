package Baekjoon;/*
 * 백준 17136번 - 색종이 붙이기 (골드 2)
 * 
 * <그림 1>과 같이 정사각형 모양을 한 다섯 종류의 색종이가 있다.
 * 색종이의 크기는 1×1, 2×2, 3×3, 4×4, 5×5로 총 다섯 종류가 있으며, 각 종류의 색종이는 5개씩 가지고 있다.
 * 
 * 색종이를 크기가 10×10인 종이 위에 붙이려고 한다. 
 * 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 0 또는 1이 적혀 있다. 
 * 
 * 1이 적힌 칸은 모두 색종이로 덮여져야 한다.
 * 색종이를 붙일 때는 종이의 경계 밖으로 나가서는 안되고, 겹쳐도 안 된다. 
 * 또, 칸의 경계와 일치하게 붙여야 한다. 
 * 0이 적힌 칸에는 색종이가 있으면 안 된다.
 * 
 * 종이가 주어졌을 때, 1이 적힌 모든 칸을 붙이는데 필요한 색종이의 최소 개수를 구해보자.
 * 1을 모두 덮는 것이 불가능한 경우에는 -1을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136_색종이_붙이기 {
	private static final int N = 10; // 종이 한 변의 길이

	private static int[] paper;
	private static int[][] board;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		paper = new int[] { 5, 5, 5, 5, 5 }; // 색종이의 개수 (1×1, 2×2, 3×3, 4×4, 5×5)
		board = new int[N][N]; // 10x10 종이 배열

		// 종이 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		answer = Integer.MAX_VALUE; // 색종이의 최소 개수 (가장 큰 값으로 초기화)

		dfs(0, 0, 0);

		// 모두 덮는 것이 불가능한 경우에는 -1을 출력한다.
		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);

		br.close();
	}

	// r : 행, c : 열, cnt : 붙인 색종이의 개수
	private static void dfs(int r, int c, int cnt) {
		// 저장된 최솟값보다 커지면 중단한다.
		if (answer <= cnt)
			return;

		// 마지막 칸까지 탐색했다면 최솟값을 갱신하고 중단한다.
		if (r >= N - 1 && c > N - 1) {
			answer = Math.min(answer, cnt);
			return;
		}

		// 현재 행의 모든 칸을 확인했다면 다음 행으로 이동한다.
		if (c > N - 1) {
			dfs(r + 1, 0, cnt);
			return;
		}

		// 현재 위치의 칸이 1이면 탐색을 시작한다.
		if (board[r][c] == 1) {
			// 5x5 부터 1x1 색종이까지 모두 붙여본
			for (int size = 5; size >= 1; size--) {
				// 해당 색종이를 붙일 수 있는지 확인한다. (색종이의 개수가 충분한지, 해당 범위에 1이 다 있는지)
				if (paper[size - 1] > 0 && canAttach(r, c, size)) {
					// 색종이를 붙인다.
					attach(r, c, size, 0);
					paper[size - 1]--; // 색종이 한 장 사용

					// 다음 오른쪽 탐색 위치로 이동
					dfs(r, c + size, cnt + 1);

					// 원상 복구
					attach(r, c, size, 1);
					paper[size - 1]++;
				}
			}
		}
		// 현재 위치의 칸이 0이면 오른쪽으로 한 칸 이동한다.
		else
			dfs(r, c + 1, cnt);
	}

	// 색종이를 붙이거나 뗀다.
	// r : 행, c : 열, size : 색종이의 한 변의 길이
	// state : 색종이를 붙인다면 0을, 색종이를 뗀다면 1을 입력한다.
	private static void attach(int r, int c, int size, int state) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				board[i][j] = state;
			}
		}
	}

	// size 크기의 색종이를 붙일 수 있는지 여부를 반환한다.
	// r : 행, c : 열, size : 색종이의 한 변의 길이
	private static boolean canAttach(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				// 범위 밖이거나 칸이 0이면 색종이를 붙일 수 없다.
				if (i < 0 || i >= N || j < 0 || j >= N || board[i][j] == 0)
					return false;
			}
		}

		return true;
	}
}
