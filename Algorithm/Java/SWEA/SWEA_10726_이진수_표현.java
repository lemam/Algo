import java.util.Scanner;

/*
 * SWEA 10726번 - 이진수 표현 (D3)
 * 
 * 정수 N, M 이 주어질 때, 
 * M의 이진수 표현의 마지막 N 비트가 모두 1로 켜져 있는지 아닌지를 판별하여 출력하라.
 * 
 * 마지막 N개의 비트가 모두 켜져 있다면 ON 아니면 OFF 를 출력하라.
 */

public class SWEA_10726_이진수_표현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String answer = "ON";

			// 마지막부터 N개의 비트 확인
			for (int i = 0; i < N; i++) {
				// 비트가 꺼져 있으면
				if ((M & (1 << i)) <= 0) {
					answer = "OFF";
					break;
				}
			}
			
			System.out.printf("#%d %s\n", tc, answer);
		}

		sc.close();
	}
}
