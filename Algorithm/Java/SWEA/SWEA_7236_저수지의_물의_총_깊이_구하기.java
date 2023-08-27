/*
 * SWEA 7236번 - 저수지의 물의 총 깊이 구하기 (D3)
 * 
 * NxN 구획으로 이루어진 지역에 있는 저수지의 물(W)의 총 깊이를 구하려 한다.
 * 각 구획의 물(W)의 깊이는 구획을 애워싼 영역에 땅(G)이 있으면 땅을 뺀 합이 그 구획의 물 깊이다.
 * 하지만 둘러싼 모든 영역이 땅(G)인 경우  그 구획의 물 깊이는 1이된다.
 * 
 * NxN 구획으로 이루어진 지역에 있는 저수지의 물(W)의 총 깊이는
 * 각 구획의 물 깊이 중 가장 깊은 구획의 깊이가 저수지에서 가장 깊은 물의 깊이로 저수지의 총 깊이가 된다. 
 */

import java.util.Scanner;

public class SWEA_7236_저수지의_물의_총_깊이_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		// T, TR, R, BR, B, BL, L, TL
		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 저수지 구획의 크기
			String[][] map = new String[N][N]; // 저수지

			// 배열 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next();
				}
			}

			int depth = 0; // 저수지의 총 깊이

			// 모든 구획의 물 깊이 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 만약 구획이 땅이라면 건너뛴다.
					if (map[i][j].equals("G")) continue;

					int cnt = 0; // 구획 주변의 물 영역 개수

					// 8방향 탐색
					for (int dir = 0; dir < 8; dir++) {
						// 탐색할 다음 위치
						int nr = i + dr[dir];
						int nc = j + dc[dir];

						// 배열 범위 밖이거나 땅 영역이면 건너뛴다.
						if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc].equals("G"))
							continue;

						// 물 영역이면 개수를 추가한다.
						cnt++;
					}

					// 둘러싼 모든 영역이 땅인 경우 그 구획의 물의 깊이는 1이 된다.
					if (cnt == 0) cnt = 1;
					
					depth = Math.max(depth, cnt);
				}
			}
			
			System.out.printf("#%d %d\n", tc, depth);
		}

		sc.close();
	}

}
