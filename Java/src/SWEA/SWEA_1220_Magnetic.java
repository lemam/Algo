package SWEA;/*
 * SWEA 1220번 - Magnetic (D3)
 * 
 * 테이블 위에 자성체들이 놓여 있다.
 * 자성체들은 성질에 따라 색이 부여되는데, 
 * 푸른 자성체의 경우 N극에 이끌리는 성질을 가지고 있고, 
 * 붉은 자성체의 경우 S극에 이끌리는 성질이 있다.
 * 
 * 아래와 같은 테이블에서 일정 간격을 두고 강한 자기장을 걸었을 때, 
 * 시간이 흐른 뒤에 자성체들이 서로 충돌하여 테이블 위에 남아있는 교착 상태의 개수를 구하라.
 * 
 * 1은 N극 성질을 가지는 자성체를 2는 S극 성질을 가지는 자성체를 의미하며 
 * 테이블의 윗부분에 N극이 아래부분에 S극이 위치한다고 가정한다.
 * (N극 성질을 가지는 자성체는 S극에 이끌리는 성질이 있다.)
 */

import java.util.Scanner;

public class SWEA_1220_Magnetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 테이블의 한 변의 크기
			int[][] table = new int[N][N]; // 테이블
			int answer = 0; // 교착 상태 개수

			// 테이블 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}

			// 세로줄 탐색
			for (int j = 0; j < N; j++) {
				boolean hasN = false;

				for (int i = 0; i < N; i++) {
					// N극 성질을 가지는 자성체를 만나면 마킹한다.
					if (table[i][j] == 1) {
						hasN = true;
					}
					// S극 성질을 가지는 자성체를 만나면
					else if (table[i][j] == 2) {
						// 위에 N극 자성체가 있었다면 교착 상태 발생
						if (hasN) {
							answer++;
							hasN = false;
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
