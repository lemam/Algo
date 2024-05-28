package Baekjoon;/*
 * 백준 10870번 - 피보나치 수 5 (브론즈 2)
 * 
 * 피보나치 수는 0과 1로 시작한다. 
 * 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 
 * 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
 * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
 * 
 * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10870_피보나치_수_5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		System.out.println(fibo(N));
		
		br.close();
	}

	// 피보나치 수
	private static int fibo(int n) {
		if (n <= 1) return n;
		
		return fibo(n-1) + fibo(n-2);
	}
}
