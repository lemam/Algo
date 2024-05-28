package SWEA;/*
 * SWEA 2005번 - 파스칼의 삼각형 (D2)
 * 
 * 크기가 N인 파스칼의 삼각형을 만들어야 한다.
 * 
 * 파스칼의 삼각형이란 아래와 같은 규칙을 따른다.
 * 1. 첫 번째 줄은 항상 숫자 1이다.
 * 2. 두 번째 줄부터 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합으로 구성된다.
 * 
 * N을 입력 받아 크기 N인 파스칼의 삼각형을 출력하는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class SWEA_2005_파스칼의_삼각형 {
	public static int maxSize = 10;	// 파스칼의 삼각형의 크기 N의 최댓값
	public static int size = 1;	// 저장된 파스칼 삼각형의 크기
	public static int[][] memo = new int[maxSize + 1][maxSize + 1]; // 파스칼 삼각형 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		// 첫 번째 줄은 항상 숫자 1이다.
		memo[1][1] = 1;
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 삼각형의 크기
		
			// N이 현재 저장된 높이보다 크면 size+1번 줄부터 N까지 생성
			if (N > size) {
				for (int i = size + 1; i <= N; i++) {
					// 한 줄의 양 끝은 항상 1이다.
					memo[i][1] = 1;
					memo[i][i] = 1;

					for (int j = 2; j < i; j++) {
						// 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합으로 구성된다.
						memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j];
					}
				}
				
				// size를 갱신한다.
				size = N;
			}
			
			System.out.println("#" + tc);
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <=i; j++) {
					System.out.print(memo[i][j] + " ");
				}
				System.out.println();
			}
		}

		sc.close();
	}
}
