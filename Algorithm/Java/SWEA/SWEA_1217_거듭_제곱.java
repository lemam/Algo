import java.util.Scanner;

/*
 * SWEA 1217번 - 거듭 제곱 (D3)
 * 
 * 다음과 같이 두 개의 숫자 N, M이 주어질 때, 
 * N의 M 거듭제곱 값을 구하는 프로그램을 재귀호출을 이용하여 구현해 보아라.
 */

public class SWEA_1217_거듭_제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt(); // 테스트 케이스 번호
			int N = sc.nextInt();
			int M = sc.nextInt();

			// N의 M 거듭제곱 값 구하기
			System.out.printf("#%d %d\n", t, pow(N, M));
		}

		sc.close();
	}

	private static int pow(int n, int m) {
		if (m == 1)
			return n;

		if (m % 2 == 0)
			return pow(n, m / 2) * pow(n, m / 2);
		else
			return pow(n, (m - 1) / 2) * pow(n, (m - 1) / 2) * n;
	}
}
