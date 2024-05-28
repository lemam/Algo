package Baekjoon;

import java.util.Scanner;

/*
 * 백준 2444번 - 별 찍기 - 7 (브론즈 3)
 * 
 * 다이아몬드 별 찍기
 * 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
 */

public class BOJ_2444_별_찍기_7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i <= N - 1; i++) {
			// 빈 칸 찍기
			for (int j = 1; j <= N - i; j++) {
				System.out.print(" ");
			}
			
			// 별 찍기
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for (int i = N; i >= 1; i--) {
			// 빈 칸 찍기
			for (int j = 1; j <= N - i; j++) {
				System.out.print(" ");
			}
			
			// 별 찍기
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}

		sc.close();
	}
}
