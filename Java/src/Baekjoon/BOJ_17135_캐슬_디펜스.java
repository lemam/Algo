package Baekjoon;/*
 * 백준 17135번 - 캐슬 디펜스 (골드 3)
 * 
 * 캐슬 디펜스는 성을 향해 몰려오는 적을 잡는 턴 방식의 게임이다. 
 * 게임이 진행되는 곳은 크기가 N×M인 격자판으로 나타낼 수 있다. 
 * 격자판은 1×1 크기의 칸으로 나누어져 있고, 각 칸에 포함된 적의 수는 최대 하나이다. 
 * 격자판의 N번행의 바로 아래(N+1번 행)의 모든 칸에는 성이 있다.
 * 
 * 성을 적에게서 지키기 위해 궁수 3명을 배치하려고 한다. 
 * 궁수는 성이 있는 칸에 배치할 수 있고, 하나의 칸에는 최대 1명의 궁수만 있을 수 있다. 
 * 각각의 턴마다 궁수는 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공격한다. 
 * 
 * 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고, 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다.
 * 같은 적이 여러 궁수에게 공격당할 수 있다. 
 * 공격받은 적은 게임에서 제외된다.
 * 
 * 궁수의 공격이 끝나면, 적이 이동한다. 
 * 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다. 
 * 모든 적이 격자판에서 제외되면 게임이 끝난다. 
 * 
 * 게임 설명에서 보다시피 궁수를 배치한 이후의 게임 진행은 정해져있다. 
 * 따라서, 이 게임은 궁수의 위치가 중요하다.
 * 격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산해보자.
 * 격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.
 * 
 * 첫째 줄에 격자판 행의 수 N, 열의 수 M, 궁수의 공격 거리 제한 D가 주어진다. 
 * 둘째 줄부터 N개의 줄에는 격자판의 상태가 주어진다. 
 * 0은 빈 칸, 1은 적이 있는 칸이다.
 * 
 * 첫째 줄에 궁수의 공격으로 제거할 수 있는 적의 최대 수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬_디펜스 {
	private static int N, M, D;
	private static int[][] map;
	private static boolean[] castle;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 격자판의 행의 수
		M = Integer.parseInt(st.nextToken()); // 격자판의 열의 수
		D = Integer.parseInt(st.nextToken()); // 궁수의 공격 거리 제한

		map = new int[N][M]; // 격자판 배열
		castle = new boolean[M]; // 성 배열, 궁수가 있으면 true

		// 격자판 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		answer = 0; // 궁수의 공격으로 제거할 수 있는 적의 최대 수

		setArcher(0, 3, M);

		System.out.println(answer);

		br.close();
	}

	// 궁수를 배치한다.
	// idx : 조합 시작 인덱스, r : 뽑아야 할 궁수의 수, n : 뽑을 수 있는 궁수의 수
	private static void setArcher(int idx, int r, int n) {
		if (r == 0) {
			play(); // 게임을 진행한다.
			return;
		}

		for (int i = idx; i < n; i++) {
			if (castle[i]) continue;

			castle[i] = true;
			setArcher(idx + 1, r - 1, n);
			castle[i] = false;
		}
	}

	// 게임을 진행한다.
	private static void play() {
		int[][] copyMap = new int[N][M]; // map 배열 복제 배열

		// 배열 복제
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		int count = 0; // 제거한 적의 개수

		// N줄 탐색 (공격이 끝나면 적이 한 칸 아래로 이동하는 것을 궁수를 한 칸 위로 올리는 것으로 표현)
		for (int ar = N; ar > 0; ar--) {
			boolean[][] visited = new boolean[N][M]; // 궁수의 공격으로 제거된 적 표시 배열

			// 모든 궁수 공격 범위 탐색
			for (int ac = 0; ac < castle.length; ac++) {
				// 궁수가 없으면 건너 뛴다.
				if (!castle[ac]) continue;

				int minDist = Integer.MAX_VALUE; // 최소 거리
				int minCol = Integer.MAX_VALUE; // 최소 거리의 행
				int minRow = Integer.MAX_VALUE; // 최소 거리의 열

				// 맵 전체 탐색
				for (int i = 0; i < ar; i++) {
					for (int j = 0; j < M; j++) {
						// 해당 위치에 제거되지 않은 적이 있는 경우
						if (copyMap[i][j] == 1) {
							int dist = Math.abs(ar - i) + Math.abs(ac - j); // 궁수와 적의 거리

							// 현재 저장된 최소 거리보다 더 짧으면 갱신한다.
							if (minDist > dist) {
								minDist = dist;
								minRow = i;
								minCol = j;
							}
							// 현재 저장된 최소 거리와 같다면 가장 왼쪽에 있는 적 위치로 갱신한다.
							else if (minDist == dist) {
								if (minCol > j) {
									minRow = i;
									minCol = j;
								}
							}
						}
					}
				}

				// 최종 최소 거리가 D보다 작으면 해당 위치의 몬스터를 공격한다.
				// 같은 적이 여러 궁수에게 공격당할 수 있다.
				if (minDist <= D)
					visited[minRow][minCol] = true;
			}

			// 공격당한 적의 수를 세고 게임에서 제외시킨다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						copyMap[i][j] = 0;
						count++;
					}
				}
			}
		}

		// 정답 갱신
		answer = Math.max(answer, count);
	}
}
