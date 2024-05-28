package Baekjoon;/*
 * 백준 2839번 - 설탕 배달 (실버 4)
 * 
 * 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 
 * 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다.
 * 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
 * 
 * 상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다.
 * 상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 
 * 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 * 
 * 상근이가 배달하는 봉지의 최소 개수를 출력한다.
 * 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕_배달 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		while (true) {
			// N이 5의 배수인 경우 5kg에 전부 담는다.
			if (N % 5 == 0) {
				System.out.println(N / 5 + cnt);
				break;
			}

			// N이 음수인 경우 설탕이 나누어떨어지지 않으므로 중단한다.
			if (N < 0) {
				System.out.println(-1);
				break;
			}

			// 설탕을 3kg에 담는다.
			N -= 3;
			cnt++;
		}

		br.close();
	}
}
