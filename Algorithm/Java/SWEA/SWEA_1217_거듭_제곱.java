import java.util.Scanner;

/*
 * SWEA 1217번 - 거듭 제곱
 * 두 개의 숫자 N, M이 주어질 때, 
 * N의 M 거듭제곱 값을 구하는 프로그램을 재귀호출을 이용하여 구현해 보아라.
 */

public class SWEA_1217_거듭_제곱  {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
	
			System.out.printf("#%d %d\n", t, pow(N, M));
		}

		sc.close();
	}
	
	// n의 m 거듭제곱 값을 반환
	public static int pow(int n, int m) {
		if (m == 1) return n;

		return n * pow(n, m-1);
	}
}
