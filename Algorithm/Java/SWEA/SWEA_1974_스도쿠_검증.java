import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * SWEA 1974번 - 스도쿠 검증 (D2)
 * 
 * 스도쿠는 숫자퍼즐로, 가로 9칸 세로 9칸으로 이루어져 있는 표에 1 부터 9 까지의 숫자를 채워넣는 퍼즐이다.
 * 
 * 같은 줄에 1 에서 9 까지의 숫자를 한번씩만 넣고, 
 * 3 x 3 크기의 작은 격자 또한, 1 에서 9 까지의 숫자가 겹치지 않아야 한다.
 * 
 * 입력으로 9 X 9 크기의 스도쿠 퍼즐의 숫자들이 주어졌을 때, 
 * 위와 같이 겹치는 숫자가 없을 경우, 1을 정답으로 출력하고 그렇지 않을 경우 0 을 출력한다.
 * 
 * 테스트 케이스는 9 x 9 크기의 퍼즐의 데이터이다.
 */

public class SWEA_1974_스도쿠_검증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스
		int N = 9; // 스도쿠 퍼즐 한 변의 크기

		for (int tc = 1; tc <= T; tc++) {
			int[][] board = new int[N][N]; // 스도쿠 퍼즐
			int answer = 1;

			// 퍼즐 배열 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}

			PriorityQueue<Integer> pq = new PriorityQueue<>();

			// 가로 줄 탐색
			for (int i = 0; i < N && answer == 1; i++) {
				pq.clear();

				// i행 한 줄 탐색
				for (int j = 0; j < N; j++) {
					pq.add(board[i][j]);
				}

				for (int cnt = 1; cnt <= 9; cnt++) {
					if (cnt != pq.poll()) {
						answer = 0;
						break;
					}
				}
			}

			// 세로 줄 탐색
			for (int j = 0; j < N && answer == 1; j++) {
				pq.clear();

				// j열 한 줄 탐색
				for (int i = 0; i < N; i++) {
					pq.add(board[i][j]);
				}

				for (int cnt = 1; cnt <= 9; cnt++) {
					if (cnt != pq.poll()) {
						answer = 0;
						break;
					}
				}
			}

			// 3 x 3 격자
			loop: for (int i = 0; i < N - 2 && answer == 1; i += 3) {
				for (int j = 0; j < N - 2; j += 3) {
					pq.clear();

					// board[i][j] 격자 탐색 시작 원소
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							pq.add(board[i + k][j + l]);
						}
					}

					for (int cnt = 1; cnt <= 9; cnt++) {
						if (cnt != pq.poll()) {
							answer = 0;
							break loop;
						}
					}
				}
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
