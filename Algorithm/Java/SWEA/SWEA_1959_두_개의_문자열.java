import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/* N개의 숫자로 구성된 숫자열 A(i) (i = 1 ~ N)
		 * M개의 숫자로 구성된 숫자열 B(j) (j = 1 ~ M)
		 * 
		 * ex)
		 * A(i) = 1, 5, 3
		 * B(j) = 3, 6, -7, 5, 4
		 * 
		 * A(i)나 B(j)를 자유롭게 움직여서 숫자들이 서로 마주보는 위치를 변경할 수 있음
		 * 단, 더 긴 쪽의 양 끝을 벗어나면 안됨
		 *  
		 * ex)
		 * A(i) =    1, 5, 3
		 * B(j) = 3, 6, -7, 5, 4
		 * 
		 * 서로 마주보는 숫자들을 곱한 뒤 더할 때 최댓값은?
		 * ex)
		 * A(i) =        1, 5, 3
		 * B(j) = 3, 6, -7, 5, 4
		 * -7 + 25 + 12 = 30
		 * 
		 * (N 과 M은 3 이상 20 이하이다.)
		 */
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] Ai = new int[N];
			int[] Bj = new int[M];
			
			for (int i = 0; i < N; i++) {
				Ai[i] = sc.nextInt();
			}
			
			for (int i = 0; i < M; i++) {
				Bj[i] = sc.nextInt();
			}
			
			int[] smallArr;
			int[] bigArr;
			int move = 0;
			int result = 0;
			
			if (N <= M) {
				smallArr = Ai;
				bigArr = Bj;
				move = M - N;
			} else {
				smallArr = Bj;
				bigArr = Ai;
				move = N - M;
			}
			
			/*
			 * Ai - Bj
			 * 0 - 0, 1 - 1, 2 - 2
			 * 0 - 1, 1 - 2, 2 - 3
			 * 0 - 2, 1 - 3, 3 - 4
			 */
			
			for (int p = 0; p <= move; p++) {
				int temp = 0;
				
				for (int i = 0; i < smallArr.length; i++) {
					temp += smallArr[i] * bigArr[i + p];
				}
				
				if (result < temp) result = temp;
			}
			
			System.out.printf("#%d %d\n", t + 1, result);
		}
	}

}
