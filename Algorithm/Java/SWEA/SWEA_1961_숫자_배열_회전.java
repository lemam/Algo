import java.util.Scanner;

public class Solution {
	
	public static int[][] turnClockwise(int[][] arr) {
		int[][] result = new int[arr.length][arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				result[i][j] = arr[arr.length - j - 1][i]; 
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		/*
		 * N x N 행열
		 * 시계 방향으로 90도, 180도, 270도 회전한 모양 출력
		 * (3 <= N <= 7)
		 */
		
		/*
 			123
			456
			789
			
			741	[2][0] [1][0] [0][0]
			852 [2][1] [1][1] [0][1]
			963 [2][2] [1][2] [0][2]
			
			987 [2][2] [2][1] [2][0]
			654 [1][2] [1][1] [1][0]
			321 [0][2] [0][1] [0][0]
			
			369	[0][2] [1][2] [2][2]
			258 [0][1] [1][1] [2][1]
			147 [0][0] [1][0] [2][0]
		*/
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[][] mat = new int[N][N];
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					mat[x][y] = sc.nextInt();
				}
			}

			int[][] mat90 = turnClockwise(mat);
			int[][] mat180 = turnClockwise(mat90);
			int[][] mat270 = turnClockwise(mat180);
			
			System.out.println("#" + (t + 1));
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					System.out.print(mat90[x][y]);
				}
				
				System.out.print(" ");
				
				for (int y = 0; y < N; y++) {
					System.out.print(mat180[x][y]);
				}
				
				System.out.print(" ");
				
				for (int y = 0; y < N; y++) {
					System.out.print(mat270[x][y]);
				}
				
				System.out.print("\n");
			}
		}
		
		sc.close();
	}

}
