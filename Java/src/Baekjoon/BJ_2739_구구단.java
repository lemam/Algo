package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2739_구구단 {
	public static void main(String[] args) throws IOException {
		/*
		 * N을 입력받은 뒤, 구구단 N을 출력
		 * (1 <= N <= 9)
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", N, i, N * i);
		}
	}
}
