/*
 * 백준 24416번 - 알고리즘 수업 - 피보나치 수 1 (브론즈 1)
 * 
 * 오늘은 n의 피보나치 수를 재귀호출과 동적 프로그래밍으로 구하는 알고리즘을 배웠다. 
 * 재귀호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해 보자. 
 * 아래 의사 코드를 이용하여 n의 피보나치 수를 구할 경우 코드1 코드2 실행 횟수를 출력하자.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24416_알고리즘_수업_피보나치_수_1 {
	public static int[] f;
	public static int cntFibo;
	public static int cntFibonacci;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		f = new int[n + 1];
		
		fib(n);
		fibonacci(n);
		
		System.out.println(cntFibo + " " + cntFibonacci);
		
		br.close();
	}

	// 피보나치 수 재귀호출
	public static int fib(int n) {
		if (n == 1 || n == 2) {
			cntFibo++;
			return 1;
		}

		return fib(n - 1) + fib(n - 2);
	}

	// 피보나치 수 동적 프로그래밍
	public static int fibonacci(int n) {
		f[1] = 1;
		f[2] = 1;

		for (int i = 3; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
			cntFibonacci++;
		}

		return f[n];
	}
}
