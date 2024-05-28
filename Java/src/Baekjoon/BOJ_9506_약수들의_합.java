package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 9506번 - 약수들의 합 (브론즈 1)
 * 
 * 어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.
 * 예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.
 * n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.
 * 
 * 입력의 마지막엔 -1이 주어진다.
 * 
 * 테스트케이스 마다 한줄에 하나씩 출력해야 한다.
 * n이 완전수라면, n을 n이 아닌 약수들의 합으로 나타내어 출력한다
 * (6 = 1 + 2 + 3)
 * 이때, 약수들은 오름차순으로 나열해야 한다.
 * n이 완전수가 아니라면 n is NOT perfect. 를 출력한다.
 */

public class BOJ_9506_약수들의_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int n = Integer.parseInt(br.readLine());

			// 입력의 마지막엔 -1이 주어진다.
			if (n == -1) break;

			String output = n + " = 1"; // 출력값
			int sum = 1; // n을 제외한 모든 약수들의 합

			// 2부터 n-1까지 순회 
			for (int i = 2; i < n; i++) {
				// i가 약수이면 합한다.
				if (n % i == 0) {
					output += " + " + i;
					sum += i;
				}
			}
			
			// n을 제외한 모든 약수들의 합이 n과 같으면 완전수이다.
			if (sum == n)
				System.out.println(output);
			else
				System.out.println(n + " is NOT perfect.");
		}

		br.close();
	}
}
