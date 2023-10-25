/*
 * SWEA 2805번 - 농작물 수확하기 (D3)
 * 
 * N X N크기의 농장이 있다.
 * 이 농장에는 이상한 규칙이 있다.
 * 규칙은 다음과 같다.
 * 
 * 1. 농장은 크기는 항상 홀수이다. (1 X 1, 3 X 3 … 49 X 49)
 * 2. 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능하다.
 * 
 * 농장의 크기 N와 농작물의 가치가 주어질 때, 규칙에 따라 얻을 수 있는 수익은 얼마인지 구하여라.
 */

import java.util.Scanner;

public class SWEA_2805_농작물_수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 농장의 크기
			int[][] farm = new int[N][N]; // 농장 배열
			
			// 농장 배열 입력
			for (int i = 0; i < N; i++) {
				String[] input = sc.next().split("");
				for (int j = 0; j < N; j++) {
					farm[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			int answer = 0;	// 수익
			
			for (int i = 0; i < N; i++) {
				int diff = Math.abs(i - (N / 2));
				
				for (int j = 0 + diff; j < N - diff; j++) {
					answer += farm[i][j];
				}
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
