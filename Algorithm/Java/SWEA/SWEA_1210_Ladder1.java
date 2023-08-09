package Solution;

import java.util.Scanner;

/*
 * SW Expert Academy 1210번 - Ladder1 (D4)
 * 
 * N x N 배열 안의 숫자는 해당 영역에 존재하는 파리의 개수를 의미한다.
 * M x M 크기의 파리채를 한 번 내리쳐 최대한 많은 파리를 죽이고자 한다.
 * 죽은 파리의 개수를 구하라.
 */

public class SWEA_1210_Ladder1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테스트 케이스
		int N = 100; // 배열의 크기

		// 3, 9, 12
		int[] dx = { 0, 0, -1 };
		int[] dy = { 1, -1, 0 };

		for (int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt(); // 테스트 번호

			int[][] ladder = new int[N][N]; // 사다리 배열
			boolean[][] flag = new boolean[N][N]; // 이동 가능 여부 (이동한 곳은 false)

			int startRow = 99;	// 도착점의 행
			int startCol = 0;	// 도착점의 열

			// 배열 입력
			for (int i = 0; i < ladder.length; i++) {
				for (int j = 0; j < ladder[0].length; j++) {
					ladder[i][j] = sc.nextInt();
					flag[i][j] = (ladder[i][j] != 0);

					// 도착점의 x좌표 찾기
					if (ladder[i][j] == 2)
						startCol = j;
				}
			}

			while (startRow > 0) {
				// 오른쪽, 왼쪽, 위쪽 방향 순서로 사다리 탐색
				for (int d = 0; d < 3; d++) {
					// 다음 탐색할 위치값
					int nextRow = startRow + dx[d];
					int nextCol = startCol + dy[d];

					// 범위 밖이면 스킵한다.
					if (nextRow < 0 || nextRow >= N)
						continue;
					if (nextCol < 0 || nextCol >= N)
						continue;

					// 다음 위치에 사다리가 없거나 이미 지나온 곳이라면 스킵한다.
					if (ladder[nextRow][nextCol] != 1 || !flag[nextRow][nextCol])
						continue;

					// 다음 위치로 이동
					startRow = nextRow;
					startCol = nextCol;
					flag[nextRow][nextCol] = false;
					break;
				}
			}

			System.out.printf("#%d %d\n", t, startCol);
		}

		sc.close();
	}
}
