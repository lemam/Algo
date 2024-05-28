package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2231_분해합 {
	
	public static int getGenerator(int N) {
		// 탐색
		for (int i = 1; i <= N; i++) {
			int number = i;
			int sum = 0;
			
			// N의 각 자리수 합하기
			while (number > 0) {
				sum += number % 10;
				number /= 10;
			}
			
			// 분해합과 N이 같으면 i 반환
			if (sum + i == N) return i;
		}
		
		// 생성자가 없으면 0 반환
		return 0;
	}

	public static void main(String[] args) throws IOException {
		/*
		 * 어떤 자연수 N의 분해합 = N과 N을 이루는 각 자리수의 합
		 * 
		 * 어떤 자연수 M의 분해합 = N일때,
		 * M = N의 생성자
		 * 
		 * ex)
		 * 245의 분해합 = 245 + 2 + 4 + 5 = 256
		 * 245는 256의 생성자
		 * 
		 * 어떤 자연수는 생성자가 없거나 여러 개일 수 있다.
		 * 
		 * 자연수 N의 가장 작은 생성자를 구해내는 프로그램
		 * 생성자가 없을 경우 0을 출력
		 * N(1 ≤ N ≤ 1,000,000)
		 */
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(getGenerator(N));
	}

}
