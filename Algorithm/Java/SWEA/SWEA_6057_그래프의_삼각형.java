import java.util.Scanner;

/*
 * SWEA 6057번 - 그래프의 삼각형 (D3)
 * 
 * 정점이 N개, 간선이 M개 있는 그래프가 주어진다. (무향 그래프)
 * 정점에는 1번에서 N번까지의 번호가 붙어 있다.
 * 
 * 이 때, i번 정점과 j번 정점 사이에, j번 정점과 k번 정점 사이에, k번 정점과 i번 정점 사이에 
 * 모두 간선이 있는 ( i, j, k ) (단, i < j < k )를 삼각형이라고 하자.
 * 
 * 삼각형의 개수를 구하는 프로그램을 작성하라.
 */

public class SWEA_6057_그래프의_삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 정점의 개수
			int M = sc.nextInt(); // 간선의 개수

			// 간선 배열
			int[][] edges = new int[N + 1][N + 1]; // 정점은 1~N번까지 있다.

			// 간선 배열 입력
			for (int i = 0; i < M; i++) {
				// 인접한 두 정점
				int x = sc.nextInt();
				int y = sc.nextInt();

				edges[x][y] = edges[y][x] = 1; // 무향 그래프
			}

			int answer = 0; // 삼각형의 개수

			for (int i = 1; i <= N - 2; i++) {
				for (int j = i + 1; j <= N - 1; j++) {
					for (int k = j + 1; k <= N; k++) {
						// i번 정점과 j번 정점, j번 정점과 k번 정점, k번 정점과 i번 정점이 인접하면 삼각형이다.
						if (edges[i][j] == 1 && edges[j][k] == 1 && edges[k][i] == 1)
							answer++;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
