import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*
		 * N x N 배열 안의 숫자: 해당 영역에 존재하는 파리의 개체 수
		 * 
		 * 파리 킬러 스프레이를 한 번만 뿌려 최대한 많은 파리를 잡으려고 한다.
		 * + 형태, x 형태로 분사된다.
		 * M의 세기로 분사하면 중심이 향한 칸부터 각 방향으로 M칸의 파리를 잡을 수 있다.
		 * 뿌려진 일부가 영역을 벗어나도 상관없다.
		 * 
		 * 한 번에 잡을 수 있는 최대 파리수를 출력
		 * 
		 * (5 <= N <= 15)
		 * (2 <= M <= N)
		 * 각 영역의 파리 갯수는 30 이하
		 */
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	// 테스트 케이스

		// + 방향 : 12 3 6 9
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		// x 방향 : TR BR BL TL
		int[] tx = {-1, 1, 1, -1};
		int[] ty = {1, 1, -1, -1};
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();	// 배열의 크기
			int M = sc.nextInt();	// 스프레이 세기
			
			int[][] grid = new int[N][N];
			int max = 0;	// 파리 개수 최대 값
			
			// 배열 입력 받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			
			// 완전 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum = grid[i][j];
					
					// + 4방향으로 M만큼 탐색 (중앙도 1회로 포함)
					for (int k = 0; k < 4; k++) {
						for (int m = 1; m < M; m++) {
							int row = i + dx[k] * m;
							int col = j + dy[k] * m;
							
							if (row < 0 || row >= N) continue;
							if (col < 0 || col >= N) continue;
							
							sum += grid[row][col];
						}
					}
					
					if (max < sum) max = sum;
					
					sum = grid[i][j];
					
					// x 4방향으로 M만큼 탐색 (중앙도 포함)
					for (int k = 0; k < 4; k++) {
						for (int m = 1; m < M; m++) {
							int row = i + tx[k] * m;
							int col = j + ty[k] * m;
							
							if (row < 0 || row >= N) continue;
							if (col < 0 || col >= N) continue;
							
							sum += grid[row][col];
						}
					}
					
					if (max < sum) max = sum;
				}
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}

}
