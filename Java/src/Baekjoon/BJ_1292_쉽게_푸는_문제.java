package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1292_쉽게_푸는_문제 {

	public static void main(String[] args) throws IOException {
		/*
		 * 1을 한 번, 2를 두 번, 3을 세 번
		 * 이런 식으로 1 2 2 3 3 3 4 4 4 4 5 ... 수열을 만들고
		 * 어느 일정한 구간의 합을 구하는 것
		 * 
		 * 구간의 시작과 끝을 나타내는 정수 A, B(1 ≤ A ≤ B ≤ 1,000)
		 * A번째 숫자부터 B번째 숫자까지 합은?
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int idx = 0;	// 현재 수열 인덱스
		int result = 0;	// 누적합
		
		// 1부터 B번째 숫자까지 수열 생성
		for (int i = 1; i <= B; i++) {
			for (int j = 1; j <= i; j++) {
				idx++;
				
				// 만약 인덱스가 A와 B 사이라면 그 값을 더한다.
				if (A <= idx && idx <= B) {
					result += i;
				}
			}
		}
		
		System.out.println(result);
	}

}
