package SWEA;/*
 * SWEA 7964번 - 부먹왕국의 차원 관문 (D3)
 * 
 * 부먹 왕국의 특징은 모든 도시들을 건설 할 때 일렬로 이어지게 만들었다.
 * 어느 도시에 차원 관문을 설치하면
 * 그 도시와 거리 D 이하인 다른 도시에서 차원 관문이 있는 곳으로 들어오거나, 
 * 혹은 차원 관문에서 거리 D 이하인 다른 도시로 나가는것이 가능하다.
 * 
 * 찍먹 왕국의 재침공에 대비하기 위해서 모든 도시 이동이 되어야하며 
 * 모든 차원 관문 사이와 직접적으로 이동이 가능하도록 차원 관문을 재건하려고 한다.
 * (단, 0번 위치와 N+1번 위치에는 차원 관문이 존재 한다.)
 * 
 * 가능한 빠른 건설을 위하여 최소 개수로 설치하는 계획을 세우려고 할때 
 * 도시들마다 차원관문이 남아있는 지에 대한 정보가 주어졌을 때, 이동에 필요한 차원관문의 최소 개수를 구하여라.
 * 
 * 1번 도시부터 차례대로 각 도시에 차원관문이 남아있는 지에 대한 정보
 * 1은 남아있음을 의미하며 0은 파괴 당한 것을 의미한다.
 * i번 도시와 (i+1)번 도시 사이의 거리는 모든 1 ≤ i < N에 대해서 1이다.
 * 
 * 부먹 왕국이 추가로 건설 해야 하는 차원관문 의 최소 개수를 구하여라.
 */

import java.util.Scanner;

public class SWEA_7964_부먹왕국의_차원_관문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 부먹 왕국의 도시 수
			int D = sc.nextInt(); // 이동 제한 거리

			int cnt = 0; // 연속된 0의 개수
			int answer = 0; // 추가로 건설해야 하는 차원관문의 개수

			// (연속된 0의 개수 / 제한 거리)를 모두 더한다.
			for (int i = 0; i < N; i++) {
				int gate = sc.nextInt();

				if (gate == 0) {
					cnt++;
				}

				if (gate == 1 || i == N - 1) {
					answer += cnt / D;
					cnt = 0;
				}
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
