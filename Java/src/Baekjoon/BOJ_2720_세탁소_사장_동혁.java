package Baekjoon;/*
 * 백준 2720번 - 세탁소 사장 동혁 (브론즈 3)
 * 
 * 거스름돈의 액수가 주어지면 리암이 줘야할 
 * 쿼터(Quarter, $0.25)의 개수, 
 * 다임(Dime, $0.10)의 개수, 
 * 니켈(Nickel, $0.05)의 개수, 
 * 페니(Penny, $0.01)의 개수를 구하는 프로그램을 작성하시오. 
 * 
 * 거스름돈은 항상 $5.00 이하이고, 손님이 받는 동전의 개수를 최소로 하려고 한다.
 * 쿼터의 개수, 다임의 개수, 니켈의 개수, 페니의 개수를 공백으로 구분하여 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2720_세탁소_사장_동혁 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] changeArr = { 25, 10, 5, 1 }; // 쿼터, 다임, 니켈, 페니

		for (int tc = 1; tc <= T; tc++) {
			int C = Integer.parseInt(br.readLine());

			for (int i = 0; i < changeArr.length; i++) {
				int coin = C / changeArr[i]; // 거스름돈 개수

				if (coin != 0)
					C %= changeArr[i] * coin;

				System.out.print(coin + " ");
			}

			System.out.println();
		}

		br.close();
	}
}
