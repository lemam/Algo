package Solution;

import java.util.Scanner;

/*
 * SW Expert Academy 1979번 - 어디에 단어가 들어갈 수 있을까 (D2)
 * 
 * N X N 크기의 단어 퍼즐을 만들려고 한다. 
 * 입력으로 단어 퍼즐의 모양이 주어진다.
 * 
 * 주어진 퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수를 출력하는 프로그램을 작성하라.
 * (빈 칸 길이와 K가 같아야 함)
 * 
 * 퍼즐의 각 셀 중, 빈 칸은 1, 단어를 쓸 수 없는 칸은 0 으로 주어진다.
 */

public class SWEA_1979_어디에_단어가_들어갈_수_있을까 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 퍼즐의 가로, 세로 길이
			int K = sc.nextInt(); // 단어의 길이
			int[][] map = new int[N][N]; // 퍼즐 배열
			int answer = 0; // 단어가 들어갈 수 있는 자리의 수

			// 퍼즐 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 가로 탐색
			for (int i = 0; i < N; i++) {
				int cnt = 0; // 연속된 빈 칸의 개수
				
				for (int j = 0; j < N; j++) {
					// 빈 칸이 아니면 지금까지 연속된 빈 칸의 수가 K와 같은지 확인하고 다음 칸 탐색으로 넘어간다.
					if (map[i][j] == 0) {
						if (cnt == K) answer++;
						cnt = 0;
						
						continue;
					}
					
					// 빈 칸이면 개수를 더한다.
					cnt++;
				}
				
				// 연속된 빈 칸 개수가 K와 같으면 answer에 1을 더한다.
				if (cnt == K) answer++;
			}

			// 세로 탐색
			for (int j = 0; j < N; j++) {
				int cnt = 0; // 연속된 빈 칸의 개수
				
				for (int i = 0; i < N; i++) {
					// 빈 칸이 아니면 지금까지 연속된 빈 칸의 수가 K와 같은지 확인하고 다음 칸 탐색으로 넘어간다.
					if (map[i][j] == 0) {
						if (cnt == K) answer++;
						cnt = 0;
						
						continue;
					}
					
					// 빈 칸이면 개수를 더한다.
					cnt++;
				}
				
				// 연속된 빈 칸 개수가 K와 같으면 answer에 1을 더한다.
				if (cnt == K) answer++;
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
