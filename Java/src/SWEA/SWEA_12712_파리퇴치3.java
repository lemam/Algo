package SWEA;

import java.util.Scanner;

public class SWEA_12712_파리퇴치3 {

	public static void main(String[] args) {
		/*
		 * N x N �迭 ���� ����: �ش� ������ �����ϴ� �ĸ��� ��ü ��
		 * 
		 * �ĸ� ų�� �������̸� �� ���� �ѷ� �ִ��� ���� �ĸ��� �������� �Ѵ�.
		 * + ����, x ���·� �л�ȴ�.
		 * M�� ����� �л��ϸ� �߽��� ���� ĭ���� �� �������� Mĭ�� �ĸ��� ���� �� �ִ�.
		 * �ѷ��� �Ϻΰ� ������ ����� �������.
		 * 
		 * �� ���� ���� �� �ִ� �ִ� �ĸ����� ���
		 * 
		 * (5 <= N <= 15)
		 * (2 <= M <= N)
		 * �� ������ �ĸ� ������ 30 ����
		 */
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	// �׽�Ʈ ���̽�

		// + ���� : 12 3 6 9
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		// x ���� : TR BR BL TL
		int[] tx = {-1, 1, 1, -1};
		int[] ty = {1, 1, -1, -1};
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();	// �迭�� ũ��
			int M = sc.nextInt();	// �������� ����
			
			int[][] grid = new int[N][N];
			int max = 0;	// �ĸ� ���� �ִ� ��
			
			// �迭 �Է� �ޱ�
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			
			// ���� Ž��
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum = grid[i][j];
					
					// + 4�������� M��ŭ Ž�� (�߾ӵ� 1ȸ�� ����)
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
					
					// x 4�������� M��ŭ Ž�� (�߾ӵ� ����)
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
